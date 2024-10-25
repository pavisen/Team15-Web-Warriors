package pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.DriverFactory;

public class BatchEditPage {

    public   WebDriver driver= DriverFactory.getDriver();

	@FindBy(xpath = "//span[text()='Batch']")
	public  WebElement Batch;
	
	@FindBy(xpath = "//table/tbody/tr[1]/td[7]/div/span[1]/button")
	public  WebElement BatchEditIcon;
	
	@FindBy(id="programName")
	public static WebElement ProgNameDisabled;
	
	@FindBy(id="batchName")
	public  WebElement BatchNameDisabled;
	

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
   
   
   
}