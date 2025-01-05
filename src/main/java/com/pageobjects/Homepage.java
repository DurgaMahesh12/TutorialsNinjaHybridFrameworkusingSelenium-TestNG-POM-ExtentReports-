package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement MyAccountDropDown;
	 
	
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement LoginOption;
	 @FindBy(linkText = "Register")
	private WebElement Registeroption;
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//Actions 
	
	public void ClickonMyAccount() {
		MyAccountDropDown.click();
		
	}
	public Loginpage selectloginoption() {
		 LoginOption.click();
		return new Loginpage(driver);
	}

	public Registerpage ClickRegisteroption() {
		Registeroption.click();
		return new Registerpage(driver);
		
	}
	
}
