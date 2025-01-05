package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchpage {
	
	WebDriver driver;
	
    @FindBy(name ="search" )
	private WebElement searchbar;
    
    @FindBy(xpath="//div[@id='search']/descendant::button")
    private WebElement searchbutton;
	
    @FindBy(xpath="//a[text()='HP LP3065']")
    private WebElement ValidproductisDisplayed;
    
    @FindBy(xpath="//div[@id='content']/descendant::p[2]")
    private WebElement NoProductmatch;
    
    public Searchpage(WebDriver driver) {
    	this.driver =driver;
    	PageFactory.initElements(driver, this);
    }
    
    public void Enteringproductdata(String product) {
    	searchbar.sendKeys(product);
    }
    public void Clickseachbutton() {
    	searchbutton.click();
    }
    public boolean productdescriptiondataisdisplayed() {
    	return ValidproductisDisplayed.isDisplayed();
    }
    public String RetriveNoproductmatchmessage() {
    	return NoProductmatch.getText();
    }
    
}
