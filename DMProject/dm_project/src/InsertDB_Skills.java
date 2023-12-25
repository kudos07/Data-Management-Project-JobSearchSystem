import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDB_Skills {
    public static void main(String[] args) {
        // Replace with your database details
        String url = "jdbc:mysql://localhost:3306/jobsearch";
        String user = "root";
        String password = "dmproject123@";

        try {
             //Load and register JDBC driver for MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

             //Establish a connection
            Connection connection = DriverManager.getConnection(url, user, password);

             //Create a statement
            Statement statement = connection.createStatement();

            String InsertStatement_Employees = "INSERT INTO Skills (SkillID, SkillName, Experience) VALUES" + 
                    "(700, 'Java Programming', 2)," + 
                    "(701, 'Database Management', 2)," + 
                    "(702, 'Web Development', 4)," + 
                    "(703, 'Project Management', 4)," + 
                    "(704, 'Python Programming', 2)," + 
                    "(705, 'Data Analysis', 5)," + 
                    "(706, 'Agile Methodology', 3)," + 
                    "(707, 'Network Security', 4)," + 
                    "(708, 'UI/UX Design', 2)," + 
                    "(709, 'Machine Learning', 3)," + 
                    "(710, 'C# Programming', 3)," + 
                    "(711, 'Database Administration', 4)," + 
                    "(712, 'Mobile App Development', 2)," + 
                    "(713, 'Product Management', 4)," + 
                    "(714, 'JavaScript Development', 3)," + 
                    "(715, 'Data Science', 5)," + 
                    "(716, 'Scrum Master', 3)," + 
                    "(717, 'Cybersecurity', 4)," + 
                    "(718, 'Graphic Design', 2)," + 
                    "(719, 'Natural Language Processing', 3)," + 
                    "(720, 'Java Programming', 3)," + 
                    "(721, 'Financial Analysis', 4)," + 
                    "(722, 'Digital Marketing', 2)," + 
                    "(723, 'Project Management', 3)," + 
                    "(724, 'Python Programming', 3)," + 
                    "(725, 'Content Marketing', 5)," + 
                    "(726, 'Strategic Planning', 4)," + 
                    "(727, 'Risk Management', 3)," + 
                    "(728, 'Social Media Management', 2)," + 
                    "(729, 'Business Intelligence', 3)," + 
                    "(730, 'JavaScript Development', 2)," + 
                    "(731, 'Market Research', 4)," + 
                    "(732, 'Financial Modeling', 2)," + 
                    "(733, 'Product Marketing', 3)," + 
                    "(734, 'C++ Programming', 2)," + 
                    "(735, 'SEO Optimization', 5)," + 
                    "(736, 'Leadership', 4)," + 
                    "(737, 'Investment Analysis', 3)," + 
                    "(738, 'Email Marketing', 2)," + 
                    "(739, 'Data Visualization', 3)," + 
                    "(740, 'Ruby on Rails Development', 3)," + 
                    "(741, 'Brand Management', 4)," + 
                    "(742, 'Financial Planning', 2)," + 
                    "(743, 'Event Planning', 3)," + 
                    "(744, 'Swift Programming', 2)," + 
                    "(745, 'Content Creation', 5)," + 
                    "(746, 'Flask.', 4)," + 
                    "(747, 'Economic Analysis', 3)," + 
                    "(748, 'Influencer Marketing', 2)," + 
                    "(749, 'Database Design', 3)," + 
                    "(750, 'React.js Development', 3)," + 
                    "(751, 'Public Relations', 4)," + 
                    "(752, 'Accounting', 2)," + 
                    "(753, 'User Interface Design', 3)," + 
                    "(754, 'Corporate Finance', 2)," + 
                    "(755, 'Copywriting', 5)," + 
                    "(756, 'Conflict Resolution', 4)," + 
                    "(757, 'Financial Reporting', 3)," + 
                    "(758, 'Content Strategy', 2)," + 
                    "(759, 'iOS App Development', 3)," + 
                    "(760, 'Event Marketing', 3)," + 
                    "(761, 'Statistical Analysis', 4)," + 
                    "(762, 'Search Engine Marketing', 2)," + 
                    "(763, 'Business Development', 3)," + 
                    "(764, 'Graphic Illustration', 2)," + 
                    "(765, 'Entrepreneurship', 3)," + 
                    "(766, 'Cost Accounting', 2)," + 
                    "(767, 'Video Production', 3)," + 
                    "(768, 'International Business', 2)," + 
                    "(769, 'Vue.js Development', 3)," + 
                    "(770, 'Social Media Advertising', 4)," + 
                    "(771, 'Financial Risk Management', 2)," + 
                    "(772, 'Event Coordination', 3)," + 
                    "(773, 'Scala Programming', 2)," + 
                    "(774, 'Public Speaking', 5)," + 
                    "(775, 'Customer Relationship Management', 4)," + 
                    "(776, 'Tax Planning', 3)," + 
                    "(777, 'Inbound Marketing', 2)," + 
                    "(778, 'Data Warehousing', 3)," + 
                    "(779, 'Angular Development', 3)," + 
                    "(780, 'Market Segmentation', 4)," + 
                    "(781, 'Cost-Benefit Analysis', 2)," + 
                    "(782, 'User Experience Research', 3)," + 
                    "(783, 'Mergers and Acquisitions', 2)," + 
                    "(784, 'Email Campaign Management', 5)," + 
                    "(785, 'Leadership Development', 4)," + 
                    "(786, 'Financial Forecasting', 3)," + 
                    "(787, 'Brand Strategy', 2)," + 
                    "(788, 'Android App Development', 3)," + 
                    "(789, 'Django Web Framework', 3)," + 
                    "(790, 'Content Editing', 4)," + 
                    "(791, 'Real Estate Investment Analysis', 2)," + 
                    "(792, 'Event Marketing Strategy', 3)," + 
                    "(793, 'Kotlin Programming', 2)," + 
                    "(794, 'Brand Awareness', 5)," + 
                    "(795, 'Project Leadership', 4)," + 
                    "(796, 'Financial Compliance', 3)," + 
                    "(797, 'Social Media Analytics', 2)," + 
                    "(798, 'Cloud Database Management', 3)," + 
                    "(799, 'Node.js Development', 3)," + 
                    "(800, 'Marketing Analytics',4)";
            

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
