package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPage extends BasePage {
	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	WebElement btnItems;
	
	@FindBy(xpath="//strong[normalize-space()='View Cart']")
	WebElement lnkViewCart;
	
	@FindBy(xpath="//div[@id='content']//h1[contains(text(),'Shopping Cart')]")
	WebElement msgHeading;
	
	@FindBy(xpath="//div[@id='content']//div[@class='col-sm-4 col-sm-offset-8']//table//tr[4]//td[2]")
	WebElement lblTotalPrice;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement btnCheckout;
	
	@FindBy(xpath="//a[normalize-space()='Continue Shopping']")
	WebElement btnContinueShopping;
	
	@FindBy(xpath="//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]")
	WebElement msgEmptyCart;
	
	public void clickItemsToNavigateToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(btnItems)).click();
	}
	
	public void clickViewCart() {
		wait.until(ExpectedConditions.elementToBeClickable(lnkViewCart)).click();
	}
	
	public boolean isShoppingCartPageExists() {
		try {
			return wait.until(ExpectedConditions.visibilityOf(msgHeading)).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public String getTotalPrice() {
		return wait.until(ExpectedConditions.visibilityOf(lblTotalPrice)).getText();
	}
	
	public void clickOnCheckout() {
		wait.until(ExpectedConditions.elementToBeClickable(btnCheckout)).click();
	}
	
	public void clickOnContinueShopping() {
		wait.until(ExpectedConditions.elementToBeClickable(btnContinueShopping)).click();
	}
	
	public boolean isCartEmpty() {
		try {
			return wait.until(ExpectedConditions.visibilityOf(msgEmptyCart)).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}