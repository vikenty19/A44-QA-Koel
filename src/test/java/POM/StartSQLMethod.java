package POM;

import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Date;

public class StartSQLMethod {
    public static void main(String[] args) throws SQLException {
        GetSQLInfo getSQLInfo = new GetSQLInfo();
      //  getSQLInfo.checkSQLPlayListName("Sausage Dog");
       getSQLInfo.listOfSongsBelongsToEachAuthor();
     //  getSQLInfo.listOfArtists();

    }


}