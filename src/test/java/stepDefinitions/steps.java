package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.SeleniumServerStandaloneManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;


public class steps {

    WebDriver driver;
    HomePage hp;
    DesktopsPage dp;
    HPLP3065Page hplp;
    CanonEOS5D canon;
    LaptopNotebookPage lnp;
    MacbookPage mbp;
    ProductComparisonPage pcp;
    MacBookProPage mbpp;
    LoginPage lp;
    MyAcctDashboardPage madp;
    MyAffiliateAcctPage maap;
    MyAccountInfoPage maip;
    ShoppingCart sc;
    ResourceBundle rb; // for reading properties file
    String br; //to store browser name
   // Logger logger;

    @Before
    public void setup()
    {
       // logger = LogManager.getLogger(this.getClass());

        //Reading config.properties (for browser)
        rb=ResourceBundle.getBundle("config");
        br=rb.getString("browser");
    }


    @Given("User is on Retail website")
    public void user_is_on_retail_website() {
       WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

       /* if(br.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if (br.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (br.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }*/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://tek-school.com/retail/");
        driver.manage().window().maximize();

    }
    @When("User click on Desktops tab")
    public void user_click_on_desktops_tab() {
        hp=new HomePage(driver);
        hp.clickDesktop();
        //logger.info("Clicked on desktops tab");

    }
    @When("User click on Show all desktops")
    public void user_click_on_show_all_desktops() {
        hp=new HomePage(driver);
        hp.clickSeeAllDesktops();
      //  logger.info("Clicked on Show all Desktops tab");

    }

    @Then("User should see all items are present in Desktop page")
    public void user_should_see_all_items_are_present_in_desktop_page() {
        dp = new DesktopsPage(driver);
        boolean desktopsPage = dp.checkDesktop();
        driver.close();

        if(desktopsPage) {
         //   logger.info("Can see all the items in the desktop page");
            Assert.assertTrue(true);
        }
        else {
          //  logger.error("Cannot see all the items in the desktop page");
            Assert.assertTrue(false);
        }

    }

    @When("User click  ADD TO CART option on HP LP3065 item")
    public void user_click_add_to_cart_option_on_item() {
        dp = new DesktopsPage(driver);
        dp.clickdesktopAddtoCart();
        //logger.info("Clicked Add to Cart on HP LP3065");

    }
    @When("User select quantity {int}")
    public void user_select_quantity(int qty) {
        hplp = new HPLP3065Page(driver);
        canon = new CanonEOS5D(driver);

        String value1 = Integer.toString(qty);
        int hpvalue = hplp.getValue();
        int canonvalue = canon.getCanonValue();

       if(hpvalue == 1) {
            hplp.setTxt_quantity(value1);
         //   logger.info("Selected quantity for HP LP3065");
        }
        else if (canonvalue == 2)
           canon.setCanonTxt_quantity(value1);
          //  logger.info("Selected quantity for Canon");
        }

    @When("User click add to Cart button")
    public void user_click_add_to_cart_button() {

            hplp = new HPLP3065Page(driver);
            mbp = new MacbookPage(driver);

            int hpvalue = hplp.getValue();
            int lnpvalue = mbp.getLaptopNotebookValue();

            if(hpvalue == 1) {
                hplp.clickAddtoCart();
              //  logger.info("Clicked Add to Cart for HP LP3065");
            }
            else if (lnpvalue == 1) {
                mbp.clickAddToCart_LaptopNotebooks();
             //   logger.info("Clicked Add to Cart for Laptops and Notebooks");
            }


    }
    @Then("User should see a message ‘Success: you have added HP LP {int} to your Shopping cart!’")
    public void user_should_see_a_message_success_you_have_added_hp_lp_to_your_shopping_cart(Integer version) {
        hplp = new HPLP3065Page(driver);

        String value2 = Integer.toString(version);
        String expectedSuccessMessage= "Success: You have added HP LP"+value2+" to your shopping cart!\n" +
                "×";
        String value3 = hplp.checkSuccessMessage();
        System.out.println(value3);

       // driver.close();

        if(value3.equals(expectedSuccessMessage)) {
            Assert.assertTrue(true);
         //   logger.info("Success Message is Displayed for HP LP3065");
        }
        else {
            Assert.assertTrue(false);
          //  logger.error("Success Message is Not Displayed for HP LP3065");
        }

    }

