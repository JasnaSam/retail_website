package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAffiliateAcctPage {

    WebDriver driver;

    public MyAffiliateAcctPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@name='agree']")
    WebElement chkbox_AboutUs;

    @FindBy(xpath = "//input[@id='input-company']")
    WebElement txt_Company;

    @FindBy(id="input-website")
    WebElement txt_website;

    @FindBy(id ="input-tax")
    WebElement txt_taxID;

    @FindBy(xpath = "//input[@value='cheque']")
    WebElement txt_cheque;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btn_Continue;

    @FindBy(id = "input-cheque")
    WebElement txt_PayeeName;

    @FindBy(xpath = "//input[@value='bank']")
    WebElement radio_BankTransfer;

    @FindBy(id = "input-bank-name")
    WebElement txt_BankName;

    @FindBy(id="input-bank-branch-number")
    WebElement txt_abaNumber;

    @FindBy(id="input-bank-swift-code")
    WebElement txt_swiftCode;

    @FindBy(id="input-bank-account-name")
    WebElement txt_bankAcctName;

    @FindBy(id="input-bank-account-number")
    WebElement txt_bankAcctNumber;

    public void clickAboutUs()
    {
        chkbox_AboutUs.click();
    }

    public void clickContinue()
    {
        btn_Continue.click();
    }

    public void setCompany(String company)
    {
        txt_Company.sendKeys(company);
    }

    public void setWebsite(String website)
    {
        txt_website.sendKeys(website);
    }

    public void setTaxID(String taxID)
    {
        txt_taxID.sendKeys(taxID);
    }

    public void setCheque(String paymentMethod)
    {
        txt_cheque.isSelected();
    }

    public void setPayeeName()
    {
        txt_PayeeName.sendKeys("Jasna");
    }

    public void selectBankTransfer()
    {
        radio_BankTransfer.click();
    }

    public void setBankName(String bankName)
    {
        txt_BankName.clear();
        txt_BankName.sendKeys(bankName);
    }

    public void setabaNumber(String abaNumber)
    {
        txt_abaNumber.clear();
        txt_abaNumber.sendKeys(abaNumber);
    }

    public void setSwiftCode(String swiftCode)
    {
        txt_swiftCode.clear();
        txt_swiftCode.sendKeys(swiftCode);
    }

    public void setBankAcctName(String accountName)
    {
        txt_bankAcctName.clear();
        txt_bankAcctName.sendKeys(accountName);
    }

    public void setBankAcctNumber(String accountNumber)
    {
        txt_bankAcctNumber.clear();
        txt_bankAcctNumber.sendKeys(accountNumber);
    }


}
