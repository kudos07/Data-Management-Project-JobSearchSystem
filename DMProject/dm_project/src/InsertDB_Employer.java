import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDB_Employer {
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

            String InsertStatement_Employer = "INSERT INTO employers (EmployerID, EnterpriseName, CEO, Location, Address)"+
            "VALUES"+ 
                "(101, 'Acme Corporation', 'John Doe', 'New York', '123 Main St'),"+
                "(102, 'Tech Innovators Ltd.', 'Jane Smith', 'San Francisco', '456 Elm St'),"+
                "(103, 'Data Dynamics Inc.', 'Mark Johnson', 'Los Angeles', '789 Oak St'),"+
                "(104, 'Global Innovations Group', 'Emily Brown', 'London', '10 Baker St'),"+
                "(105, 'Innovative Solutions Co.', 'Michael Lee', 'Tokyo', '22 Sakura Ave'),"+
                "(106, 'Digital Insights Corporation', 'Sarah Davis', 'Paris', '7 Rue de la Paix'),"+
                "(107, 'FutureTech Ventures Ltd.', 'Alex Turner', 'Berlin', '15 Friedrichstrasse'),"+
                "(108, 'International Ventures Inc.', 'Olivia Clark', 'Sydney', '30 King St'),"+
                "(109, 'Digital Solutions Co.', 'Ethan Wilson', 'Toronto', '25 Maple Rd'),"+
                "(110, 'Advanced Systems Ltd.', 'Sophia Martinez', 'Dubai', '5 Sheikh Zayed Rd'),"+
                "(111, 'Tech Solutions Ltd.', 'Jacob Anderson', 'Houston', '40 Oak Ave'),"+
                "(112, 'Global Innovations Inc.', 'Sophie Turner', 'Mumbai', '55 Palm St'),"+
                "(113, 'Digital World Enterprises', 'William Harris', 'Singapore', '18 Orchard Rd'),"+
                "(114, 'Infinite Technologies Ltd.', 'Chloe Wilson', 'Seoul', '77 Gangnam Blvd'),"+
                "(115, 'Creative Minds Co.', 'Daniel Evans', 'Osaka', '9 Sakura Rd'),"+
                "(116, 'Smart Systems Corporation', 'Ava Garcia', 'Madrid', '3 Gran Via'),"+
                "(117, 'Innovative Solutions Group', 'Noah Roberts', 'Stockholm', '12 Sveavagen'),"+
                "(118, 'NextGen Enterprises', 'Lily Brown', 'Moscow', '8 Red Square'),"+
                "(119, 'TechVision Innovations', 'James Clark', 'Melbourne', '14 Collins St'),"+
                "(120, 'GlobalTech Solutions', 'Mia Thompson', 'Dublin', '50 Connell St'),"+
                "(121, 'Tech Innovators Inc.', 'Ella Wilson', 'Vancouver', '100 Main St'),"+
                "(122, 'InnoTech Solutions', 'David Moore', 'Rome', '5 Colosseum Ave'),"+
                "(123, 'GlobalTech Enterprises', 'Harper Jackson', 'Cape Town', '25 Ocean View Rd'),"+
                "(124, 'Innovative Ideas Corp.', 'Logan Garcia', 'Amsterdam', '15 Keizersgracht'),"+
                "(125, 'FutureTech Solutions', 'Zoe Martinez', 'Hong Kong', '8 Nathan Rd'),"+
                "(126, 'Dynamic Innovations Ltd.', 'Nathan Turner', 'Buenos Aires', '20 Avenida 9 de Julio'),"+
                "(127, 'Infinite Innovations Ltd.', 'Madison Hill', 'Zurich', '35 Bahnhofstrasse'),"+
                "(128, 'Elevate Technologies', 'Tyler Scott', 'Vienna', '12 Ringstrasse'),"+
                "(129, 'Advanced Innovations Inc.', 'Peyton Phillips', 'Brussels', '7 Grand Place'),"+
                "(130, 'TechGenius Corporation', 'Aiden Morris', 'Edinburgh', '22 Royal Mile'),"+
                "(131, 'Innovative Solutions Ltd.', 'Avery Turner', 'Toronto', '123 Yonge St'),"+
                "(132, 'GlobalTech Innovations', 'Evelyn White', 'Berlin', '45 Alexanderplatz'),"+
                "(133, 'Future Innovations Corporation', 'Brooklyn Turner', 'Sydney', '30 George St'),"+
                "(134, 'Innovative Minds Inc.', 'Riley Martinez', 'Tokyo', '7 Shibuya Crossing'),"+
                "(135, 'Tech Visionaries Ltd.', 'Madeline Stewart', 'Paris', '15 Champs-Élysées'),"+
                "(136, 'InnoSystems Solutions Ltd.', 'Hudson Murphy', 'Barcelona', '20 Passeig de Gracia'),"+
                "(137, 'NewGen Technologies', 'Eva Adams', 'Seoul', '88 Gangnam Blvd'),"+
                "(138, 'Global Innovators Corp.', 'Parker Miller', 'New Delhi', '25 Connaught Place'),"+
                "(139, 'NextTech Solutions', 'Addison Carter', 'Dubai', '40 Sheikh Zayed Rd'),"+
                "(140, 'Digital Innovations Inc.', 'Brooklyn Evans', 'London', '5 Oxford St'),"+
                "(141, 'Global Innovations Solutions', 'Luna Sanchez', 'Singapore', '75 Marina Bay'),"+
                "(142, 'NextGen Innovations Ltd.', 'Christopher Rivera', 'Hong Kong', '18 Victoria Rd'),"+
                "(143, 'FutureTech Innovations Inc.', 'Ellie Turner', 'Berlin', '35 Friedrichstrasse'),"+
                "(144, 'Innovative Tech Solutions', 'Gabriel Wilson', 'Dubai', '60 Al Maktoum Rd'),"+
                "(145, 'TechVision Corporation', 'Natalie Foster', 'Los Angeles', '10 Hollywood Blvd'),"+
                "(146, 'InnoTech Innovations', 'Sebastian Hall', 'Paris', '28 Rue de Rivoli'),"+
                "(147, 'Innovate Systems Inc.', 'Levi Foster', 'Sydney', '14 Darling Harbour'),"+
                "(148, 'Global Future Enterprises', 'Sofia Mitchell', 'Rome', '22 Vatican Ave'),"+
                "(149, 'Digital Innovations Solutions', 'Aria Richardson', 'Mumbai', '9 Gateway St'),"+
                "(150, 'InnoGenius Technologies', 'Hannah Adams', 'Moscow', '7 Red Square'),"+
                "(151, 'InnovaTech Corporation', 'Lucas Campbell', 'Barcelona', '33 Rambla de Catalunya'),"+
                "(152, 'Future Innovations Ltd.', 'Allison Gray', 'Toronto', '28 King St'),"+
                "(153, 'NextGen Innovations Inc.', 'Maxwell Turner', 'Berlin', '9 Unter den Linden'),"+
                "(154, 'Innovative Minds Solutions', 'Savannah Nelson', 'Los Angeles', '20 Sunset Blvd'),"+
                "(155, 'TechGenius Innovations', 'Lincoln Brooks', 'Sydney', '12 Opera House'),"+
                "(156, 'Digital Innovations Solutions', 'Aria Richardson', 'Paris', '17 Champs-Élysées'),"+
                "(157, 'InnoVision Corporation', 'Jaxon Adams', 'London', '6 Piccadilly Circus'),"+
                "(158, 'GlobalTech Innovations Inc.', 'Lillian Hughes', 'New York', '50 Times Square'),"+
                "(159, 'InnoFuturTech Ltd.', 'Christian Perez', 'Tokyo', '5 Ginza Ave'),"+
                "(160, 'Innovate Systems Corporation', 'Hailey Cooper', 'Dubai', '16 Burj Khalifa St'),"+
                "(161, 'NextTech Innovations Ltd.', 'Grayson Bennett', 'Hong Kong', '3 Victoria Harbour'),"+
                "(162, 'Global Innovations Solutions', 'Luna Sanchez', 'Rome', '8 Colosseum Square'),"+
                "(163, 'TechVision Innovations Inc.', 'Mateo Ramirez', 'Sydney', '25 Bondi Beach'),"+
                "(164, 'FutureTech Solutions Ltd.', 'Nova Parker', 'Paris', '11 Montmartre Rd'),"+
                "(165, 'InnoTech Innovations Inc.', 'Owen Thompson', 'Barcelona', '42 Passeig de Gracia'),"+
                "(166, 'Innovative Solutions Corporation', 'Harper Wright', 'London', '10 Trafalgar Square'),"+
                "(167, 'TechGenius Innovations Inc.', 'Piper Martinez', 'Berlin', '15 Kurfürstendamm'),"+
                "(168, 'GlobalTech Solutions Ltd.', 'Xavier Edwards', 'New York', '60 Broadway'),"+
                "(169, 'Future Innovations Corporation', 'Brooklyn Turner', 'Los Angeles', '8 Hollywood Blvd'),"+
                "(170, 'NextGen Innovations Solutions', 'Eliana Wood', 'Sydney', '28 Circular Quay'),"+
                "(171, 'InnoTech Innovations Ltd.', 'Miles Ward', 'Tokyo', '7 Akihabara Ave'),"+
                "(172, 'Innovate Systems Inc.', 'Levi Foster', 'Paris', '14 Louvre Plaza'),"+
                "(173, 'Digital Innovations Corporation', 'Zara Campbell', 'Dubai', '20 Sheikh Zayed Rd'),"+
                "(174, 'Global Innovations Solutions Inc.', 'Colton Morgan', 'Toronto', '25 Queen St'),"+
                "(175, 'TechVision Innovations Ltd.', 'Elise Nelson', 'Mumbai', '9 Marine Drive'),"+
                "(176, 'InnovaTech Solutions Corporation', 'Finn Parker', 'Barcelona', '30 La Rambla'),"+
                "(177, 'InnoGenius Innovations Inc.', 'Cameron Reed', 'Hong Kong', '11 Victoria Rd'),"+
                "(178, 'GlobalTech Innovations Solutions', 'Sienna White', 'Rome', '18 Via del Corso'),"+
                "(179, 'NextTech Innovations Corporation', 'Kai Patterson', 'Seoul', '22 Gangnam Blvd'),"+
                "(180, 'Innovative Minds Solutions Inc.', 'Dakota Barnes', 'Moscow', '5 Red Square'),"+
                "(181, 'InnoFuturTech Corporation', 'Ruby Coleman', 'Dubai', '12 Palm Jumeirah'),"+
                "(182, 'Future Innovations Solutions Inc.', 'Phoenix Howard', 'London', '6 Oxford St'),"+
                "(183, 'TechGenius Innovations Solutions', 'Emery Mitchell', 'New York', '55 Wall St'),"+
                "(184, 'NextGen Innovations Corporation', 'Aubrey Cooper', 'Tokyo', '4 Shinjuku Ave'),"+
                "(185, 'GlobalTech Solutions Corporation', 'Kian Bell', 'Los Angeles', '18 Sunset Blvd'),"+
                "(186, 'InnoTech Innovations Solutions', 'Carter Rodriguez', 'Berlin', '25 Friedrichstrasse'),"+
                "(187, 'Digital Innovations Corporation', 'Zara Campbell', 'Los Angeles', '12 Hollywood Blvd'),"+
                "(188, 'TechVision Innovations Solutions', 'Jesse Simmons', 'Paris', '30 Champs-Élysées'),"+
                "(189, 'Future Innovations Solutions Ltd.', 'Aurora Sanders', 'New York', '45 Broadway'),"+
                "(190, 'Innovative Minds Solutions Corporation', 'Beckett Cooper', 'Sydney', '22 Circular Quay'),"+
                "(191, 'InnoGenius Innovations Corporation', 'Paige Gonzalez', 'Toronto', '18 King St'),"+
                "(192, 'GlobalTech Solutions Corporation', 'Kian Bell', 'Tokyo', '3 Ginza Ave'),"+
                "(193, 'NextGen Innovations Solutions Ltd.', 'Mila Ramirez', 'Dubai', '14 Sheikh Zayed Rd'),"+
                "(194, 'InnoFuturTech Innovations Solutions', 'Brody Watson', 'London', '8 Piccadilly Circus'),"+
                "(195, 'TechGenius Innovations Corporation', 'Adalyn Gray', 'Barcelona', '35 Rambla de Catalunya'),"+
                "(196, 'Future Innovations Solutions Corporation', 'Kaden Hughes', 'Moscow', '6 Red Square'),"+
                "(197, 'InnovaTech Innovations Corporation', 'Eli Baldwin', 'Hong Kong', '9 Victoria Rd'),"+
                "(198, 'Global Innovations Solutions Corporation', 'Everly Wood', 'Seoul', '20 Gangnam Blvd'),"+
                "(199, 'Innovate Systems Solutions Corporation', 'Jensen Price', 'Mumbai', '7 Marine Drive'),"+
                "(200, 'NextTech Innovations Solutions Ltd.', 'Isla Ward', 'Rome', '11 ColosseumSquare')";

            statement.executeUpdate(InsertStatement_Employer);

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
