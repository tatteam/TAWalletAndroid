package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.URL;

//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
		
	
	public static AppiumDriver<MobileElement> driver;
	 
	@BeforeTest
	  public void beforeTest() {
		  System.out.println("Baseclass Initiated");
		  try {
		  DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "MI Note 8 Pro");
			cap.setCapability(MobileCapabilityType.UDID, "uc6sq8yh6h757h7d");
			cap.setCapability("appPackage", "com.ta.wallet.tawallet");
			cap.setCapability("appActivity", "com.ta.wallet.tawallet.agent.View.Activities.SplashScreen");		
			cap.setCapability("automationName", "uiautomator1");
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
			
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			
			driver = new AppiumDriver<MobileElement>(url, cap);
			 System.out.println("Baseclass completed");
		  }
		  catch(Exception exp)
		  {
			  System.out.println("Cause is.. "+exp.getCause());
			  System.out.println("Message is.. "+exp.getMessage());
			  exp.printStackTrace();
		  }
	  }

	  @AfterTest
	  public void Teardown() {
		  
		  driver.closeApp();
		//  driver.quit();
		  System.out.println("Driver Closed");
	  }
}
