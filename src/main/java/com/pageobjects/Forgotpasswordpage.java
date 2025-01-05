package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Forgotpasswordpage {
  WebDriver driver;
  
  @FindBy(id="input-email")
  WebElement EnterEmail;
  
  @FindBy(xpath="//input[@value='Continue']")
  WebElement Continuebutton;
  
 
	public void EnteringEmailAdress(String email) {
	 EnterEmail.sendKeys(email);
		
	}
	public void ClickingContinueButton() {
		Continuebutton.click();
	}
	public Forgotpasswordpage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
}
