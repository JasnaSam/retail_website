package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.management.remote.rmi._RMIConnection_Stub;

public class DesktopsPage {

    WebDriver driver;

    public DesktopsPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//h2[normalize-space()='Desktops']")
    WebElement title_Desktop;

    @FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[3]/div[1]/div[2]/div[2]/button[1]")
    WebElement btn_DesktopAddtoCart;

    @FindBy(xpath="//div[@id='product-category']//div[2]//div[1]//div[2]//div[2]//button[1]//span[1]")
    WebElement btn_CanonAddtoCart;

    @FindBy(xpath = "//a[normalize-space()='Canon EOS 5D Camera']")
    WebElement link_CanonEOSCamera;



    public boolean checkDesktop()
    {
        try
        {
            return (title_Desktop.isDisplayed());
        }
        catch(Exception e)
        {
            return(false);
        }
    }
    public void clickdesktopAddtoCart()
    {
        btn_DesktopAddtoCart.click();

    }

    public void clickCanonAddtoCart()
    {
        btn_CanonAddtoCart.click();
    }

    public void clickCanonEOSCamera()
    {
        link_CanonEOSCamera.click();
    }



}
