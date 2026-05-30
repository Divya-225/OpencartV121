package pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{


    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//span[normalize-space()='My Account']")
    WebElement lnkMyaccount;

    @FindBy(xpath="//a[normalize-space()='Register']")
    WebElement lnkRegister;
    
    @FindBy(xpath="//a[normalize-space()='Login']")
    WebElement lnkLogin;
    
    @FindBy(xpath="//input[@placeholder='Search']")
    WebElement lnkSearch ;
    
    @FindBy(xpath="//button[@class='btn btn-default btn-lg']")
    WebElement lnkClickSearch ;


    public void clickMyAccount()
    {
        lnkMyaccount.click();
    }

    public void clickRegister()
    {
        lnkRegister.click();
    }
    
    public void clickLogin()
    {
        lnkLogin.click();
    }
    
    public void enterProductName(String Product) {
    	lnkSearch.sendKeys(Product);	
    }
    
    public void clickSearch() {
    	lnkClickSearch.click();
    }
}
