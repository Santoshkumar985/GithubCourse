package org.automationexercise.qa.pages;

import org.automationexercise.qa.base.TestBase;
import org.automationexercise.qa.modal.Checkout2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCart extends TestBase {
	

	@FindBy(xpath="//a[text()='Proceed To Checkout']")
	WebElement checkout;
	
	
	public ViewCart()
	{
		PageFactory.initElements(driver, this);
	}
	
	public Checkout2 clickProceedtoCheckout() {
		checkout.click();
		return new Checkout2();	
	}
	
	public BillingDetails clickCheckout() {
		checkout.click();
		return new BillingDetails();	
	}
	
	
	
	public String validateCheckoutTitle() {
		return driver.getTitle();
	}

}
