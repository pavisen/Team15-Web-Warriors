package pageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.DriverFactory;
import utilities.ConfigReader;
import utilities.Utility_Methods;

public class ManageClassPage {
	

	  public  WebDriver driver= DriverFactory.getDriver();
	  public Utility_Methods util = new Utility_Methods();
	  String dashboardURL=ConfigReader.DashboardURL();
	  String baseurl = ConfigReader.loginPage();
	  
   
	  WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  
		@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']") public  WebElement LMSValidation;
		@FindBy(xpath = "//span[@class='p-button-icon pi pi-trash']") public  WebElement deleteButtontop;
		@FindBy(xpath = "//thead[@class='p-datatable-thead']/tr/th") public List<WebElement> datatableHeaders;
		@FindBy(xpath = "//input[@id='filterGlobal']") public  WebElement searchBarPage;
		@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted']") public  WebElement PageFooter;
		@FindBy(xpath="//tbody//tr") public List<WebElement> rowsinTable;
		@FindBy(xpath = "//span[@class='p-checkbox-icon']") public WebElement checkboxBM;
		//@FindBy(xpath = "//div/button[@icon='pi pi-trash']") public  WebElement topdeleteBatchButton;
		@FindBy(xpath = "//div[@class='signin-content']/mat-card/mat-card-title/div") public  WebElement manageClassText;
		@FindBy(xpath = "//*[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']") public  WebElement SortClassPageArrows;
		
		@FindBy(xpath = "//span[text()='Are you sure you want to delete Typescript?']") public  WebElement confirmdeleteAlert;
		@FindBy(xpath = "//button/span[text()='Yes']") public  WebElement deleteAlert_YesBtn;
		@FindBy(xpath = "//button/span[text()='No']") public  WebElement deleteAlert_NoBtn;
		
		@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-right']") public  WebElement nextPageButton;
		@FindBy(xpath = "//span[@class = 'p-paginator-icon pi pi-angle-double-right']") public  WebElement doublenextButton;
		@FindBy(xpath = "//button[@class = 'p-paginator-page p-paginator-element p-link p-highlight p-ripple ng-star-inserted']") public  WebElement FirstPage;	
		@FindBy(xpath = "//span[@class = 'p-paginator-icon pi pi-angle-left']") public  WebElement LeftButton;
		@FindBy(xpath = "//span[@class = 'p-paginator-icon pi pi-angle-double-left']") public  WebElement doubleLeftButton;
		@FindBy(xpath="//span[@class='p-paginator-pages ng-star-inserted']") public WebElement numberpages;
		
		public ManageClassPage() {
			PageFactory.initElements(driver, this);
		}

		public String HeaderVaidation() throws InterruptedException {
			Thread.sleep(1000);
			String header=manageClassText.getText();
			System.out.println(header);
			return header;
		
		}
		
		public String validatePage() {
			String url=driver.getCurrentUrl();
			System.out.println(url);
			return url;
			
		}
		
		public String validateTitle() {
			String Title=driver.getTitle();
			System.out.println(Title);
			return Title;
			
		}
		
	public Boolean headerTextValidation() {
			
			
			List<String> expheader = Arrays.asList("","Batch Name","Batch Description","Batch Status","No Of Classes","Program Name","Edit / Delete");
			List<String> actualheader=new ArrayList<String>();
			//Boolean head = null;
			for(WebElement Header:datatableHeaders)
			{
			String headertext=Header.getText();
			actualheader.add(headertext);
			System.out.println(actualheader);
			}
			return actualheader.equals(expheader);
	}
	
	public boolean paginationcontrol() {	
		Boolean icon = null;
	if(doublenextButton.isDisplayed()&&(doubleLeftButton.isDisplayed())&&(nextPageButton.isDisplayed())&&(LeftButton.isDisplayed())&&(numberpages.isDisplayed())) {
		icon=true;
	}

	return icon;
		    
	}
	 public  void checkSortIcon() {
	    	int col1=0;
	    	int col4=4;
	    	System.out.println(datatableHeaders.size());
	    	for (int i = 0; i < datatableHeaders.size(); i++) {
	    	
	    	if((SortClassPageArrows.isDisplayed() && (i == col1 || i == col4))) {
	    		 System.out.println("Sort icon is not present for column " + (i + 1));

	    	}else{
	            System.out.println("Sort icon is present for column " + (i + 1));
	        }
	    }
	    }
	  
		
		public int rowsize() {
			int rowsize=rowsinTable.size();
			return rowsize;
		}
		
    public void deleteicon() {
   
    	if(util.isElementEnabled(deleteButtontop));
    	
    }
    
	public Boolean CheckifNewClassAdded(String string) throws InterruptedException {

		util.webSendKeys(searchBarPage, string);
		String Class_CountPage = (PageFooter).getText();
		System.out.println(Class_CountPage);
		Boolean BatchExists = Class_CountPage.equals("Showing 1 to 1 of 1 entries"); // BatchCheckPage.contains("Showing 1 to 1 of 1 entries");
		System.out.println(BatchExists);
		return BatchExists;		
	}
}
