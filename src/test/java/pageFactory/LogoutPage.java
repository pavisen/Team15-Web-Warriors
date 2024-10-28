package pageFactory;

import drivers.DriverFactory;
import utilities.ConfigReader;
import utilities.Utility_Methods;

public class LogoutPage {
     
	LoginPage loginpage= new LoginPage();
	DashBoardPage dashboard= new DashBoardPage();
	Utility_Methods util = new Utility_Methods();
	
	public void clickLogout()
	{
		util.waitForElement(loginpage.ProgramBtn);
		dashboard.LogoutBtn.click();
	}
	
	public boolean logoutvalidation()
	{
		util.waitForElement(loginpage.password);
		String curntURL=DriverFactory.getDriver().getCurrentUrl();
		if(curntURL.equalsIgnoreCase(ConfigReader.loginPage()))
		return true;
		else
			return false;
	}
}
