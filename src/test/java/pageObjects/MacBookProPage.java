package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MacBookProPage {

    WebDriver driver;

    public MacBookProPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h2[normalize-space()='$2,000.00']")
    WebElement txt_MacBookProPrice;

    public boolean getMacBookProPrice()
    {
        try {
            return (txt_MacBookProPrice.isDisplayed());
        }
        catch (Exception e) {
            return(false);
        }
    }
}
