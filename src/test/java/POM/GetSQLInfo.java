package POM;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class GetSQLInfo {

    public void getSQLData(String songName) {


        String url = "jdbc:mariadb://104.237.13.60:3306/";
        String dbName = "dbkoel";
        String dbURL = url + dbName;
        String name = "dbuser01";//dbuser01 pa$$01
        String password = "pa$$01";

        Connection connection = null;


        try {
            //connect to Koel DB
            connection = DriverManager.getConnection(dbURL, name, password);
            //verify the connection and execute SQL statement
            if (!connection.isClosed()) {
                System.out.println("we are in!");
                // Fire SQL Selection statement
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement
                        .executeQuery("SELECT p.name, count(p.name) FROM dbkoel.playlists p WHERE p.name = '" + songName + "'");

                while (resultSet.next()) {
                    System.out.println(resultSet.getString("p.name") + " ------  " + resultSet.getString("count(p.name)"));
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
                    System.out.println("connection is closed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
