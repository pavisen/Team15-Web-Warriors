package pageFactory;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.DriverFactory;
import utilities.Utility_Methods;

public class BatchEditPage {

    public   WebDriver driver= DriverFactory.getDriver();
    Utility_Methods utm= new Utility_Methods();

	@FindBy(xpath = "//span[text()='Batch']")
	public  WebElement Batch;
	
	@FindBy(xpath = "//table/tbody/tr[1]/td[7]/div/span[1]/button")
	public  WebElement BatchEditIcon;
	
	@FindBy(xpath = "//span[text()='Batch Details']")
	public  WebElement BatchDetailsPopUptext;
	
	@FindBy(id="programName")
	public static WebElement ProgNameDisabled;
	
	@FindBy(id="batchName")
	public  WebElement BatchNameDisabled;
	
	@FindBy(id="batchName")
	public  WebElement BatchNameDisablednn;
	
	@FindBy(id="batchDescription")
	public  WebElement BatchDescription;
	
	@FindBy(xpath="//div[@class='p-radiobutton-box p-highlight']//span[@class='p-radiobutton-icon']")
	public  WebElement Radiobuttonactive;
	
	@FindBy(xpath="//*[@id=\"batchStatus\"][@ng-reflect-input-id='INACTIVE']")
	public  WebElement RadiobuttonInactive;
	
	@FindBy(xpath="//input[@id='batchNoOfClasses']")
	public  WebElement BatchnoofClassesdd;
	
	@FindBy(xpath="//*[@id='text-danger']")
	public  WebElement errortext;
	
	@FindBy(xpath="//div[text()='Successful']")
	public  WebElement successmessage1;
	
	@FindBy(xpath="//div[text()='batch Updated']")
	public  WebElement successmessage2;
	
	@FindBy(xpath="//button[@ng-reflect-label='Save']")
	public  WebElement savebutton;
	
	@FindBy(xpath="//button[@ng-reflect-label='Cancel']")
	public  WebElement cancelbutton;
	
	@FindBy(xpath="//*[text()=' Manage Batch']")
	public  WebElement Managebatch;
	
	@FindBy(xpath="	//span[contains(@class,'p-dialog-header-close-icon ng-tns-c168-33 pi pi-times')]")
	public  WebElement closebutton;
	

	
	
	
	//span[contains(@class,'p-dialog-header-close-icon ng-tns-c168-33 pi pi-times')]
	
	
	
	public BatchEditPage() {
		PageFactory.initElements(driver,this);
	}
	

   public void Clickbatch() {
	   Batch.click();
     }
   
   public void ClickbatchEditIcon() throws InterruptedException {
	   Thread.sleep(1000);
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("arguments[0].click();", BatchEditIcon);
     }
   
   
   public String checkingpopupwindow() {
   String Text=BatchDetailsPopUptext.getText();
    return Text;
	   
   }
   
   public Boolean ProgNameDisable() {
	Boolean status1= ProgNameDisabled.isEnabled();
	System.out.println(status1);
	return status1;
   }

	public Boolean BatchNameDisable() {
		Boolean status= BatchNameDisabled.isEnabled();
		System.out.println(status);
		return status;	
	}
	
	public void enterinvalidvalues() throws InterruptedException {
		utm.waitForElement(BatchDescription);
		BatchDescription.clear();
		BatchDescription.sendKeys("1 month Java class");
		utm.waitForElement(BatchnoofClassesdd);
		BatchnoofClassesdd.clear();
		BatchnoofClassesdd.sendKeys("");
	}
	
	public void enterallmandatoryfields() throws InterruptedException {
		BatchDescription.clear();
		BatchDescription.sendKeys("Java class");
//		utm.waitForElement(Radiobuttonactive);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
// 	    js.executeScript("arguments[0].click();", Radiobuttonactive);
//		Radiobuttonactive.click();
		
		
		utm.waitForElement(BatchnoofClassesdd);
		BatchnoofClassesdd.clear();
		BatchnoofClassesdd.sendKeys("50");
		
	}
	
   
    public String errormessage() {
    	return errortext.getText();
    }
    
    
    public void clicksavebutton() {
    	utm.waitForElement(savebutton);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
 	    js.executeScript("arguments[0].click();", savebutton);
     }
    
    public void clickcancelbutton() {
    	utm.waitForElement(cancelbutton);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
 	    js.executeScript("arguments[0].click();", cancelbutton);
     }
    
     public String[] sucessmessgetext() throws InterruptedException {
    	 Thread.sleep(1000);
    	String text1=successmessage1.getText();
    	String text2=successmessage2.getText();
    	return new String[] {text1,text2};
    
    }
    
     public String Managebatchpage() {
     	return Managebatch.getText();
     }
    
    
   
   
}