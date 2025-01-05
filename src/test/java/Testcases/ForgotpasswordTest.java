package Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.pageobjects.Forgotpasswordpage;
import com.pageobjects.Homepage;
import com.pageobjects.Loginpage;

import Utils.Utilities;

public class ForgotpasswordTest extends BaseClass {

	WebDriver driver;
	 Loginpage loginpage;
	Forgotpasswordpage Forgotpage;

	@BeforeMethod
	public void setup() {
		driver = InitializeBrowser("chrome");
		Homepage homepage = new Homepage(driver);
		homepage.ClickonMyAccount();
		loginpage=homepage.selectloginoption();
	}

	@Test(priority = 1)
	public void VerifyForgotpasswordEnteringCorrectemail() {
		loginpage.ClickForgotpasswordlink();
		Forgotpage = new Forgotpasswordpage(driver);
		Forgotpage.EnteringEmailAdress("durgamaheshvanum123@gmail.com");
		Forgotpage.ClickingContinueButton();
		String SentEmailMessage = "An email with a confirmation link has been sent your email address.";
		Assert.assertEquals(SentEmailMessage, "An email with a confirmation link has been sent your email address.",
				"There is no any sent emaill message");
	}

	@Test(priority = 2)
	public void VerifyForgotpasswordEnteringInCorrectemail() {

		loginpage.ClickForgotpasswordlink();
		Forgotpage = new Forgotpasswordpage(driver);
		Forgotpage.EnteringEmailAdress(Utilities.generateemailwithtimestamp());
		Forgotpage.ClickingContinueButton();
		String SentEmailMessage = "Warning: The E-Mail Address was not found in our records, please try again!";
		Assert.assertEquals(SentEmailMessage,
				"Warning: The E-Mail Address was not found in our records, please try again!");

	}

	@Test(priority = 3)
	public void VerifyForgotpasswordWithoutEnteringFields() {
		loginpage.ClickForgotpasswordlink();
		Forgotpage = new Forgotpasswordpage(driver);
		Forgotpage.ClickingContinueButton();
		String SentEmailMessage = "Warning: The E-Mail Address was not found in our records, please try again!";
		Assert.assertEquals(SentEmailMessage,
				"Warning: The E-Mail Address was not found in our records, please try again!");

	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

}
