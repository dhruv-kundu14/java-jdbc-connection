import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class absolute {

    public static void main(String[] args) {
        try {
            // Establish database connection
        	String url = "jdbc:oracle:thin:@localhost:1521:XE";
    		String username = "system";
    		String password = "system";
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database.");

            // Create a Statement object
            Statement statement = conn.createStatement();

            // Execute the query and retrieve the result set
            String query = "SELECT * FROM Student";
            ResultSet resultSet = statement.executeQuery(query);

            // Move the cursor to the 3rd row
            boolean rowExists = resultSet.absolute(3);
            if (rowExists) {
                // Retrieve data from the current row
                int rollNo = resultSet.getInt("roll_no");
                String name = resultSet.getString("name");
                int marks = resultSet.getInt("marks");

                // Print the retrieved data
                System.out.println("Roll No: " + rollNo);
                System.out.println("Name: " + name);
                System.out.println("Marks: " + marks);
            } else {
                System.out.println("Requested row does not exist.");
            }

            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
