package automationexercise.tests;

import automationexercise.pages.*;
import framework.engine.DriverFactory;
import framework.engine.JsonFileManager;
import framework.engine.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class AutomationExercise {

    static WebDriver driver;
    JsonFileManager testData;
    JsonFileManager testInvalidData;

    private AutomationExerciseHomePage automationExerciseHomePage ;
    private NavigateToLoginPage navigateToSignupPage ;
    private NewUserSignUpForm newUserSignUpForm;
    private SignUpPage signUpPage ;
    private CreateAccount createAccount ;

    private DeleteAccount deleteAccount ;
    private LoginUser loginUser ;
    private UserAccount userAccount;
    private LogoutUser logoutUser ;
    private ContactUsForm contactUsForm ;
    private TestCasesPage testCasesPage;
    private ProductsPage productsPage;
    @Test
    public void createAccountTestCase()
    {
        automationExerciseHomePage.verificationOnHomePage ();
        navigateToSignupPage.navigatetoSignUpPage();
        navigateToSignupPage.validateOnSignUpPage();
        newUserSignUpForm.signUpform(testData.getTestData("username") , testData.getTestData("email"));
        signUpPage.verificationAccountInformationPage() ;
        signUpPage.accountInformationDetails(testData.getTestData("accountDetails.Password"), true , true );
        signUpPage.addressInformationDetails(testData.getTestData("addressInformation.firstname") , testData.getTestData("addressInformation.lastname") , testData.getTestData("addressInformation.company") , testData.getTestData("addressInformation.address1"), testData.getTestData("addressInformation.address2") , testData.getTestData("addressInformation.state") , testData.getTestData("addressInformation.city") , testData.getTestData("addressInformation.zipcode") , testData.getTestData("addressInformation.mobileNum"));
        createAccount.createAccount() ;
        createAccount.createAccountVerification() ;
        userAccount.navigateToAccount();
        loginUser.validateLoggedInOnUser(testData.getTestData("username"));
    }

    @Test
    public void loginWithValidEmailAndPassword()
    {
        loginUser.loginToUserAccount(testData.getTestData("email"), testData.getTestData("accountDetails.Password") ) ;
        loginUser.validateLoggedInOnUser(testData.getTestData("username"));
        contactUsForm.navigateToContactUsForm();
        contactUsForm.fillContactUsData(testData.getTestData("username") , testData.getTestData("email"),testData.getTestData("ContactUsDetails.subject"),testData.getTestData("ContactUsDetails.msg"),testData.getTestData("ContactUsDetails.filePath") );
    }
    @Test
    public void loginWithInvalidEmailAndPassword()
    {
        loginUser.loginToUserAccount(testInvalidData.getTestData("email"), testInvalidData.getTestData("accountDetails.Password")) ;
        loginUser.validateOnErrorMsg();
    }
    @Test
    public void loginAndDeleteAccount()
    {
        loginUser.loginToUserAccount(testData.getTestData("email"), testData.getTestData("accountDetails.Password") ) ;
        loginUser.validateLoggedInOnUser(testData.getTestData("username"));
        deleteAccount.deleteUserAccount();
        deleteAccount.validateOnDelete();
    }
    @Test
    public void logoutUser()
    {
        loginUser.loginToUserAccount(testData.getTestData("email"), testData.getTestData("accountDetails.Password") ) ;
        loginUser.validateLoggedInOnUser(testData.getTestData("username"));
        logoutUser.logoutFromUserAccount();
        navigateToSignupPage.validateOnSignUpPage();
    }
    @Test
    public void registerWithExistingEmail()
    {
        String newUserName = testData.getTestData("username") + "NEW" ;
        String newEmail = "NEW1" +testData.getTestData("email") ;
        automationExerciseHomePage.verificationOnHomePage ();
        navigateToSignupPage.navigatetoSignUpPage();
        navigateToSignupPage.validateOnSignUpPage();
        newUserSignUpForm.signUpform(testData.getTestData("username") , testData.getTestData("email"));
        if (newUserSignUpForm.validateEmailAlreadyExists())
        {
            newUserSignUpForm.signUpWithNewEmail(newUserName, newEmail);
        }
        signUpPage.verificationAccountInformationPage() ;
        signUpPage.accountInformationDetails(testData.getTestData("accountDetails.Password"), true , true );
        signUpPage.addressInformationDetails(testData.getTestData("addressInformation.firstname") , testData.getTestData("addressInformation.lastname") , testData.getTestData("addressInformation.company") , testData.getTestData("addressInformation.address1"), testData.getTestData("addressInformation.address2") , testData.getTestData("addressInformation.state") , testData.getTestData("addressInformation.city") , testData.getTestData("addressInformation.zipcode") , testData.getTestData("addressInformation.mobileNum"));
        createAccount.createAccount() ;
        createAccount.createAccountVerification() ;
        userAccount.navigateToAccount();
        loginUser.validateLoggedInOnUser(newUserName);
    }
    @Test
    public void testContactUsForm()
    {
        contactUsForm.navigateToContactUsForm();
        contactUsForm.verifyContactUsForm();
        contactUsForm.fillContactUsData(testData.getTestData("username") , testData.getTestData("email"),testData.getTestData("ContactUsDetails.subject"),testData.getTestData("ContactUsDetails.msg"),testData.getTestData("ContactUsDetails.filePath") );
        contactUsForm.submitContactUsDetails();
        contactUsForm.actionInPopUpMsg(Duration.ofMillis(500L));
        contactUsForm.verifySuccessContactUs();
        contactUsForm.returnToHomePage();
    }

    @Test
    public void testCasesPage()
    {
        testCasesPage.navigateToTestCasesPage();
        testCasesPage.validateOnTestCasesPage();
    }

    @Test
    public void allProductsAndProductDetails()
    {
        productsPage.navigateToProductsPage();
        productsPage.verificationOnPage();
        productsPage.viewFirstProduct();
        productsPage.verificationOnProduct();
    }
    @Test
    public void searchProduct()
    {
        productsPage.navigateToProductsPage();
        productsPage.verificationOnPage();
        productsPage.searchProduct(testData.getTestData("Product"));
        productsPage.verificationOnSearchedProducts();
        productsPage.verifyOnListedProducts(testData.getTestData("Product"));
    }

    @BeforeClass
    public void beforeClass() {
        PropertiesReader.loadProperties();
        testData = new JsonFileManager("src/test/resources/Test Data/TestData.json");
        testInvalidData = new JsonFileManager("src/test/resources/Test Data/TestInvalidData.json");
    }
    @BeforeMethod
    public void beforemethod()
    {
        driver = DriverFactory.initDriver();
        automationExerciseHomePage = new AutomationExerciseHomePage(driver) ;
        automationExerciseHomePage.navigatetoAutomationExerciseHomePage();
        navigateToSignupPage = new NavigateToLoginPage(driver) ;
        newUserSignUpForm = new NewUserSignUpForm(driver) ;
        signUpPage = new SignUpPage(driver) ;
        createAccount = new CreateAccount(driver);
        deleteAccount = new DeleteAccount(driver) ;
        loginUser = new LoginUser(driver) ;
        userAccount = new UserAccount(driver);
        logoutUser = new LogoutUser(driver) ;
        contactUsForm = new ContactUsForm(driver) ;
        testCasesPage = new TestCasesPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @AfterMethod
    public void aftermethod()
    {
        driver.quit();
    }







}
