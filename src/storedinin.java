import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class storedinin {
    public static void main(String[] args) throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");

        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "system";
        String password = "system";
        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("Connected");

        CallableStatement cst = conn.prepareCall("{call updateMarks(?, ?)}");
        cst.setInt(1, 9); // Set the roll number
        cst.setInt(2, 85); // Set the new marks
        cst.execute();

        System.out.println("Marks updated successfully!");

        cst.close();
        conn.close();
    }
}
