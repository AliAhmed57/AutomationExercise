package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutUser {
    private WebDriver driver ;
    //Locators

    private final By logout_a = (By.xpath("//a[@href='/logout']"));

    public LogoutUser(WebDriver driver) {
        this.driver = driver ;
    }

    // Actions
    public void logoutFromUserAccount()
    {
        driver.findElement(logout_a).click();
    }



}
