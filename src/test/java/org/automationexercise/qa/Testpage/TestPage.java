package org.automationexercise.qa.Testpage;

import java.io.File;
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

public class TestPage extends TestBase {
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
	
	
	public TestPage() {
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
		addtocarttab=homepage.clickAddtoCart();
		addtocarttab.validatTexteMsg();
	}
	@Test
	public void addtocart()
	{
		viewCart=addtocarttab.clickonViewCart();
		viewCart.validateCheckoutTitle();
		Assert.assertEquals(viewCart.validateCheckoutTitle(),"Automation Exercise - Checkout");
		checkout2=viewCart.clickProceedtoCheckout();
		checkout2.validatCartTexteMsg();

	}
	
	@Test
	public void checkout()
	{
		signin=checkout2.clickonRegister();
		signin.validateHomePageTitle();
		
	}
	
	@Test(dataProvider="LoginData")
	public void login(String Name,String Email,String Password,String FirstName,String LastName,String Address,String State,String City,String Zipcode,String Mobile,String Text, String NameOnCard, String CardNumber,String CVC,String Expiration,String Year) throws IOException
	{
		signindetails=signin.signin(Name, Email);
		createconfirnationpage=signindetails.signinDetails(Password, FirstName, LastName, Address,State, City,Zipcode, Mobile);
		createconfirnationpage.validateAccountCreationMsg();
		loggedin=createconfirnationpage.clickonContinuebutton();
		loggedin.validaLoggedinuname();
		viewCart=loggedin.clickoncart();
		billingDetails=viewCart.clickCheckout();
		billingDetails.validateAdressDetails();
		billingDetails.validatReviewOrderDetails(); 
		paymentDetails=billingDetails.placeOrder(Text);
		orderPlaced=paymentDetails.payment(NameOnCard, CardNumber, CVC, Expiration, Year);
		orderPlaced.validateOrderPlacedMsg();
		
		orderPlaced.clickonDownloadInvoice();
		File listOfFiles[]=folder.listFiles();
		Assert.assertTrue(listOfFiles.length>0);
		
		for(File file:listOfFiles)
		{
			Assert.assertTrue(file.length()>0);
			billingDetails.totalamount(file);
		}
		loggedin=orderPlaced.clickonContinuebutton();
		deleteconfirnationpage=loggedin.clickondelete();
		deleteconfirnationpage.validateAccountDeleteMsg();
		homepage=deleteconfirnationpage.clickonContinuebutton();
	}
	 
	
	
	
	@DataProvider(name="LoginData")
	public Object[][] SigninData() {
		Object[][] data = null;
		try {
			data = TestUtil.getData("Details.xlsx","Sheet1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}


	
		
		
	}


