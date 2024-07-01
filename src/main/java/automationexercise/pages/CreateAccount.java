package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CreateAccount {
    private WebDriver driver ;

    public CreateAccount(WebDriver driver) {
        this.driver = driver;
    }
    // Locators
    private final By createaccount_Button =  By.xpath("(//button [@data-qa = 'create-account'])");
    private final By createaccountMessage_h2 = By.xpath("(//h2[@class])//b");



    // Actions
    public void createAccount()
    {
        driver.findElement(createaccount_Button).click() ;

    }


    // Validation
    public void createAccountVerification()
    {
        String accountcreated = driver.findElement(createaccountMessage_h2).getText();
        Assert.assertEquals(accountcreated,  "ACCOUNT CREATED!");
    }


}
