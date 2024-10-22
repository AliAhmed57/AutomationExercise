package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCasesPage {

    //Locators
    private final By testCases_href =  By.xpath("(//a[@href='/test_cases'])");
    private final By testCases_title = By.xpath("(//span[@class='google-anno-t'])");

    private WebDriver driver ;

    //Constructor
    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
    }

    //Actions

    public void navigateToTestCasesPage()
    {
        driver.findElement(testCases_href).click();
    }

    //Validations
    public void validateOnTestCasesPage()
    {
        String title = driver.findElement(testCases_title).getText();
        Assert.assertEquals(title,"TEST");
    }
}
