package org.automationexercise.qa.pages;

import org.automationexercise.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignIn extends TestBase {
	
	
	@FindBy(xpath="//input[@name='name']")
	WebElement name;
	
	@FindBy(xpath="//form[@action='/signup']//input[@name='email']")
	WebElement emailField;
	
	@FindBy(xpath="//button[text()='Signup']")
	WebElement signup;
	
	
	
	public SignIn()
	{
		PageFactory.initElements(driver, this);
	}
	
	public SignInDetails signin(String Name,String Email) {
		name.sendKeys(Name);
		emailField.sendKeys(Email);
		signup.click();
		return new SignInDetails();
	}
	
	
	
		

	public String validateHomePageTitle() {
		return driver.getTitle();
	}
}
