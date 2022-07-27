package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountInfoPage {

    WebDriver driver;

    public MyAccountInfoPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="input-firstname")
    WebElement txt_firstname;

    @FindBy(id="input-lastname")
    WebElement txt_lastname;

    @FindBy(id="input-email")
    WebElement txt_email;

    @FindBy(id="input-telephone")
    WebElement txt_telephone;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btn_Continue;

    public void setFirstname(String firstname)
    {
        txt_firstname.clear();
        txt_firstname.sendKeys(firstname);
    }

    public void setLastname(String lastName)
    {
        txt_lastname.clear();
        txt_lastname.sendKeys(lastName);
    }

    public void setEmail(String email)
    {
        txt_email.clear();
        txt_email.sendKeys(email);
    }

    public void setTxt_telephone(String telephone)
    {
        txt_telephone.clear();
        txt_telephone.sendKeys(telephone);
    }

    public void clickContinue()
    {
        btn_Continue.click();
    }

    public int getMyAccountInfoValue()
    {
        return 1;
    }

}
