package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[normalize-space()='Desktops']")
    WebElement lnk_desktop;

    @FindBy(xpath="//a[normalize-space()='Show All Desktops']")
    WebElement lnk_seeAllDesktop;

    @FindBy(xpath="//a[normalize-space()='Laptops & Notebooks']")
    WebElement lnk_LaptopNotebooks;

    @FindBy(xpath="//a[normalize-space()='Show All Laptops & Notebooks']")
    WebElement lnk_shwAllLaptopNotebooks;

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement lnk_myAccount;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
    WebElement lnk_Login;

    @FindBy(xpath = "//span[normalize-space()='Currency']")
    WebElement drp_Currency;

    @FindBy(xpath = "//button[contains(text(),'€ Euro')]")
    WebElement drp_Euro;

    @FindBy(xpath = "//strong[contains(text(),'€')]")
    WebElement txt_Euro;

    @FindBy(xpath = "//a[@title='Shopping Cart']")
    WebElement link_ShoppingCart;

    public void clickDesktop()
    {
        lnk_desktop.click();
    }

    public void clickSeeAllDesktops()
    {
        lnk_seeAllDesktop.click();
    }

    public void clickLaptopNotebooks()
    {
        lnk_LaptopNotebooks.click();
    }

    public void click_ShowAllLaptopsNotebooks()
    {
        lnk_shwAllLaptopNotebooks.click();
    }

    public void clickMyAccount()
    {
        lnk_myAccount.click();
    }

    public void clickLogin()
    {
        lnk_Login.click();
    }

    public void clickCurrency()
    {
        drp_Currency.click();
    }

    public void clickEuro()
    {
        drp_Euro.click();
    }

    public boolean checkEuro()
    {
        try {
            Thread.sleep(5000);
            System.out.println(txt_Euro.getText());
            return txt_Euro.isDisplayed();
        }
        catch (Exception e)
        {
            return(false);
        }
    }

    public void clickShoppingCart()
    {
        link_ShoppingCart.click();
    }


}
