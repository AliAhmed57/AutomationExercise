package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ProductsPage {
    private WebDriver driver ;


    public ProductsPage(WebDriver driver) {
        this.driver = driver;

    }


    //Locators
    private final By products_href = By.xpath("(//a[@href='/products'])");
    private final By verificationOnTitle_h2 = By.xpath("//h2[@class='title text-center']");
    private final By viewProduct_href = By.xpath("//a[@href='/product_details/1']");
    private final By productInfo_class = By.className("product-information");
    private final By productName_h2 = By.xpath("//div[@class='product-information']//h2") ;
    private final By productCategory_p = By.xpath("(//div[@class='product-information']//p)[1]");
    private final By productPrice_span = By.xpath("(//span//span)[1]");

    private final By searchProduct_id = By.id("search_product");
    private final By submitSearch_id = By.id("submit_search") ;
    private final By verificationOnSearchedProducts_h2 = By.xpath("//h2[@class='title text-center']");
    private final By productsInfo_class = By.xpath("(//div[@class='features_items']//div[@class='productinfo text-center'])");
    //Actions
    public void navigateToProductsPage()
    {
        driver.findElement(products_href).click();
    }

    public void viewFirstProduct()
    {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        driver.findElement(viewProduct_href).click();
    }
    public void searchProduct(String searchName)
    {
        driver.findElement(searchProduct_id).sendKeys(searchName);
        driver.findElement(submitSearch_id).click();
    }

    //Verification
    public void verificationOnPage()
    {
        String actualTitle = driver.findElement(verificationOnTitle_h2).getText();
        String expectedTitle = "ALL PRODUCTS";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    public void verificationOnProduct()
    {
        driver.findElement(productInfo_class).isDisplayed();
    }
    public void verificationOnSearchedProducts()
    {
        String actualTitle = driver.findElement(verificationOnSearchedProducts_h2).getText();
        String expectedTitle = "SEARCHED PRODUCTS";
        Assert.assertEquals(actualTitle,expectedTitle);

    }

    public void verifyOnListedProducts(String searchName)
    {
        List<WebElement> searchResults = driver.findElements(productsInfo_class);
       for (WebElement product : searchResults)
       {
         String productName = product.getText().toLowerCase();
         Assert.assertTrue(productName.contains(searchName));

       }

    }

}
