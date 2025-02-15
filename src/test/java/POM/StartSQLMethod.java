package POM;

import org.testng.annotations.Test;

import java.util.Date;

public class StartSQLMethod {
    public static void main(String[] args) {
        GetSQLInfo getSQLInfo = new GetSQLInfo();
        getSQLInfo.checkSQLPlayListName("Sausage Dog");
    }


}