import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class prepared {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
	
		
		Class.forName("oracle.jdbc.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "mca";
        String password = "mca";
        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("Connected");
     

        String q = "INSERT INTO electric_item (item_id, item_name, item_price) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(q);

        Scanner scanner = new Scanner(System.in);

        int n;
        do {
            System.out.print("Enter the number of records to insert: ");
            n = scanner.nextInt();
        } while (n <= 0);

        scanner.nextLine();

        int i = 0;
        do {
            i++;
           

            System.out.print("Enter itm_id : ");
            int itm_id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter itm_name : ");
            String itm_name = scanner.nextLine();

            System.out.print("Enter itm_price : ");
            int itm_price = scanner.nextInt();
            scanner.nextLine();

            preparedStatement.setInt(1, itm_id);
            preparedStatement.setString(2, itm_name);
            preparedStatement.setInt(3, itm_price);

            preparedStatement.executeUpdate();
        } while (i < n);

        preparedStatement.close();
        conn.close();
        scanner.close();
            scanner.close();
        }
}
    

