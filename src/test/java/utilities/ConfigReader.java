package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    //private final static String propertyFilePath = "./src/test/resources/config/config.properties";
    private final static String propertyFilePath = "./config/config.properties";

    public static void readConfig() throws Throwable {

        InputStream fis;
        fis = ConfigReader.class.getClassLoader().getResourceAsStream(propertyFilePath);
    	
        properties = new Properties();
		//FileInputStream fis = new FileInputStream(propertyFilePath);

        if (fis == null) {
        	
            throw new FileNotFoundException("Property file '" + propertyFilePath + "' not found in the classpath");
        }
        try {
        	System.out.println("Iam loading properties!!!!");
            properties.load(fis);	
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Browser Type
    public static String browserType() {
        String browser = properties.getProperty("browser");
        LoggerLoad.info("Get Browser Type from Properties");
        if (browser != null)
            return browser;
        else
            throw new RuntimeException("Browser Not Specified in Config.Properties file");
    }


    // Signin URL
    public static String loginPage() {
        String loginurl = properties.getProperty("baseurl");
        if (loginurl != null)
            return loginurl;
        else
            throw new RuntimeException("login not specified in the Config.properties file");
    }
    public static String getHomePageTitle() {
		String url = properties.getProperty("homePageTitle");
		if (url != null)
			return url;
		else
			throw new RuntimeException("homeURL"
					+ " not specified in the Configuration.properties file.");
	}
   

    public static String getexcelfilepath() {
        String excelfilelpath = properties.getProperty("excelFilePath");
        if (excelfilelpath != null)
            return excelfilelpath;
        else
            throw new RuntimeException("Excel file path not specified in the Configuration.properties file.");
    }

  public static String getValidDetails(String detail)
  {
	  String validData = properties.getProperty("detail");
	return null;
	  
  }


    // public static String geturl(String pagename) {
    //     String url = properties.getProperty(pagename);
    //     if (url != null)
    //         return url;
    //     else
    //         throw new RuntimeException(pagename + " url not specified in the Configuration.properties file.");
    // }

    public static void setBrowserType(String browser) {
        System.out.println("----------------------------Setting browser type to: " + browser);
        properties.setProperty("browser", browser);
    }
}