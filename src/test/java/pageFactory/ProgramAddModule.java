package pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import drivers.DriverFactory;
import utilities.ConfigReader;
import utilities.Utility_Methods;

public class ProgramAddModule {
    // public static WebDriver driver = DriverFactory.getDriver();
    public WebDriver driver = DriverFactory.getDriver();
    public static ConfigReader configReader = new ConfigReader();
    Utility_Methods util = new Utility_Methods();

    @FindBy(xpath = "//div/button[@id='program']")
    WebElement ProgramModule;
    // @FindBy(xpath="//div//div//div//button[@class='mat-focus-indicator
    // mat-menu-item ng-tns-c225-2']")
    @FindBy(xpath = "//div/button[text()='Add New Program']")
    WebElement addnewProgBtn;
    @FindBy(xpath = "//*[@class='ng-trigger ng-trigger-animation ng-tns-c168-9 p-fluid p-dialog p-component p-dialog-draggable p-dialog-resizable ng-star-inserted']")
    WebElement PopUpWindow;

    @FindBy(xpath = "//span[contains(@class,'p-dialog-title')]")
    public WebElement programDetails;
    @FindBy(xpath = ("//label[@for='programName']//span[1]"))
    public WebElement mandatoryField;

    @FindBy(id = "programName")
    public WebElement inputName;
    @FindBy(id = "programDescription")
    public WebElement inputDescription;
    @FindBy(id = "saveProgram")
    public WebElement saveButton;
    @FindBy(xpath = "//span[contains(@class,'p-dialog-header-close-icon')]")
    public WebElement xButon;
    @FindBy(xpath = "//div[@class='p-radiobutton-box']")
    public List<WebElement> radioButtons;
    @FindBy(xpath = "//p-radiobutton[@ng-reflect-input-id='Active']")
    public WebElement active;
    @FindBy(xpath = "//p-radiobutton[@ng-reflect-input-id='Inactive']")
    public WebElement inactive;
    @FindBy(xpath = "//small[@class='p-invalid ng-star-inserted']")
    public List<WebElement> errorMessage;
    @FindBy(xpath = "//div[contains(text(),'Program Created Successfully')]")
    public WebElement successprogramMessage;

    @FindBy(id = "filterGlobal")
    WebElement searchBar;
    @FindBy(xpath = "//span[text()='Save']")
    public WebElement xSuccessButton;
    @FindBy(xpath = "//span[text()='Save']")

    public WebElement xButton;

    @FindBy(xpath = "//span[text()='Cancel']")
    public WebElement cancelButton;

    public ProgramAddModule() {
        PageFactory.initElements(driver, this);
    }

    // public String getProgramurl() {
    // String url= driver.getCurrentUrl();
    // System.out.println("programurl "+url);
    // return url;
    // }

    // public void clickProgram() {
    // program.click();

    // }
    public void admin_click_program_module_link_Dashboard_1() {
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
        ProgramModule.click();

    }

    // Admin clicks on "New Program" under the "Program" menu bar
    public void addNewProgram() throws InterruptedException {
        // ProgramModule.click();
        util.webElement_Click(addnewProgBtn);
    }

    // Admin should see pop up window for program details
    public boolean PopUpWindow() {
        return PopUpWindow.isDisplayed();
    }

    // Admin should see window title as "Program Details"
    public void assertProgramDetailsTitle() {
        util.assertText(programDetails, "Program Details", "Program Details is not displayed");

    }

    // Admin should see red "*" mark beside mandatory field "Name"
    public void assertAstriskMandatoryFields() {
        util.assertText(mandatoryField, "*", "Mandatory field is not displayed for Name");
    }

    // Admin clicks save button without entering mandatory
    public void clickSaveButton() {
        util.webElement_Click(saveButton);
    }

    // Admin gets message '<field> is required'
    public void assertErrorMessage() {
        Assert.assertEquals(errorMessage.size(), 3);

    }

    // Admin can see Program Details form disappears
    public void programDetailsDisappear() {

    }

    // Admin can see the text entered
    public void enterInputName() {
        util.webSendKeys(inputName, ConfigReader.SearchProgName()+Utility_Methods.random5LetterWord());
    }

    public String getinputName() {
        return util.getElementAttribute(inputName,"ng-reflect-model");
    }

    // Admin can see the text entered in description box
    public void enterInputDescription() {
        util.webSendKeys(inputDescription, ConfigReader.SearchProgDescription()+Utility_Methods.random5LetterWord());
    }

    public String getInputDescription() {
        return util.getElementAttribute(inputDescription,"ng-reflect-model");
    }

    // Admin can see 'Active/Inactive' status selected
    public void selectActiveStatus() {
        active.click();
    }

    // Admin can see 'Active/Inactive' status selected
    public void selectInactiveStatus() {
        inactive.click();
    }

    public String getActiveStatus() {
        return util.getElementAttribute(active,"ng-reflect-value");
    }

    public String getInactiveStatus() {
    	  return util.getElementAttribute(inactive,"ng-reflect-value");
    }
    // Admin en
    // Admin enter valid details for mandatory fields and Click on save button

    // Admin gets message 'Successful Program created'
    public void getSuccessMessage( ) {
    	try {
    		Thread.sleep(1000);
    		// dialog will close and throw exception on accessing the dialog's control
			cancelButton.isDisplayed();
		} catch (Exception e) {
			Assert.assertTrue(true, "Add program is closed");
			// this means the dialog is closed and info is saved
			return;
		}
		Assert.assertTrue(false, "Add program is still displaying and not saved");
    }

    // Admin Click on cancel button
    public void clickCancelButton() {
        cancelButton.click();

    }

	// Admin can see program details form disappear
	public void isAddProgramDisappeared() {
		try {
			//this is to make sure that cancel button is disappeared
			Thread.sleep(1000);
			cancelButton.isDisplayed();
		} catch (Exception e) {
			Assert.assertTrue(true, "Add program is not displayed");
			return;
		}
		Assert.assertTrue(false, "Add program is still displaying");
	}

 

    

    // Admin Click on "X" button
    public void clickXButton() {
    	util.webElement_Click(xButon);
    }

    // Admin can see program details form disappear
    public void xButton() {
    	util.webElement_Click(xButon);
    }

    public void verifyProgramPopup() {
    
    }

    public void validateInput() {
    	
        String inputDescription2 = getInputDescription();
        String getinputName = getinputName();
		Assert.assertTrue(inputDescription2.startsWith(configReader.SearchProgDescription()),"Description is not mentioned");
		Assert.assertTrue(getinputName.startsWith(configReader.SearchProgName()),"Program name is not matching");
		
    }
}
