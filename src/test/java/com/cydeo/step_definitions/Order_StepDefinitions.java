package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.OrderPage;
import com.cydeo.pages.ViewAllOrdersPage;
import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class Order_StepDefinitions {
    WebTableLoginPage loginPage = new WebTableLoginPage();//It has to be on class level
    BasePage basePage = new BasePage();// We created BasePage object to call the methods.
    OrderPage orderPage = new OrderPage();//We are gone use the locations of webelements (isn select) so we create its object.
    ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();// We need to create object of  ViewAllOrdersPage class

    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("webTableUrl"));
        //calling our login method to log in to web table application
        loginPage.login();


        //clicking to order link to go to order page
        basePage.order.click();

    }

    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {

        Select select = new Select(orderPage.productDropdown);
        select.selectByVisibleText(string);

    }


    // @When("user enters quantity {string}")
    // public void user_enters_quantity(String string) {
    //    Select select=new Select(orderPage.inputQuantity);
    //    select.selectByVisibleText(string);    }

    @And("user enters quantity {int}")
    public void userEntersQuantity(int quantity) {

        //Accepting int argument and sending it using sendKeys method
        //Browser does not care what type we send, wheather it is integer or String.
        // Since sendKeys() method only accepts String value, we need to either concat with "" or
        // send String.valueOf(int);
        //sendKeys accept only String, in order to send int we;
        // a. Concatunate it with "" to change the type to String
        orderPage.inputQuantity.sendKeys(quantity + "");

        //We can clear everything from the field by using clear() method.
        orderPage.inputQuantity.clear();

        // If clear does not work, we can use back-space, to imitate BACK-SPACE button from keyboard to delete the field box
        orderPage.inputQuantity.sendKeys(Keys.BACK_SPACE);

        // b. hide the int in String and sent it.
        orderPage.inputQuantity.sendKeys(String.valueOf(quantity));
    }


    @When("user enters customer name {string}")
    public void user_enters_customer_name(String string) {
        orderPage.inputName.sendKeys(string);

    }

    @When("user enters street {string}")
    public void user_enters_street(String string) {
        orderPage.inputStreet.sendKeys(string);

    }

    @When("user enters city {string}")
    public void user_enters_city(String string) {
        orderPage.inputCity.sendKeys(string);
    }

    @When("user enters state {string}")
    public void user_enters_state(String string) {
        orderPage.inputState.sendKeys(string);
    }

    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
        orderPage.inputZip.sendKeys(string);
    }

    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String expectedCardType) {
        //This line will loop through and decide which radio button to click.
        BrowserUtils.clickRadioButton(orderPage.cardType, expectedCardType);
    }

    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {
        orderPage.cardnoInput.sendKeys(string);

    }

    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {
        orderPage.cardExpInput.sendKeys(string);

    }

    @When("user enters process order button")
    public void user_enters_process_order_button() {
        orderPage.processOrderBtn.click();

    }

    @Then("user should see {string} in the first row of the web table")
    public void user_should_see_in_the_first_row_of_the_web_table(String expectedViewAllOrdersPageText) {

        String actualViewAllOrdersPageText = viewAllOrdersPage.newCustomerCell.getText();

        System.out.println("viewAllOrdersPageText = " + actualViewAllOrdersPageText);

        Assert.assertEquals(expectedViewAllOrdersPageText,actualViewAllOrdersPageText);
    }


}
