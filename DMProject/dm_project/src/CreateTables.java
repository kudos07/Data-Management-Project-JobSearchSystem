import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
    public static void main(String[] args) {
        // Replace with your database details
        String url = "jdbc:mysql://localhost:3306/jobsearch";
        String user = "root";
        String password = "dmproject123@";

        try {
            // Load and register JDBC driver for MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // Create a statement
            Statement statement = connection.createStatement();

            // SQL command to create a table
            String sql_Employers = "CREATE TABLE Employers ("+
                "EmployerID INT AUTO_INCREMENT PRIMARY KEY,"+
                "EnterpriseName VARCHAR(255),"+
                "CEO VARCHAR(100),"+
                "Location VARCHAR(100),"+
                "Address VARCHAR(255))";

            String sql_Skills = "CREATE TABLE Skills ("+
                "SkillID INT AUTO_INCREMENT PRIMARY KEY,"+
                "SkillName VARCHAR(100),"+
                "Experience INT)";
            


            String sql_Jobs = "CREATE TABLE Jobs ("+
                "JobID INT AUTO_INCREMENT PRIMARY KEY," +
                "JobDescription VARCHAR(255)," +
                "Salary DECIMAL(10, 2)," +
                "EmployerID INT," +
                "FOREIGN KEY (EmployerID) REFERENCES Employers(EmployerID) ON DELETE CASCADE)";
            
            
            String sql_Candidates = "CREATE TABLE Candidates ("+
                "CandidateID INT AUTO_INCREMENT PRIMARY KEY,"+
                "Qualification VARCHAR(100),"+
                "Experience INT)";
            
            
            String sql_Employees = "CREATE TABLE Employees ("+
            "EmployeeID INT AUTO_INCREMENT PRIMARY KEY,"+
            "Designation VARCHAR(100),"+
            "DateJoined DATE,"+
            "SupervisorID INT,"+
            "FOREIGN KEY (SupervisorID) REFERENCES Employees(EmployeeID) ON DELETE SET NULL)";     
            
            String sql_CandidateSkills =  "CREATE TABLE CandidateSkills ("+
                "CandidateID INT,"+
                "SkillID INT,"+
                "PRIMARY KEY (CandidateID, SkillID),"+
                "FOREIGN KEY (CandidateID) REFERENCES Candidates(CandidateID) ON DELETE CASCADE,"+
                "FOREIGN KEY (SkillID) REFERENCES Skills(SkillID) ON DELETE CASCADE)";



            // Execute SQL command
            statement.executeUpdate(sql_Employers);
            statement.executeUpdate(sql_Skills);
            statement.executeUpdate(sql_Jobs);
            statement.executeUpdate(sql_Candidates);
            statement.executeUpdate(sql_Employees);
            statement.executeUpdate(sql_CandidateSkills);
            System.out.println("Table created successfully");

            // Close the statement and connection
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
