import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
//import java.util.Scanner;

public class batch {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
	
		
			//Scanner sc = new Scanner(System.in);
		Class.forName("oracle.jdbc.OracleDriver");
		Class.forName("oracle.jdbc.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "system";
		String password = "system";
		Connection conn =  DriverManager.getConnection(url, username, password);
		System.out.println("connected");
		Statement st=conn.createStatement();
		String q1 = "insert into student values(5,'fff',31)";
		String q2 = "delete from student where marks = 75 ";
		String q3 = "update student set marks = marks+10 where roll_no=8";
		st.addBatch(q1);
		st.addBatch(q2);
		st.addBatch(q3);
		
		st.executeBatch();
		
		System.out.println("batch update done ");
	}

}
