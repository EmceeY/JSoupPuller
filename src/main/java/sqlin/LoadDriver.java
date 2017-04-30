package sqlin;

import java.sql.*;

/**
 * Created by User on 4/29/17.
 * Loads JDBC driver to connect with the MySQL database
 *
 */
public class LoadDriver {

    public static void main(String[] args)

    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:8889/nothings-on";
//        String username = "root";
//        String password = "YES";

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/nothings-on?" +
                    "user=nothings-on&password=nothing");

            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT * FROM film");

            while (rs.next()){
                String name = rs.getString("title");
                System.out.println(name);

            }


            System.out.println(rs.getString("title"));

        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        finally{
            if(rs != null){
                try{
                    rs.close();
                } catch (SQLException sqlEx) { }

                rs = null;
            }

            if (stmt != null){
                try{
                    stmt.close();
                } catch (SQLException sqlEx) { }

                stmt = null;
            }
        }
    }
}
