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


public class AutomationExercise {

    static WebDriver driver;
    JsonFileManager testData;

    private AutomationExerciseHomePage automationExerciseHomePage ;
    private NavigateToLoginPage navigateToSignupPage ;
    private NewUserSignUpForm newUserSignUpForm;
    private SignUpPage signUpPage ;
    private CreateAccount createAccount ;

    private DeleteAccount deleteAccount ;
    private LoginUser loginUser ;
    private UserAccount userAccount;
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
        loginUser.validateOnUser(testData.getTestData("username"));
    }

    @Test
    public void loginTestCase()
    {
        loginUser.loginToUserAccount(testData.getTestData("email"), testData.getTestData("accountDetails.Password") ) ;
        loginUser.validateOnUser(testData.getTestData("username"));
        deleteAccount.deleteUserAccount();
        deleteAccount.validateOnDelete();
    }


    @BeforeClass
    public void beforeClass() {
        PropertiesReader.loadProperties();
        testData = new JsonFileManager("src/test/resources/Test Data/TestData.json");
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
    }

    @AfterMethod
    public void aftermethod()
    {
        driver.quit();
    }







}
