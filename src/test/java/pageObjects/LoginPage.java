package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="input-email")
    WebElement txt_email;

    @FindBy(id="input-password")
    WebElement txt_password;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement btn_Login;

    public void setEmail()
    {
        txt_email.sendKeys("acs@gmail.com");
    }

    public void setPassword()
    {
        txt_password.sendKeys("acs@123");
    }

    public void clickLogin()
    {
        btn_Login.click();
    }
}
