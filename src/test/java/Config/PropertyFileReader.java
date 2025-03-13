package Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader implements ConfigurationReader{

    Properties prop=null;

	public PropertyFileReader() {
        prop=new Properties();
        File propFile=new File(System.getProperty("user.dir")+"/src/test/resources/ConfigurationFile/config.properties");
        try {
            FileInputStream fis = new FileInputStream(propFile);
            prop.load(fis);
            System.out.println(prop);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return prop.getProperty("url");
    }

    public String getBrowser() {
        return prop.getProperty("browser");
    }

    public int getPageLoadTimeOut() {
        return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
    }


}


