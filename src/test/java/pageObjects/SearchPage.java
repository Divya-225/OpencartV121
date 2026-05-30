package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement txtQuantity;

    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement btnAddToCart;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement cnfMsg;


    
    public boolean isProductExist(String productName) {
        try {
            WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
            mywait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(productName)));
            return driver.findElement(By.linkText(productName)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void selectProduct(String productName) {
        driver.findElement(By.linkText(productName)).click();
    }

    public void setQuantity(String qty) {
        txtQuantity.clear();
        txtQuantity.sendKeys(qty);
    }

    public void addToCart() {
        btnAddToCart.click();
    }

    public boolean checkConfMsg() {
        try {
            WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
            mywait.until(ExpectedConditions.visibilityOf(cnfMsg));
            return cnfMsg.getText().contains("Success: You have added");
        } catch (Exception e) {
            return false;
        }
    }
}