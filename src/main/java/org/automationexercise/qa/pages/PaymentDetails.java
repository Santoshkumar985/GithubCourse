package org.automationexercise.qa.pages;

import org.automationexercise.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PaymentDetails extends TestBase {
	
	
	
	@FindBy(xpath="//input[@name='name_on_card']")
	WebElement cardName;
	
	@FindBy(xpath="//input[@name='card_number']")
	WebElement cardNumber;
	
	@FindBy(xpath="//input[@name='cvc']")
	WebElement cvc;
	
	@FindBy(xpath="//input[@name='expiry_month']")
	WebElement expiryMonth;
	
	@FindBy(xpath="//input[@name='expiry_year']")
	WebElement expiryYear;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement confirmOrder;
	
	

	
   public PaymentDetails()
	{
		PageFactory.initElements(driver, this);
	}
	


	public OrderPlaced payment(String NameOnCard,String CardNumber,String CVC,String Expiration,String Year ) {
		cardName.sendKeys(NameOnCard);
		cardNumber.sendKeys(CardNumber);
		cvc.sendKeys(CVC);
		expiryMonth.sendKeys(Expiration);
		expiryYear.sendKeys(Year);
		confirmOrder.click();
		return new OrderPlaced();
	}
	
	


	
}
