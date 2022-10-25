package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage {

   public WebTableLoginPage(){
       PageFactory.initElements(Driver.getDriver(),this);
   }

   @FindBy(css = "input[name='username']")
   public WebElement inputUsername;

   @FindBy(css = "input[name='password']")
   public WebElement inputPassword;

   @FindBy(xpath = "//button[.='Login']")
   public WebElement loginButton;


   /**
    * no parameters
    * It will directly login when we call this method by using
    *
    * username: Test
    * pw: Tester
    */
   public void login(){

      this.inputUsername.sendKeys("Test");
      this.inputPassword.sendKeys("Tester");
      this.loginButton.click();


   }

   /**
    * This method will accept 2 arguments and login.
    * @param username
    * @param password
    */
   public void login(String username, String password){
      inputUsername.sendKeys(username);
      inputPassword.sendKeys(password);
      loginButton.click();

   }

   /**
    * This method will log in using credentials from configuration.properties
    */
   public void loginWithConfig(){
      inputUsername.sendKeys(ConfigurationReader.getProperty("webTableUsername"));
      inputPassword.sendKeys(ConfigurationReader.getProperty("webTablePw"));
      loginButton.click();
   }

}
