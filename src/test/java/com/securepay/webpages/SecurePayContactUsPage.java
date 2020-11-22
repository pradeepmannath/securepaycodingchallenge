package com.securepay.webpages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecurePayContactUsPage {

    WebDriver driver;
    WebDriverWait wait;

    public SecurePayContactUsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,30);
    }

    @FindBy(name= "firstName")
    WebElement firstName;

    @FindBy(name = "lastName")
    WebElement lastName;

    @FindBy(name = "email")
    WebElement emailAddress;

    @FindBy(name = "phone")
    WebElement phoneNumber;

    @FindBy(name = "website")
    WebElement websiteURL;

    @FindBy(name = "company")
    WebElement businessName;

    @FindBy(xpath = "//label/textarea[@name='message']")
    WebElement enquiryMessage;

    @FindBy(xpath= "//div/h1")
    WebElement contactUSPageText;

    @FindBy(xpath= "//div/select[@name='amount']")
    WebElement drpdwnBusinessProcessAmt;

    @FindBy(xpath= "//input[@id='existingCustomer']")
    WebElement chkboxExistingCustomer;

    public void verifyContactUSPage() {

        wait.until(ExpectedConditions.visibilityOf(firstName));
        Assert.assertEquals("Contact our Sales Team",contactUSPageText.getText());
        System.out.println(driver.getTitle());

    }

    public void contactDetails(String fName,String lName,String eMail,String phNumber,String bName,String url,String enqMessage, String BusinessProcessAmt){

        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        emailAddress.sendKeys(eMail);
        phoneNumber.sendKeys(phNumber);
        businessName.sendKeys(bName);
        websiteURL.sendKeys(url);
        enquiryMessage.sendKeys(enqMessage);

        Select drpBusinessProcessAmt = new Select(drpdwnBusinessProcessAmt);
        drpBusinessProcessAmt.selectByVisibleText(BusinessProcessAmt);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", chkboxExistingCustomer);

    }


}
