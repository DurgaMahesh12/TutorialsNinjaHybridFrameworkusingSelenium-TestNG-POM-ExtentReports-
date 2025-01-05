package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productpage {
         
	WebDriver driver;
	
	@FindBy(linkText = "HP LP3065")
	WebElement Hplink;
	@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='HP LP3065']")
	WebElement Hptextdisplayed;
	@FindBy(id="button-cart")
	WebElement Addtocartbutton;
	
	
	public void ClickHplinktext() {
		Hplink.click();
	}
	
	public boolean Hptextvisible() {
		return Hptextdisplayed.isDisplayed();
		
	}
	
	public void clickAddtocartbutton() {
		Addtocartbutton.click();
	}
	
	
	
	public Productpage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
}
