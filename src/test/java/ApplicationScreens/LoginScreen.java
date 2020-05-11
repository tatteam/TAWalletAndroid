package ApplicationScreens;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BaseClass;


public class LoginScreen extends  BaseClass {
	
	public LoginScreen() throws IOException
	{
		
		 System.out.println("Application Initialized");
		 		  
	}
	
	
	public void AllowContactsAccessButton() 
	{
		System.out.println("AllowContactsAccessButton method started");
		
		try {
			driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
	        System.out.println("AllowContactsAccessButton clicked");
		}
		catch(Exception exp)
		{
			System.out.println("Unable to click AllowContactsAccessButton");
		}
	}
	
	
	  public void EnterDetails(String username, String password)
	  {
		 		  
		  try 
		  {
			  WebDriverWait wait = new WebDriverWait(driver,10);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.ta.wallet.tawallet:id/mobile")));			  
			  driver.findElementById("com.ta.wallet.tawallet:id/mobile").sendKeys(username); 
			  driver.findElementById("com.ta.wallet.tawallet:id/pass").sendKeys(password); 
			  
		  }
		  catch(Exception exp) 
		  {
	           System.out.println("Unable to enter user details");
	      } 
	  }
	  
	  public void Login() 
	  { 
		  try 
		  { 
			  driver.findElementById("com.ta.wallet.tawallet:id/button2").click();
	          System.out.println("LoginButton clicked");
	          Thread.sleep(5000);
		  } 
		  catch(Exception exp) 
		  {
			  System.out.println("LoginButton Cause is.. "+exp.getCause());
			  System.out.println("LoginButton Message is.. "+exp.getMessage());
			  exp.printStackTrace(); 
	      } 
	  }
	 


	public void VerifyWhetherLoggedintoScreen() {
		try
		  {
	  if(driver.findElementById("com.ta.wallet.tawallet:id/topLNameBalRP").isDisplayed())
	  	{
		  System.out.println("User logged in successfully"); 
		  }
	  else {
		  System.out.println("User login failed"); }
	  
		  }
		  catch(Exception exp)
		  {
			  System.out.println("Unable to Loginto the Application");
		  }
		
	}
}
