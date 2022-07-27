package pageObjects;

import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LaptopNotebookPage {
    WebDriver driver;

    public LaptopNotebookPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='MacBook']")
    WebElement lnk_Macbook;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[1]/div[2]/div[2]/button[3]")
    WebElement btn_CompareMacbook;

    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/div[4]/div[3]/div[1]/div[2]/div[2]/button[3]")
    WebElement btn_CompareMacbookAir;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement txt_MacbookAirSuccessMessage;

    @FindBy(id="compare-total")
    WebElement lnk_ProductCompare;

    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/div[4]/div[5]/div[1]/div[2]/div[2]/button[2]")
    WebElement btn_SonyHeartIcon;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement txt_SonyWishListMsg;

    @FindBy(xpath = "//a[normalize-space()='MacBook Pro']")
    WebElement lnk_MacbookPro;

    public void clickMacbook() {
        lnk_Macbook.click();
    }

    public void clickCompareMackook()
    {
        btn_CompareMacbook.click();
    }

    public void clickCompareMacbookAir()
    {
        btn_CompareMacbookAir.click();
    }

    public String chkMacbookAirSuccessMessage()
    {
        try {
            Thread.sleep(5000);
            return (txt_MacbookAirSuccessMessage.getText());
        }
        catch (Exception e){
            return "false";}
    }

    public void clickProductCompare()
    {
        lnk_ProductCompare.click();
    }

    public void clickSonyHeartIcon()
    {
        btn_SonyHeartIcon.click();
    }

    public String getSonyWishListMessage()
    {
        try {
            return (txt_SonyWishListMsg.getText());
        }
        catch (Exception e)
        {
            return "false";
        }
    }

    public void clickMacbookPro()
    {
        lnk_MacbookPro.click();
    }



}

