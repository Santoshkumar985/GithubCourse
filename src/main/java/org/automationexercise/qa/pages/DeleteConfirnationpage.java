package org.automationexercise.qa.pages;

import org.automationexercise.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DeleteConfirnationpage extends TestBase {
	
	
	
	@FindBy(xpath="//p[contains(text(),'Your account has been permanently deleted!')]")
	WebElement accountDeletedmsg;
	
	@FindBy(xpath="	//a[text()='Continue']")
	WebElement continuebutton;

		
	public DeleteConfirnationpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateAccountDeleteMsg()
	{
		return accountDeletedmsg.isDisplayed();
	}
	
	public Homepage clickonContinuebutton() {
		continuebutton.click();
		return new Homepage();
	}
	
	
	
		

	
}
