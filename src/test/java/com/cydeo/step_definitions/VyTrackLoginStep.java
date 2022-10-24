package com.cydeo.step_definitions;

import com.cydeo.pages.VyTrackDashboardPage;
import com.cydeo.pages.VyTrackLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VyTrackLoginStep {

    VyTrackLoginPage vyTrackLoginPage = new VyTrackLoginPage();
    VyTrackDashboardPage vyTrackDashboardPage = new VyTrackDashboardPage();


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackUrl"));

    }

    @When("user enters driver credentials")
    public void user_enters_driver_credentials() throws IOException {
        String path = "Task_1_Credentials.xlsx";//We copyied the address of our excel file by using  "copy path/reference"
        // and "path from repository root". We showed the address of our excel file to the class.
        FileInputStream fIS = new FileInputStream(path);//We reached to excel file by using "FileInputStream"
        XSSFWorkbook workbook = new XSSFWorkbook(fIS);// We get the file
        XSSFSheet sheet = workbook.getSheet("Sayfa1");//We reached to the sheet we are looking for.
        String username = sheet.getRow(0).getCell(0).toString();//We get information from the first row first cell
        String password = sheet.getRow(0).getCell(1).toString();// We get information from first row second cell
        vyTrackLoginPage.userNameField.sendKeys(username);
        vyTrackLoginPage.passwordField.sendKeys(password);
        vyTrackLoginPage.loginBtn.click();
    }

    @Then("user should see below navigations")
    public void user_should_see_below_navigations(List<String> menuOptions) {
        List<String> actualOpt = new ArrayList<>();

        for (WebElement menu : vyTrackDashboardPage.menus) {
            actualOpt.add(menu.getText());
        }

        Assert.assertEquals(menuOptions, actualOpt);
    }

    @When("user enters {string} information")
    public void user_enters_information(String string) throws IOException {
        String path = "Task_1_Credentials.xlsx";//We copyied the address of our excel file by using  "copy path/reference"
        // and "path from repository root". We showed the address of our excel file to the class.
        FileInputStream fIS = new FileInputStream(path);//We reached to excel file by using "FileInputStream"
        XSSFWorkbook workbook = new XSSFWorkbook(fIS);// We get the file
        XSSFSheet sheet = workbook.getSheet("Sayfa1");//We reached to the sheet we are looking for.

        String username = "";
        String password = "";

        switch (string) {
            case "Sales":
                username = sheet.getRow(10).getCell(0).toString();//We get information from the seventh row first cell
                password = sheet.getRow(10).getCell(1).toString();// We get information from seventh row second cell


            case "Store":
                username = sheet.getRow(6).getCell(0).toString();//We get information from the seventh row first cell
                password = sheet.getRow(6).getCell(1).toString();// We get information from seventh row second cell

        }
        vyTrackLoginPage.userNameField.sendKeys(username);
        vyTrackLoginPage.passwordField.sendKeys(password);
        vyTrackLoginPage.loginBtn.click();

    }

    @Then("user should see manager navigation options")
    public void user_should_see_manager_navigation_options(List<String> expectedOptions) {
        List<String> actualOptions = new ArrayList<>();
        BrowserUtils.sleep(10);

        for (WebElement menu : vyTrackDashboardPage.menus) {
            actualOptions.add(menu.getText());
        }
        Assert.assertEquals(expectedOptions, actualOptions);
    }

}
