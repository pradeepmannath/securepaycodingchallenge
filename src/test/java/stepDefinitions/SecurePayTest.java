package stepDefinitions;

import com.securepay.testdata.ContactDetails;
import com.securepay.webpages.GooglePage;
import com.securepay.webpages.GoogleSearchResultsPage;
import com.securepay.webpages.SecurePayContactUsPage;
import com.securepay.webpages.SecurePayHomePage;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigFileReader;

import java.util.concurrent.TimeUnit;

public class SecurePayTest {

    public WebDriver driver = null;
    ConfigFileReader configFileReader;
    GooglePage googlePage;
    GoogleSearchResultsPage resultsPage;
    SecurePayHomePage securePayHomePage;
    SecurePayContactUsPage securePayContactUsPage;
    ContactDetails contactDetails;

    @Before
    public void browserSetUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }


    @Given("^User is on Google Search page$")
    public void navigateToGoogle(){

        configFileReader= new ConfigFileReader();
        driver.get(configFileReader.getApplicationUrl());

    }

    @When("^User searches for (.*) on Google$")
    public void searchSecurePay(String SecurePay) {

        googlePage = PageFactory.initElements(driver,GooglePage.class);
        googlePage.enterSecurePay(SecurePay);

    }

    @And("^User clicks on SecurePay website from the search results to navigate to SecurePay$")
    public void navigateSecurePay()  {

        resultsPage = PageFactory.initElements(driver,GoogleSearchResultsPage.class);
        resultsPage.selectSecurePay();

    }

    @And("^User navigates to Contact Us page in the SecurePay website$")
    public void clickContactUs() {

        securePayHomePage = PageFactory.initElements(driver,SecurePayHomePage.class);
        securePayHomePage.clickContactUS();


    }

    @Then("^User fills the Contact Us form with the random data generated using a library$")
    public void enterContactInfo() {

        securePayContactUsPage = PageFactory.initElements(driver,SecurePayContactUsPage.class);
        securePayContactUsPage.verifyContactUSPage();
        contactDetails = new ContactDetails();
        securePayContactUsPage.contactDetails(contactDetails.firstName(),contactDetails.lastName(),contactDetails.email(),contactDetails.phone(),contactDetails.cName(),contactDetails.url(),contactDetails.enqMessage(),contactDetails.drpDwnBusinessAmt());

    }

    @After
    public void tearDown() {

        driver.close();
        driver.quit();

    }

}