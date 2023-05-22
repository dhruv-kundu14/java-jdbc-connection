import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.*;

public class Oracleconn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{
			Scanner sc = new Scanner(System.in);
		    Class.forName("oracle.jdbc.OracleDriver");
		
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "system";
		String password = "system";
		
		Connection conn =  DriverManager.getConnection(url, username, password);
		System.out.println("connected");
		String q = "insert into connectdb values(?,?,?)";
		PreparedStatement pst = conn.prepareStatement(q);
		char ch=0;
		String c = null;
		int n=0;
		do {
			System.out.println("Enter Roll no");
			int r = sc.nextInt();
			System.out.println("Enter Name");
			String name = sc.next();
			System.out.println("Enter marks");
			double m = sc.nextDouble();
			pst.setInt(1, r);
			pst.setString(2, name);
			pst.setDouble(3, m);
			n=pst.executeUpdate();
			System.out.println("Do you want to continue");
			c  = sc.next();
			ch = c.charAt(0);
			}
		while(ch=='y' || ch=='Y');
		
		if(n>0) {
			System.out.println("Data inserted");
		}
		else {
			System.out.println("Not Inserted");
		}
		
/*		System.out.println("Creating statement...");
		Statement stmt = conn.createStatement();
		System.out.println("Data Insertion StaRTED...");
		String sql="insert into connectdb values (19,'Dhruv Kundu', '2201139')";
		stmt.executeUpdate (sql); 
		System.out.println("dATA Inserted Successfully...");
		*/
		
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
		
		
		


		}

}
