package pageFactory;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.io.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.DriverFactory;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import utilities.ConfigReader;
import utilities.Utility_Methods;




public class HomePage {

	
	public  WebDriver driver= DriverFactory.getDriver();
    String dashboardURL=ConfigReader.DashboardURL();
	String baseurl = ConfigReader.loginPage();
	 Utility_Methods util=new Utility_Methods();	 
	 Actions actions = new Actions(DriverFactory.getDriver());
	 LoginPage loginpage= new LoginPage();
		
	@FindBy(xpath="//*[starts-with(text(), 'Please')]")
	WebElement signInmesg;
		
	 @FindBy(partialLinkText = "please") 
	 WebElement LMStext;
	 
	 @FindBy(xpath = "//*[contains(text(),'User')]") 
	 WebElement userText;
	 
	 @FindBy(xpath = "//*[contains(text(),'Password')]") 
	 WebElement passwordText; 
	 
	 @FindBy(xpath="//img[@src='assets/img/LMS-logo.jpg']")
	 WebElement companyLogo;
	
	 @FindBy(xpath="//img")
	 WebElement DashboardImage;
	
	 
	  public HomePage() {

			PageFactory.initElements(driver, this);		

		}
	 
	public void getInvalidbaseurl() {
		driver.get(ConfigReader.Invalid_BaseURL());
	}
	
	
	public int BrokenLinkValidation() throws MalformedURLException, IOException
	{
		int i=0;
		int Rescode=-1;
		List<WebElement> links = DriverFactory.getDriver().findElements(By.tagName("link"));		
		
		for(WebElement link : links)
		{			
			String url=link.getAttribute("href");
			
				if(url==null || url.isEmpty())
				{
					continue;
				}
			
			HttpURLConnection huc = (HttpURLConnection) (new URL(url).openConnection());
			huc.connect();
			
			 Rescode=huc.getResponseCode();
			
			if(Rescode>=400)
			{
				i++;				
				System.out.println("Broken Links " + i);
			}
			else{}		
			
		}
		return i;
	}
	
		
		public int InvalidURLValidation() throws IOException {
			
			URL url = new URL(ConfigReader.Invalid_BaseURL());
			 HttpURLConnection huc = (HttpURLConnection) url.openConnection();
	         huc.setRequestMethod("GET");
	         huc.connect();
	         int responseCode = huc.getResponseCode();
	         return responseCode;
		}
		
		
	public Boolean homePageTextValidation()
	{
		util.waitForElement(loginpage.loginbtn);
		String Alltexts= DriverFactory.getDriver().findElement(By.cssSelector("body")).getText();
		List<String> stringsToValidate = Arrays.asList("User *", "Password *", "Please login to LMS application","Login");
		for (String expectedText : stringsToValidate) {
            if (!Alltexts.toLowerCase().contains(expectedText.toLowerCase())) {
               
                return false;
            }
        }
       
        return true;
    }
	
	
	public boolean companyLogoValidation() 
	{
		// Get the position of the logo image
				Point logoImagePosition = companyLogo.getLocation();
				int logoImageOnX = logoImagePosition.getX();
				// to Check if the logo image is in the left side it should be less than 50
				boolean isImageInLeft = logoImageOnX < 50;
				System.out.println("logoImageOnX::"+logoImageOnX+",isImageInLeft::"+isImageInLeft);
				// Output the result
				if (isImageInLeft) {
					System.out.println("Yes, Logo image is in the left side.");
					return true;
				} else {
					System.out.println("No, Logo image is not in the left side.");
					return false;
				}

	}
	
	public boolean appicationNameValidation(String ExpText,boolean order) throws TesseractException, IOException 
	{
		
		util.waitForElement(signInmesg);       
        
        // Take a screenshot of the image
        File imageFile = DashboardImage.getScreenshotAs(OutputType.FILE);
        File tempFile = new File("temp_image.png");
        FileHandler.copy(imageFile, tempFile);         

        // Initialize Tesseract
        
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C://Program Files//Tesseract-OCR//tessdata"); 
        tesseract.setLanguage("eng"); 

        // Extract text from the image
        String extractedText = tesseract.doOCR(tempFile);      
    	        if(order) {        	
        	int LMSIndex = extractedText.indexOf("LMS");
        	int NumpytIndex = extractedText.indexOf("Numpy");
        
        	if(ExpText.contains("LMS") && LMSIndex <NumpytIndex) {
            	
            	return true;
        	}else if(ExpText.contains("Numpy") && NumpytIndex > LMSIndex) {
        		System.out.println("Numpy is after LMS"); 
            	return true;
        	}
        	
        }else {
        	if(extractedText.contains(ExpText)) 
            	return true;
            else
            	return false;               
        }
        return false;
	}
		
	
	
	
	
public Boolean signIncontentValidation()
{
	util.waitForElement(signInmesg);	
	if(signInmesg.isDisplayed())	
	return true;
	else
		return false;

}

public int VerifyingTextfieldCount()
{
	util.waitForElement(loginpage.loginbtn);
	List<WebElement> TextFields= DriverFactory.getDriver().findElements(By.xpath("//form//mat-form-field"));
	int TextFieldCount=TextFields.size();	
	return TextFieldCount;
	
}
	
public Boolean verifyingTextField(String text)

{
	util.waitForElement(loginpage.loginbtn);
	List<WebElement> textFields= DriverFactory.getDriver().findElements(By.xpath("//form//mat-form-field"));
	
	switch (text) {
    case "User": 
    	
        if (textFields.get(0).getText().contains(text)) {   
        	System.out.println(textFields.get(0).getText());
            return true;
        }
        break;

    case "Password":        
        if (textFields.get(1).getText().contains(text)) {
        	System.out.println(textFields.get(1).getText());
        	 return true;
        }
        break;
        
    case "User *" :
    	 if (textFields.get(0).getText().equalsIgnoreCase(text)) {
        	 return true;
        }
        break;
        
    case "Password *" :
    	
   	 if (textFields.get(1).getText().equalsIgnoreCase(text)) {
       	 return true;
       }
       break;
    default:
        System.out.println("Invalid text input.");
        
}
	return false;
}


public Boolean loginBtnEnable()
{
	util.waitForElement(loginpage.loginbtn);
	if(loginpage.loginbtn.isEnabled())
	return true;
	else 
		return false;
}

public boolean loginBtnAllignment()
{
	util.waitForElement(loginpage.loginbtn);
	int expectedX =631;
	int expectedY = 499;
	
    int loginBtnX = loginpage.loginbtn.getLocation().getX();
    int loginBtnY = loginpage.loginbtn.getLocation().getY();    

    // Check if the input field is centered
    if (loginBtnX== expectedX && loginBtnY == expectedY) {
    	
        return true;
    } else {
    	return false;
    }
    
}


public boolean adminTextColorValidation(String Text)
{	
	util.waitForElement(userText);	
	String expectedColor = "rgba(0, 0, 0, 0.54)";
	
	switch (Text) {
    case "User": 	
    	  String textColor = userText.getCssValue("color");    	  
            if (textColor.equalsIgnoreCase(expectedColor))
            return true;       
            break;

    case "Password": 
    	  String PasstextColor = passwordText.getCssValue("color");    	  
    	    if (PasstextColor.equalsIgnoreCase(expectedColor))
            return true;       
            break;
            
    default:
		return false;
	}
	
	return false;
}



}	


  
  
  
  
  

	
	

	

