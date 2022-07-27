package pageObjects;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MacbookPage {

    WebDriver driver;

    public MacbookPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="button-cart")
    WebElement btn_AddtoCart;

    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
    WebElement txt_SuccessMessage;

    @FindBy(xpath="//span[@id='cart-total']")
    WebElement btn_ItemsInTheCart;

    @FindBy(xpath = "//button[@title='Remove']")
    WebElement btn_RedX;

    public void clickAddToCart_LaptopNotebooks()
    {
        btn_AddtoCart.click();
    }

    public int getLaptopNotebookValue()
    {
        return 1;
    }

    public String chkSuccessAddtoCartMessage()
    {
        if(txt_SuccessMessage.isDisplayed())
            return txt_SuccessMessage.getText();
        else
            return "invalid";
    }

    public String chkItemsInTheCart()
    {
        try {
            return(btn_ItemsInTheCart.getText());

        }
        catch(Exception e) {
            return "false";
        }
    }

    public void clickOnItem()
    {
        btn_ItemsInTheCart.click();
    }

    public void clickRedX()
    {
        btn_RedX.click();
    }

    @After
    public String chkItemQuantityInCart()
    {

        try {
            return (btn_ItemsInTheCart.getText());
        } catch (Exception e) {
            return "false";
        }

    }


}