    @When("User click  ADD TO CART option on ‘Canon EOS 5D’ item")
    public void user_click_add_to_cart_option_on_canon_eos_5d_item() {
        dp = new DesktopsPage(driver);
        dp.clickCanonAddtoCart();
      //  logger.info("Click Add to Cart for Canon EOS 5D");
    }

    @When("User select color from dropdown ‘Red’")
    public void user_select_color_from_dropdown_red() {
        canon = new CanonEOS5D(driver);
        canon.selectColor();
       // logger.info("Selected Red color");
    }

    @Then("User should see a message ‘Success: You have added Canon EOS 5D to your shopping cart!’")
    public void user_should_see_a_message_success_you_have_added_canon_eos_5d_to_your_shopping_cart() {
        canon = new CanonEOS5D(driver);
        String target = canon.checkSucessMessage();
        String actualText = "Success: You have added Canon EOS 5D Camera to your shopping cart!\n" +
                "×";
        System.out.println(target);
        //driver.close();
        if(target.equals(actualText)) {
         //   logger.info("Success Message is displayed for Canon EOS 5D");
            Assert.assertTrue(true);
        }

        else {
           // logger.error("Success Message is Not displayed for Canon EOS 5D");
            Assert.assertTrue(false);
        }
    }

    @When("User click on Canon EOS 5D item")
    public void user_click_on_canon_eos_5d_item() {
       dp = new DesktopsPage(driver);
       dp.clickCanonEOSCamera();
      //  logger.info("Clicked Canon EOS 5D");

    }
    @When("User click on write a review link")
    public void user_click_on_write_a_review_link() {
        canon = new CanonEOS5D(driver);
        canon.clickWriteAReview();
      //  logger.info("Clicked on Write a Review Canon EOS 5D");
       
    }
    @When("user fill the review information with {string}, {string} and {string}")
    public void user_fill_the_review_information_with_and(String name, String review, String rating) {
        canon = new CanonEOS5D(driver);
        canon.setTxt_Name(name);
      //  logger.info("Provided Name");
        canon.setTxt_Review(review);
      //  logger.info("Provided review");
        canon.clickRating(rating);
      //  logger.info("Provided rating");

    }
    @When("User click on Continue Button")
    public void user_click_on_continue_button() {
        canon = new CanonEOS5D(driver);
        canon.clickSubmitReview();
        //  logger.info("Clicked on Submit Review");

    }
    @Then("User should see a message with ‘Thank you for your review. It has been submitted to the webmaster for approval.”")
    public void user_should_see_a_message_with_thank_you_for_your_review_it_has_been_submitted_to_the_webmaster_for_approval() {
        canon = new CanonEOS5D(driver);
        String reviewText = canon.checkReviewMessage();
        driver.close();
        if(reviewText.equals("Thank you for your review. It has been submitted to the webmaster for approval.")) {
           // logger.info("Sucess message for submitting review");
            Assert.assertTrue(true);
        }
        else {
           // logger.error("Unable to submit a review");
            Assert.assertTrue(false);
        }

    }

    // Laptop and Notebooks

