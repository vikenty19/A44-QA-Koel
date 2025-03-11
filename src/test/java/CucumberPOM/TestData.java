package CucumberPOM;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "LoginData")
    public static Object[][] getData() {
        return new Object[][]{
                {"@", "<>test</>"},
                {,}, {"#?", "MEGAdelta06"}
        };
    }
}
