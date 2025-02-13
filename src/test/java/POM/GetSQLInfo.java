package POM;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class GetSQLInfo {

    public String getSQLData(String songName) {


        String url = "jdbc:mariadb://104.237.13.60:3306/";
        String dbName = "dbkoel";
        String dbURL = url + dbName;
        String name = "dbuser01";//dbuser01 pa$$01
        String password = "pa$$01";

        Connection connection;

        {
            try {
                connection = DriverManager.getConnection(dbURL, name, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (!connection.isClosed()) {
                    System.out.println("we are in!");
                } else {
                    System.out.println("We are not in");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            Statement statement;

            {
                try {
                    statement = connection.createStatement();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            ResultSet resultSet;

            {
                try {
                    resultSet = statement.executeQuery("SELECT p.name, count(p.name) FROM dbkoel.playlists p WHERE p.name = '" + songName + "'");

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            //  Map<String, String> songs = new HashMap<>();
            while (true) {
                try {
                    if (!resultSet.next()) break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
       /*     try {
                songs.put(resultSet.getString("p.name"), resultSet.getString("count(p.name)"));
            } catch (SQLException e) {
                throw new RuntimeException(e);*/
            }
            // System.out.println(resultSet.getString("id")+"--"+resultSet.getString("email")+"----"+ resultSet.getString("password"));
            try {
                System.out.println(resultSet.getString("p.name") + " ------  " + resultSet.getString("count(p.name)"));
                try {
                    return resultSet.getString("p.name");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


            //   System.out.println("Number of songs in the DB is = " + songs.size());
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        }

    }

