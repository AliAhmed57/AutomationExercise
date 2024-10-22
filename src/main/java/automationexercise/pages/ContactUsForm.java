package automationexercise.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ContactUsForm {
    private WebDriver driver ;

    //Locators
    private final By contactUs_a = By.xpath("(//a [@href='/contact_us'])");
    private final By verifyContactUs_h2 = By.xpath("(//h2)[2]");
    private final By nameField_input = By.xpath("//div//input[@data-qa='name']");
    private final By emailField_input = By.xpath("//div//input[@data-qa='email']") ;
    private final By subjectField_input = By.xpath("//div//input[@data-qa='subject']") ;

    private final By msgField_id = By.id("message");
    private final By fileField_input = By.xpath("//div//input[@type='file']") ;
    private final By submitButton_input = By.xpath("//div//input[@type='submit']") ;
    private final By verifySuccess_input = By.xpath("//div[@class='status alert alert-success']") ;
    private final By homeButton_a= By.xpath("//div//a[@class='btn btn-success']") ;


    // Constructor
    public ContactUsForm(WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public void navigateToContactUsForm()
    {
        driver.findElement(contactUs_a).click();
    }
    public void fillContactUsData(String name , String email , String subject , String msg , String filePath)
    {
        driver.findElement(nameField_input).sendKeys(name);
        driver.findElement(emailField_input).sendKeys(email);
        driver.findElement(subjectField_input).sendKeys(subject);
        driver.findElement(msgField_id).sendKeys(msg);
        driver.findElement(fileField_input).sendKeys(filePath);
    }

    public void submitContactUsDetails()
    {
        driver.findElement(submitButton_input).click();
    }
    public void actionInPopUpMsg(Duration timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String popupText = alert.getText();
        System.out.println("Popup message: " + popupText);
        alert.accept();
        driver.switchTo().defaultContent();
    }

    public void returnToHomePage()
    {
        driver.findElement(homeButton_a).click();
    }


    //Verification
    public void verifyContactUsForm()
    {
        String verificationTitle = driver.findElement(verifyContactUs_h2).getText() ;
        Assert.assertEquals(verificationTitle , "GET IN TOUCH");
    }

    public void verifySuccessContactUs()
    {
        String successVerification = driver.findElement(verifySuccess_input).getText();
        Assert.assertEquals(successVerification, "Success! Your details have been submitted successfully.");

    }



}