    @When("User click on Laptop &NoteBook tab")
    public void user_click_on_laptop_note_book_tab() {
        hp = new HomePage(driver);
        hp.clickLaptopNotebooks();
      //  logger.info("Clicked on Laptop & Notebooks tab");

    }
    @When("User click on Show all Laptop &NoteBook option")
    public void user_click_on_show_all_laptop_note_book_option() {
        hp = new HomePage(driver);
        hp.click_ShowAllLaptopsNotebooks();
       // logger.info("Clicked on Show all laptop and notebooks tab");

    }
    @When("User click on MacBook  item")
    public void user_click_on_mac_book_item() {
        lnp = new LaptopNotebookPage(driver);
        lnp.clickMacbook();
      //  logger.info("Clicked on Macbook Item");

    }
    @Then("User should see a message ‘Success: You have added MacBook to your shopping cart!’")
    public void user_should_see_a_message_success_you_have_added_mac_book_to_your_shopping_cart() {
        mbp = new MacbookPage(driver);
        String expectedTextMessage = "Success: You have added MacBook to your shopping cart!\n" +
                "×";
        String actualTextMessage = mbp.chkSuccessAddtoCartMessage();

        if(actualTextMessage.equals(expectedTextMessage))
        {
        //    logger.info("Success Message for Addintg Macbook to Cart");
            Assert.assertTrue(true);
        }
        else
        {
         //  logger.error("Unable to Add Macbook to Cart");
            Assert.assertTrue(false);
        }

    }
    @Then("User should see ‘{int} tem\\(s) {double}’ showed to the cart")
    public void user_should_see_tem_s_showed_to_the_cart(Integer num, Double price) {
        mbp = new MacbookPage(driver);
        String expectedItemText = num+" item(s) - $"+price+"0";
        String actualItemText = mbp.chkItemsInTheCart();

        if(actualItemText.equals(expectedItemText))
        {
        //    logger.info("Matched item Quantity and Prices ");
            Assert.assertTrue(true);
        }

        else
        {
          //  logger.error("Mismatched Item quanity and price");
            Assert.assertTrue(false);
        }


    }
    @Then("User click on cart option")
    public void user_click_on_cart_option() {
        mbp = new MacbookPage(driver);
        mbp.clickOnItem();
      //  logger.info("Clicked on Cart option");

    }
    @Then("user click on red X button to remove the item from cart")
    public void user_click_on_red_x_button_to_remove_the_item_from_cart() throws InterruptedException {
        mbp = new MacbookPage(driver);
        mbp.clickRedX();
        Thread.sleep(5000);
      //  logger.info("Clicked on Red x button");

    }
    @Then("item should be removed and cart should show ‘{int} item\\(s)’")
    public void item_should_be_removed_and_cart_should_show_item_s(Integer qty) {
        mbp = new MacbookPage(driver);
        String expectedItemNumber = qty+" item(s)";
        String getItemNumber = mbp.chkItemQuantityInCart();
        String actualItemNumber = getItemNumber.substring(0,9);

        if(actualItemNumber.equals(expectedItemNumber)) {
        //    logger.info("Item quantity Shows 0 after removing item from the cart");
            Assert.assertTrue(true);
        }
        else {
        //    logger.info("Item quantity Doesn't show 0 after removing item from the cart");
            Assert.assertTrue(false);
        }

    }

    @When("User click on product comparison icon on ‘MacBook’")
    public void user_click_on_product_comparison_icon_on_mac_book() {
        lnp = new LaptopNotebookPage(driver);
        lnp.clickCompareMackook();

    }
    @When("User click on product comparison icon on ‘MacBook Air")
    public void user_click_on_product_comparison_icon_on_mac_book_air() {
        lnp = new LaptopNotebookPage(driver);
        lnp.clickCompareMacbookAir();

    }
    @Then("User should see a message ‘Success: You have added MacBook Air to your product comparison!’")
    public void user_should_see_a_message_success_you_have_added_mac_book_air_to_your_product_comparison() throws InterruptedException {
        lnp = new LaptopNotebookPage(driver);
        String actualMacbookAirMsg = "Success: You have added MacBook Air to your product comparison!\n" +
                "×";
        String expectedMacbookAirMsg = lnp.chkMacbookAirSuccessMessage();

        System.out.println(expectedMacbookAirMsg);

        if(expectedMacbookAirMsg.equals(actualMacbookAirMsg))
            Assert.assertTrue(true);
        else Assert.assertTrue(false);


    }
    @Then("User click on Product comparison link")
    public void user_click_on_product_comparison_link() {
        lnp = new LaptopNotebookPage(driver);
        lnp.clickProductCompare();

    }

