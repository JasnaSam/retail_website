package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HPLP3065Page {

    WebDriver driver;

    public HPLP3065Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-quantity")
    WebElement txt_quantity;

    @FindBy(id = "button-cart")
    WebElement btn_AddtoCart;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement msg_success;

    @FindBy(linkText = "HP LP3065")
    WebElement txt_title;

    public void setTxt_quantity(String quantity) {
        txt_quantity.clear();
        txt_quantity.sendKeys(quantity);
       // System.out.println(txt_title.getText());

    }

    public void clickAddtoCart() {
        btn_AddtoCart.click();
    }

    public String checkSuccessMessage() {
        try {
            msg_success.isDisplayed();
            return msg_success.getText();
        } catch (Exception e) {
            return "invalid";
        }
    }

            public int getValue()
            {
                //System.out.println(txt_title.getText());
               return 1;

            }


    }

