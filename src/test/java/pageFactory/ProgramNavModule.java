package pageFactory;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import drivers.DriverFactory;
import utilities.ConfigReader;
import utilities.Utility_Methods;

public class ProgramNavModule {
	// private static final String configProperties = null;
	public static ConfigReader configReader = new ConfigReader();
	public static WebDriver driver = DriverFactory.getDriver();
	@FindBy(xpath = "//button/span[text()='Program']")
	WebElement program;

	@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']")
	WebElement lmsHeading;

	@FindBy(xpath = "//span[text()='Program']")
	WebElement programHeader;

	@FindBy(xpath = "//span[@class='mat-button-wrapper']")
	List<WebElement> headers;

	@FindBy(xpath = "//div[text()=' Manage Program']")
	WebElement manageProgramHeader;

	@FindBy(xpath = "//span[text()='Logout']")
	WebElement logoutHeader;

	@FindBy(xpath = "//button[text()='Add New Program']")
	WebElement addNewProgramBtn;

	@FindBy(xpath = "//tr/th")
	List<WebElement> progcolHeaders;

	@FindBy(xpath = "(//button[@ng-reflect-icon='pi pi-trash'])[1]")
	WebElement multipleDelBtn;

	@FindBy(id = "filterGlobal")
	WebElement searchBar;

	@FindBy(xpath = "(//div[@class='p-checkbox p-component'])[1]")
	WebElement headerCheckBox;

	@FindBy(xpath = "//div[@class='p-checkbox p-component']")
	List<WebElement> allCheckBoxes;

	@FindBy(xpath = "//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")
	List<WebElement> sorticons;

	@FindBy(xpath = "//div[@class='action']")
	List<WebElement> editdelicons;

	@FindBy(xpath = "//thead[@class='p-datatable-thead']")
	WebElement dataTableHeader;

	@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted']")
	WebElement paginator;

	@FindBy(xpath = "//button[@class='p-paginator-first p-paginator-element p-link p-disabled p-ripple ng-star-inserted']")
	WebElement prevSetofPagesMove;

	@FindBy(xpath = "//button[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted']")
	WebElement nextSetofPagesMove;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-right']")
	WebElement nextPageMove;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-left']")
	WebElement prevPageMove;

	@FindBy(xpath = "//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']")
	WebElement programFooter;
	@FindBy(tagName = "link")
	List<WebElement> links;
	@FindBy(xpath = "//button[@routerlink]")
	List<WebElement> buttonsWithRouterLink;
    @FindBy(xpath = "//td[contains(text(),'FiftyTwo')][1]")
    public WebElement verifyName;
	public ProgramNavModule() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateDashboardPage() {
		if (driver.getTitle().equals("LMS") && Utility_Methods.getElementText(lmsHeading) != "") {
			if (headers.isEmpty()) {
				System.out.println("No headings found on the page.");
				return false;
			}
			return true;
		}
		return false;
	}
	// Records of the newly created "Program Name" is displayed and match the data
    // entered
    public void verifyProgramName() {
         Assert.assertTrue(Utility_Methods.getElementText(verifyName).contains(configReader.SearchProgName()),"Program not found");
    }
	public void clickProgram() {
		Utility_Methods.webElement_Click(program);
	//	program.click();

	}
	// Admin should not have any broken links for Program module

	public void checkForBrokenLinks() throws Throwable {

		System.out.println("Total links found: " + links.size());
		System.out.println("Total buttons with routerLink found: " + buttonsWithRouterLink.size());
		for (WebElement linkElement : links) {
			String url = linkElement.getAttribute("href");
			if (url != null && !url.isEmpty()) {
				verifyLink(url);
			} else {
				// log.info("URL is not configured for link tag");
			}
		}

		for (WebElement buttonElement : buttonsWithRouterLink) {
			String routerLink = buttonElement.getAttribute("routerlink");
			if (routerLink != null && !routerLink.isEmpty()) {
				String fullUrl = configReader.baseUrl() + routerLink;
				verifyLink(fullUrl);
			} else {
				// log.info("No routerLink configured for button element.");
			}
		}
	}

	public void verifyLink(String urllink) throws Throwable {

		try {
			URL link = new URL(urllink);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();
			if (httpURLConnection.getResponseCode() >= 400) {
				// log.info("Broken link found: " + link + " with response code: " +
				// httpURLConnection.getResponseCode());

			} else {
				// log.info("Valid link found: " + link);

			}
		} catch (IOException e) {
			// log.info("Error connecting to the URL");
			e.printStackTrace();

		}

	}

	// Admin should see the heading "LMS - Learning Management System"
	public void lmsHeading() {
		 Assert.assertEquals( Utility_Methods.getElementText(lmsHeading)," LMS - Learning Management System ");

	}

	// Admin should see the module names as in order "Home Program Batch Class Admin
	// Assignment Attendance"
	public void validateModuleNames(String expectedOrder) {

		List<String> actualOrder = new ArrayList<>();

		for (int i = 0; i < headers.size() - 1; i++) {
			actualOrder.add(headers.get(i).getText());
		}

		String[] expectedOrderArray = expectedOrder.split(" ");
		assertEquals(Arrays.asList(expectedOrderArray), actualOrder);

	}

	// Admin should see Logout in menu bar
	public void getLogout() {
		Utility_Methods.getElementText(logoutHeader);

	}

