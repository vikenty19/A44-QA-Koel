import POM.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class SmartPlayListTest extends BaseTest {

    @Test
    public void createSmartPlistWithNameOfTheSong() {
        BasePage basePage = new BasePage(driver);
        String addedSong = "Episode 2";
        String SmartPlistName = generateRandomPlaylistName() + basePage.timeStamp();
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        loginPage.login(myEmail, myLogin);
        playListPage.plusBtnClick();
        SmartPlayListPage smart = new SmartPlayListPage(driver);
        smart.createSmartPlistWithOutGroup(SmartPlistName, addedSong);
        basePage.isSuccessBannerDisplayed();

        String plName = smart.getSmartPlistName();
        String songTitle = smart.getAddedSongName();
        System.out.println("Song added in the Playlist --" + songTitle);
        System.out.println(" name of created plyList  ---" + plName);
        assertEquals(songTitle, addedSong);
        //  Assert.assertEquals(plName,SmartPlistName);

    }
    @Test
    public void cancelCreatingSmartPlist() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        String SmartPlistName = generateRandomPlaylistName()+basePage.timeStamp();
        String addedSong = "Episode 2";;
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        loginPage.login(myEmail, myLogin);
        playListPage.plusBtnClick();
        SmartPlayListPage smart = new SmartPlayListPage(driver);
        smart.createSmartPlist.click();
        smart.clickPlusToCreatePlist();
        smart.playListName.sendKeys(SmartPlistName);
        smart.songName.sendKeys(addedSong);
        smart.cancelCreatedPlist.click();
        smart.cancelConfirm.click();
        //check Plist has NOT been created
        assertFalse(smart.isSmartPlistCreated(SmartPlistName));
    }

    @Test
    public void createSmartPlistWithNameAndGroup() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage(driver);
        SmartPlayListPage smartPlayListPage = new SmartPlayListPage(driver);
        String addedSong = "Reactor";// this artist name ended with "O" "Reactor"
        String enteredLetter = "o";
        String SmartPlistName = generateRandomPlaylistName() + basePage.timeStamp();
        System.out.println(SmartPlistName);
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        loginPage.login(myEmail, myLogin);
        playListPage.plusBtnClick();
        smartPlayListPage.enterSmartPlistName(SmartPlistName);
        //Add text in the value field
        smartPlayListPage.enterValueToCreateSmartPlist(addedSong);
        //add group title Artist
         smartPlayListPage.selectGroupTitle("Artist");
         //select option in group
        smartPlayListPage.selectOptionInGroup("ends with");
        smartPlayListPage.enterOptionForGroupRule(enteredLetter);
        smartPlayListPage.clickSubmitBtn();
        basePage.isSuccessBannerDisplayed();
        //Check name in the DB
        GetSQLInfo.checkSQLPlayListName(SmartPlistName);

        //Check if Playlist is in the list
        assertTrue(smartPlayListPage.isSmartPlistCreated(SmartPlistName));

        Thread.sleep(1000);//because of instability

        //check the last letter of the artist name
        List<WebElement> songsInSmartPlist = driver.findElements(By.cssSelector("tr td.artist"));
        for (WebElement temp : songsInSmartPlist) {
            String lastLetter = temp.getText();

            // Get last char of the artist name
            if (!lastLetter.isEmpty()) {
                char lastChar = lastLetter.charAt(lastLetter.length() - 1);

                String lastLetterString = "" + lastChar;
                // Assert if result conform to entering last letter of the artist name
                softAssert.assertTrue(lastLetterString.equalsIgnoreCase(enteredLetter));
                //Taking screenShot of the error
                if (!lastLetterString.equalsIgnoreCase(enteredLetter)) {
                    File scrShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    File destinationScrShotFile = new File("./src/test/java/ScreenShots/SmartPlist.png");
                    try {
                        FileHandler.copy(scrShot, destinationScrShotFile);

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                softAssert.assertAll();
            }

        }

    }




    @Test
    public void createPListByArtistName() throws InterruptedException, SQLException {
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        HomePage homePage = new HomePage(driver);
        SmartPlayListPage smart = new SmartPlayListPage(driver);
        loginPage.login(myEmail, myLogin);

        // pick the name of artist
        List<String>artists = GetSQLInfo.listOfArtists();
        Iterator<String> name = artists.iterator();
        // iterate through Artist names
        while (name.hasNext()) {
            String SmartPlistName = generateRandomPlaylistBookName();
            String Artist = name.next();
            //pick the  first song of the chosen artist
            String songArtist = GetSQLInfo.listOfSongsBelongsToEachAuthor().get(Artist).get(0);
            System.out.println(Artist + "  and    Song name ----->   " + songArtist);

            playListPage.plusBtnClick();
            //Create smartPlist
            smart.enterSmartPlistName(SmartPlistName);

            WebElement dropDownField = homePage.waitUntilClickable(By.name("model[]"));
            WebElement dropDownOption = homePage.waitUntilClickable(By.name("operator[]"));

            Select select = new Select(dropDownField);
            select.selectByVisibleText("Artist");

            Select select1 = new Select(dropDownOption);
            select1.selectByVisibleText("is");
            driver.findElement(By.name("value[]")).sendKeys(Artist);
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("footer [type = 'submit']")).click();

            assertTrue(homePage.getAvatar());
            WebElement text = homePage.waitUntilVisible(By
                    .cssSelector("div.song-list-wrap.main-scroll-wrap.playlist td:nth-child(2)"));
            String textOnScreen = text.getText();
            System.out.println(textOnScreen);
            if (!textOnScreen.equalsIgnoreCase(songArtist)) {
                Thread.sleep(300);
                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileHandler.copy(srcFile, new File("./ScreenShots/smartPlist"+Artist+".png"));
                    System.out.println("Song name in Playlist doesn't match DataBase name ");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        }

    }
    @Test(dataProvider = "SmartPlistDataProvider")
    public void createSmartPListWithExelSheetData(String title,String Rule,String letter) throws InterruptedException, IOException {

        String SmartPlistName = generateRandomPlaylistBookName();
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        HomePage homePage = new HomePage(driver);
        SmartPlayListPage smart = new SmartPlayListPage(driver);
        loginPage.login(myEmail, myLogin);
        playListPage.plusBtnClick();
        //Create smartPlist
        smart.enterSmartPlistName(SmartPlistName);

        WebElement dropDownField = homePage.waitUntilClickable(By.name("model[]"));
        WebElement dropDownOption = homePage.waitUntilClickable(By.name("operator[]"));

        Select select = new Select(dropDownField);
           select.selectByVisibleText(title);
        Select select1 = new Select(dropDownOption);
        select1.selectByVisibleText(Rule);
        driver.findElement(By.name("value[]")).sendKeys(letter);
        driver.findElement(By.cssSelector("footer [type = 'submit']")).click();
        assertTrue(homePage.getAvatar());
        // Check songs in the playlist
        String artistName = driver.findElement(By
                .cssSelector(".song-list-wrap.main-scroll-wrap.playlist .virtual-scroller .artist")).getText();
        System.out.println(artistName);
        Character firstLetter = artistName.charAt(0);
        System.out.println(firstLetter);
        assertTrue(firstLetter.toString().equalsIgnoreCase(letter));
        Thread.sleep(2000);

    }



@DataProvider(name = "SmartPlistDataProvider")
        public Object[][] exelSheetData () throws IOException {
            String exelProperty = System.getProperty("user.dir") + "/src/test/resources/pairwise.xlsx";
            File exelFile = new File(exelProperty);
            FileInputStream fis = new FileInputStream(exelFile);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("pairwise");
            //find number of rows in the sheet table
            int rowsCount = (sheet.getPhysicalNumberOfRows());

            //find number of columns
            int colCount = sheet.getRow(0).getLastCellNum();
            //create Object Array to pass the data
            //  Iterator<Row> rows= sheet.iterator();
            Object[][] data = new Object[rowsCount-1][colCount];//rowCount-1 because first row is names of columns
            for (int i = 0; i < rowsCount-1; i++) {
                XSSFRow row = sheet.getRow(i+1);// i +1 because first row is names of columns
                for (int j = 0; j < colCount; j++) {
                    XSSFCell cell = row.getCell(j);
                    CellType cellType = cell.getCellType();
                    switch (cellType) {
                        case STRING:
                            data[i][j] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            data[i][j] = cell.getNumericCellValue();
                            break;

                        case BOOLEAN:
                            data[i][j] = cell.getBooleanCellValue();
                            break;
                    }


                }
            }
            for (Object[] row : data) {
                for (Object cell : row) {
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
            return data;
        }

    @Test(dataProvider = "alphabet")//Checking first letter of the artists names in the list of songs
    public void plListByArtistNamesFirstLetterCheck(char letter) {


        Character firstLetterOfArtistName = letter;
        String SmartPlistName = generateRandomPlaylistBookName();
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        HomePage homePage = new HomePage(driver);
        SmartPlayListPage smart = new SmartPlayListPage(driver);
        loginPage.login(myEmail, myLogin);
        playListPage.plusBtnClick();
    //    driver.findElement(By.cssSelector("[data-testid =playlist-context-menu-create-smart]")).click();
     //   driver.findElement(By.name("name")).sendKeys(SmartPlistName);
        WebElement dropDownField = homePage.waitUntilClickable(By.name("model[]"));
        WebElement dropDownOption = homePage.waitUntilClickable(By.name("operator[]"));

        Select select = new Select(dropDownField);
        select.selectByVisibleText("Artist");

        Select select1 = new Select(dropDownOption);
        select1.selectByVisibleText("begins with");
        driver.findElement(By.name("value[]")).sendKeys(firstLetterOfArtistName.toString());
        driver.findElement(By.cssSelector("footer [type = 'submit']")).click();
        assertTrue(homePage.getAvatar());
        // Check List of songs in the playlist
        List<WebElement> artistName = driver.findElements(By
                .cssSelector(".song-list-wrap.main-scroll-wrap.playlist .virtual-scroller .artist"));
        if (artistName.size() == 0) {
            String message = driver.findElement(By.cssSelector("#playlistWrapper .screen-placeholder .text")).getText();
            assertTrue(message.contains("No songs match the playlist's "));
            System.out.println("No song like that");
        }
        for (WebElement temp : artistName) {
            String name = temp.getText();
            System.out.println(name);
            Character firstLetter = name.charAt(0);
            String a = firstLetter.toString();
            assertTrue(a.equalsIgnoreCase(firstLetterOfArtistName.toString()));
        }

    }

    @DataProvider(name = "alphabet")
    public Object[][] returnChar() {
        Object[][] alphabet = new Object[26][1];
        for (int i = 0; i < 26; i++) {
            alphabet[i][0] = (char) ('a' + i);
        }
        return alphabet;
    }


}