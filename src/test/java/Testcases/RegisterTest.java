package Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.pageobjects.AccountSuccessPage;
import com.pageobjects.Homepage;
import com.pageobjects.Registerpage;

import Utils.Utilities;

public class RegisterTest extends BaseClass {

	public WebDriver driver;
	Registerpage register;

	@BeforeMethod
	public void setup() {
		driver = InitializeBrowser("chrome");
		Homepage homepage = new Homepage(driver);
		homepage.ClickonMyAccount();
	 register = homepage.ClickRegisteroption();
		
	}

	@Test(priority = 1)
	public void verifyRegisteringAccountWithMandatoryFields() {
	    register.Enterfirstnamefield("Vanum");
	    register.EnterLastnamefield("Durga Mahesh");
	    register.Enteremailfield(Utilities.generateemailwithtimestamp());
	    register.Entertelephonefield("9177517544");
	    register.Enterpasswordfield("123456");
	    register.Enterconfirmfieldfield("123456");
	    register.selectprivacypolicymessage();
	    register.Clickcontinuebutton();
	    AccountSuccessPage aspage = new AccountSuccessPage(driver);
	    String actualSuccessHeading = aspage.RetriveAccountsuccessmessage();
	    Assert.assertEquals(actualSuccessHeading, "Your Account Has Been Created!",
	        "Account success page is not displayed as expected.");
	}


	@Test(priority = 2)
	public void verifyRegisteringAccountByProvidingAllFields() {
		register.Enterfirstnamefield("Vanum");
		register.EnterLastnamefield("Durga Mahesh");
		register.Enteremailfield(Utilities.generateemailwithtimestamp());
		register.Entertelephonefield("9177517544");
		register.Enterpasswordfield("123456");
		register.Enterconfirmfieldfield("123456");
		register.selctnewsletter();
		register.selectprivacypolicymessage();
		register.Clickcontinuebutton();
        AccountSuccessPage aspage=new AccountSuccessPage(driver);
		String actualSuccessHeading = aspage.RetriveAccountsuccessmessage();
		Assert.assertEquals(actualSuccessHeading, "Your Account Has Been Created!",
				"Account success page is not displayed as expected.");
	}

	@Test(priority = 3)
	public void verifyRegisteringAccountWithExistingEmailAddress() {
		register.Enterfirstnamefield("Vanum");
		register.EnterLastnamefield("Durga Mahesh");
		register.Enteremailfield("durgamahesh5451@gmail.com");
		register.Entertelephonefield("9177517544");
		register.Enterpasswordfield("123456");
		register.Enterconfirmfieldfield("123456");
		register.selctnewsletter();
		register.selectprivacypolicymessage();
		register.Clickcontinuebutton();
		String actualWarningMessage =register.Existingemailadresswarning();
		Assert.assertTrue(actualWarningMessage.contains("Warning: E-Mail Address is already registered!"),
				"Warning message for duplicate email address is not displayed.");
	}

	@Test(priority = 4)
	public void verifyRegisteringAccountWithoutFillingDetails() {
		register.Clickcontinuebutton();
		String actualPrivacyPolicyMessage = register.Retriveprivacypolicywaringmessage();
		Assert.assertTrue(actualPrivacyPolicyMessage.contains("You must agree to the Privacy Policy!"),
				"Privacy policy agreement warning message is not displayed.");
		String firstNameActualWarningMessage = register.RetriveFirstnamewarningmessage();
		Assert.assertTrue(firstNameActualWarningMessage.contains("First Name must be between 1 and 32 characters!"),
				"First Name warning message is not displayed.");
	}

	@AfterMethod
	public void close() {
		if (driver != null) {
			driver.quit();
		}
	}
}
