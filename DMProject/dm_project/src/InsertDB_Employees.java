import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDB_Employees {
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

            String InsertStatement_Employees = "INSERT INTO Employees (EmployeeId, Designation, DateJoined, SupervisorID)"+
            "VALUES"+
              "(20001, 'Database Admin', '2023-01-01', NULL),"+
              "(20002, 'Admin', '2023-02-15', 20001),"+
              "(20003, 'Database Admin', '2023-03-10', NULL),"+
              "(20004, 'Manager', '2023-04-05', 20002),"+
              "(20005, 'Admin', '2023-05-20', 20001),"+
              "(20006, 'Employee', '2023-06-15', 20004),"+
              "(20007, 'Database Admin', '2023-07-01', NULL),"+
              "(20008, 'Manager', '2023-08-10', 20002),"+
              "(20009, 'Manager', '2023-09-05', 20005),"+
              "(20010, 'Database Admin', '2023-10-15', NULL),"+
            "(20011, 'Manager', '2023-11-01', 20005),"+
              "(20012, 'Database Admin', '2023-12-15', NULL),"+
              "(20013, 'Employee', '2022-01-10', 20005),"+
              "(20014, 'Admin', '2022-02-05', 20012),"+
              "(20015, 'Employee', '2022-03-20', 20008),"+
              "(20016, 'Database Admin', '2022-04-15', NULL),"+
              "(20017, 'Admin', '2022-05-01', 20016),"+
              "(20018, 'Employee', '2022-06-10', 20011),"+
              "(20019, 'Database Admin', '2022-07-05', NULL),"+
              "(20020, 'Admin', '2022-08-15', 20016),"+
            "(20021, 'Database Admin', '2022-09-01', NULL),"+
              "(20022, 'Admin', '2022-10-15', 20021),"+
              "(20023, 'Manager', '2022-11-10', 20022),"+
              "(20024, 'Admin', '2022-12-05', 20021),"+
              "(20025, 'Employee', '2021-01-20', 20023),"+
              "(20026, 'Database Admin', '2021-02-15', NULL),"+
              "(20027, 'Admin', '2021-03-01', 20026),"+
              "(20028, 'Employee', '2021-04-10', 20023),"+
              "(20029, 'Database Admin', '2021-05-05', NULL),"+
              "(20030, 'Admin', '2021-06-15', 20026),"+
            "(20031, 'Manager', '2021-07-01', 20030),"+
              "(20032, 'Database Admin', '2021-08-15', NULL),"+
              "(20033, 'Admin', '2021-09-10', 20032),"+
              "(20034, 'Employee', '2021-10-05', 20031),"+
              "(20035, 'Admin', '2021-11-20', 20032),"+
              "(20036, 'Database Admin', '2021-12-15', NULL),"+
              "(20037, 'Employee', '2020-01-01', 20035),"+
              "(20038, 'Admin', '2020-02-10', 20036),"+
              "(20039, 'Database Admin', '2020-03-05', NULL),"+
              "(20040, 'Employee', '2020-04-15', 20031),"+
            "(20041, 'Admin', '2020-05-01', 20039),"+
              "(20042, 'Database Admin', '2020-06-15', NULL),"+
              "(20043, 'Manager', '2020-07-10', 20041),"+
              "(20044, 'Admin', '2020-08-05', 20042),"+
              "(20045, 'Employee', '2020-09-20', 20043),"+
              "(20046, 'Database Admin', '2020-10-15', NULL),"+
              "(20047, 'Admin', '2020-11-01', 20046),"+
              "(20048, 'Manager', '2020-12-10', 20045),"+
              "(20049, 'Database Admin', '2019-01-05', NULL),"+
              "(20050, 'Admin', '2019-02-15', 20049),"+
            "(20051, 'Employee', '2019-03-01', 20048),"+
              "(20052, 'Database Admin', '2019-04-15', NULL),"+
              "(20053, 'Admin', '2019-05-10', 20052),"+
              "(20054, 'Employee', '2019-06-05', 20048),"+
              "(20055, 'Admin', '2019-07-20', 20052),"+
              "(20056, 'Database Admin', '2019-08-15', NULL),"+
              "(20057, 'Manager', '2019-09-01', 20055),"+
              "(20058, 'Admin', '2019-10-10', 20056),"+
              "(20059, 'Database Admin', '2019-11-05', NULL),"+
              "(20060, 'Employee', '2019-12-15', 20057),"+
            "(20061, 'Admin', '2018-01-01', 20059),"+
              "(20062, 'Database Admin', '2018-02-15', NULL),"+
              "(20063, 'Manager', '2018-03-10', 20061),"+
              "(20064, 'Admin', '2018-04-05', 20062),"+
              "(20065, 'Employee', '2018-05-20', 20063),"+
              "(20066, 'Database Admin', '2018-06-15', NULL),"+
              "(20067, 'Admin', '2018-07-01', 20066),"+
              "(20068, 'Manager', '2018-08-10', 20067),"+
              "(20069, 'Database Admin', '2018-09-05', NULL),"+
              "(20070, 'Admin', '2018-10-15', 20069),"+
            "(20071, 'Employee', '2018-11-01', 20068),"+
              "(20072, 'Database Admin', '2018-12-15', NULL),"+
              "(20073, 'Admin', '2017-01-10', 20072),"+
              "(20074, 'Manager', '2017-02-05', 20073),"+
              "(20075, 'Admin', '2017-03-20', 20072),"+
              "(20076, 'Database Admin', '2017-04-15', NULL),"+
              "(20077, 'Employee', '2017-05-01', 20074),"+
              "(20078, 'Admin', '2017-06-10', 20076),"+
              "(20079, 'Database Admin', '2017-07-05', NULL),"+
              "(20080, 'Manager', '2017-08-15', 20078),"+
            "(20081, 'Admin', '2017-09-01', 20079),"+
              "(20082, 'Database Admin', '2017-10-15', NULL),"+
              "(20083, 'Employee', '2017-11-10', 20080),"+
              "(20084, 'Admin', '2017-12-05', 20082),"+
              "(20085, 'Manager', '2016-01-20', 20084),"+
              "(20086, 'Database Admin', '2016-02-15', NULL),"+
              "(20087, 'Admin', '2016-03-01', 20086),"+
              "(20088, 'Employee', '2016-04-10', 20085),"+
              "(20089, 'Database Admin', '2016-05-05', NULL),"+
              "(20090, 'Admin', '2016-06-15', 20089),"+
            "(20091, 'Database Admin', '2016-07-01', NULL),"+
              "(20092, 'Admin', '2016-08-15', 20091),"+
              "(20093, 'Manager', '2016-09-10', 20092),"+
              "(20094, 'Admin', '2016-10-05', 20091),"+
              "(20095, 'Employee', '2016-11-20', 20093),"+
              "(20096, 'Database Admin', '2016-12-15', NULL),"+
              "(20097, 'Admin', '2015-01-01', 20096),"+
              "(20098, 'Employee', '2015-02-10', 20093),"+
              "(20099, 'Database Admin', '2015-03-05', NULL),"+
              "(20100, 'Admin', '2015-04-15',20099)";
            

            statement.executeUpdate(InsertStatement_Employees);

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

