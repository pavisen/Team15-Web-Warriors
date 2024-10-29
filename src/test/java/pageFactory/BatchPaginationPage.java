package pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.DriverFactory;
import utilities.Utility_Methods;

public class BatchPaginationPage {

	public   WebDriver driver= DriverFactory.getDriver();
	Utility_Methods utm= new Utility_Methods();
	
	@FindBy(xpath ="//span[@class='p-paginator-icon pi pi-angle-right']")
  	public WebElement nextbutton;
	
	@FindBy(xpath ="//span[@class='p-paginator-icon pi pi-angle-double-right']")
  	public WebElement doublearrowrightbutton;
	
	@FindBy(xpath ="//button[@class='p-paginator-next p-paginator-element p-link p-ripple p-disabled']")
  	public WebElement disablenextbutton;
	
	@FindBy(xpath ="//button[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted p-disabled']")
  	public WebElement disabledoublearrowrightbutton;
	
	@FindBy(xpath ="//span[@class='p-paginator-icon pi pi-angle-left']")
  	public WebElement backbutton;
	
	@FindBy(xpath ="//span[@class='p-paginator-icon pi pi-angle-double-left']")
  	public WebElement doublearrowleftbutton;
	
	
	@FindBy(xpath ="//button[@class='p-paginator-prev p-paginator-element p-link p-ripple p-disabled']")
  	public WebElement disablebackbutton;
	
	@FindBy(xpath ="//button[@class='p-paginator-first p-paginator-element p-link p-ripple ng-star-inserted p-disabled']")
  	public WebElement disabledoublearrowleftbutton;
	
	
	public BatchPaginationPage() {
		PageFactory.initElements(driver,this);
	  }
	
	
	public void clicknextpagelink() throws InterruptedException {
		 utm.waitForElement(nextbutton);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();",nextbutton);
	     }
		
	public boolean isNextLinkEnabled() {
		System.out.println(doublearrowrightbutton.isEnabled());
	    return doublearrowrightbutton.isEnabled();
	}
	
	public void clicklastpagelink() throws InterruptedException {
		 utm.waitForElement(doublearrowrightbutton);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();",doublearrowrightbutton);
		 Thread.sleep(1000);
	}
	
	public boolean[] nextandlastlinksdisabled() throws InterruptedException {
		 utm.waitForElement(disabledoublearrowrightbutton);
		 System.out.println(disabledoublearrowrightbutton.isEnabled());
		 utm.waitForElement(disablenextbutton);
		 System.out.println(disablenextbutton.isEnabled());
		 return new boolean[] {disabledoublearrowrightbutton.isEnabled(), disablenextbutton.isEnabled()};
	} 
	
	public void clickbackwardpagelink() {
		utm.waitForElement(backbutton);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();",backbutton);
	     }
	
	
	public boolean isPreviousLinkEnabled() {
		System.out.println(doublearrowleftbutton.isEnabled());
	    return doublearrowleftbutton.isEnabled();
	}
	
	public void clickfirstpagelink() throws InterruptedException {
		 utm.waitForElement(doublearrowleftbutton);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();",doublearrowleftbutton);
		 Thread.sleep(1000);
		
	 }
	
	
	public boolean[] backwardandpreviouslinksdisabled() throws InterruptedException {
		 utm.waitForElement(disabledoublearrowleftbutton);
		 System.out.println(disabledoublearrowleftbutton.isEnabled());
		 utm.waitForElement(disablebackbutton);
		 System.out.println(disablebackbutton.isEnabled());
		 return new boolean[] {disabledoublearrowleftbutton.isEnabled(), disablebackbutton.isEnabled()};
	}
	
	
}
