//import java.sql.CallableStatement;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.util.Scanner;
//import java.sql.*;
//
//public class storedprocedure {
//
//	public static void main(String[] args)throws Exception {
//		// TODO Auto-generated method stub
//		Class.forName("oracle.jdbc.OracleDriver");
//		Class.forName("oracle.jdbc.OracleDriver");
//		
//		String url = "jdbc:oracle:thin:@localhost:1521:XE";
//		String username = "system";
//		String password = "system";
//		Connection conn =  DriverManager.getConnection(url, username, password);
//		System.out.println("connected");
//		
//		CallableStatement cst = conn.prepareCall("{call upData(?,?)}");
//		Scanner sc = new Scanner(System.in);
//		System.out.println("ENTER ROLL NO :");
//		int num = sc.nextInt();
//		cst.setInt(1, num);
//		cst.registerOutParameter(2, Types.VARCHAR);
//		cst.execute();
//		System.out.println("Name of student "+cst.getString(2));
//		 cst.close();
//       conn.close();
//	}
//
//}


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class storedprocedure {

    public static void main(String[] args) throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");
        
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "system";
        String password = "system";
        Connection conn =  DriverManager.getConnection(url, username, password);
        System.out.println("Connected");
        
        CallableStatement cst = conn.prepareCall("{call upData(?, ?)}");
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER ROLL NO:");
        int num = sc.nextInt();
        cst.setInt(1, num);
        cst.registerOutParameter(2, Types.VARCHAR);
        cst.execute();
        System.out.println("Name of student: " + cst.getString(2));

        
        cst.close();
        conn.close();
    }
}
