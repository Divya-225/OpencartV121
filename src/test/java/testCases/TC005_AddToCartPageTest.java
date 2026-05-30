package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC005_AddToCartPageTest extends BaseClass {

    @Test(groups= {"Master"})
    public void verify_addToCart() throws InterruptedException {
        logger.info(" Starting TC_005_AddToCartPageTest ");
        
        try {
            
            HomePage hp=new HomePage(driver);
            
            hp.enterProductName("iPhone");
            hp.clickSearch();
            
            SearchPage sp=new SearchPage(driver);
            
            if(sp.isProductExist("iPhone"))
            {
                sp.selectProduct("iPhone");
                sp.setQuantity("3");
                sp.addToCart();
            }
            
            
            Assert.assertTrue(sp.checkConfMsg(), "Add to cart confirmation message not found ");
            logger.info("Product added to cart successfully");
            
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
        
        logger.info(" Finished TC005_AddToCartTest ");
        
    }
}