    @Then("User should see Product Comparison Chart")
    public void user_should_see_product_comparison_chart() {
        pcp = new ProductComparisonPage(driver);
        boolean pageDisplayed = pcp.getProductComparison();
        System.out.println(pageDisplayed);

        if(pageDisplayed)
            Assert.assertTrue(true);

        else Assert.assertTrue(false);

    }

    @When("User click on heart icon to add ‘Sony VaIO’ laptop to wish list")
    public void user_click_on_heart_icon_to_add_sony_va_io_laptop_to_wish_list() {
        lnp = new LaptopNotebookPage(driver);
        lnp.clickSonyHeartIcon();
    }
    @Then("User should get a message ‘You must login or create an account to save Sony VAIO to your wish list!’")
    public void user_should_get_a_message_you_must_login_or_create_an_account_to_save_sony_vaio_to_your_wish_list() {
        lnp = new LaptopNotebookPage(driver);

        String expectedWishListMsg = "You must login or create an account to save Sony VAIO to your wish list!\n" +
                "×";
        String actualWishListMsg = lnp.getSonyWishListMessage();

        System.out.println(actualWishListMsg);

        if(actualWishListMsg.equals(expectedWishListMsg))
            Assert.assertTrue(true);
        else Assert.assertTrue(false);

    }

    @When("User click on ‘MacBook Pro’ item")
    public void user_click_on_mac_book_pro_item() {
        lnp = new LaptopNotebookPage(driver);
        lnp.clickMacbookPro();

    }
    @Then("User should see  ‘${double}’ price tag is present on UI.")
    public void user_should_see_$_price_tag_is_present_on_ui(Double double1) {
        mbpp = new MacBookProPage(driver);

        Boolean actualPrice = mbpp.getMacBookProPrice();

        if(actualPrice)
            Assert.assertTrue(true);
        else Assert.assertTrue(false);
    }

    @Given("User click  on MyAccount")
    public void user_click_on_my_account() {
        hp = new HomePage(driver);
        hp.clickMyAccount();

    }
    @When("User click on Login")
    public void user_click_on_login() {
        hp = new HomePage(driver);
        hp.clickLogin();

    }
    @When("User enter username ‘userName’ and password 'password’")
    public void user_enter_username_user_name_and_password_password() {
        lp = new LoginPage(driver);
        lp.setEmail();
        lp.setPassword();
    }
    @When("User click on Login button")
    public void user_click_on_login_button() {
        lp=new LoginPage(driver);
        lp.clickLogin();

    }
    @Then("User should be logged in to MyAccount dashboard")
    public void user_should_be_logged_in_to_my_account_dashboard() {
        madp = new MyAcctDashboardPage(driver);
        boolean headingtxt = madp.chkDashboardHeading();

        if(headingtxt)
            Assert.assertTrue(true);
        else
            Assert.assertTrue(false);

    }
    @When("User click on ‘Register for an Affiliate Account’ link")
    public void user_click_on_register_for_an_affiliate_account_link() {
        madp=new MyAcctDashboardPage(driver);
        madp.clickRegisterAffiliateAcct();

    }
    @When("User fill affiliate form with below information")
    public <list> void user_fill_affiliate_form_with_below_information(DataTable dataTable) {
        maap = new MyAffiliateAcctPage(driver);
        List<Map<String, String>> inputs = dataTable.asMaps(String.class, String.class);
		maap.setCompany(inputs.get(0).get("company"));
        maap.setWebsite(inputs.get(0).get("website"));
        maap.setTaxID(inputs.get(0).get("taxID"));
        maap.setCheque(inputs.get(0).get("paymentMethod"));
        maap.setPayeeName();

	try {
			Thread.sleep(3000);
	} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // these all run in the same step for just one test case
        // i need to put them in the scenario outline to run for five times i guess
    }

    @When("User check on About us check box")
    public void user_check_on_about_us_check_box() {
        maap = new MyAffiliateAcctPage(driver);
        maap.clickAboutUs();
    }

