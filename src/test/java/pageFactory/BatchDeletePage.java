package pageFactory;

import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.noneDSA;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.DriverFactory;
import utilities.Utility_Methods;

public class BatchDeletePage {

	public   WebDriver driver= DriverFactory.getDriver();
	Utility_Methods utm= new Utility_Methods();
	List<String> batchnames;
	String batchNameBeforeClick;
	String batchNameAfterClick1;
	String batchNameAfterClick2;
	
	String firstrowname;
	
	@FindBy(xpath ="//table/tbody/tr[1]/td[7]/div/span[2]/button")
  	public WebElement BatchDeleteIcon;
	
	@FindBy(xpath = "//span[text()='Confirm']")
  	public  WebElement confirmalertboxtext;
	
	 @FindBy(xpath = "//span[text()='Yes']")
	 public  WebElement yesbutton;
	 
	 @FindBy(xpath = "//span[text()='No']")
	 public  WebElement Nobutton;
	 
	 @FindBy(xpath="//button[contains(@class,'ng-tns-c204-8 p-dialog-header-icon p-dialog-header-close p-link ng-star-inserted')]")
	 public  WebElement closebutton;
	 
	 @FindBy(xpath = "//div[text()='Successful']")
	 public  WebElement Successmessage1;
	 
	 @FindBy(xpath = "//div[text()='batch Deleted']")
	 public  WebElement Successmessage2;
	 
	 @FindBy(xpath = "//tbody/tr/td[2]")
	 public  List<WebElement> batchnamelist;
	 
	 @FindBy(xpath="//*[text()=' Manage Batch']")
	 public  WebElement Managebatch;
	 
	 @FindBy(xpath="//button[contains(@class,'p-button-danger p-button p-component p-button-icon-only')]")
	 public  WebElement deleteiconManagebatch;
	 
	 @FindBy(xpath="//tr[1]/td[1]")
	 public  WebElement singlecheckbox;
	 
	 @FindBy(xpath="//td[1]")
	 public  WebElement multiplecheckbox;
	 
	 @FindBy(id="filterGlobal")
	 public  WebElement searchbox;
	 
	 
	 
	 
	 public BatchDeletePage() {
			PageFactory.initElements(driver,this);
		}
		
	 
	public void ClickbatchDeleteIcon() throws InterruptedException {
		
		   utm.waitForElement(BatchDeleteIcon);
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();",BatchDeleteIcon);
		   Thread.sleep(1000);
	     }
	   
	public String  confirmalerttext() throws InterruptedException {
	    utm.waitForElement(confirmalertboxtext);
		String text=confirmalertboxtext.getText();
	    System.out.println(text);
	    return text;
	}  
	
	public void clickYesbutton() throws InterruptedException {
		   utm.waitForElement(yesbutton);
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();",yesbutton);
		   Thread.sleep(1000);
	     }

	 
    public void clicknobutton() throws InterruptedException {
    	   utm.waitForElement(Nobutton);
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();",Nobutton);
		   Thread.sleep(1000);
	     }
	
    public void clickClosebutton() throws InterruptedException {
 	       utm.waitForElement(closebutton);
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();",closebutton);
		   Thread.sleep(1000);
	     }
	
	
    public String[] sucessmessgetext() {
    	String text1=Successmessage1.getText();
    	String text2=Successmessage2.getText();
    	return new String[] {text1,text2};
    
    }
    
    
    public  String  printlistofbatchName() {
    	
    	 batchnames= new ArrayList<String>();
    	
    	for (WebElement names : batchnamelist) {
		batchnames.add(names.getText());
    	}
    	System.out.println(batchnames.get(0));
    	return batchnames.get(0);
	    
        }
    
    
   
    
    
    public void clickDelandYes() throws InterruptedException {
    	
        batchNameBeforeClick = printlistofbatchName();
        ClickbatchDeleteIcon();
        clickYesbutton();
        batchNameAfterClick1 = printlistofbatchName();
       }
       
       public void clickDelandNo() throws InterruptedException {
    	    batchNameBeforeClick = printlistofbatchName();
           ClickbatchDeleteIcon();
           clicknobutton();
           batchNameAfterClick2 = printlistofbatchName();
       }
       
      public void IsbatchNamedeleted() {
    	  if(batchNameBeforeClick.equals(batchNameAfterClick1)) {
    		  System.out.println("It is not deleted");
    		  
    	  }else if (batchNameBeforeClick.equals(batchNameAfterClick2)){
    		  System.out.println("It is  not deleted");
    	 
    	  }else if (!batchNameBeforeClick.equals(batchNameAfterClick2)){
    		  System.out.println("It is deleted");	  
    		  
    	  }else {
    		  System.out.println("end");
    	  }
    	}
          
       	public String Managebatchpage() {
 	    return Managebatch.getText();
           }
    	
    	
    	public void clicksinglecheckbox() {
    		
    	   utm.waitForElement(singlecheckbox);
   		   JavascriptExecutor js = (JavascriptExecutor) driver;
   		   js.executeScript("arguments[0].click();",singlecheckbox);
   		  
    	}
    	

	   public void clickmultiplecheckbox() {
		   utm.waitForElement(multiplecheckbox);
   		   JavascriptExecutor js = (JavascriptExecutor) driver;
   		   js.executeScript("arguments[0].click();",multiplecheckbox);
		   
		}
    	
	   public void clickdeleteiconmanagebatch() {
		   utm.waitForElement(deleteiconManagebatch);
   		   JavascriptExecutor js = (JavascriptExecutor) driver;
   		   js.executeScript("arguments[0].click();",deleteiconManagebatch);  
		   
		   
   	   	}
	
	   public void entertextinsearchbox() {
		   searchbox.clear();
		   searchbox.sendKeys("micro");
	   }
	   
	   
	   public String searchlist() {
		   searchbox.clear();
		   searchbox.sendKeys("micro");
		   StringBuilder batchNames = new StringBuilder();
	    for (WebElement names : batchnamelist) {
	    	System.out.println(names.getText());
	    	 batchNames.append(names.getText()).append(", ");
		 }
		return batchNames.toString();
	
	    
		
	   }
	   
	   
	   
	   
        } 
    
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

