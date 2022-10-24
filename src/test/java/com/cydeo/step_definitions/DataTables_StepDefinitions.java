package com.cydeo.step_definitions;

import com.cydeo.pages.DropdownsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DataTables_StepDefinitions {

    @Then("users should see fruits I like")
    public void users_should_see_fruits_ı_like(List<String> fruits) {

        System.out.println(fruits);
        //[kiwi, banana, cucumber, orange, mango, grape, pomegranate]

        System.out.println(fruits.get(1));
        //banana

    }

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");

    }


    DropdownsPage dropdownsPage=new DropdownsPage();
    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedMonths) {
        System.out.println(expectedMonths);
        /* Select select=new Select(dropdownsPage.monthDropdown);

        //List of all ACTUAL month <options> as a web element
        List<WebElement> actualOptionsAsWebElements= select.getOptions();

        //Create a list of string to pass all the actual web element options' srting into that list
        //List of all ACTUAL month <options> as a String
        List<String> actualOptionsAsString=new ArrayList<>();

        for (WebElement each : actualOptionsAsWebElements) {

            actualOptionsAsString.add(each.getText());

            // OR;

         */

        List<String> actualMonths=BrowserUtils.dropdownOptionsAsString(dropdownsPage.monthDropdown);
        Assert.assertEquals(expectedMonths,actualMonths);
        }

        //Assert will check the size of the two lists and if they are equal, then it'll check the content one by one.

    }


