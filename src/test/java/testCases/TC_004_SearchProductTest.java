package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_004_SearchProductTest extends BaseClass {

    @Test(groups= {"Master"})
    public void verify_productSearch() {
        logger.info("**** Starting TC_004_SearchProductTest ****");
        
        try {
            HomePage hm = new HomePage(driver);
            String productName = p.getProperty("searchProductName");
            
            hm.enterProductName(productName);
            logger.info("Searching for: " + productName);
            hm.clickSearch();
            
            SearchPage sp = new SearchPage(driver);
            boolean status = sp.isProductExist(productName);
            
            Assert.assertTrue(status, "Product " + productName + " not found in search results");
            logger.info("Product found successfully");
            
        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
        }
        
        logger.info("**** Finished TC_004_SearchProductTest ****");
    }
}