package POM;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetSQLInfo {

    public static String checkSQLPlayListName(String songName) {


        String url = "jdbc:mariadb://104.237.13.60:3306/";
        String dbName = "dbkoel";
        String dbURL = url + dbName;
        String name = "dbuser01";//dbuser01 pa$$01
        String password = "pa$$01";

        Connection connection = null;

          String dbPlistName = "";
        try {
            //connect to Koel DB
            connection = DriverManager.getConnection(dbURL, name, password);
            //verify the connection and execute SQL statement
            if (!connection.isClosed()) {
              //  System.out.println("we are in!");
                // Fire SQL Selection statement
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement
                        .executeQuery("SELECT p.name, count(p.name) FROM dbkoel.playlists p WHERE p.name = '" + songName + "'");

                while (resultSet.next()) {
                    // Getting playlist name from DB
                     dbPlistName = resultSet.getString("p.name");

                   System.out.println(resultSet.getString("p.name") + " ------SQL count  " + resultSet.getString("count(p.name)"));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //close the connection
            try {
                connection.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection.isClosed()) {
                 //   System.out.println("connection is closed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return dbPlistName;
    }
    public static List<String> listOfArtists ()throws SQLException {
        String url = "jdbc:mariadb://104.237.13.60:3306/";
        String dbName = "dbkoel";
        String dbURL = url + dbName;
        String name = "dbuser01";//dbuser01 pa$$01
        String password = "pa$$01";

        Connection connection = DriverManager.getConnection(dbURL, name, password);
        if (!connection.isClosed()) {
            System.out.println("we are in!");
        } else {
            System.out.println("We are not in");
        }
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT art.name  FROM dbkoel.artists art;");// WHERE p.name = '" + plName + "'");
        List<String > artistList = new ArrayList<>();

        while (resultSet.next()) {
                      artistList.add( resultSet.getString("art.name"));
;        }
   //     System.out.println(artistList);

        connection.close();
        return artistList;

    }
    public  static Map<String,List<String>> listOfSongsBelongsToEachAuthor ()throws SQLException {
        String url = "jdbc:mariadb://104.237.13.60:3306/";
        String dbName = "dbkoel";
        String dbURL = url + dbName;
        String name = "dbuser01";//dbuser01 pa$$01
        String password = "pa$$01";

        Connection connection = DriverManager.getConnection(dbURL, name, password);
        if (!connection.isClosed()) {
            System.out.println("we are in!");
        } else {
            System.out.println("We are not in");
        }
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement
                .executeQuery("SELECT art.name,s.title  FROM dbkoel.artists art left join dbkoel.songs s on art .id = s.id ;");// WHERE p.name = '" + plName + "'");
// Collect artist and his songs
        Map<String,List<String>>songListOfArtists = new HashMap<>();
        while (resultSet.next()) {
            String artist = resultSet.getString("art.name");
            String title = resultSet.getString("s.title");

            if(!songListOfArtists.containsKey(artist)){
                songListOfArtists.put(artist,new ArrayList<>());
            };
            songListOfArtists.get(artist).add(title);
        }

        //printing all songs of each author
        for(Map.Entry<String,List<String>>entry: songListOfArtists.entrySet()){//list needed to collect all songs of this autho
            String author= entry.getKey();
            List<String> titles = entry.getValue();
           // System.out.println(author+"---"+titles);
        }
     //   System.out.println(songListOfArtists.get("Till Paradiso").get(0));
        connection.close();
        return songListOfArtists;

    }
}
