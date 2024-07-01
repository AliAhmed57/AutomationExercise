package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignUpPage {
    private WebDriver driver ;
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By titleinformation_h2 = By.xpath("(//h2[@class])//b") ;
    private final By title_id = By.id("id_gender1") ;
    private final By password_id = By.id("password");
    /*private By day_select(String day) {
        return By.xpath("(//select [@data-qa = 'days'])//option [@value = ' " + day + "']");
    }
    */
    private final By day_select = By.xpath("(//select [@data-qa = 'days'])//option [@value = '14']");

    private final By month_select = By.xpath("(//select [@data-qa = 'months'])//option [@value = '1']");
    private final By year_select = By.xpath("(//select [@data-qa = 'years'])//option [@value = '2001']");

    private final By newsteller_input = By.xpath("(//input [@name ='newsletter'])") ;
    private final By optin_input = By.xpath("(//input [@name ='optin'])") ;
    private final By firstname_id = By.id("first_name") ;
    private final By lastname_id = By.id("last_name") ;
    private final By company_id = By.id("company") ;
    private final By address1_id = By.id("address1");
    private final By address2_id = By.id("address2") ;
    private final By country_select = By.xpath("(//select [@data-qa = 'country'])//option [@value = 'United States']");
    private final By state_id = By.id("state") ;

    private final By city_id = By.id("city") ;
    private final By zipcode_id = By.id("zipcode");
    private final By mobilenum_id = By.id("mobile_number");


    // Actions
    public void verificationAccountInformationPage()
    {
        String titleinformation = driver.findElement(titleinformation_h2).getText();
        Assert.assertEquals(titleinformation,"ENTER ACCOUNT INFORMATION");
    }
    public void accountInformationDetails(String password , Boolean newsteller , Boolean optin)
    {
        driver.findElement(title_id).click();
        driver.findElement(password_id).sendKeys(password);
        driver.findElement(day_select).click();
        driver.findElement(month_select).click();
        driver.findElement(year_select).click();
        if (newsteller)
        {
            driver.findElement(newsteller_input).click();
        }
        if (optin)
        {
            driver.findElement(optin_input).click();
        }
    }
    public void addressInformationDetails(String firstName , String lastName , String company , String address1 , String address2 , String state , String city , String zipcode , String mobilenum)
    {
        driver.findElement(firstname_id).sendKeys(firstName);
        driver.findElement(lastname_id).sendKeys(lastName);
        driver.findElement(company_id).sendKeys(company);
        driver.findElement(address1_id).sendKeys(address1);
        driver.findElement(address2_id).sendKeys(address2);
        driver.findElement(country_select).click();
        driver.findElement(state_id).sendKeys(state);
        driver.findElement(city_id).sendKeys(city);
        driver.findElement(zipcode_id).sendKeys(zipcode);
        driver.findElement(mobilenum_id).sendKeys(mobilenum);
    }






}
