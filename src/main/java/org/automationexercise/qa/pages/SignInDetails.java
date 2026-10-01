package org.automationexercise.qa.pages;

import org.automationexercise.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignInDetails extends TestBase {
	
	
	@FindBy(xpath="//input[@id='id_gender1']")
	WebElement title;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement address;
	
	@FindBy(xpath="//input[@id='state']")
	WebElement state;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='zipcode']")
	WebElement zipCode;
	
	@FindBy(xpath="//input[@id='mobile_number']")
	WebElement mobileNumber;
	
	@FindBy(xpath="//button[text()='Create Account']")
	WebElement createAccountBtn;
	
	
	
	public SignInDetails()
	{
		PageFactory.initElements(driver, this);
	}
	
	public CreateConfirnationpage signinDetails(String Password,String FirstName,String LastName,String Address,String State,String City,String Zipcode,String Mobile) {
		title.click();
		password.sendKeys(Password);
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		address.sendKeys(Address);
		state.sendKeys(State);
		city.sendKeys(City);
		zipCode.sendKeys(Zipcode);
		mobileNumber.sendKeys(Mobile);
		createAccountBtn.click();
		return new CreateConfirnationpage();
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
}
