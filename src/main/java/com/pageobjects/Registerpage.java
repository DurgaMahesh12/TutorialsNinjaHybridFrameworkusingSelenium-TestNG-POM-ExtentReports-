package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {

    WebDriver driver;

    public Registerpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 

    @FindBy(id = "input-firstname")
    private WebElement firstnamefield;

    @FindBy(id = "input-lastname")
    private WebElement lastnamefield;

    @FindBy(id = "input-email")
    private WebElement emailfield;

    @FindBy(id = "input-telephone")
    private WebElement telephonefield;

    @FindBy(id = "input-password")
    private WebElement passwordfield;

    @FindBy(id = "input-confirm")
    private WebElement confirmfield;

    @FindBy(name = "agree")
    private WebElement agreebox;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continuebutton;

    @FindBy(xpath = "//input[@name='newsletter'][@value=1]")
    private WebElement clicknewsletter;
    
    @FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
    private WebElement ExistingEmailadresswarningmessage;
    
    @FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
    private WebElement privacypolicywarning;
    
    @FindBy(xpath="//div[text()='First Name must be between 1 and 32 characters!']")
    private WebElement Firstnamewarningmessage;
   
    
    
    public void Enterfirstnamefield(String firstname) {
        firstnamefield.sendKeys(firstname);
    }

    public void EnterLastnamefield(String lastname) {
        lastnamefield.sendKeys(lastname);
    }

    public void Enteremailfield(String email) {
        emailfield.sendKeys(email);
    }

    public void Entertelephonefield(String telephone) {
        telephonefield.sendKeys(telephone);
    }

    public void Enterpasswordfield(String password) {
        passwordfield.sendKeys(password);
    }

    public void Enterconfirmfieldfield(String confirmPassword) {
        confirmfield.sendKeys(confirmPassword);
    }

    public void Clickcontinuebutton() {
        continuebutton.click();
    }

    public void selctnewsletter() {
        clicknewsletter.click();
    }

    public void selectprivacypolicymessage() {
        agreebox.click();
    }
    public String Existingemailadresswarning() {
    	return ExistingEmailadresswarningmessage.getText();
    	
    }
    public String Retriveprivacypolicywaringmessage() {
    	return privacypolicywarning.getText();
    }
    public String RetriveFirstnamewarningmessage() {
    	return Firstnamewarningmessage.getText();
    }
}
