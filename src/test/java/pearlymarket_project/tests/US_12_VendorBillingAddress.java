package pearlymarket_project.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pearlymarket_project.pages.PearlyMarketHomePage;
import pearlymarket_project.pages.PearlyMarketMyAccountPage;
import pearlymarket_project.utilities.*;

import static org.testng.AssertJUnit.assertTrue;

public class US_12_VendorBillingAddress {

    @Test
    public void addingBillingAddressTest() throws Exception {
        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketMyAccountPage pearlyMarketMyAccountPage = new PearlyMarketMyAccountPage();

        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));

//        1. User clicks "Sign In" button
        pearlyMarketHomePage.SignIn.click();
//        2. User enters Vendor email
        ReusableMethod.sendKeysWithTimeout(pearlyMarketHomePage.vendorUserName, ConfigReader.getProperty("vendor_email"), 1);
//        3. User enters Vendor password
        ReusableMethod.sendKeysWithTimeout(pearlyMarketHomePage.vendorPassword, ConfigReader.getProperty("vendor_password"), 1);
//        4. User clicks "sign in" button
        MediaUtils.takeScreenshotOfTheEntirePage();
        pearlyMarketHomePage.signInButton.click();
//        5. My Account is visible
        JSUtils.scrollAllTheWayDownJS();
        ReusableMethod.getTextWithTimeout(pearlyMarketHomePage.myAccount, 3);
//        6- Navigate to the "My Account" section and click
        WaitUtils.waitFor(3);
        pearlyMarketHomePage.myAccount.click();
        MediaUtils.takeScreenshotOfTheEntirePage();


//        7- Click on the "Addresses" tab.   (pearlyMarket MyAccount Page)
        ReusableMethod.clickWithTimeOut(pearlyMarketMyAccountPage.addresses, 2);
        MediaUtils.takeScreenshotOfTheEntirePage();
//        8- Locate the "Billing Address" section.
        ReusableMethod.verifyElementDisplayed(pearlyMarketMyAccountPage.billingAddress);
//        9- Click on the "Add " button.
        ReusableMethod.clickWithTimeOut(pearlyMarketMyAccountPage.add, 2);
        MediaUtils.takeScreenshotOfTheEntirePage();
//        10- Fill in the required fields with valid data for the new billing address:
        //Enter First Name
        ReusableMethod.sendKeysWithTimeout(pearlyMarketMyAccountPage.firstName, ConfigReader.getProperty("billing_address_firstname"), 2);
        //Enter Last Name
        ReusableMethod.sendKeysWithTimeout(pearlyMarketMyAccountPage.lastName, ConfigReader.getProperty("billing_address_lastname"), 2);
        //Enter Country/Region
        ReusableMethod.clickWithTimeOut(pearlyMarketMyAccountPage.countryRegionField, 2);
        ReusableMethod.selectDropdownByValue(pearlyMarketMyAccountPage.Canada, "Canada");
        pearlyMarketMyAccountPage.Canada.click();
        //Enter Street Address
        ReusableMethod.sendKeysWithTimeout(pearlyMarketMyAccountPage.streetAddress, ConfigReader.getProperty("billing_street/address"), 5);
        //Enter Town/City
        ReusableMethod.sendKeysWithTimeout(pearlyMarketMyAccountPage.townCity, ConfigReader.getProperty("billing_town/city"), 5);
        //Enter Province
        ReusableMethod.clickWithTimeOut(pearlyMarketMyAccountPage.province, 2);
        ReusableMethod.selectDropdownByValue(pearlyMarketMyAccountPage.province, "Alberta");
        pearlyMarketMyAccountPage.Alberta.click();
        //Enter State-Zip Code
        ReusableMethod.sendKeysWithTimeout(pearlyMarketMyAccountPage.postalCode, ConfigReader.getProperty("billing_postal_code"), 5);
        //Enter Phone Number
        ReusableMethod.sendKeysWithTimeout(pearlyMarketMyAccountPage.phone, ConfigReader.getProperty("billing_phone"), 5);
        //Verify the registered email address filled in automatically.
        ReusableMethod.verifyElementDisplayed(pearlyMarketMyAccountPage.confirmedEmail);
        MediaUtils.takeScreenshotOfTheEntirePage();
//       11- Click on the "Save Address" button.
        //ReusableMethod.clickWithTimeOut(pearlyMarketMyAccountPage.saveAddressButton,2);
//       12- Verify that the new billing address is successfully added and displayed in the "Billing Address" section.
        ReusableMethod.verifyElementDisplayed(pearlyMarketMyAccountPage.address_added);
        MediaUtils.takeScreenshotOfTheEntirePage();

       // Driver.closeDriver();

    }
}

