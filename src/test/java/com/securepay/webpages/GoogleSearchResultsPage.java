package com.securepay.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GoogleSearchResultsPage {
    WebDriver driver;

    public GoogleSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//h3/span[text()='SecurePay | Trusted Online Payment Gateway Provider in ...']")
    WebElement searchResultsList;

    public void selectSecurePay() {

        searchResultsList.click();

    }

}
