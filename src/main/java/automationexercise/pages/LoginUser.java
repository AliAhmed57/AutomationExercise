package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginUser extends NavigateToLoginPage {

    private WebDriver driver ;
// Constructor
    public LoginUser(WebDriver driver) {
        super(driver);
        this.driver = driver ;
    }
// Locators
private final By login_name = (By.xpath("(//input[@data-qa='login-email'])"));
    private final By login_password = (By.name("password"));
    private final By login_Button = By.xpath("(//button[@data-qa='login-button'])") ;
    private final By username_id = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b");



    public void loginToUserAccount(String email , String password)
    {
        navigatetoSignUpPage();
        driver.findElement(login_name).sendKeys(email);
        driver.findElement(login_password).sendKeys(password);
        driver.findElement(login_Button).click();

    }
    public void validateOnUser(String username)
    {
        String loggedInUser = driver.findElement(username_id).getText();
        Assert.assertEquals(loggedInUser,username );
    }


}
