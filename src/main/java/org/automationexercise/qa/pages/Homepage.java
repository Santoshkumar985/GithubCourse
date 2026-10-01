package org.automationexercise.qa.pages;

import org.automationexercise.qa.base.TestBase;
import org.automationexercise.qa.modal.Addtocarttab;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Homepage extends TestBase {
	
	@FindBy(xpath="	//div[@id='cartModal']//parent::div/div[2]//descendant::div[@class='productinfo text-center']/a")
	WebElement addtocartButton;
	
	@FindBy(xpath="//a[text()=' Signup / Login']")
	WebElement signinbtn;
	
	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public SignIn clickSigninBtn() {
		signinbtn.click();
		return new SignIn();	
	}
	
	public Addtocarttab clickAddtoCart() {
		addtocartButton.click();
		return new Addtocarttab();	
	}
	

	public String validateHomePageTitle() {
		return driver.getTitle();
	}
}



