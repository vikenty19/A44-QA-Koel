import com.opencsv.CSVReader;
import org.testng.annotations.DataProvider;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class DataProviders {
    @DataProvider(name = "IncorrectLoginProviders")
    public static Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"notExisting@email.com", "NotExistingPassword"},
                {"demo@class.com", ""},
                {"", ""}, {"demo@@class.com", "te$t$tudent"}, {"<include name=test'></include>@class.com", "te$t$tudent"}
        };
    }
    @DataProvider(name = "getSongsData")
    // Method to read the data from .csv file and return it as array
    public Object[][] getData() throws Exception {
        // path to csv file that is located under resources folder
        Reader reader = Files.newBufferedReader(Paths.get(System.getProperty("user.dir") + "/src/test/resources/Songs.csv"));
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> records = csvReader.readAll();
        Object[][] array = null;
        for (int i = 0; i < records.size(); i++) {

            Object[] row = records.get(i);
            if (Objects.isNull(array)) {
                array = new Object[records.size()][row.length];
            }
            array[i][0] = row[0];
            //      array[i][1] = row[1];
            //       array[i][2] = row[3];
        }
        return array;
    }
    @DataProvider(name = "InvalidDataSet")
    public Iterator<Object[]> dataSupplier(){
        List<Object[]> list= new ArrayList<Object[]>();
        list.add(new Object[]{"notExisting@email.com", "NotExistingPassword"});
        list.add(new Object[]{"@gmail.com","!@$%^&&"});
        list.add(new Object[]{"",""});
        return list.iterator();
    }
}
