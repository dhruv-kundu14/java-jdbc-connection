import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class fetchrow {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Class.forName("oracle.jdbc.OracleDriver");

            String url = "jdbc:oracle:thin:@localhost:1521:XE";
    		String username = "system";
    		String password = "system";

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database.");

            String sqlQuery = "SELECT * FROM student";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                int roll_no = resultSet.getInt("roll_no");
                String name = resultSet.getString("name");
                int marks = resultSet.getInt("marks");

                System.out.println("roll_no: " + roll_no + ", Name: " + name + ", marks: " + marks);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
