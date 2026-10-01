package org.automationexercise.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.automationexercise.qa.util.TestUtil;
import org.automationexercise.qa.constants.ApplicationConstant;

public class TestBase {


	public static WebDriver driver;
	public static Properties prop;
	public static File folder;
	ChromeOptions options;
	DesiredCapabilities cap;
	
	
		public TestBase(){
			try
			{
				 prop = new Properties();
				 ApplicationConstant applicationConstant=new ApplicationConstant();
				 String propFileLocation=applicationConstant.PROPERTIES_FILE_LOCATION;

				FileInputStream fis= new FileInputStream(propFileLocation);
				
				prop.load(fis);
				
			}catch (FileNotFoundException e){
				e.printStackTrace();
			}catch (IOException e){
				e.printStackTrace();
			}
		}
		
		@SuppressWarnings("deprecation")
		public WebDriver intialization() throws IOException
		{
			folder=new File(UUID.randomUUID().toString());
			folder.mkdir();
		String browserName = prop.getProperty("browser");
			
		System.out.println(browserName);
		String chromeDriverFileLocation = prop.getProperty("chromedriver_file_location");
		String firefoxDriverFileLocation = prop.getProperty("firefiox_file_location");
		String edgeDriverFileLocation = prop.getProperty("edge_file_location");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", chromeDriverFileLocation);
			options=new ChromeOptions();
			
			Map<String,Object> prefs=new HashMap<String,Object>();
			prefs.put("profile.default_content_setting.popups",0);
			prefs.put("download.default_directory", folder.getAbsolutePath());
			
			options.setExperimentalOption("prefs", prefs);
			cap=DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			  driver = new ChromeDriver(cap);
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", firefoxDriverFileLocation);
			  driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.edge.driver", edgeDriverFileLocation);
			  driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));
		
	
		return driver;

}
}