    @When("User click on Continue Button on the page")
    public void user_click_on_continue_button_on_the_page() {
        maap = new MyAffiliateAcctPage(driver);
        maap.clickContinue();
    }

    @Then("User should see a success message")
    public void user_should_see_a_success_message() {
        madp = new MyAcctDashboardPage(driver);

        boolean AffiliateSuccessMsg = madp.chkAffiliateSuccessMsg();
        if(AffiliateSuccessMsg)
            Assert.assertTrue(true);
        else
            Assert.assertTrue(false);
    }

    @When("User click on ‘Edit your affiliate informationlink")
    public void user_click_on_edit_your_affiliate_informationlink() {
        madp = new MyAcctDashboardPage(driver);
        madp.clickEditAffiliateInfo();
    }
    @When("user click on Bank Transfer radio button")
    public void user_click_on_bank_transfer_radio_button() {
        maap = new MyAffiliateAcctPage(driver);
        maap.selectBankTransfer();
    }
    @When("User fill Bank information with below information")
    public void user_fill_bank_information_with_below_information(io.cucumber.datatable.DataTable dataTable) {

        maap = new MyAffiliateAcctPage(driver);
        List<Map<String, String>> inputs = dataTable.asMaps(String.class, String.class);
        maap.setBankName(inputs.get(0).get("bankName"));
        maap.setabaNumber(inputs.get(0).get("abaNumber"));
        maap.setSwiftCode(inputs.get(0).get("swiftCode"));
        maap.setBankAcctName(inputs.get(0).get("accountName"));
        maap.setBankAcctNumber(inputs.get(0).get("accountNumber"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    @When("User click on ‘Edit your account information’ link")
    public void user_click_on_edit_your_account_information_link() {
        madp = new MyAcctDashboardPage(driver);
        madp.clickEditAcctInfo();
    }
    @When("User modify below information")
    public void user_modify_below_information(io.cucumber.datatable.DataTable dataTable) {
        maip = new MyAccountInfoPage(driver);
        List<Map<String, String>> inputs = dataTable.asMaps(String.class, String.class);
        maip.setFirstname(inputs.get(0).get("firstname"));
        maip.setLastname(inputs.get(0).get("lastName"));
        maip.setEmail(inputs.get(0).get("email"));
        maip.setTxt_telephone(inputs.get(0).get("telephone"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @When("User click on continue button after updation")
    public void user_click_on_continue_button_after_updation() {
        maip = new MyAccountInfoPage(driver);
        maip.clickContinue();
        }

    @Then("User should see a message ‘Success: Your account has been successfully updated.’")
    public void user_should_see_a_message_success_your_account_has_been_successfully_updated() {
      madp = new MyAcctDashboardPage(driver);
      boolean successmessage = madp.chkSuccessMessage();

      if (successmessage)
      {
          Assert.assertTrue(true);
      }
      else Assert.assertTrue(false);
    }

    @When("User click on Currency")
    public void user_click_on_currency() {
        hp = new HomePage(driver);
        hp.clickCurrency();
    }
    @When("User Chose Euro from dropdown")
    public void user_chose_euro_from_dropdown() {
        hp = new HomePage(driver);
        hp.clickEuro();
    }
    @Then("currency value should change to Euro")
    public void currency_value_should_change_to_euro() {
        hp = new HomePage(driver);
        boolean valuetoEuro = hp.checkEuro();
        if (valuetoEuro)
            Assert.assertTrue(true);
        else Assert.assertTrue(false);
    }

    @When("User click on shopping cart")
    public void user_click_on_shopping_cart() {
        hp = new HomePage(driver);
        hp.clickShoppingCart();
    }
    @Then("“Your shopping cart is empty!” message should display")
    public void your_shopping_cart_is_empty_message_should_display() {
        sc = new ShoppingCart(driver);
        boolean shoppingcartmessage = sc.chkShoppingCart();
        if(shoppingcartmessage)
            Assert.assertTrue(true);
        else Assert.assertTrue(false);
    }


}
