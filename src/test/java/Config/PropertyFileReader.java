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
    public String getEmail(){
        return prop.getProperty("email");
    }
    public String getPassword(){
        return prop.getProperty("password");
    }

    public String getBrowser() {
        return prop.getProperty("browser");
    }

    public int getPageLoadTimeOut() {
        return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
    }
    public String getProduct(){
        return prop.getProperty("product");
    }
    public String getProduct(String product){
        return prop.getProperty(product);
    }


}


