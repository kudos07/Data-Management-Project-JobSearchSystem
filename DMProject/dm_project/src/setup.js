const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const path = require('path');
const mysql = require('mysql');
const port = 8080;

// Replace this object with your database connection and query logic
const users = {
  'dbadmin': { password: 'dbpass', role: 'database admin', redirectUrl: 'dbadmin_dashboard.html' },
  'admin': { password: 'adminpass', role: 'admin', redirectUrl: 'admin_dashboard.html' },
  'manager': { password: 'managerpass', role: 'manager', redirectUrl: 'manager_dashboard.html' },
  'employee': { password: 'employeepass', role: 'employee', redirectUrl: 'employee_dashboard.html' },
  'candidate': { password: 'candidatepass', role: 'candidate', redirectUrl: 'candidate_dashboard.html' },
  'employer': { password: 'employerpass', role: 'employer', redirectUrl: 'employer_dashboard.html' }
};

const db = mysql.createConnection({
  host: 'localhost', // Database host
  user: 'root', // Your database username
  password: 'dmproject123@', // Your database password
  database: 'jobsearch' // The database name
});

db.connect(err => {
  if (err) {
      console.error('Error connecting to the database:', err);
      return;
  }
  console.log('Database connection established');
});

// Middleware to parse request bodies
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

// Serve static files (HTML, CSS, JS, etc.)
app.use(express.static(path.join(__dirname, '/')));

// Login API endpoint
// Server-side role to user type mapping (to match the client-side logic)
const roleToUserType = {
    'database admin': 'employee',
    'admin': 'employee',
    'manager': 'employee',
    'employee': 'employee',
    'candidate': 'candidate',
    'employer': 'employer'
  };
  
  app.post('/api/login', (req, res) => {
    const { username, password, userType } = req.body;
    const user = users[username];
  
    if (user && user.password === password) {
      const mappedUserType = roleToUserType[user.role]; // Map the role to user type
      if (mappedUserType === userType) {
        res.json({ success: true, redirectUrl: user.redirectUrl });
      } else {
        res.status(401).json({ success: false, message: 'Invalid role for this login' });
      }
    } else {
      res.status(401).json({ success: false, message: 'Invalid username or password' });
    }
  });

  app.get('/api/candidates', (req, res) => {
    const query = 'SELECT CandidateID, Qualification, Experience FROM Candidates';
    db.query(query, (error, results, fields) => {
        if (error) {
            res.status(500).send('Error in database operation');
        } else {
            res.json(results);
        }
    });
});

