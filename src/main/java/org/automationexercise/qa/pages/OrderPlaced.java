package org.automationexercise.qa.pages;

import org.automationexercise.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OrderPlaced extends TestBase {
	
	
	
	@FindBy(xpath="//p[text()='Congratulations! Your order has been confirmed!']")
	WebElement orderPlacedMsg;
	
	@FindBy(xpath="//a[text()='Download Invoice']")
	WebElement downloadInvoice;
	
	@FindBy(xpath="	//a[text()='Continue']")
	WebElement continuebutton;

		
	public OrderPlaced()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateOrderPlacedMsg()
	{
		return orderPlacedMsg.isDisplayed();
	}

	public OrderPlaced clickonDownloadInvoice() {
		downloadInvoice.click();
		return this;
	}
	
	public Loggedin clickonContinuebutton() {
		continuebutton.click();
		return new Loggedin();
	}
	
	
	
		

	
}
