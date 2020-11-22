package com.securepay.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecurePayHomePage {

    WebDriver driver;
    WebDriverWait wait;

    public SecurePayHomePage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver,30);

    }

    @FindBy(xpath= "//a/span[text()='Contact us']")
    WebElement contactUSLink;

    public void clickContactUS() {

        wait.until(ExpectedConditions.visibilityOf(contactUSLink));
        contactUSLink.click();

    }



}
