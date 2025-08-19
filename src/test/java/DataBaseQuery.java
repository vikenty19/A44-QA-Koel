import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseQuery {


     public static List<String> listOfArtists()throws SQLException {
            String url = "jdbc:mariadb://104.237.13.60:3306/";
            String dbName = "dbkoel";
            String dbURL = url + dbName;
            String name = "dbuser01";//dbuser01 pa$$01
            String password = "pa$$01";
            String plName = "Sausage Dog";

            Connection connection = DriverManager.getConnection(dbURL, name, password);
            if (!connection.isClosed()) {
                System.out.println("we are in!");
            } else {
                System.out.println("We are not in");
            }
            Statement statement = connection.createStatement();
            //   ResultSet resultSet = statement.executeQuery("SELECT p.name, count(p.name) FROM dbkoel.playlists p WHERE p.name = '" + plName + "'");
            ResultSet resultSet = statement.executeQuery("SELECT art.name  FROM dbkoel.artists art;");// WHERE p.name = '" + plName + "'");
            List<String > plist = new ArrayList<>();

            while (resultSet.next()) {
                //      plist.add( resultSet.getString("p.name"));
                plist.add( resultSet.getString("art.name"));
                //     System.out.println("Number of songs in the DB is = "+ songs.size());
                //   System.out.println(plist+ "____");//+ resultSet.getString("count(art.name)"));

            }
            System.out.println((plist));

            connection.close();
            return plist;

        }
    public List<String> listOfArtistSongs ()throws SQLException {
        String url = "jdbc:mariadb://104.237.13.60:3306/";
        String dbName = "dbkoel";
        String dbURL = url + dbName;
        String name = "dbuser01";//dbuser01 pa$$01
        String password = "pa$$01";
        String plName = "Sausage Dog";

        Connection connection = DriverManager.getConnection(dbURL, name, password);
        if (!connection.isClosed()) {
            System.out.println("we are in!");
        } else {
            System.out.println("We are not in");
        }
        Statement statement = connection.createStatement();
        //   ResultSet resultSet = statement.executeQuery("SELECT p.name, count(p.name) FROM dbkoel.playlists p WHERE p.name = '" + plName + "'");
        ResultSet resultSet = statement.executeQuery("SELECT art.name  FROM dbkoel.artists art;");// WHERE p.name = '" + plName + "'");
        List<String > plist = new ArrayList<>();

        while (resultSet.next()) {
            //      plist.add( resultSet.getString("p.name"));
            plist.add( resultSet.getString("art.name"));
            //     System.out.println("Number of songs in the DB is = "+ songs.size());
            //   System.out.println(plist+ "____");//+ resultSet.getString("count(art.name)"));

        }
        System.out.println((plist));

        connection.close();
        return plist;

    }

}




