package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CanonEOS5D {

    WebDriver driver;

    public CanonEOS5D(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "input-option226")
    WebElement dp_color;

    @FindBy(id="button-cart")
    WebElement btn_CanonCart;

    @FindBy(linkText = "Canon EOS 5D Camera")
    WebElement txt_Canontitle;

    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
    WebElement txt_CanonSucessmessage;

    @FindBy(id = "input-quantity")
    WebElement txt_Canonquantity;

    @FindBy(xpath="//a[normalize-space()='Write a review']")
    WebElement link_WriteAReview;

    @FindBy(id = "input-name")
    WebElement txt_Name;

    @FindBy(id = "input-review")
    WebElement txt_Review;

    @FindBy(xpath = "//div[4]//div[1]//input[1]")
    WebElement radio_badRating;

    @FindBy(xpath="//input[@value='5']")
    WebElement radio_goodRating;

    @FindBy(id="button-review")
    WebElement btn_SubmitReview;

    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
    WebElement txt_ReviewSuccessMessage;

    public void selectColor()
    {
        Select select = new Select(dp_color);
        select.selectByValue("15");
    }

    public void clickCanonCart()
    {
        btn_CanonCart.click();
    }

    public int getCanonValue()
    {
        return 2;

    }

    public String checkSucessMessage()
    {
        try {
            return txt_CanonSucessmessage.getText();
        }
        catch(Exception e)
        {
            return "invalid";
        }
    }

    public void setCanonTxt_quantity(String quantity) {
        txt_Canonquantity.clear();
        txt_Canonquantity.sendKeys(quantity);

    }

    public void clickWriteAReview()
    {
        link_WriteAReview.click();
    }

    public void setTxt_Name(String name)
    {
        txt_Name.sendKeys(name);
    }

    public void setTxt_Review(String review)
    {
        txt_Review.sendKeys(review);
    }

    public void clickRating(String rating)
    {
        switch(rating){
            case "bad":
                radio_badRating.click();
                break;
            case "good":
                radio_goodRating.click();
                break;

        }
    }

    public void clickSubmitReview()
    {
        btn_SubmitReview.click();
    }

    public String checkReviewMessage()
    {
        try
        {
            return txt_ReviewSuccessMessage.getText();
        }

        catch(Exception e)
        {
            return "invalid";
        }
    }

}
