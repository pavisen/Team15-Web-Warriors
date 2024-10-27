package pageFactory;

import static org.junit.Assert.assertArrayEquals;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.DriverFactory;
import io.cucumber.messages.types.Duration;
import utilities.ConfigReader;
import utilities.Utility_Methods;

public class EditProgramPage {
	public WebDriver driver= DriverFactory.getDriver();
    String baseurl = ConfigReader.loginPage();
    Utility_Methods um=new Utility_Methods();
    
    @FindBy(xpath="//app-header//mat-toolbar//div//button[@id='program']") WebElement ProgramModule;
    @FindBy(id="filterGlobal") WebElement Searchbar;
    @FindBy(xpath="//p-tablecheckbox//div//div[2][@class='p-checkbox-box p-component']") WebElement SingleCheckbox;
    @FindBy(id="editProgram") WebElement EditButton;
    @FindBy(id="pr_id_2-label") WebElement ProgramDetails_Title;
    @FindBy(xpath="//div//div//div[3]//button[1]//span[2]") WebElement CancelButton_Form;
    @FindBy(id="saveProgram") WebElement SaveButton_Form;
    @FindBy (xpath="//app-root//app-program//div/mat-card//mat-card-title//div[1][text()]") WebElement ManageProgramTitle;
    @FindBy(xpath="") WebElement RedStar;
    @FindBy(id="programName") WebElement ProgNameTextbox;
    @FindBy(id="programDescription") WebElement DescriptionTextbox;
    @FindBy(xpath="//div//div[1]//table//tbody//tr//td[2][text()]") WebElement UpdatedProgName;
    @FindBy(xpath="//mat-card-content//p-table//div//div[1]//table//tbody//tr//td[3][text()]") WebElement UpdatedDescription;
    @FindBy(xpath="//div[3]//div[2]//p-radiobutton//div//div[2][@class='p-radiobutton-box p-highlight']") WebElement ActiveButton;
    @FindBy(xpath="//div[3]//div[3]//p-radiobutton//div//div[2][@class='p-radiobutton-box']") WebElement InactiveButton;
    @FindBy(xpath="//div//div//div//div//button[@class='ng-tns-c168-6 p-dialog-header-icon p-dialog-header-close p-link p-ripple ng-star-inserted']") WebElement CloseButtonProgForm;
    @FindBy(id="deleteProgram") WebElement DeleteButtonOnPrgram;
    @FindBy(xpath="//div//div//div//span[@class='p-dialog-title ng-tns-c204-7 ng-star-inserted']") WebElement DeleteDialogbox;
    @FindBy(xpath="//div//div[3]//button//span[@class='p-button-icon p-button-icon-left pi pi-times']") WebElement Delete_Confirm_No;
    @FindBy(xpath="//div//div[3]//button[2]//span[@class='p-button-icon p-button-icon-left pi pi-check']")WebElement Delete_Confirm_Yes;
    @FindBy(xpath="//div//div//button//span[@class='pi pi-times ng-tns-c204-7']") WebElement Delete_Confirm_Close;
    
    public EditProgramPage() {
    	PageFactory.initElements(driver, this);
    }
    public void admin_click_program_module_link_Dashboard() {
    	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
    	ProgramModule.click();
    	System.out.println("Admin is on Program module");
	     Actions actions = new Actions(driver);
	     actions.moveToLocation(100, 200).click().perform();
    }
    public void admin_clicks_on_edit_option_for_particular_program(String SearchProgName) throws InterruptedException {
    	Searchbar.click();
	     Searchbar.sendKeys(SearchProgName);
	     um.waitForElement(Searchbar);
	     //Thread.sleep(500);
	     SingleCheckbox.click();
	     driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
	     EditButton.click();  
	}
    
    public void SingleCheckBox_Click() throws Exception {
    	Thread.sleep(500);
//    	SingleCheckbox.clear();
	     SingleCheckbox.click();
    }
    public void EditButton_Click() {
    	EditButton.click();
    }
    public void DeleteButton_Click() {
    	DeleteButtonOnPrgram.click();
    }
    
    public void admin_lands_on_program_details_form() {
    	driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
    	ProgramDetails_Title.isDisplayed();    
	}
    public void cancel_click() {
    	//driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
    	CancelButton_Form.click();
    }
    public void Save_Button_Click() {
    	driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
    	SaveButton_Form.click();
    }
    public void SearchBar_Write() {
    	Searchbar.sendKeys(ConfigReader.SearchProgName());
    }
//    public void SearchBar_Write_Deleted() {
//    	Searchbar.sendKeys(ConfigReader.SearchDeletedProgName());
//    }
    public void clear_searchfield() {
    	Searchbar.clear();
    }
    public void Verify_Manage_Program_Title() {
    	ManageProgramTitle.isDisplayed();
    }
    public void mandetoryfieldstar() {
    	String Color=RedStar.getCssValue("color");
    	System.out.println("Star is present with color"+Color);
    }
    public void Edit_Prog_Name_Textbox() {
    	ProgNameTextbox.clear();
    	ProgNameTextbox.sendKeys(ConfigReader.GetEditProgramName());
    }
    public void Edit_ProDescription() {
    	DescriptionTextbox.clear();
    	DescriptionTextbox.sendKeys(ConfigReader.GetEditProgramDescription());
    }
    public void Search_Program_Description() {
    	Searchbar.sendKeys(ConfigReader.SearchProgDescription());
    }
    
    public void get_updatedProgName() {
    	String actualProgname=UpdatedProgName.getText();
    	String expectedProgName=ConfigReader.GetEditProgramName();
    	Assert.assertEquals(actualProgname, expectedProgName);
    }
    public void get_updatedProgDescription() {
    	String actualDescription=UpdatedDescription.getText();
    	String expectedDescription=ConfigReader.GetEditProgramDescription();
    	Assert.assertEquals(actualDescription, expectedDescription);
    }
    
    public void StatusChangeRadioButton() {
    	if(ActiveButton.isEnabled()) {
    		InactiveButton.click();
    	}
    	else if(InactiveButton.isEnabled()){
    		ActiveButton.click();
    	}
    }
    public void OpenEditProgramForm() {
    	cancel_click();
		clear_searchfield();
	     SearchBar_Write();
	     EditButton_Click();
    }
    public void CloseProgForm() {
    	CloseButtonProgForm.click();
    }
    public void getDeleteDialogebox() {
    	String ActualResult=DeleteDialogbox.getText();
    	String ExpectedResult="Confirm";
    	Assert.assertEquals(ActualResult, ExpectedResult);
    }
    public void delete_Confirm_Yes() {
    	Delete_Confirm_Yes.click();
    }
    public void delete_Confirm_No() {
    	Delete_Confirm_No.click();
    }
    public void delete_Confirm_Close() {
    	Delete_Confirm_Close.click();
    }
    public void non_exist_prog() {
    	Searchbar.sendKeys("xyz12");
    }
}
