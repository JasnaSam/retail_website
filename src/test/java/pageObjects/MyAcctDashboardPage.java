package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAcctDashboardPage {

    WebDriver driver;

    public MyAcctDashboardPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//h2[normalize-space()='My Account']")
    WebElement txt_heading;

    @FindBy(xpath = "//a[normalize-space()='Register for an affiliate account']")
    WebElement lnk_RegisterAffiliateAcct;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement txt_AffiliateRegisterSuccessMsg;

    @FindBy(xpath = "//a[normalize-space()='Edit your affiliate information']")
    WebElement link_editAffiliateInfo;

    @FindBy(xpath = "//a[normalize-space()='Edit your account information']")
    WebElement link_EditAcctInfo;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement txt_EditAcctInfoSuccessMsg;

    public boolean chkDashboardHeading()
    {
        try{
            return(txt_heading.isDisplayed());
        }
        catch (Exception e)
        {
            return(false);
        }
    }

    public void clickRegisterAffiliateAcct()
    {
        lnk_RegisterAffiliateAcct.click();
    }

    public boolean chkAffiliateSuccessMsg()
    {
        try
        {
            return (txt_AffiliateRegisterSuccessMsg.isDisplayed());
        }
        catch (Exception e)
        {
            return(false);
        }
    }

    public void clickEditAffiliateInfo()
    {
        link_editAffiliateInfo.click();
    }

    public void clickEditAcctInfo()
    {
        link_EditAcctInfo.click();
    }

    public boolean chkSuccessMessage()
    {
        try{
            return txt_EditAcctInfoSuccessMsg.isDisplayed();
        }
        catch (Exception e)
        {
            return(false);
        }
    }


}
