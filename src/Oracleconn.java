import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.*;

public class Oracleconn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{
		    Class.forName("oracle.jdbc.OracleDriver");
		
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "system";
		String password = "system";
		
		Connection conn =  DriverManager.getConnection(url, username, password);
		System.out.println("connected");
		System.out.println("Creating statement...");
		Statement stmt = conn.createStatement();
		System.out.println("Data Insertion StaRTED...");
		String sql="insert into connectdb values (19,'Dhruv Kundu', '2201139')";
		stmt.executeUpdate (sql); 
		System.out.println("dATA Inserted Successfully...");
		
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
		


		}

}
