import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDB_Jobs {
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

            String InsertStatement_Jobs = "INSERT INTO jobs (JobID, JobDescription, Salary, EmployerID)"+
            "VALUES"+
              "(1, 'Software Engineer', 80000, 101),"+
              "(2, 'Marketing Specialist', 60000, 102),"+
              "(3, 'Data Analyst', 70000, 103),"+
              "(4, 'Product Manager', 90000, 104),"+
              "(5, 'Graphic Designer', 55000, 105),"+
              "(6, 'Financial Analyst', 75000, 106),"+
              "(7, 'Human Resources Manager', 85000, 107),"+
              "(8, 'Sales Representative', 50000, 108),"+
              "(9, 'Web Developer', 82000, 109),"+
              "(10, 'Customer Support Representative', 45000, 110),"+
               "(11, 'Quality Assurance Analyst', 70000, 111),"+
              "(12, 'Business Development Manager', 85000, 112),"+
              "(13, 'Systems Administrator', 75000, 113),"+
              "(14, 'UX/UI Designer', 68000, 114),"+
              "(15, 'Operations Manager', 92000, 115),"+
              "(16, 'Content Writer', 50000, 116),"+
              "(17, 'Network Engineer', 78000, 117),"+
              "(18, 'Supply Chain Analyst', 72000, 118),"+
              "(19, 'Accountant', 65000, 119),"+
              "(20, 'Social Media Manager', 60000, 120),"+
            "(21, 'Technical Support Specialist', 48000, 121),"+
              "(22, 'Project Manager', 90000, 122),"+
              "(23, 'Healthcare Analyst', 72000, 123),"+
              "(24, 'Event Coordinator', 55000, 124),"+
              "(25, 'Digital Marketing Specialist', 65000, 125),"+
              "(26, 'Legal Assistant', 58000, 126),"+
              "(27, 'Customer Success Manager', 75000, 127),"+
              "(28, 'IT Consultant', 85000, 128),"+
              "(29, 'Research Scientist', 95000, 129),"+
              "(30, 'Administrative Assistant', 40000, 130),"+
            "(31, 'Sales Manager', 88000, 131),"+
              "(32, 'UX Researcher', 70000, 132),"+
              "(33, 'Business Analyst', 76000, 133),"+
              "(34, 'Content Strategist', 62000, 134),"+
              "(35, 'Network Administrator', 78000, 135),"+
              "(36, 'Financial Advisor', 85000, 136),"+
              "(37, 'Software Tester', 60000, 137),"+
              "(38, 'Executive Assistant', 55000, 138),"+
              "(39, 'IT Security Analyst', 82000, 139),"+
              "(40, 'Marketing Coordinator', 50000, 140),"+
            "(41, 'Data Scientist', 90000, 141),"+
              "(42, 'Customer Service Manager', 78000, 142),"+
              "(43, 'Front-end Developer', 82000, 143),"+
              "(44, 'HR Generalist', 65000, 144),"+
              "(45, 'Business Development Coordinator', 60000, 145),"+
              "(46, 'Database Administrator', 76000, 146),"+
              "(47, 'Marketing Analyst', 70000, 147),"+
              "(48, 'IT Project Manager', 92000, 148),"+
              "(49, 'Technical Writer', 55000, 149),"+
              "(50, 'Sales Support Specialist', 48000, 150),"+
            "(51, 'Product Owner', 95000, 151),"+
              "(52, 'Customer Experience Specialist', 72000, 152),"+
              "(53, 'Systems Analyst', 78000, 153),"+
              "(54, 'UI Developer', 85000, 154),"+
              "(55, 'Logistics Coordinator', 60000, 155),"+
              "(56, 'Health and Safety Coordinator', 68000, 156),"+
              "(57, 'Social Media Coordinator', 55000, 157),"+
              "(58, 'DevOps Engineer', 90000, 158),"+
              "(59, 'Legal Counsel', 85000, 159),"+
              "(60, 'Public Relations Specialist', 62000, 160),"+
            "(61, 'Quality Control Analyst', 70000, 161),"+
              "(62, 'Business Intelligence Analyst', 80000, 162),"+
              "(63, 'UX Designer', 75000, 163),"+
              "(64, 'Legal Secretary', 58000, 164),"+
              "(65, 'Network Security Analyst', 82000, 165),"+
              "(66, 'Sales Analyst', 67000, 166),"+
              "(67, 'Software Architect', 92000, 167),"+
              "(68, 'Content Manager', 60000, 168),"+
              "(69, 'IT Support Specialist', 48000, 169),"+
              "(70, 'Marketing Manager', 88000, 170),"+
            "(71, 'HR Coordinator', 55000, 171),"+
             " (72, 'Full Stack Developer', 90000, 172),"+
              "(73, 'Business Systems Analyst', 76000, 173),"+
              "(74, 'Graphic Artist', 62000, 174),"+
              "(75, 'Technical Trainer', 70000, 175),"+
              "(76, 'Customer Service Representative', 48000, 176),"+
              "(77, 'Database Developer', 82000, 177),"+
             " (78, 'Public Relations Manager', 85000, 178),"+
              "(79, 'Financial Planner', 75000, 179),"+
              "(80, 'IT Auditor', 68000, 180),"+
            "(81, 'Marketing Specialist', 60000, 181),"+
              "(82, 'Systems Engineer', 78000, 182),"+
              "(83, 'Customer Success Specialist', 70000, 183),"+
              "(84, 'Legal Analyst', 58000, 184),"+
              "(85, 'Quality Assurance Tester', 65000, 185),"+
             "(86, 'Business Operations Manager', 92000, 186),"+
              "(87, 'IT Manager', 85000, 187),"+
              "(88, 'Social Media Strategist', 62000, 188),"+
              "(89, 'Research Analyst', 75000, 189),"+
              "(90, 'Sales Coordinator', 55000, 190),"+
              "(91, 'UX/UI Developer', 82000, 191),"+
              "(92, 'Operations Coordinator', 60000, +192),"+
              "(93, 'Software Support Engineer', 70000,+ 193)," +
              "(94, 'Content Developer', 55000, 194),"+
              "(95, 'Financial Analyst', 78000, 195),"+
              "(96, 'HR Assistant', 48000, 196),"+
              "(97, 'Network Technician', 85000, 197),"+
              "(98, 'Marketing Analyst', 75000, 198),"+
              "(99, 'IT Specialist', 68000, 199),"+
              "(100, 'Product Marketing Manager',90000,200)";

            statement.executeUpdate(InsertStatement_Jobs);

            System.out.println("Table created successfully");

            statement.close();
            connection.close();
            
        }
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
