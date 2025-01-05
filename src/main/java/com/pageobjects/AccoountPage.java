package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccoountPage {
      
	WebDriver driver;
	
	@FindBy(linkText = "Edit your account information")
	WebElement EditYourAccountInformation;
	
	public AccoountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	
	public  boolean VerifyEditYourAccountPageIsDisplayed() {
		
		return EditYourAccountInformation.isDisplayed();
		
	}

	
}
