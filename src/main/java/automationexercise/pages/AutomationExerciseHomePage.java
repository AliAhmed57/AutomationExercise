package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AutomationExerciseHomePage {
    private WebDriver driver ;
    // Locators
    String automationExerciseHomePageurl = "https://automationexercise.com/" ;
    private final By homePageVerification_h2 = By.xpath("(//h2 [@class = 'title text-center'])");

    public AutomationExerciseHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void navigatetoAutomationExerciseHomePage()
    {

        driver.navigate().to(automationExerciseHomePageurl);
    }
    // Validation
    public void verificationOnHomePage ()
    {
        String homePageVerification = driver.findElement(homePageVerification_h2).getText();
        Assert.assertEquals(homePageVerification, "FEATURES ITEMS" );
    }




}
