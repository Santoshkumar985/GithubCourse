package org.automationexercise.qa.Testpage;

import java.io.IOException;
import org.automationexercise.qa.base.TestBase;
import org.automationexercise.qa.modal.Addtocarttab;
import org.automationexercise.qa.modal.Checkout2;
import org.automationexercise.qa.pages.ViewCart;
import org.automationexercise.qa.pages.BillingDetails;
import org.automationexercise.qa.pages.CreateConfirnationpage;
import org.automationexercise.qa.pages.DeleteConfirnationpage;
import org.automationexercise.qa.pages.Homepage;
import org.automationexercise.qa.pages.Loggedin;
import org.automationexercise.qa.pages.SignIn;
import org.automationexercise.qa.pages.SignInDetails;
import org.automationexercise.qa.pages.OrderPlaced;
import org.automationexercise.qa.pages.PaymentDetails;
import org.automationexercise.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase22 extends TestBase {
	Homepage homepage;
	Addtocarttab addtocarttab;
	Checkout2 checkout2;
	SignIn signin;
	SignInDetails signindetails;
	CreateConfirnationpage createconfirnationpage;
	Loggedin loggedin;
	ViewCart viewCart;
	BillingDetails billingDetails;
	PaymentDetails paymentDetails;
	OrderPlaced orderPlaced;
	DeleteConfirnationpage deleteconfirnationpage;
	
	
	public TestCase22() {
		super();
	}

	@BeforeTest
	public void setup() throws IOException, InterruptedException {
		intialization();
		homepage=new Homepage();
		addtocarttab=new Addtocarttab();
		checkout2=new Checkout2();
		signin=new SignIn();
		signindetails=new SignInDetails();
		createconfirnationpage=new CreateConfirnationpage();
		loggedin=new Loggedin();
		viewCart=new ViewCart();
		billingDetails=new BillingDetails();
		paymentDetails=new PaymentDetails();
		orderPlaced=new OrderPlaced();
		deleteconfirnationpage=new DeleteConfirnationpage();
		
		
	}
	
	@Test
	public void Homepage()
	{
		System.out.println(homepage.validateHomePageTitle());
		Assert.assertEquals(homepage.validateHomePageTitle(), "Automation Exercise");
		signin=homepage.clickSigninBtn();
		signin.validateHomePageTitle();
	}
	
	@Test(dataProvider="LoginData")
	public void login(String Name,String Email,String Password,String FirstName,String LastName,String Address,String State,String City,String Zipcode,String Mobile) throws IOException
	{
		signindetails=signin.signin(Name, Email);
		createconfirnationpage=signindetails.signinDetails(Password, FirstName, LastName, Address,State, City,Zipcode, Mobile);
		createconfirnationpage.validateAccountCreationMsg();
		loggedin=createconfirnationpage.clickonContinuebutton();
		loggedin.validaLoggedinuname();
		addtocarttab=loggedin.clickAddtoCart();
		addtocarttab.validatTexteMsg();
		loggedin=addtocarttab.clickOnContinueShopping();
		viewCart=loggedin.clickoncart();
		billingDetails=viewCart.clickCheckout();
		billingDetails.deliverydetails();
		billingDetails.getDta();
		deleteconfirnationpage=loggedin.clickondelete();
		deleteconfirnationpage.validateAccountDeleteMsg();
		homepage=deleteconfirnationpage.clickonContinuebutton();
	}
	 
	

	@DataProvider(name="LoginData")
	public Object[][] SigninData() {
		Object[][] data = null;
		try {
			data = TestUtil.getData("Details.xlsx","Sheet2");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	
	
	
	
	
	
		
	}


