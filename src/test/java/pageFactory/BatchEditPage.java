package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.DriverFactory;

public class BatchEditPage {

    public static  WebDriver driver= DriverFactory.getDriver();

	@FindBy(xpath = "//span[text()='Batch']")
	public static WebElement Batch;
	
	@FindBy(xpath = "//table/tbody/tr[1]/td[7]/div/span[1]/button")
	public static WebElement BatchEditIcon;
	
	@FindBy(id="programName")
	public static WebElement ProgNameDisabled;
	
	@FindBy(id="batchName")
	public static WebElement BatchNameDisabled;
	

	public BatchEditPage() {
		PageFactory.initElements(driver,this);
	}
	

   public void Clickbatch() {
	   Batch.click();
     }
   
   public void ClickbatchEditIcon() {
	  BatchEditIcon.click();
     }
   
   
   
}