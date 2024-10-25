package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import drivers.DriverFactory;

public class ProgramAddModule {
    public static WebDriver driver = DriverFactory.getDriver();
    @FindBy(xpath="//*[@id='program']") WebElement program;
    @FindBy(xpath="//*[text()=' LMS - Learning Management System ']") WebElement LmsHeading;
    @FindBy(xpath ="//div[@class='ng-star-inserted']") WebElement ModuleOrder;
    @FindBy(xpath ="//*[text()='Logout']") WebElement Logout;
    @FindBy(xpath ="//*[text()=' Manage Program']") WebElement ManageProgram;
    @FindBy(xpath ="//*[@class='p-button-danger p-button p-component p-button-icon-only']") WebElement deleteIcon;
}
