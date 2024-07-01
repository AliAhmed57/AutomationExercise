package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserAccount {
    private WebDriver driver ;

    // Locators
    private final By continue_Button = By.xpath("//div//a[@data-qa='continue-button']");
    public UserAccount(WebDriver driver) {
        this.driver = driver ;
    }
    // Actions
    public void navigateToAccount()
    {
        driver.findElement(continue_Button).click();

    }

}
