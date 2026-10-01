package org.automationexercise.qa.pages;

import org.automationexercise.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateConfirnationpage extends TestBase {
	
	
	
	@FindBy(xpath="//p[contains(text(),'Congratulations!')]")
	WebElement accountCreatedmsg;
	
	@FindBy(xpath="	//a[text()='Continue']")
	WebElement continuebutton;

		
	public CreateConfirnationpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateAccountCreationMsg()
	{
		return accountCreatedmsg.isDisplayed();
	}
	
	public Loggedin clickonContinuebutton() {
		continuebutton.click();
		return new Loggedin();
	}
	
	
	
		

	
}
