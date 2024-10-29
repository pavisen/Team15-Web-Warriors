package pageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import drivers.DriverFactory;
import utilities.Utility_Methods;

public class ProgramSortingPage {
	Utility_Methods util = new Utility_Methods();
	Actions actions= new Actions(DriverFactory.getDriver());
	
	@FindBy(xpath = "//app-header//mat-toolbar//div//button[@id='program']")
	WebElement ProgramModule;
	
		
	@FindBy(xpath = "//th[contains(text(),'Program Name')]")
    WebElement ProgramnameSort;	
	
	
	LoginPage loginpage= new LoginPage();

	public void programclick() {		
		Utility_Methods.webElement_Click(loginpage.ProgramBtn);
		
	}

	
	public void ProgramDescriptionSortClick() throws InterruptedException
	{
		actions.moveToLocation(100, 200).click().perform(); 	
		  Thread.sleep(2000);
		  List<WebElement> rows = DriverFactory.getDriver().findElements(By.xpath("//table/tbody/tr"));	
		  
		 DriverFactory.getDriver().findElement(By.xpath("//th[contains(text(),'Program Description ')]")).click();
	}
	
	public void ProgramNameSortClick() throws InterruptedException {	   	
		 actions.moveToLocation(100, 200).click().perform(); 	
		  Thread.sleep(2000);
		  List<WebElement> rows = DriverFactory.getDriver().findElements(By.xpath("//table/tbody/tr"));		 
		 DriverFactory.getDriver().findElement(By.xpath("//th[contains(text(),'Program Name')]")).click();		
	}
	
	
	public void ProgramStatusSortClick() throws InterruptedException
	{
		  actions.moveToLocation(100, 200).click().perform(); 	
		  Thread.sleep(2000);
		  List<WebElement> rows = DriverFactory.getDriver().findElements(By.xpath("//table/tbody/tr"));		 
		 DriverFactory.getDriver().findElement(By.xpath("//th[contains(text(),'Program Status')]")).click();
	}

	
	public boolean verifyingProgrameNameSorting(String ASCorDES) {
		
		List<WebElement> rows = DriverFactory.getDriver().findElements(By.xpath("//table/tbody/tr"));
		
		for (WebElement row : rows) {
           // System.out.println("Row: " + row.getText());
        }
		
		List<String> actualData = new ArrayList<>();
		
		for (WebElement row : rows) {			
			actualData.add(row.findElement(By.xpath("//tbody/tr/td[2]")).getText()); 
		}		
		
		List<String> Ascendingdata = new ArrayList<>(actualData);		
		
		switch (ASCorDES.trim()) { 
		
        case "Ascending":        	
            Collections.sort(Ascendingdata); // Sort in ascending order
            break;

        case "Descending":
            Collections.sort(Ascendingdata, Collections.reverseOrder()); // Sort in descending order
            DriverFactory.getDriver().findElement(By.xpath("//th[contains(text(),'Program Name')]")).click(); // Click to sort
            break;

        default:
            System.out.println("Invalid sort option: " + ASCorDES);
            return false; // Invalid sorting option
    }

    // Step 4: Verify the sorted order
    if (actualData.equals(Ascendingdata)) {    	
      
        return true; // Sorting is verified
    } else {
     
        return false; // Sorting verification failed
    }	
		
	}
	
	
public boolean verifyingProgramDescriptionSorting(String ASCorDES) {
		
		List<WebElement> rows = DriverFactory.getDriver().findElements(By.xpath("//table/tbody/tr"));	
		
		for (WebElement row : rows) {
            //System.out.println("Row: " + row.getText());
        }
		List<String> actualData = new ArrayList<>();
		
		for (WebElement row : rows) {			
			actualData.add(row.findElement(By.xpath("//tbody/tr/td[3]")).getText()); 
		}			
		
		List<String> Ascendingdata = new ArrayList<>(actualData);		
		
		switch (ASCorDES) { 
        case "Ascending":        	
            Collections.sort(Ascendingdata); // Sort in ascending order
            break;

        case "Descending":
            Collections.sort(Ascendingdata, Collections.reverseOrder()); // Sort in descending order
            DriverFactory.getDriver().findElement(By.xpath("//th[contains(text(),'Program Description ')]")).click(); // Click to sort
            break;

        default:
            System.out.println("Invalid sort option: " + ASCorDES);
            return false; // Invalid sorting option
    }

    // Step 4: Verify the sorted order
    if (actualData.equals(Ascendingdata)) {
               
        return true; // Sorting is verified
    } else {
     
        return false; // Sorting verification failed
    }	
		
	}


public boolean verifyingProgramStatusSorting(String ASCorDES) {
	
	List<WebElement> rows = DriverFactory.getDriver().findElements(By.xpath("//table/tbody/tr"));	
	
	for (WebElement row : rows) {
        System.out.println("Row: " + row.getText());
    }
	List<String> actualData = new ArrayList<>();
	
	for (WebElement row : rows) {			
		actualData.add(row.findElement(By.xpath("//tbody/tr/td[4]")).getText()); 
	}			
	
	List<String> Ascendingdata = new ArrayList<>(actualData);		
	
	switch (ASCorDES) { 
    case "Ascending":        	
        Collections.sort(Ascendingdata); // Sort in ascending order
        break;

    case "Descending":
        Collections.sort(Ascendingdata, Collections.reverseOrder()); // Sort in descending order
        DriverFactory.getDriver().findElement(By.xpath("//th[contains(text(),'Program Status ')]")).click(); // Click to sort
        break;

    default:
        System.out.println("Invalid sort option: " + ASCorDES);
        return false; // Invalid sorting option
}

// Step 4: Verify the sorted order
if (actualData.equals(Ascendingdata)) {
           
    return true; // Sorting is verified
} else {
 
    return false; // Sorting verification failed
}	
	


}














	
	
}



