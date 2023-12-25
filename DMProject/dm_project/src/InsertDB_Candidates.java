import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDB_Candidates {
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

            String InsertStatement_Candidates = "INSERT INTO Candidates (CandidateID, Qualification, Experience)"+
            "VALUES"+
                "(100001, 'Bachelor in Computer Science', 3),"+
                "(100002, 'Master in Business Administration', 5),"+
                "(100003, 'Bachelor in Engineering', 2),"+
                "(100004, 'Bachelor in Computer Science', 4),"+
                "(100005, 'Master in Business Administration', 2),"+
                "(100006, 'Bachelor in Engineering', 3),"+
                "(100007, 'Bachelor in Computer Science', 5),"+
                "(100008, 'Master in Business Administration', 1),"+
                "(100009, 'Bachelor in Engineering', 4),"+
                "(100010, 'Bachelor in Computer Science', 2),"+
                "(100011, 'Master in Computer Science', 4),"+
                "(100012, 'Bachelor in Business Administration', 3),"+
                "(100013, 'Master in Engineering', 2),"+
                "(100014, 'Bachelor in Computer Science', 5),"+
                "(100015, 'Master in Business Administration', 1),"+
                "(100016, 'Bachelor in Engineering', 4),"+
                "(100017, 'Master in Computer Science', 3),"+
                "(100018, 'Bachelor in Business Administration', 2),"+
                "(100019, 'Master in Engineering', 5),"+
                "(100020, 'Bachelor in Computer Science', 1),"+
                "(100021, 'Bachelor in Computer Science', 3),"+
                "(100022, 'Master in Business Administration', 5),"+
                "(100023, 'Bachelor in Engineering', 2),"+
                "(100024, 'Master in Computer Science', 4),"+
                "(100025, 'Bachelor in Business Administration', 2),"+
                "(100026, 'Master in Engineering', 3),"+
                "(100027, 'Bachelor in Computer Science', 5),"+
                "(100028, 'Master in Business Administration', 1),"+
                "(100029, 'Bachelor in Engineering', 4),"+
                "(100030, 'Bachelor in Computer Science', 2),"+
                 "(100031, 'Master in Computer Science', 4),"+
                "(100032, 'Bachelor in Business Administration', 3),"+
                "(100033, 'Master in Engineering', 2),"+
                "(100034, 'Bachelor in Computer Science', 5),"+
                "(100035, 'Master in Business Administration', 1),"+
                "(100036, 'Bachelor in Engineering', 4),"+
                "(100037, 'Master in Computer Science', 3),"+
                "(100038, 'Bachelor in Business Administration', 2),"+
                "(100039, 'Master in Engineering', 5),"+
                "(100040, 'Bachelor in Computer Science', 1),"+
                "(100041, 'Bachelor in Computer Science', 3),"+
                "(100042, 'Master in Business Administration', 5),"+
                "(100043, 'Bachelor in Engineering', 2),"+
                "(100044, 'Master in Computer Science', 4),"+
                "(100045, 'Bachelor in Business Administration', 2),"+
                "(100046, 'Master in Engineering', 3),"+
                "(100047, 'Bachelor in Computer Science', 5),"+
                "(100048, 'Master in Business Administration', 1),"+
                "(100049, 'Bachelor in Engineering', 4),"+
                "(100050, 'Bachelor in Computer Science', 2),"+
                "(100051, 'Master in Computer Science', 4),"+
                "(100052, 'Bachelor in Business Administration', 3),"+
                "(100053, 'Master in Engineering', 2),"+
                "(100054, 'Bachelor in Computer Science', 5),"+
                "(100055, 'Master in Business Administration', 1),"+
                "(100056, 'Bachelor in Engineering', 4),"+
                "(100057, 'Master in Computer Science', 3),"+
                "(100058, 'Bachelor in Business Administration', 2),"+
                "(100059, 'Master in Engineering', 5),"+
                "(100060, 'Bachelor in Computer Science', 1),"+
                "(100061, 'Bachelor in Computer Science', 3),"+
                "(100062, 'Master in Business Administration', 5),"+
                "(100063, 'Bachelor in Engineering', 2),"+
                "(100064, 'Master in Computer Science', 4),"+
                "(100065, 'Bachelor in Business Administration', 2),"+
                "(100066, 'Master in Engineering', 3),"+
                "(100067, 'Bachelor in Computer Science', 5),"+
                "(100068, 'Master in Business Administration', 1),"+
                "(100069, 'Bachelor in Engineering', 4),"+
                "(100070, 'Bachelor in Computer Science', 2),"+
                "(100071, 'Master in Computer Science', 4),"+
                "(100072, 'Bachelor in Business Administration', 3),"+
                "(100073, 'Master in Engineering', 2),"+
                "(100074, 'Bachelor in Computer Science', 5),"+
                "(100075, 'Master in Business Administration', 1),"+
                "(100076, 'Bachelor in Engineering', 4),"+
                "(100077, 'Master in Computer Science', 3),"+
                "(100078, 'Bachelor in Business Administration', 2),"+
                "(100079, 'Master in Engineering', 5),"+
                "(100080, 'Bachelor in Computer Science', 1),"+
                "(100081, 'Bachelor in Computer Science', 3),"+
                "(100082, 'Master in Business Administration', 5),"+
                "(100083, 'Bachelor in Engineering', 2),"+
                "(100084, 'Master in Computer Science', 4),"+
                "(100085, 'Bachelor in Business Administration', 2),"+
                "(100086, 'Master in Engineering', 3),"+
                "(100087, 'Bachelor in Computer Science', 5),"+
                "(100088, 'Master in Business Administration', 1),"+
                "(100089, 'Bachelor in Engineering', 4),"+
                "(100090, 'Bachelor in Computer Science', 2),"+
                 "(100091, 'Master in Computer Science', 4),"+
                "(100092, 'Bachelor in Business Administration', 3),"+
                "(100093, 'Master in Engineering', 2),"+
                "(100094, 'Bachelor in Computer Science', 5),"+
                "(100095, 'Master in Business Administration', 1),"+
                "(100096, 'Bachelor in Engineering', 4),"+
                "(100097, 'Master in Computer Science', 3),"+
                "(100098, 'Bachelor in Business Administration', 2),"+
                "(100099, 'Master in Engineering', 5),"+
                "(100100, 'Bachelor in Computer Science', 1)";
            

            statement.executeUpdate(InsertStatement_Candidates);

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

