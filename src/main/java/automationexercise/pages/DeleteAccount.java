package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DeleteAccount {

    private WebDriver driver ;
    String expectedDeleteMsg = "ACCOUNT DELETED!" ;
    public DeleteAccount(WebDriver driver) {
        this.driver = driver;
    }

    // Locators

    private final By delete_a = (By.xpath("//a[@href]//i[@class='fa fa-trash-o']"));
    private final By delete_h2= (By.xpath("//h2 [@data-qa='account-deleted']"));

    //Actions
    public void deleteUserAccount()
    {
        driver.findElement(delete_a).click();
    }
    public void backToHomePage()
    {

    }
    // Validations
    public void validateOnDelete()
    {
        String actualDeleteMSg = driver.findElement(delete_h2).getText() ;
        Assert.assertEquals(actualDeleteMSg , expectedDeleteMsg);
    }


}
