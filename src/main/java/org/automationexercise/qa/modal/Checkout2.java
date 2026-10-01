package org.automationexercise.qa.modal;

import org.automationexercise.qa.base.TestBase;
import org.automationexercise.qa.pages.SignIn;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout2 extends TestBase {

	
	
	@FindBy(xpath="//u[text()='Register / Login']")
	WebElement Register;
	
	@FindBy(xpath="//p[text()='Register / Login account to proceed on checkout.']")
	WebElement CartText;
	
	public Checkout2()
	{
		PageFactory.initElements(driver, this);
	}
	
	public SignIn clickonRegister() {
		Register.click();
		return new SignIn();	
	}
	
	public boolean validatCartTexteMsg()
	{
		return CartText.isDisplayed();
	}
}