app.get('/api/employers', (req, res) => {
  const query = 'SELECT EmployerID, EnterpriseName, CEO, Location, Address FROM employers';
  db.query(query, (error, results) => {
      if (error) {
          console.error('Error fetching employers:', error);
          res.status(500).send('Error fetching employers');
      } else {
          console.log('Sending employers data:', results);
          res.json(results);
      }
  });
});


  app.post('/api/run-query', (req, res) => {
    const { queryNumber, ...params } = req.body;
    let query = '';
    let queryParams = [];

    switch (queryNumber) {
        case 1:
            query = `
                SELECT j.JobDescription, j.Salary
                FROM Jobs j
                JOIN Employers e ON j.EmployerID = e.EmployerID
                WHERE e.Location = ? AND e.EnterpriseName LIKE ?;
            `;
            queryParams = [params.location, params.enterpriseName];
            break;
        case 2:
            query = `
                SELECT c.CandidateID, c.Qualification
                FROM Candidates c
                JOIN CandidateSkills cs ON c.CandidateID = cs.CandidateID
                JOIN Skills s ON cs.SkillID = s.SkillID
                WHERE c.Qualification LIKE ? AND s.SkillName IN (?, ?)
                GROUP BY c.CandidateID
                HAVING COUNT(DISTINCT s.SkillName) = 2;
            `;
            queryParams = [`%${params.qualification}%`, params.skill1, params.skill2];
            break;
        case 3:
              query = `
                  SELECT e.EnterpriseName
                  FROM Employers e
                  JOIN Jobs j ON e.EmployerID = j.EmployerID
                  LEFT JOIN Employees emp ON e.EmployerID = emp.SupervisorID
                  WHERE j.Salary > ?
                    AND NOT EXISTS (
                      SELECT 1 FROM Employees
                      WHERE SupervisorID = e.EmployerID AND DateJoined > ?
                    )
                  GROUP BY e.EnterpriseName;
              `;
              // No queryParams are needed for this query as the conditions are fixed
              queryParams = [params.salary || 75000, params.year ? `${params.year}-01-01` : '2025-01-01'];
              break;
        
          case 4:
            query = `
                SELECT e.EnterpriseName, COUNT(DISTINCT j.JobDescription) AS NumberOfPositions
                FROM Employers e
                JOIN Jobs j ON e.EmployerID = j.EmployerID
                GROUP BY e.EnterpriseName
                ORDER BY NumberOfPositions DESC
                LIMIT 5;
            `;
            break;

            case 5:
              query = `
                  SELECT s.SkillName, COUNT(*) AS Frequency
                  FROM Skills s
                  JOIN CandidateSkills cs ON s.SkillID = cs.SkillID
                  JOIN Candidates c ON cs.CandidateID = c.CandidateID
                  WHERE c.Qualification = ?
                  GROUP BY s.SkillName
                  ORDER BY Frequency DESC
                  LIMIT 3;
              `;
              queryParams = [params.qualification];
              break;
              
            case 6:
                query = `
                    SELECT DISTINCT c.CandidateID
                    FROM Candidates c
                    JOIN CandidateSkills cs ON c.CandidateID = cs.CandidateID
                    JOIN Skills s ON cs.SkillID = s.SkillID
                    WHERE s.SkillID IN (
                        SELECT SkillID
                        FROM CandidateSkills
                        WHERE CandidateID IN (
                            SELECT CandidateID
                            FROM Jobs
                            WHERE JobDescription = ?
                        )
                    );
                `;
                queryParams = [params.jobDescription];
                break;
              
            case 7:
            query = `
                SELECT COUNT(DISTINCT c.CandidateID) AS CandidatesCount
                FROM Candidates c
                JOIN CandidateSkills cs ON c.CandidateID = cs.CandidateID
                JOIN Skills s ON cs.SkillID = s.SkillID
                WHERE c.Qualification LIKE '%Master%' AND s.SkillName = ?;
            `;
            queryParams = [params.skillName];
            break;
          
            case 8:
            query = `
                SELECT c.CandidateID, s.SkillName
                FROM Candidates c
                JOIN CandidateSkills cs ON c.CandidateID = cs.CandidateID
                JOIN Skills s ON cs.SkillID = s.SkillID
                WHERE s.SkillID NOT IN (
                  SELECT SkillID
                  FROM CandidateSkills
                  WHERE CandidateID != c.CandidateID
                );
            `;
            break;

          case 9:
              query = `
                  SELECT s.SkillName, COUNT(*) AS Demand
                  FROM Skills s
                  JOIN CandidateSkills cs ON s.SkillID = cs.SkillID
                  WHERE cs.CandidateID NOT IN (
                    SELECT c.CandidateID
                    FROM Candidates c
                    JOIN Jobs j ON c.CandidateID = j.EmployerID
                  )
                  GROUP BY s.SkillID
                  ORDER BY Demand DESC
                  LIMIT 5;
              `;
              break;
          

        // ... Add cases for queries 3 through 10, constructing the SQL and parameters ...
        case 10:
            query = `
                SELECT e.EnterpriseName
                FROM Employers e
                WHERE NOT EXISTS (
                    SELECT 1 FROM Employees emp
                    JOIN Candidates c ON emp.EmployeeID = c.CandidateID
                    JOIN CandidateSkills cs ON c.CandidateID = cs.CandidateID
                    JOIN Skills s ON cs.SkillID = s.SkillID
                    WHERE s.SkillName = ? AND e.EmployerID = emp.SupervisorID
                );
            `;
            queryParams = [params.skillName];
            break;
        default:
            return res.status(400).send('Invalid query number');
    }

    // Execute the query using the database connection
    db.query(query, queryParams, (error, results) => {
        if (error) {
            console.error(error);
            res.status(500).send('Error executing query');
        } else {
            res.json(results);
        }
    });
});


  

app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}/`);
});
