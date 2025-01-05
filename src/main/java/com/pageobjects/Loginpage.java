package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Loginpage {
     WebDriver driver;
     
	@FindBy(id = "input-email")
	private WebElement EmailAdreessFied;
	
	@FindBy(id= "input-password")
    private	WebElement passwordfield;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginbutton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement Emailpasswordnotmatchingwarning;
	
	@FindBy(linkText ="Forgotten Password")
	private WebElement Forgotpassword;
	
	
	public Loginpage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	//Actions
	public void EnterEmailAddress(String email) {
		
		EmailAdreessFied.sendKeys(email);
		
	}
	public void EnteringPassword(String password) {
		passwordfield.sendKeys(password);
	}
	public AccoountPage ClickLoginButton() {
		loginbutton.click();
		return new AccoountPage(driver);
	}
	public String Emailpasswordwarningmessage() {
		return Emailpasswordnotmatchingwarning.getText();
	}
	public void ClickForgotpasswordlink() {
		Forgotpassword.click();
	}
	

	
}
