package com.securepay.webpages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage {

    WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(name= "q")
    WebElement searchTextBox;

    public void enterSecurePay(String searchInput) {

        searchTextBox.sendKeys(searchInput);
        searchTextBox.sendKeys(Keys.ENTER);
    }


}

