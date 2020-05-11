package testcases;

import org.testng.annotations.Test;
import ApplicationScreens.LoginScreen;
import Utilities.BaseClass;
import Utilities.ExcelUtil;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;


public class LoginTest extends  BaseClass {
	static LoginScreen lp;
	
	//Main Directory of the project
		public static final String currentDir = System.getProperty("user.dir");
		public static final String excelpath = currentDir + "/excel/TestData.xlsx";
		public static final String excelSheetname = "Credentials";
	
	@Test(dataProvider="test1data")
	public void test1(String username, String password) 
	
	{
		System.out.println("Username: " + username + '\n' + "Password: " + password);
		
		try {
			  
			  lp=new LoginScreen(); 
			  System.out.println("LoginScreen started"+'\n');
			  lp.AllowContactsAccessButton();
			 // Thread.sleep(5000);
			  lp.EnterDetails(username,password); 
			  lp.Login();
			  lp.VerifyWhetherLoggedintoScreen();
			  System.out.println("LoginScreen Completed");
			  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			  } 
			  catch(Exception exp) {
			  System.out.println("TestLogin Cause is.. "+exp.getCause());
			  System.out.println("TestLogin Message is.. "+exp.getMessage());
			  exp.printStackTrace(); 
			  
			  }
				
	}
	
	@DataProvider(name = "test1data")
	public  Object[][] getData()
	{
		Object data[][] = testdata(excelpath, excelSheetname);
		return data;
	}

	public  Object[][] testdata(String excelpath, String sheetName)
	{
	 ExcelUtil excel = new ExcelUtil(excelpath, sheetName);
	 
	 int rowCount = excel.getRowcount();
	 int colcount = excel.getColcount();
	 Object data[][] = new Object[rowCount-1][colcount];
	 
	 for(int i=1; i< rowCount; i++)
	 {
		 for(int j=0; j< colcount; j++) {
			String celldata = excel.getCellData(i, j);
			data[i-1][j] = celldata;
			 
		 }
		 System.out.println();
	 }
	 return data;
	 
	}
}