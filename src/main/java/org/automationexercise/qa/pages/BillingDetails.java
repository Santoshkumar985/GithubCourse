package org.automationexercise.qa.pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.automationexercise.qa.base.TestBase;
import org.automationexercise.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BillingDetails extends TestBase {
	
	String line;
	String totalAmount;
	String finalamount;
	BufferedReader br;
	InputStreamReader isr;
	InputStream fis;
	String actualName;
	String DeliveryName;
	String DeliveryStreet;
	String DeliveryAddress;
	String DeliveryPhone;
	String DeliveryactualName;
	String RealName;
	String BillingName;
	String BillingStreet;
	String BillingAddress;
	String BillingPhone;
	
	@FindBy(xpath="//h2[text()='Address Details']")
	WebElement adressDetails;
	
	@FindBy(xpath="//h2[text()='Review Your Order']")
	WebElement reviewOrder;
	
	@FindBy(xpath="//textarea[@class='form-control']")
	WebElement textArea;
	
	@FindBy(xpath="//a[text()='Place Order']")
	WebElement placeOrder;
	
	@FindBy(xpath="//td//p[@class='cart_total_price']")
	WebElement TotalAmount;
	
	@FindBy(xpath="//ul[@id='address_delivery']//li[@class='address_firstname address_lastname']")
	WebElement deliveryName;
	
	@FindBy(xpath="//ul[@id='address_delivery']//li[text()='GodabarishNagar']")
	WebElement deliveryStreet;

	
	@FindBy(xpath="//ul[@id='address_delivery']//li[@class='address_city address_state_name address_postcode']")
	WebElement deliveryAddress;

	
	@FindBy(xpath="//ul[@id='address_delivery']//li[@class='address_phone']")
	WebElement deliveryPhone;

	
	@FindBy(xpath="//ul[@id='address_invoice']//li[@class='address_firstname address_lastname']")
	WebElement billingName;

	
	@FindBy(xpath="//ul[@id='address_invoice']//li[text()='GodabarishNagar']")
	WebElement billingStreet;

	
	@FindBy(xpath="//ul[@id='address_invoice']//li[@class='address_city address_state_name address_postcode']")
	WebElement billingAddress;

	
	@FindBy(xpath="//ul[@id='address_invoice']//li[@class='address_phone']")
	WebElement billingPhone;

	
	public BillingDetails()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateAdressDetails()

	{
		return adressDetails.isDisplayed();
	}

	public boolean validatReviewOrderDetails()

	{
		return reviewOrder.isDisplayed();
	}

	public PaymentDetails placeOrder(String Text ) {
		totalAmount=TotalAmount.getText();
		finalamount=totalAmount.substring(4);
		textArea.sendKeys(Text);
		placeOrder.click();
		return new PaymentDetails();
	}
	
	public BillingDetails totalamount(File file) throws IOException
	{
		
		fis = new FileInputStream(file);
        isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
        br = new BufferedReader(isr);
        while ((line = br.readLine()) != null) {

            if (line.contains(finalamount)) {
                System.out.print("Total amount and Invoice amount Both are Same");
            }
        }
		return this;
	}
	
	public BillingDetails deliverydetails()
	{
		 actualName=deliveryName.getText();
		 DeliveryName=actualName.substring(4);
		 DeliveryStreet=deliveryStreet.getText();
		 DeliveryAddress=deliveryAddress.getText();
		 DeliveryPhone=deliveryPhone.getText();
		 
		 RealName=billingName.getText();
		 BillingName=RealName.substring(4);
		 BillingStreet=billingStreet.getText();
		 BillingAddress=billingAddress.getText();
		 BillingPhone=billingPhone.getText();
		 
		 return this;
	}
	
	public BillingDetails getDta()
	{
		String path="D:\\Data\\Details.xlsx";
		TestUtil Data=new TestUtil(path);
		String fname=Data.getCellData("Sheet2", "FirstName", 2);
		String lname=Data.getCellData("Sheet2", "LastName", 2);
		String street=Data.getCellData("Sheet2", "Address", 2);
		String state=Data.getCellData("Sheet2", "State", 2);
		String city=Data.getCellData("Sheet2", "City", 2);
		String zipcode=Data.getCellData("Sheet2", "Zipcode", 2);
		String mobile=Data.getCellData("Sheet2", "Mobile", 2);
		
		String finalname=fname + " " + lname;
		String finaladdress=city + " " + state + " " + zipcode;
		System.out.println(finalname);
		System.out.println(finaladdress);	
		
		if(finalname.equals(DeliveryName))
		{
			System.out.println("Both Name are Same");
		}
		
		if(street.equals(DeliveryStreet))
		{
			System.out.println("Both Street are Same");
		}
		
		if(finaladdress.equals(DeliveryAddress))
		{
			System.out.println("Both adress are Same");
		}
		
		if(mobile.equals(DeliveryPhone))
		{
			System.out.println("Both mobile numbers are Same");
		}
		
		
		
		if(finalname.equals(BillingName))
		{
			System.out.println("Both Name are Same");
		}
		
		if(street.equals(BillingStreet))
		{
			System.out.println("Both Street are Same");
		}
		
		if(finaladdress.equals(BillingAddress))
		{
			System.out.println("Both adress are Same");
		}
		
		if(mobile.equals(BillingPhone))
		{
			System.out.println("Both mobile numbers are Same");
		}
		return this;
	}
	
	

	

	
}
