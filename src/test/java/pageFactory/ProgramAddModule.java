package pageFactory;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import drivers.DriverFactory;
import utilities.ConfigReader;
import utilities.Utility_Methods;


public class ProgramAddModule {
	public static WebDriver driver = DriverFactory.getDriver();
     public static ConfigReader configReader = new ConfigReader();

	@FindBy(xpath = "//button/span[text()='Program']")
    WebElement program;
	 @FindBy(xpath = "//button[text()='Add New Program']")
	    WebElement addNewProgramBtn;
        @FindBy(xpath = "//span[@class='p-dialog-title ng-tns-c168-22 ng-star-inserted']")
        public WebElement programDetails;
    @FindBy(id = "programName")
     public WebElement inputName;
    @FindBy(id = "programDescription")
    public WebElement inputDescription;
    @FindBy(id = "saveProgram")
    public WebElement saveButton;
    @FindBy(xpath = "//span[@class='p-dialog-header-close-icon ng-tns-c132-3 pi pi-times']")
    public WebElement xButon;
    @FindBy(xpath = "//div[@class='p-radiobutton-box']")
    public List<WebElement> radioButtons;
    @FindBy(xpath = "//div[@class='p-radiobutton-box'][1]")
    public WebElement active;
    @FindBy(xpath = "//div[@class='p-radiobutton-box']")
    public WebElement inactive;
    @FindBy(xpath = "//small[@class='p-invalid ng-star-inserted']")
    public List<WebElement> errorMessage;
   @FindBy(xpath = "//*[text()='Successful']")
    public WebElement successprogramMessage;
    @FindBy(xpath = "//span[@class='p-button-icon pi pi-pencil'][1]")
    public WebElement editButton;
    @FindBy(id = "filterGlobal")
    WebElement searchBar;
    @FindBy(xpath = "//span[text()='Save']")
    public WebElement editSave;
    @FindBy(xpath = "//button[@class='p-toast-icon-close p-link ng-tns-c90-12 p-ripple ng-star-inserted']")
    public WebElement xSuccessButton;
    @FindBy(xpath = "/span[@class='p-dialog-header-close-icon ng-tns-c168-9 pi pi-times']")
    public WebElement xButton;
    @FindBy(xpath = "//span[text()='Cancel']")
    public WebElement cancelButton;
    
    
    public ProgramAddModule() {
        PageFactory.initElements(driver, this);
    }

    
    public void clickProgram() {
    	program.click();

    }
    //Admin clicks on "New Program" under the "Program" menu bar
    public void addNewProgram() {
    	addNewProgramBtn.click();
    }

//Admin should see pop up window for program details
    // public PopUpWindow getPopUpWindow() {
    //     return new PopUpWindow();
    // }

//Admin should see window title as "Program Details"
public String programDetails() {
    return Utility_Methods.getElementText(programDetails);

}

    //Admin should see red "*" mark beside mandatory field "Name"
public void mandatoryField() {      
}

//Admin clicks save button without entering mandatory 
public void clickwithoutSaveButton() {
    saveButton.click();
}

//Admin gets message '<field> is required'
public String getErrorMessage() {
    return Utility_Methods.getElementText(errorMessage.get(0));
}

//Admin can see Program Details form disappears
public void programDetailsDisappear() {
    xButon.click();
}

//Admin can see the text entered
public void inputName(){
    inputName.sendKeys(ConfigReader.SearchProgName());
    
}
//Admin can see the text entered in description box
public void inputDescription(){
    inputDescription.sendKeys(ConfigReader.SearchProgDescription());
    
}
//Admin can see 'Active/Inactive' status selected
public void selectStatus(){
    active.click();
}
//Admin enter valid details for mandatory fields and Click on save button
public void clickWithSaveButton(){
    saveButton.click();
}
//Admin gets message 'Successful Program created'
public String getSuccessMessage(){
    return Utility_Methods.getElementText(successprogramMessage);
}

//Admin Click on cancel button
public void clickCancelButton(){
    cancelButton.click();
}
//Admin can see program details form disappear
public void cancelButton(){
    cancelButton.click();
}


//Admin searches with newly created "Program Name"
public void searchProgramName(){
    searchBar.sendKeys(ConfigReader.SearchProgName());
}

//Records of the newly created  "Program Name" is displayed and match the data entered
public void verifyProgramName(){
    
}


//Admin Click on "X" button
public void clickXButton(){
    xButton.click();
}
//Admin can see program details form disappear
public void xButton(){      
    xButton.click();    
}

    
    
    
   
   
    public void clickSaveButton(){
        saveButton.click();
    }
    
    
    
    
    
    	
    }



    

