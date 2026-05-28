package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_LoginDDT(String email,String Pwd,String exp) {
		 logger.info("****** Starting TC_003_LoginTest ******");
	        
	        try
	        {
	            //HomePage
	            HomePage hp=new HomePage(driver);
	            hp.clickMyAccount();
	            hp.clickLogin();
	            
	            //Login
	            LoginPage lp=new LoginPage(driver);
	            lp.setEmail("email");
	            lp.setPassword("Pwd");
	            lp.clickLogin();
	            
	          
	            
	            //MyAccount
	            MyAccountPage macc=new MyAccountPage(driver);
	            boolean targetPage=macc.isMyAcountPageExists();
	            
	            /*
	             Data is valid- login success- test passed
	                          - login fails- test failed
	                          
	             Data is InValid-  login fails -test passed
	                             - login passed -test failed
	             
	             */
	            
	          if(exp.equalsIgnoreCase("Valid")) {
	        	  
	        	  if(targetPage==true) {
	        		  macc.clickLogout();
	        		  Assert.assertTrue(true);
	        	  }else {
	        		  Assert.assertTrue(false); 
	        	  }
	        	  
	          }
	          
	          if(exp.equalsIgnoreCase("InValid")) {
	        	  
	        	  if(targetPage==true) {
	        		  macc.clickLogout();
	        		  Assert.assertTrue(false);
	        	  }else {
	        		  Assert.assertTrue(true); 
	        	  }
	        	  
	          }
	          
	          logger.info("finished TC003 Execution");
	          
	          
	        }
	        catch(Exception e)
	        {
	            Assert.fail();
	        }
	}

}