	// Admin should see sub menu in menu bar as "Add New Program"
	public void AddNewProgram() {

		Utility_Methods.getElementText(addNewProgramBtn);

	}
	// Admin should see the heading "Manage Program"

	public String getManageProgramHeading() {
		return Utility_Methods.getElementText(manageProgramHeader);

	}

	// Admin should able to see Program name, description, and status for each
	// program
	public void validateColheaders() {

		List<String> actualColheaders = new ArrayList<>();

		for (int i = 1; i < progcolHeaders.size() - 1; i++) {
			actualColheaders.add(progcolHeaders.get(i).getText());
		}

	}

	// Admin should see a Delete button in left top is disabled
	public boolean validatemultipleDeleteIcon() {
		boolean DeleteIconEnability = multipleDelBtn.isEnabled();
		// if (DeleteIconEnability == false)
		// System.out.println("DeleteIcon is disabled. Return: " + DeleteIconEnability);
		// else
		// System.out.println("DeleteIcon is enabled. Return: " + DeleteIconEnability);
		return DeleteIconEnability;
	}

	// Admin should see Search bar with text as "Search..."

	public void searchBar() {
		Utility_Methods.getElementText(searchBar);

	}

	// Admin should see data table with column header on the Manage Program Page as
	// Program Name, Program Description, Program Status, Edit/Delete
	public boolean validateDataTableHead() {
		boolean DatatableHeaddisplayed = dataTableHeader.isDisplayed();
		if (DatatableHeaddisplayed = true) {
			System.out.println("DatatableHeaddisplayed is visible. Return: " + DatatableHeaddisplayed);
		} else {
			System.out.println("DatatableHeaddisplayed is not visible. Return: " + DatatableHeaddisplayed);
		}
		return DatatableHeaddisplayed;
	}

	// Admin should see the Edit and Delete buttons on each row of the data table

	public boolean validateEditDelIcons() {
		try {

			for (int i = 0; i < editdelicons.size(); i++) {
				if (editdelicons.get(i).isDisplayed())
					return true;
			}

		} catch (Exception e) {
			return false;
		}
		return false;
	}

	// Admin should see checkbox default state as unchecked beside Program Name
	// column header as

	public boolean validateheaderCheckBoxUnchecked() {
		try {
			return !headerCheckBox.isSelected();
		} catch (Exception e) {
			return false;
		}

	}

	// Admin should see check box default state as unchecked on the left side in all
	// rows against program name
	public boolean validateAllCheckBoxesUnchecked() {
		try {
			for (int i = 1; i < allCheckBoxes.size(); i++) {
				if (allCheckBoxes.get(i).isSelected())
					return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

// Admin searches with newly created "Program Name"
    public void searchProgramName() {
    	Utility_Methods.webSendKeys(searchBar, ConfigReader.SearchProgName());
    }
	
	// Admin should see the sort arrow icon beside to each column header except Edit
	// and Delete

	public boolean validateSortIcons() {
		try {

			for (int i = 0; i < sorticons.size(); i++) {
				if (sorticons.get(i).isDisplayed())
					return true;
			}

		} catch (Exception e) {
			return false;
		}
		return false;
	}
	// "Admin should see the text as ""Showing x to y of z entries"" along with
	// Pagination icon below the table.
	// x- starting record number on that page
	// y-ending record number on that page
	// z-Total number of records"

	public boolean validatePagination() {
		boolean PaginationCtrldisplayed = paginator.isDisplayed();
		// if (PaginationCtrldisplayed == true)
		// System.out.println("PaginationCtrls are displayed. Return: " +
		// PaginationCtrldisplayed);
		// else
		// System.out.println("PaginationCtrls are not displayed. Return: " +
		// PaginationCtrldisplayed);
		return PaginationCtrldisplayed;
	}

	public void validatePaginationTextandIcons() throws InterruptedException {
		String text = "";

		Thread.sleep(1000);
		boolean areIconsPresent = prevPageMove.isDisplayed() && prevSetofPagesMove.isDisplayed()
				&& nextPageMove.isDisplayed() && nextSetofPagesMove.isDisplayed();
		try {
			if (areIconsPresent) {
				String textValidation = paginator.getText();
				Pattern pattern = Pattern.compile("\\d+");
				Matcher matcher = pattern.matcher(textValidation);
				List<Integer> numericValues = new ArrayList<Integer>();
				while (matcher.find()) {
					int numericValue;
					numericValue = Integer.parseInt(matcher.group());
					numericValues.add(numericValue);
				}
				text = String.format("Showing %d to %d of %d entries", numericValues.get(0), numericValues.get(1),
						numericValues.get(2));
				// log.info(text);
				Assert.assertEquals(text, textValidation);
			}
		} catch (Exception e) {
			// log.error("Pagination Icons are not displayed" + e);
		}
	}

	// "Admin should see the footer as ""In total there are z programs"".
	// z- Total number of records"
	public String getTotalProgramCountFromFooter() {
		String footerText = programFooter.getText();
		// System.out.println("footerText: "+footerText);
		// In total there are 49 programs
		String totalProgramCount = footerText.trim().substring(19, footerText.length() - 9);
		// System.out.println("totalProgramCount: "+totalProgramCount);
		return totalProgramCount;
	}

	// ------------------------------//

}
