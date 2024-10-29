package pageFactory;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.DriverFactory;
import utilities.ConfigReader;
import utilities.DataAutoGenerator;
import utilities.Utility_Methods;

public class DeleteClassPage {

	public WebDriver driver = DriverFactory.getDriver();
	public Utility_Methods util = new Utility_Methods();
	public ConfigReader config = new ConfigReader();
	public DataAutoGenerator datagen = new DataAutoGenerator();
	String dashboardURL = ConfigReader.DashboardURL();
	String baseurl = ConfigReader.loginPage();
	ManageClassPage manageClassPage = new ManageClassPage();
	AddClassPage addClassPage = new AddClassPage();
	EditClassPage editClassPage = new EditClassPage();
	
	@FindBy(xpath = "//div[@ng-reflect-ng-style='[object Object]']")public  WebElement DeletionAlert;
	@FindBy(xpath = "//table[@role='grid']/tbody/tr/td[8]/div/span/button[2]") public  WebElement deleteEACHClassButton;
	@FindBy(xpath = "//button[@ng-reflect-ng-class='p-confirm-dialog-reject']")public  WebElement DeletionAlertNO;
	@FindBy(xpath = "//button[@ng-reflect-ng-class='p-confirm-dialog-accept']")public  WebElement DeletionAlertYES;
	@FindBy(xpath = "//div[contains(@class,'p-dialog-header-icons ng-tns-c204-91')]/button")public WebElement DeletionAlertClose;
	@FindBy(xpath = "//div[text()='Class Deleted']")
	public WebElement SuccessMsg_deleteClass2;
	
	
WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
	

	public  DeleteClassPage() {
	
		PageFactory.initElements(driver, this);
	}
	
	public void deleteClassDetailsWindow() throws InterruptedException {
		editClassPage.searchClass(config.BatchName());
		System.out.println("Before Clicking delete");
		 Thread.sleep(1000);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();", deleteEACHClassButton);	
		//util.webElement_Click(deleteEACHClassButton);
		
	}
	
	public void checkDelete_alertbox() {
		
		util.isElementDisplayed(DeletionAlert);
	}
	public String getDeleteMessageText() throws InterruptedException {
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		String Message2 = SuccessMsg_deleteClass2.getText();
		System.out.println("Actual message appeared on the screen is: " + Message2);
		return Message2;
	}
	
}
