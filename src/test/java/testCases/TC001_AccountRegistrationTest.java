package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

    @Test(groups={"Regression","Master"})
    public void verify_account_registration()
    {
    	try {
    		
    	logger.info("******Starting testcase TC001_AccountRegristration****");
    
        HomePage hp=new HomePage(driver);
        logger.info("******clicked on MyAccount***");
        hp.clickMyAccount();
        logger.info("******clicked on Register***");
        hp.clickRegister();

        AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
        
        logger.info("******Providing Info for Registration***");

        regpage.setFirstName(randomeString().toUpperCase());
        regpage.setLastName(randomeString().toUpperCase());
        regpage.setEmail(randomeString()+"@gmail.com"); // randomly generated the email
        regpage.setTelephone(randomeNumber());

        String password=randomeAlphaNumeric();
        
        regpage.setPassword(password);
        regpage.setConfirmPassword(password);
        
        regpage.setPrivacyPolicy();
        regpage.clickContinue();
        
        logger.info("******Validating the registration***");
        String confmsg=regpage.getConfirmationMsg();
        if(confmsg.equals("Your Account Has Been Created!")) {
        	Assert.assertTrue(true);
        	
        }
        else {
        	logger.error("Test Failed");
   		 logger.debug("debug logs....");
   		Assert.assertTrue(false);
        }
      
    	}catch(Exception e) {
    		Assert.fail();
    		
    	}
    	 logger.info("*****finished testcase Execution***");
    }
}