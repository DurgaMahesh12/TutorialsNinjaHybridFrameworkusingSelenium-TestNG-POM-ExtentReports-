package Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.pageobjects.AccoountPage;
import com.pageobjects.Homepage;
import com.pageobjects.Loginpage;

import Utils.Utilities;

public class LoginTest extends BaseClass {
    public WebDriver driver;
      
    Loginpage loginPage;

    @BeforeMethod
    public void setup() {
        driver = InitializeBrowser("chrome");
        Homepage homepage = new Homepage(driver);
        homepage.ClickonMyAccount();
        loginPage = homepage.selectloginoption();
    }

    @Test(priority = 1, dataProvider = "validCredentialsSupplier")
    public void verifyLoginWithValidCredentials(String email, String password) {
        loginPage.EnterEmailAddress(email);
        loginPage.EnteringPassword(password);
        AccoountPage accountPage = loginPage.ClickLoginButton();
        Assert.assertTrue(
           accountPage.VerifyEditYourAccountPageIsDisplayed(),
            "Expected: 'Edit your account information' link should be displayed."
        );
    }

    @DataProvider(name = "validCredentialsSupplier")
    public Object[][] supplyTestData() throws IOException {
        return Utilities.GetTestDataFromExcel("Login");
    }

    @Test(priority = 2)
    public void verifyLoginWithInvalidCredentials() {
    	 loginPage.EnterEmailAddress(Utilities.generateemailwithtimestamp());
         loginPage.EnterEmailAddress("Mahesh@27376");
         loginPage.ClickLoginButton();
        String actualWarningMessage = loginPage.Emailpasswordwarningmessage();
        String expectedMessage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertTrue(
            actualWarningMessage.contains(expectedMessage),
            "Expected warning message not displayed."
        );
    }

    @Test(priority = 3)
    public void verifyLoginWithInvalidEmailAndValidPassword() {
   	    loginPage.EnterEmailAddress(Utilities.generateemailwithtimestamp());
        loginPage.EnterEmailAddress("Mahesh@5451");
        loginPage.ClickLoginButton();

        String actualWarningMessage = loginPage.Emailpasswordwarningmessage();
        String expectedMessage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertTrue(
            actualWarningMessage.contains(expectedMessage),
            "Expected warning message not displayed."
        );
    }

    @Test(priority = 4)
    public void verifyLoginWithValidEmailAndInvalidPassword() {
    	 loginPage.EnterEmailAddress("durgamaheshvanum123@gmail.com");
         loginPage.EnterEmailAddress("Mahesh@27376");
         loginPage.ClickLoginButton();

        String actualWarningMessage = loginPage.Emailpasswordwarningmessage();
        String expectedMessage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertTrue(
            actualWarningMessage.contains(expectedMessage),
            "Expected warning message not displayed."
        );

       
    }

    @Test(priority = 5)
    public void verifyLoginWithoutProvidingCredentials() {
         loginPage.ClickLoginButton();
        String actualWarningMessage = loginPage.Emailpasswordwarningmessage();
        String expectedMessage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertTrue(
            actualWarningMessage.contains(expectedMessage),
            "Expected warning message not displayed."
        );
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
