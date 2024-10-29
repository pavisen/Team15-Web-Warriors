package utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    
	
    private static Properties properties;
    private final static String propertyFilePath = ".\\config\\config.properties";    
    
    
    public static void readConfig() throws Throwable {
        InputStream fis;
        fis = ConfigReader.class.getClassLoader().getResourceAsStream(propertyFilePath);
        properties = new Properties();
        if (fis == null) {
            throw new FileNotFoundException("Property file '" + propertyFilePath + "' not found in the classpath");
        }
        try {
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
   
    
    // Invalid BaseURL
    public static String Invalid_BaseURL()
    {
    	String InvalidBaseURL=properties.getProperty("InvalidBaseURL");
   	 if (InvalidBaseURL != null)
		    return InvalidBaseURL;
   	 else 
   		 throw new RuntimeException("Username not specified in the Config.properties file");
    }
  
    
    //DashboardURL
    
    public static String DashboardURL()
    {    	
    	 String DashboardURL=properties.getProperty("dashboardurl");
    	 if (DashboardURL != null)
		    return DashboardURL;
    	 else 
    		 throw new RuntimeException("Username not specified in the Config.properties file");
    }

        //DashboardURL
    
        public static String baseUrl()
        {    	
             String BaseURL=properties.getProperty("baseurl");
             if (BaseURL != null)
                return BaseURL;
             else 
                 throw new RuntimeException("Username not specified in the Config.properties file");
        }
    
    //DashboardClassURL
	public static String dashboardclassurl() {
		String DashboardclassURL=properties.getProperty("dashboardclassurl");
   	 if (DashboardclassURL != null)
		    return DashboardclassURL;
   	 else 
   		 throw new RuntimeException("Username not specified in the Config.properties file");
	}
    
    // UserName
    public static String userName()
    {    	
    	 String loginUserName=properties.getProperty("username");
    	 if (loginUserName != null)
		    return loginUserName;
    	 else 
    		 throw new RuntimeException("Username not specified in the Config.properties file");
    }
    
    // Password
    public static String passWord()
    {    	
    	 String loginPassword=properties.getProperty("password");
    	 if (loginPassword != null)
		    return loginPassword;
    	 else 
    		 throw new RuntimeException("Password not specified in the Config.properties file");
    }
    // BatchName
    public static String BatchName()
    {    	
    	 String batchname=properties.getProperty("BATCHNAME");
    	 if (batchname != null)
		    return batchname;
    	 else 
    		 throw new RuntimeException("Batchname not specified in the Config.properties file");
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

 
   

    public static String getexcelfilepath() {
        String excelfilelpath = properties.getProperty("excelFilePath");
        if (excelfilelpath != null)
            return excelfilelpath;
        else
            throw new RuntimeException("Excel file path not specified in the Configuration.properties file.");
    }
    
    //Program Name
    public static String GetEditProgramName()
    {    	
    	 String EditProgramName=properties.getProperty("EditProgramName");
    	 if (EditProgramName != null)
		    return EditProgramName;
    	 else 
    		 throw new RuntimeException("EditProgram not specified in the Config.properties file");
    }
    
    //Edit_Program Description
    public static String GetEditProgramDescription()
    {    	
    	 String EditProgDesc=properties.getProperty("EditProgramDescription");
    	 if (EditProgDesc != null)
		    return EditProgDesc;
    	 else 
    		 throw new RuntimeException("EditDescription not specified in the Config.properties file");
    }
    
  //Search Program Name
    public static String SearchProgName()
    {    	
    	 String SearchProgName=properties.getProperty("SearchProgName");
    	 if (SearchProgName != null)
		    return SearchProgName;
    	 else 
    		 throw new RuntimeException("Program name is not specified in the Config.properties file");
    }
    //Search Program Description
    public static String SearchProgDescription()
    {    	
    	 String SearchProgDesc=properties.getProperty("SearchProgDesc");
    	 if (SearchProgDesc != null)
		    return SearchProgDesc;
    	 else 
    		 throw new RuntimeException("Program Description is not specified in the Config.properties file");
    }


    // public static String geturl(String pagename) {
    //     String url = properties.getProperty(pagename);
    //     if (url != null)
    //         return url;
    //     else
    //         throw new RuntimeException(pagename + " url not specified in the Configuration.properties file.");
    // }

    