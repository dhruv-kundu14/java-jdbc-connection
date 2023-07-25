import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class transactiondemo {

    public static void main(String[] args) {
        int count = 0;
        Connection conn = null;
        Statement st = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");

            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String username = "system";
            String password = "system";
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");

            conn.setAutoCommit(false);
            st = conn.createStatement();

            st.executeUpdate("insert into student values(13, 'kkk', 99)");
            count++;
            System.out.println("Operation executed: " + count);

            st.executeUpdate("insert into student values(14, 'ooo', 89)");
            count++;
            System.out.println("Operation executed: " + count);

            st.executeUpdate("insert into student values(15, 'iii', 66)");
            count++;
            System.out.println("Operation executed: " + count);

            st.executeUpdate("insert into student values(16, 'hhh', 44)");
            count++;
            System.out.println("Operation executed: " + count);

            st.executeUpdate("insert into student values(20, 'eee', 33)");
            count++;
            System.out.println("Operation executed: " + count);

            conn.commit();
            System.out.println("Data inserted");
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                conn.rollback();
                System.out.println("Transaction rolled back");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        } finally {
            try {
                if (st != null)
                    st.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
