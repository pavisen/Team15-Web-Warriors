package pageFactory;


	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import utilities.Utility_Methods;

	public class Batch_navigationPage 
	{
		WebDriver driver;
		 Utility_Methods util=new Utility_Methods();	 
		//Batch page locators
		@FindBy(xpath="//span[text()='Batch']") WebElement batchinMenuBar;	
		@FindBy(xpath="//*[text()=' Manage Batch']") WebElement manageBatcheHeading;	
		@FindBy(xpath="//span[@class='p-paginator-pages ng-star-inserted']") WebElement locatepagination;
		@FindBy(xpath="//button[@class='p-button-danger p-button p-component p-button-icon-only']") WebElement disabledDeleteIcon;
		@FindBy(xpath="//span[text()='Showing 1 to 5 of 30 entries']") WebElement paginationEntriesText;
		@FindBy(xpath="//thead[@class='p-datatable-thead']") WebElement dataTableHeader;
	   	@FindBy(xpath = "//table/tbody/tr//button[contains(@icon, 'pi-pencil')]") List<WebElement> allEditicons;
	   	@FindBy(xpath = "//table/tbody/tr//button[contains(@icon, 'pi-trash')]") List<WebElement> allDeleteIcons;
		@FindBy(xpath="//*[text()=' In total there are 49 batches. ']") WebElement footerTextEle;
		@FindBy(xpath="//button[text()='Add New Batch']") WebElement addNewBatch;
		@FindBy(xpath="//div[@role='checkbox']") WebElement checkBoxInHeader;
		@FindBy(xpath="//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']") List<WebElement> allSortIcons;
	   	@FindBy(xpath = "//div[contains(@role, 'dialog')]") WebElement batchPopup; 

		public Batch_navigationPage(WebDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);		
		}
		public void clickBatchInMenuBar() 
		{
			util.webElement_Click(batchinMenuBar);
		}
		public String getBatchPageHeadingText()
		{
			return util.getElementText(manageBatcheHeading);
		}
		public boolean validateDeleteIcon() 
		{
			boolean DeleteIconEnability = disabledDeleteIcon.isEnabled();
//			if (DeleteIconEnability == false) 
//				System.out.println("DeleteIcon is disabled. Return: " + DeleteIconEnability);
//			 else 
//				System.out.println("DeleteIcon is enabled. Return: " + DeleteIconEnability);
			return DeleteIconEnability;

		}
		public boolean validatePagination() 
		{
			boolean PaginationCtrldisplayed = locatepagination.isDisplayed();
//			if (PaginationCtrldisplayed == true) 
//				System.out.println("PaginationCtrls are displayed. Return: " + PaginationCtrldisplayed);
//			 else 
//				System.out.println("PaginationCtrls are not displayed. Return: " + PaginationCtrldisplayed);
			return PaginationCtrldisplayed;
		}
		public boolean validateDataTableHead() {
			boolean DatatableHeaddisplayed = dataTableHeader.isDisplayed();
			if (DatatableHeaddisplayed = true) {
				System.out.println("DatatableHeaddisplayed is visible. Return: " + DatatableHeaddisplayed);

			} else {
				System.out.println("DatatableHeaddisplayed is not visible. Return: " + DatatableHeaddisplayed);
			}
			return DatatableHeaddisplayed;

		}
		 public String getTableHead() {
		    	if (dataTableHeader.isDisplayed()) {
		    		//String thead = dataTableHeader.getText();
		    		//System.out.println("table head text is: " +thead);
		    		return dataTableHeader.getText();
		    	} else {
		    		return "";
		    	}
		    }
		public boolean verifycheckBoxes()
		{
			List<WebElement> tablerows=driver.findElements(By.xpath("//table//tr"));
			int rowsSize=tablerows.size();
			//System.out.println("Size of rows:"+rowsSize);
			boolean checkBoxISpresent=false;
			for(int i=1;i<=rowsSize;i++)
			{
				WebElement checkBox=driver.findElement(By.xpath("(//table//tr)["+i+"]"));
				if(checkBox.isDisplayed()==true)
					return checkBoxISpresent=true;
				else
					break;
		     }
			return false;
		}
		public boolean ValidateEditIconsEnabled() {
	        boolean allEditIconsEnabled = true;
	        for (WebElement editIcon : allEditicons) {
	            if (!editIcon.isEnabled()) {
	                System.out.println("Edit icon is not enabled: " + editIcon.getText());
	                allEditIconsEnabled = false;
	            }
	        }
	        return allEditIconsEnabled;
	    }
	    
		public boolean ValidateDeleteIconsEnabled() {
	        boolean allDeleteIconsEnabled = true;
	        for (WebElement deleteIcon : allDeleteIcons) {
	            if (!deleteIcon.isEnabled()) {
	                System.out.println("Delete icon is not enabled: " + deleteIcon.getText());
	                allDeleteIconsEnabled = false;
	            }
	        }
	        return allDeleteIconsEnabled;
	    }
		public String getTotalProgramCountFromFooter()
	 	{
	 		String footerText = footerTextEle.getText();
	 		//System.out.println("footerText: "+footerText);
	 		//In total there are 49 programs
	 		String totalProgramCount = footerText.trim().substring(19,footerText.length()-9);
	 		//System.out.println("totalProgramCount: "+totalProgramCount);
	 		return totalProgramCount;
	 	}
		public boolean verifyaddNewBatchAsSubMenu()  
		{
			boolean isDisplayed = addNewBatch.isDisplayed();
			return isDisplayed;
		}
		public boolean verifycheckBoxInHeader() 
		{
			return checkBoxInHeader.isDisplayed();
		}
		public boolean verifyAllSortIcons() 
		{
			boolean allsortIconsDisplayed = true;
			for(WebElement sortIcon : allSortIcons)
			 {
				 if (!sortIcon.isDisplayed()) 
				 {
		                System.out.println("SortIcon  present in row: " + sortIcon.getText());
		                allsortIconsDisplayed = false;
		            }
			 }
	       return allsortIconsDisplayed;
		//	 try {
//		            for (int i = 0; i < allSortIcons.size(); i++) 
//		            {
//		                if (allSortIcons.get(i).isDisplayed())
//		                    return true;
//		            }
//			 }
//			 catch (Exception e) 
//			 {
//		            return false;
//		        }
//		        return false;
				 
		  }
	}


