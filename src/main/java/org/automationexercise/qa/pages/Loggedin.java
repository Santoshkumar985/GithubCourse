package org.automationexercise.qa.pages;

import org.automationexercise.qa.base.TestBase;
import org.automationexercise.qa.modal.Addtocarttab;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Loggedin extends TestBase {
	
	
	
	@FindBy(xpath="	//a[text()=' Logged in as ']")
	WebElement loggedinuname;
	
	@FindBy(xpath="//a[text()=' Cart']")
	WebElement cart;
	
	@FindBy(xpath="//a[text()=' Delete Account']")
	WebElement deleteAccount;
	
	@FindBy(xpath="	//div[@id='cartModal']//parent::div/div[2]//descendant::div[@class='productinfo text-center']/a")
	WebElement addtocartButton;
	
	public Loggedin()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validaLoggedinuname()
	{
		return loggedinuname.isDisplayed();
	}

	public ViewCart clickoncart() {
		cart.click();
		return new ViewCart();
	}
	
	public DeleteConfirnationpage clickondelete() {
		deleteAccount.click();
		return new DeleteConfirnationpage();
	}
	
	public Addtocarttab clickAddtoCart() {
		addtocartButton.click();
		return new Addtocarttab();	
	}

	
	
		

	
}
