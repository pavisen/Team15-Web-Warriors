package pageFactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utility_Methods;


public class AddNewBatchPopupPage {

		WebDriver driver;
		 Utility_Methods util=new Utility_Methods();	 
		@FindBy(xpath="//button[text()='Add New Batch']") WebElement addNewBatch;
		
		//Batch popup locators
		@FindBy(xpath="//div[@role='dialog']") WebElement batchPopupbox;
		//program
	   // @FindBy(id="programName") WebElement progNameTextbox;
		@FindBy(xpath="//input[@class='p-dropdown-label p-inputtext ng-tns-c171-10 ng-star-inserted']") WebElement progNameTextbox;
		@FindBy(xpath="//label[text()='Program Name ']") WebElement programNameLabel;
		@FindBy(xpath="//div[@role='button' and @aria-haspopup='listbox']") WebElement prrmNmeDropDown;
		@FindBy(xpath="//small[text()='Program Name is required.']") WebElement PrgmNameTxtBoxErrorMsg;
			
		//Batch
		@FindBy(xpath="//input[@id='batchProg']") WebElement batchNamePrefixTxtbox;
		@FindBy(xpath="//input[@id='batchName']") WebElement batchNameSuffixTxtbox;
		@FindBy(xpath="//label[text()='Batch Name']") WebElement batchNameLabel;
		
		//Description
		@FindBy(xpath="//input[@id='batchDescription']") WebElement descTxtbox;
		@FindBy(xpath="//label[text()='Description ']") WebElement descriptionLabel;
		//Status
		@FindBy(xpath="//lable[text()='Status : ']") WebElement statusLabel;
		@FindBy(xpath="//*[text()=' ACTIVE ']") WebElement activeLabel;
		@FindBy(xpath="//*[text()=' INACTIVE ']") WebElement inactiveLabel;
		@FindBy(xpath="//div[4]//div[2]//div[1]//div[2][@class='p-radiobutton-box']") WebElement activeRadioBtnIcon;
		//@FindBy(xpath="//div[4]//div[3]//span[@class='p-radiobutton-icon']") WebElement inActiveRadioBtnIcon;
		//@FindBy(xpath="//div[4]//div[3]//div[1]//div[2][@class='p-radiobutton-icon']") WebElement inActiveRadioBtnIcon;
		//@FindBy(xpath="(//*[@class='p-radiobutton-icon'])[2]") WebElement inActiveRadioBtnIcon;
		//@FindBy(xpath="//div[3]//div[3]//p-radiobutton//div//div[2][@class='p-radiobutton-box']") WebElement inActiveRadioBtnIcon;

	//NoOfclasses
		@FindBy(xpath="//input[@id='batchNoOfClasses']") WebElement noOfClassesTxtbox;
		@FindBy(xpath="//label[text()='Number of Classes ']") WebElement noOfClassesLabel;

		@FindBy(id="category")List<WebElement> radioBtns;	
		
		//cancel , save and close buttons
		@FindBy(xpath="//span[text()='Cancel']") WebElement cancelButton;	
		@FindBy(xpath="//span[text()='Save']") WebElement saveButton;	
		@FindBy(xpath="//span[@class='p-dialog-header-close-icon ng-tns-c168-24 pi pi-times']") WebElement closeButton;

		//error message in batchsuffix textbox
		@FindBy(xpath="//small[@class='p-invalid ng-star-inserted']") WebElement errorMessage;
		//
		@FindBy(xpath="//span[@class='p-dropdown-trigger-icon ng-tns-c171-11 pi pi-chevron-down']") WebElement dropDownMenu;
		public AddNewBatchPopupPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		public void clickaddNewSubMenu() 
		{
			util.webElement_Click(addNewBatch);
		}
		public boolean verifyAddNewBatchPopup()
		{
			return batchPopupbox.isDisplayed();
		}
		public Boolean verifyAllFieldsInPopupDetails() 
		{
			Boolean result = Boolean.FALSE;
			String batchNameInputBoxType = batchNameSuffixTxtbox.getAttribute("type");
			String descInputBoxType = descTxtbox.getAttribute("type");
			String noOfClassesInputBoxType = noOfClassesTxtbox.getAttribute("type");

			if (batchPopupbox.isDisplayed()) 
			{
		    	if (programNameLabel.isDisplayed() && prrmNmeDropDown.isDisplayed() && descriptionLabel.isDisplayed()&& descTxtbox.isDisplayed() && descInputBoxType.equals("text")
		    		&& batchNameLabel.isDisplayed() && batchNameSuffixTxtbox.isDisplayed() && batchNameInputBoxType.equals("text")	    	
		    		&& noOfClassesLabel.isDisplayed() && noOfClassesTxtbox.isDisplayed() && noOfClassesInputBoxType.equals("number")
		    		&& statusLabel.isDisplayed() && activeLabel.isDisplayed() && inactiveLabel.isDisplayed()
		    		&& activeRadioBtnIcon.isDisplayed() 
		    		&& cancelButton.isDisplayed() && saveButton.isDisplayed())
		    		result = Boolean.TRUE;
		    }
		    return result;
		}
		public void verifyBatchsuffixTxtBox(String alphabets) 
		{
			util.webSendKeys(batchNameSuffixTxtbox, alphabets);
		}
		public String errorMsg()
		{
			return errorMessage.getText();
		}
//		public void clickDropdownMenu() throws InterruptedException
//		{
//			Utility_Methods.webElement_Click(dropDownMenu);
//			Thread.sleep(2000);
//		}
		public boolean verifyBatchPrefixTxtBox(String alphabets)  
		{
			if(!batchNamePrefixTxtbox.isEnabled())
			{
				util.webSendKeys(batchNamePrefixTxtbox, alphabets);
					return true;
			}
					else
						return false;
		}
		public void verifyProgNameOnlyBlank()  
		{
			
			if (batchPopupbox.isDisplayed())
			{
				util.webSendKeys(batchNameSuffixTxtbox, "04");
				util.webSendKeys(descTxtbox, "dsffjdf");
				util.webElement_Click(activeRadioBtnIcon);
				util.webSendKeys(noOfClassesTxtbox, "2");
				util.webElement_Click(saveButton);
			}
		}
		public String verifyPrgmNmTxtBoxErrorMsg()
		{
			util.waitForElement(PrgmNameTxtBoxErrorMsg);
			return PrgmNameTxtBoxErrorMsg.getText();
		}
		public void clickCloseButton() 
		{
			util.webElement_Click(closeButton);
		}
	}


