package sqlin;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by User on 4/29/17.
 * Loads JDBC driver to connect with the MySQL database
 *
 */
public class LoadDriver {

    public static void main(String[] args) throws IOException

    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:8889/nothings-on";
//        String username = "root";
//        String password = "YES";

        FileToDatabase fileToDatabase = new FileToDatabase();

        ArrayList films = fileToDatabase.fileToDatabse("text-netflix-output-full-part2.txt");

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/nothings-on?" +
                    "user=nothings-on&password=nothing");

            stmt = conn.createStatement();

            String updateQuery8 = "INSERT INTO film (title, year, type, genre, imdb_rating, netflix_rating, " +
                    "poster, description) VALUES ";

            String updateQuery10 = "INSERT INTO film (title, year, type, genre, actors, imdb_rating, netflix_rating, " +
                    "length, poster, description) VALUES ";

            for(int i = 0; i < films.size(); i++ ) {
                //System.out.println(updateQuery + films.get(i).toString());

                String currentFilm = films.get(i).toString();

                int filmCount = currentFilm.split("\"").length;

                String sql;
                if (filmCount == 17) {
                    sql = updateQuery8 + currentFilm;
                    stmt.executeUpdate(sql);
                }

                else {
                    System.out.println(currentFilm);
                }

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
