package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewUserSignUpForm {
    private WebDriver driver ;

    public NewUserSignUpForm(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By signup_name = By.name("name") ;
    private final By signup_email = By.xpath("(//input[@data-qa ='signup-email'])");
    private final By signup_Button = By.xpath("(//button[@data-qa='signup-button'])") ;
    private final By signup_form = By.xpath("(//form[@action='/signup']//p)") ;

    // Actions
    public void signUpform(String name , String email)
    {
        driver.findElement(signup_name).sendKeys(name);
        driver.findElement(signup_email).sendKeys(email);
        driver.findElement(signup_Button).click();
    }
    public void validateEmailAlreadyExists()
    {
        String emailAlreadyExistsMsg = driver.findElement(signup_form).getText();

    }
}
