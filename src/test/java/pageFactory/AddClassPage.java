package pageFactory;

import java.time.Duration;
import java.util.List;

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

public class AddClassPage {

	public WebDriver driver = DriverFactory.getDriver();
	public Utility_Methods util = new Utility_Methods();
	public ConfigReader config = new ConfigReader();
	public DataAutoGenerator datagen = new DataAutoGenerator();
	String dashboardURL = ConfigReader.DashboardURL();
	String baseurl = ConfigReader.loginPage();

	WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));

	@FindBy(xpath = "//span[text()='Class']")
	public WebElement ClassBtn;
	@FindBy(xpath = "//p-dialog[@header='Class Details']/div/div")
	public WebElement classDetailsPopupwindow;
	@FindBy(xpath = "//button[normalize-space()='Add New Class']")
	public WebElement AddClassBtn;
	@FindBy(xpath = "//button[@label='Save']")
	public WebElement Save_Class;
	@FindBy(xpath = "//button[@label='Cancel']")
	public WebElement Cancel_class;
	@FindBy(xpath = "//body/app-root/app-session/p-dialog[@header='Class Details']/div/div/div/div/button[@type='button']")
	public WebElement Close_Classpopup;
	@FindBy(xpath = "//input[@placeholder='Select a Batch Name']")
	public WebElement BatchName;
	@FindBy(xpath = "//p-dropdown[@id='batchName']/div/div/span")
	public WebElement Batchname_Dropdownclick;
	// p-dropdown[@id='batchName']//span[@ng-reflect-ng-class='pi pi-chevron-down']
	@FindBy(xpath = "//input[@id='classDescription']")
	public WebElement ClassDescription;
	@FindBy(xpath = "//input[@id='classTopic']")
	public WebElement classTopic;
	@FindBy(xpath = "//input[@id='classNo']")
	public WebElement class_NumberOfClasses;
	@FindBy(xpath = "//input[@placeholder='Select a Staff Name']")
	public WebElement StaffName;
	@FindBy(xpath = "//p-dropdown[@id='staffId']/div/div/span")
	public WebElement Staffname_Dropdownclick;
	// p-dropdown[@id='staffId']//span[@ng-reflect-ng-class='pi pi-chevron-down
	@FindBy(xpath = "//div[@class='p-radiobutton-box']")
	public WebElement classStatus;
	@FindBy(xpath = "//p-radiobutton[@ng-reflect-value='Active']")
	public WebElement Active;
	@FindBy(xpath = "//p-radiobutton[@ng-reflect-input-id='Inactive']")
	public WebElement InActive;
	@FindBy(xpath = "//input[@id='icon']")
	public WebElement ClassDates;
	@FindBy(xpath = "//span[@class='p-button-icon pi pi-calendar']")
	public WebElement Classdate_cal;
	@FindBy(xpath = "//div[contains(@class,'p-datepicker-group-container']")
	public WebElement Calender_window;
	@FindBy(xpath = "//small[text()='Batch Name is required.']")
	public WebElement batchNameEmptyError;
	@FindBy(xpath = "//small[text()='Class Topic is required.']")
	public WebElement classTopicEmptyError;
	@FindBy(xpath = "//small[text()='Status is required.]")
	public WebElement ClassStatusEmptyError;
	@FindBy(xpath = "//small[text()='Number of classes is required.']")
	public WebElement noOfClassesEmptyError;
	@FindBy(xpath = "//small[text()='Staff Name is required.")
	public WebElement staffNameEmptyError;
	@FindBy(xpath = "//small[text()='Class Date is required.']")
	public WebElement classDateEmptyError;
	@FindBy(xpath = "//div[text()='Successful']")
	public WebElement SuccessMsg_Class1;
	@FindBy(xpath = "//div[text()='Class Created']")
	public WebElement SuccessMsg_Class2;

	@FindBy(xpath = "//input[@id='classComments']")
	public WebElement Comments;
	@FindBy(xpath = "//input[@id='classNotes']")
	public WebElement Notes;
	@FindBy(xpath = "//input[@id='classRecordingPath']")
	public WebElement Recording;
	@FindBy(xpath = "//div[@class='signin-content']")
	public WebElement mainwindow;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AddClassPage() {
		PageFactory.initElements(driver, this);
	}

	public void click_class() throws InterruptedException {
		util.webElement_Click(ClassBtn);
	}

	public void click_addclass() throws InterruptedException {
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		util.webElement_Click(AddClassBtn);
	}

	public String getClassDetailsWindow() throws InterruptedException {
		if (util.isElementDisplayed(classDetailsPopupwindow)) {
			util.isElementEnabled(Save_Class);
			Thread.sleep(1000);
			util.isElementEnabled(Cancel_class);
			// Cancel_class.click();
			return util.getElementText(classDetailsPopupwindow);
		} else
			return null;
	}

	public void bootstrap_BatchName_Dropdown() throws InterruptedException {
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Batchname_Dropdownclick.click();
		// List<WebElement> Options =
		// driver.findElements(By.xpath("//p-dropdown[@id='batchName']//span[@ng-reflect-ng-class='pi
		// pi-chevron-down']"));
		WebElement option = driver.findElement(By.xpath(
				"//body[1]/app-root[1]/app-session[1]/p-dialog[1]/div[1]/div[1]/div[2]/div[1]/p-dropdown[1]/div[1]/div[3]/div[1]/ul[1]/p-dropdownitem[3]"));
		option.click();
//		for(WebElement option : Options) {
//			String optionText = option.getText();
//			System.out.println(optionText);
//			if(optionText.equals(config.BatchName())) {
//				option.click();
//			}
//		}
	}

	public void bootstrap_StaffName_Dropdown() {
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		js.executeScript("arguments[0].click();", Staffname_Dropdownclick);
		// List<WebElement> Options =
		// driver.findElements(By.xpath("//div[contains(@class,'p-dropdown-items-wrapper')]/ul/p-dropdownitem"));;
		WebElement option = driver.findElement(By.xpath("//li[@aria-label='Getha Takur']"));
		// driver.findElement(By.xpath("//li[@aria-label='Saranya M']"))
		option.click();

	}

	public void classdate_calender() throws InterruptedException {
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Actions act = new Actions(driver);
		js.executeScript("arguments[0].click();", Classdate_cal);
		//Classdate_cal.click();
		String cur_month = driver.findElement(By.xpath("//span[contains(@class,'p-datepicker-month')]")).getText();
		String cur_year = driver.findElement(By.xpath("//span[contains(@class,'p-datepicker-year')]")).getText();

		while (!(cur_month.equals("November") && cur_year.equals("2024"))) {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[contains(@class,'p-datepicker-next')]")).click();
			cur_month = driver.findElement(By.xpath("//span[contains(@class,'p-datepicker-month')]")).getText();
			cur_year = driver.findElement(By.xpath("//span[contains(@class,'p-datepicker-year')]")).getText();

		}
		driver.findElement(By.xpath("//td[contains(@class,'ng-star-inserted')]/span[text()='21']")).click();
		System.out.println("Date set");
		act.moveToElement(classDetailsPopupwindow).click().perform();
		// classDetailsPopupwindow.click();
	}

	public void classdate_picker() {
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Actions act = new Actions(driver);
		Classdate_cal.click();

		List<WebElement> Weekend_dates = (driver.findElements(By.xpath("//span[contains(@class,'p-disabled')]")));
		for (WebElement weekend : Weekend_dates) {
			if (weekend.equals("Saturday") || weekend.equals("Sunday")) {
				Assert.assertTrue(weekend.getAttribute("class").contains("disabled"), "Weekend date is not disabled");

			}
		}
	}

	public void create_ValidClass() throws InterruptedException {

		bootstrap_BatchName_Dropdown();
		System.out.println("Inside Creation");
		String classtopic = datagen.generateClassTopic();
		classTopic.sendKeys(classtopic);
		System.out.println("before choosing calender");
		Thread.sleep(1000);
		classdate_calender();
		// System.out.println("No Of classes:"+class_NumberOfClasses.getText());
		bootstrap_StaffName_Dropdown();
		Active.click();
		Thread.sleep(1000);
		Save_Class.click();

	}

	public String get_NoOfClass() throws InterruptedException {
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		classdate_calender();
		String value = util.getattribute(class_NumberOfClasses, "ng-reflect-model");
		System.out.println(value);
		return value;

	}

	public void createClass_sendkeys(String value) throws InterruptedException {

		System.out.println("Inside class Creation through seding keys");
		String batchName = "SMPO-0001"+value;
		BatchName.sendKeys(batchName);
		String Staffname = "Saranya"+value;
		String classtopic = "Team15-Testing"+value;
		classTopic.sendKeys(classtopic);
		System.out.println("before choosing calender");
		Thread.sleep(1000);
		classdate_calender();
		// System.out.println(class_NumberOfClasses.getText());
		StaffName.sendKeys(Staffname);
		Active.click();
		Thread.sleep(1000);
		Save_Class.click();

	}

	public void createClass_Optionalfield() throws InterruptedException {

		Comments.sendKeys("Testing");
		Notes.sendKeys("Testing");
		Recording.sendKeys("Testing");
		// Active.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Save_Class);

	}

	public boolean onClick() {
		try {
			Actions act = new Actions(driver);
			Cancel_class.click();
			act.moveToElement(mainwindow).click().perform();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String getSuccessMessageText() throws InterruptedException {
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		String Message1 = SuccessMsg_Class1.getText();
		String Message2 = SuccessMsg_Class2.getText();
		String Message = Message1 + " " + Message2;
		System.out.println("Actual message appeared on the screen is: " + Message);
		return Message;
	}

	public String getEmptyfieldError() {
		String value;
		if (BatchName.getText().isEmpty()) {
			value = batchNameEmptyError.getText();
		} else if (classTopic.getText().isEmpty()) {
			value = classTopicEmptyError.getText();
		} else if (StaffName.getText().isEmpty()) {
			value = staffNameEmptyError.getText();
		} else {
			value = ClassStatusEmptyError.getText();
		}
		System.out.println("Actual Error appeared on the screen is: " + value);
		return value;
	}

}
