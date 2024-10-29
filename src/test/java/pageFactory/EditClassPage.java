package pageFactory;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import drivers.DriverFactory;
import utilities.ConfigReader;
import utilities.DataAutoGenerator;
import utilities.Utility_Methods;

public class EditClassPage {
	

	public WebDriver driver = DriverFactory.getDriver();
	public Utility_Methods util = new Utility_Methods();
	public ConfigReader config = new ConfigReader();
	public DataAutoGenerator datagen = new DataAutoGenerator();
	String dashboardURL = ConfigReader.DashboardURL();
	String baseurl = ConfigReader.loginPage();
	ManageClassPage manageClassPage = new ManageClassPage();
	AddClassPage addClassPage = new AddClassPage();
	
	@FindBy(xpath = "//table[@role='grid']/tbody/tr/td[8]/div/span/button[1]")public  WebElement editClassButton;
	@FindBy(xpath = "//table[@role='grid']/tbody/tr/td[8]/div/span/button[2]") public  WebElement deleteEACHClassButton;	
	@FindBy(xpath = "//div[text()='Successful']")
	public WebElement SuccessMsg_Class1;
	@FindBy(xpath = "//div[text()='Class Updated']")
	public WebElement SuccessMsg_updateClass2;

	WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	

	public EditClassPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void check_Disabled_fields(){
		//WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Actions act = new Actions(driver);
		//Classdate_cal.click();

		List<WebElement> disabled_fields = (driver.findElements(By.xpath("//div[contains(@class,'p-disabled')]")));
		for (WebElement field : disabled_fields) {
			System.out.println("field"+field);
			if (field.equals("Batch Name") || field.equals("Class Topic ")) {
				Assert.assertTrue(field.getAttribute("class").contains("disabled"), "Fields are not disabled");

			}
		}
	}
	
	public void searchClass(String input) {
		System.out.println("Inside Search Bar");
		manageClassPage.searchBarPage.clear();
		manageClassPage.searchBarPage.sendKeys(input);
	}

	public void editClassDetailsWindow() throws InterruptedException {
		searchClass(config.BatchName());
		System.out.println("Before Clicking edit");
		 //Thread.sleep(1000);
		 js.executeScript("arguments[0].click();", editClassButton);	
		//util.webElement_Click(deleteEACHClassButton);
		
	}
	public void update_validClass() throws InterruptedException {
		System.out.println("Inside Updation");
		String classtopic = datagen.generateClassTopic();
		//addClassPage.classTopic.sendKeys(classtopic);
		System.out.println("before choosing calender");
		Thread.sleep(1000);
		addClassPage.classdate_calender();
		addClassPage.bootstrap_StaffName_Dropdown();
		addClassPage.Active.click();
		addClassPage.Comments.sendKeys("Testing");
		addClassPage.Notes.sendKeys("Testing");
		addClassPage.Recording.sendKeys("Testing");
		js.executeScript("arguments[0].click();", addClassPage.Save_Class);
		
		
	}
	public void EditClass_invalid() throws InterruptedException {
        String value="344*&668";
		System.out.println("Inside class updation invalid");
		String Staffname = "Saranya"+value;
		String classDesc = "Team15-Testing"+value;
		addClassPage.ClassDescription.sendKeys(classDesc);
		System.out.println("before choosing calender");
		Thread.sleep(1000);
		addClassPage.classdate_calender();
		// System.out.println(class_NumberOfClasses.getText());
		addClassPage.StaffName.sendKeys(Staffname);
		js.executeScript("arguments[0].click();", addClassPage.InActive);
		js.executeScript("arguments[0].click();", addClassPage.Save_Class);

	}
	public String getUpdateMessageText() throws InterruptedException {
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		String Message1 = SuccessMsg_Class1.getText();
		String Message2 = SuccessMsg_updateClass2.getText();
		String Message = Message1 + " " + Message2;
		System.out.println("Actual message appeared on the screen is: " + Message);
		return Message;
	}

}
