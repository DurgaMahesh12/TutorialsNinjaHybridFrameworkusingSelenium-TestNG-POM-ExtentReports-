package Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.pageobjects.Productpage;
import com.pageobjects.Searchpage;

public class SearchTest extends BaseClass {
	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = InitializeBrowser("chrome");
	}

	@Test(priority = 1)
	public void VerifySearchWithValidProductAndAddtocart() {

		Searchpage searchpage = new Searchpage(driver);
		searchpage.Enteringproductdata("HP");
		searchpage.Clickseachbutton();
		Assert.assertTrue(searchpage.productdescriptiondataisdisplayed(), "Valid product Hp is Not Dispalyed");
		Productpage pp = new Productpage(driver);
		pp.ClickHplinktext();
		Assert.assertTrue(pp.Hptextvisible());
		pp.clickAddtocartbutton();
		String addtocartmessage = "Success: You have added HP LP3065 to your shopping cart!";
		Assert.assertEquals(addtocartmessage, "Success: You have added HP LP3065 to your shopping cart!");

	}

	@Test(priority = 2)
	public void VerifySearchWithInvalidProduct() {
		Searchpage searchpage = new Searchpage(driver);
		searchpage.Enteringproductdata("Honda");
		searchpage.Clickseachbutton();
		String ActualMessage = searchpage.RetriveNoproductmatchmessage();
		Assert.assertTrue(ActualMessage.contains("There is no product that matches the search criteria."),
				"Expected Message is not displayed");

	}

	@Test(priority = 3)
	public void WithoutAnyProduct() {
		Searchpage searchpage = new Searchpage(driver);
		searchpage.Clickseachbutton();
		String ActualMessage = searchpage.RetriveNoproductmatchmessage();
		Assert.assertTrue(ActualMessage.contains("There is no product that matches the search criteria."),
				"Expected no products searched message is not displaying.");

	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
