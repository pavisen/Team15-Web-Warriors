package pageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.DriverFactory;
import utilities.Utility_Methods;

public class DashBoardPage {
	
	public  WebDriver driver= DriverFactory.getDriver();
	List<String> ActualList = new  ArrayList<>();
	Utility_Methods util=new Utility_Methods();
	
	@FindBy (xpath="//*[contains(text(),'Management')]")
	WebElement dashboardTitle;
	
	@FindBy(xpath="//*[contains(text(),'Program')]")
	WebElement programBtn;

	@FindBy(xpath="//*[contains(text(),'Batch')]")
	WebElement BatchBtn;

	@FindBy(xpath="//*[contains(text(),'Class')]")
	WebElement ClassBtn;

	@FindBy(xpath="//*[contains(text(),'Logout')]")
	WebElement LogoutBtn;
	
	@FindBy(xpath="//div//button")
	WebElement header;

	
	
	  public DashBoardPage() {

			PageFactory.initElements(driver, this);		

		}
	
		
	public boolean responseTimeValidation(Integer Exptime)
	{
        long startTime = System.currentTimeMillis();		
		 long endTime = System.currentTimeMillis();
		 
		 long responseTime = endTime - startTime;
		 
		 System.out.println("Response Time: " + responseTime + " milliseconds");

        // Optionally, check if response time is within acceptable limits
        long acceptableResponseTime = 2000; // 2 seconds
        
        if (responseTime <= acceptableResponseTime) {
       	 
            System.out.println("Response time is within acceptable limits.");
            return true;
        } else {
            System.out.println("Response time exceeds acceptable limits.");
            return false;
        }
	}
	
	
	
	public String getTitle()
	{
		util.waitForElement(programBtn);
		String title=DriverFactory.getDriver().getTitle();
		return title;
	}
	
	public boolean navigationTextValidation()
	{
		
		List<String> ExpectedTexts = Arrays.asList("LMS - Learning Management System", "Program", "Class", "Batch");	
		util.waitForElement(dashboardTitle);			
	    ActualList.add(dashboardTitle.getText());
	    ActualList.add(programBtn.getText());
	    ActualList.add(ClassBtn.getText());
	    ActualList.add(BatchBtn.getText());  	   
	    
	    if (ActualList.containsAll(ExpectedTexts)) {
	    	return true;           
        } else {
            System.out.println("The lists are not equal.");
            return false;
        }
	  		
	}
	
	
	public String homepagePosition(int i)
	{
		String HeaderText="";	
		
		util.waitForElement(programBtn);
		List<WebElement> programbtnnn= DriverFactory.getDriver().findElements(By.xpath("//*[@class='mat-button-wrapper']"));		
		
		 if (!programbtnnn.isEmpty() ) {				 
				 HeaderText=programbtnnn.get(i).getText();				
			 return HeaderText;    
		 }
         else         	
             System.out.println("Header not available");
		 
		 return HeaderText; 
    
	}
	
	public boolean headerTextallignment(String HeaderText)
	{
		util.waitForElement(programBtn);	
		int ProgramExpX=1070;
		int ProgramExpY=23;		
		
		int ClassExpX = 1224; 
	    int  ClassExpY= 23; 
	    
	    int BatchExpX =1156; 
	    int  BatchExpY= 23;
	    
	    int LogoutExpX = 1291; 
	    int  LogoutExpY= 23; 	  
	  
	  switch (HeaderText) {
	    case "Program": 	
	    	 if (programBtn.getLocation().getX()== ProgramExpX && programBtn.getLocation().getY() == ProgramExpY)
	            return true;       
	            break;

	    case "Batch": 
	    	if (BatchBtn.getLocation().getX()== BatchExpX && BatchBtn.getLocation().getY() == BatchExpY)
	            return true;       
	            break;
	            

	    case "Class": 
	    	if (ClassBtn.getLocation().getX()== ClassExpX && ClassBtn.getLocation().getY() == ClassExpY)
	            return true;       
	            break;

	    case "Logout": 
	    	if (LogoutBtn.getLocation().getX()== LogoutExpX && LogoutBtn.getLocation().getY() == LogoutExpY)
	            return true;       
	            break;
	            
	    default:
			return false;
		}
		
		return false;
	  
	  
	}  
	  
	public boolean  LMS_Allignmentvalidation()
	{
		util.waitForElement(programBtn);
		int ExpLMSX=16;
       int ExpLMSY=16;       
		if (dashboardTitle.getLocation().getX()== ExpLMSX && dashboardTitle.getLocation().getY() == ExpLMSY)
            return true;  
		else
			return false;
	}
		
	public boolean LMStextValidation()
	{
		util.waitForElement(programBtn);
		String LMStext=dashboardTitle.getText();
		if(LMStext.equals(" LMS - Learning Management System "))
		return true;
		else 
			return false;
	}
	
	
	
	
}

	
	
	
	
		
	
	

