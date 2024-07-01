package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NavigateToLoginPage {
    private WebDriver driver ;

    public NavigateToLoginPage(WebDriver driver) {
        this.driver = driver;
    }
    // Locators
    private final By signup_a =By.xpath("(//a [@href='/login'])");
    private final By signup_form = By.className("signup-form");
    // Actions
    public void navigatetoSignUpPage()
    {
        driver.findElement(signup_a).click();
    }
    // Validations
    public void validateOnSignUpPage()
    {
        String signupMsg =  driver.findElement(signup_form).getText();
        Assert.assertTrue(signupMsg.contains("New User Signup!"));
    }

}
