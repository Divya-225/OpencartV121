package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	// Billing Details
	@FindBy(id="input-payment-firstname")
	WebElement txtFirstName;
	
	@FindBy(id="input-payment-lastname")
	WebElement txtLastName;
	
	@FindBy(id="input-payment-address-1")
	WebElement txtAddress1;
	
	@FindBy(id="input-payment-address-2")
	WebElement txtAddress2;
	
	@FindBy(id="input-payment-city")
	WebElement txtCity;
	
	@FindBy(id="input-payment-postcode")
	WebElement txtPin;
	
	@FindBy(id="input-payment-country")
	WebElement drpCountry;
	
	@FindBy(id="input-payment-zone")
	WebElement drpState;
	
	@FindBy(id="button-payment-address")
	WebElement btnContinueBill;
	
	// Delivery Details
	@FindBy(id="button-shipping-address")
	WebElement btnContinueDeliveryAddr;
	
	// Delivery Method
	@FindBy(name="comment")
	WebElement txtDeliveryMethodComment;
	
	@FindBy(id="button-shipping-method")
	WebElement btnContinueDeliveryMethod;
	
	// Payment Method
	@FindBy(name="agree")
	WebElement chkboxTerms;
	
	@FindBy(id="button-payment-method")
	WebElement btnContinuePaymentMethod;
	
	// Confirm Order
	@FindBy(xpath="//td[@class='text-right' and contains(text(),'$')]")
	WebElement lblTotalBeforeConfirm;
	
	@FindBy(id="button-confirm")
	WebElement btnConfOrder;
	
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement lblOrderConfirmation;
	
	// Actions
	public void setfirstName(String fname) {
		wait.until(ExpectedConditions.visibilityOf(txtFirstName)).clear();
		txtFirstName.sendKeys(fname);
	}
	
	public void setlastName(String lname) {
		wait.until(ExpectedConditions.visibilityOf(txtLastName)).clear();
		txtLastName.sendKeys(lname);
	}
	
	public void setaddress1(String address1) {
		wait.until(ExpectedConditions.visibilityOf(txtAddress1)).clear();
		txtAddress1.sendKeys(address1);
	}
	
	public void setaddress2(String address2) {
		wait.until(ExpectedConditions.visibilityOf(txtAddress2)).clear();
		txtAddress2.sendKeys(address2);
	}
	
	public void setcity(String city) {
		wait.until(ExpectedConditions.visibilityOf(txtCity)).clear();
		txtCity.sendKeys(city);
	}
	
	public void setpin(String pin) {
		wait.until(ExpectedConditions.visibilityOf(txtPin)).clear();
		txtPin.sendKeys(pin);
	}
	
	public void setCountry(String country) {
		Select drp = new Select(wait.until(ExpectedConditions.elementToBeClickable(drpCountry)));
		drp.selectByVisibleText(country);
	}
	
	public void setState(String state) {
		Select drp = new Select(wait.until(ExpectedConditions.elementToBeClickable(drpState)));
		drp.selectByVisibleText(state);
	}
	
	public void clickOnContinueAfterBillingAddress() {
		wait.until(ExpectedConditions.elementToBeClickable(btnContinueBill)).click();
	}
	
	public void clickOnContinueAfterDeliveryAddress() {
		wait.until(ExpectedConditions.elementToBeClickable(btnContinueDeliveryAddr)).click();
	}
	
	public void setDeliveryMethodComment(String comment) {
		wait.until(ExpectedConditions.visibilityOf(txtDeliveryMethodComment)).clear();
		txtDeliveryMethodComment.sendKeys(comment);
	}
	
	public void clickOnContinueAfterDeliveryMethod() {
		wait.until(ExpectedConditions.elementToBeClickable(btnContinueDeliveryMethod)).click();
	}
	
	public void selectTermsAndConditions() {
		wait.until(ExpectedConditions.elementToBeClickable(chkboxTerms)).click();
	}
	
	public void clickOnContinueAfterPaymentMethod() {
		wait.until(ExpectedConditions.elementToBeClickable(btnContinuePaymentMethod)).click();
	}
	
	public String getTotalPriceBeforeConfOrder() {
		return wait.until(ExpectedConditions.visibilityOf(lblTotalBeforeConfirm)).getText();
	}
	
	public void clickOnConfirmOrder() {
		wait.until(ExpectedConditions.elementToBeClickable(btnConfOrder)).click();
	}
	
	public boolean isOrderPlaced() {
		try {
			return wait.until(ExpectedConditions.visibilityOf(lblOrderConfirmation))
					.getText().equals("Your order has been placed!");
		} catch (Exception e) {
			return false;
		}
	}
}