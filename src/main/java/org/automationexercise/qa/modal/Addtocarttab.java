package org.automationexercise.qa.modal;

import org.automationexercise.qa.base.TestBase;
import org.automationexercise.qa.pages.Loggedin;
import org.automationexercise.qa.pages.ViewCart;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addtocarttab extends TestBase {

	
	
	@FindBy(xpath="	//u[text()='View Cart']")
	WebElement viewCart;
	
	@FindBy(xpath="//p[text()='Your product has been added to cart.']")
	WebElement addToCartText;
	
	@FindBy(xpath="//button[text()='Continue Shopping']")
	WebElement continueShopping;
	
	public Addtocarttab()
	{
		PageFactory.initElements(driver, this);
	}
	
	public ViewCart clickonViewCart() {
		viewCart.click();
		return new ViewCart();	
	}
	
	public boolean validatTexteMsg()
	{
		return addToCartText.isDisplayed();
	}
	
	public Loggedin clickOnContinueShopping() {
		continueShopping.click();
		return new Loggedin();	
	}
}
