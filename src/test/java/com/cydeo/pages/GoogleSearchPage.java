package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    public GoogleSearchPage(){
        //create a constructor
        // initialize driver instance and this class' instance by using PageFactory.initElements(Driver.getDriver(),this);
        PageFactory.initElements(Driver.getDriver(),this);
    }


    // We can locate the web elements by using @FindBy annotation

    @FindBy(name = "q")
    public WebElement searchBox;
}
