package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {
    WebDriver driver;

    public ShoppingCart(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]")
    WebElement msg_EmptyShoppingCart;

    public boolean chkShoppingCart()
    {
        try
        {
            return msg_EmptyShoppingCart.isDisplayed();
        }
        catch (Exception e)
        {
            return(false);
        }

    }
}
