


package src.test.java.pearlymarket_project.tests.positivetests;



import org.testng.annotations.Test;
import src.test.java.pearlymarket_project.pages.PearlyMarketHomePage;
import src.test.java.pearlymarket_project.pages.PearlyMarketMyAccountPage;
import src.test.java.pearlymarket_project.utilities.*;

import java.io.IOException;



public class US_12_VendorBillingAddress {

    @Test
    public void addingBillingAddress_TestCase001() throws Exception {

        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketMyAccountPage pearlyMarketMyAccountPage = new PearlyMarketMyAccountPage();

        ExtentReportUtils.info("Starting test ...");

        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));
        ExtentReportUtils.pass("Going to Homepage: "+ConfigReader.getProperty("orange_app_url"));

//        1. User clicks "Sign In" button
        pearlyMarketHomePage.SignIn.click();
        ExtentReportUtils.pass("Vendor clicked enter");

//        2. User enters Vendor email
        ReusableMethod.sendKeysWithTimeout(pearlyMarketHomePage.vendorUserName, ConfigReader.getProperty("vendor_email"), 1);
        ExtentReportUtils.pass("Vendor entered valid email");

//        3. User enters Vendor password
        ReusableMethod.sendKeysWithTimeout(pearlyMarketHomePage.vendorPassword, ConfigReader.getProperty("vendor_password"), 1);
        ExtentReportUtils.pass("Vendor entered valid password");

//        4. User clicks "sign in" button
        pearlyMarketHomePage.signInButton.click();
        ExtentReportUtils.passAndCaptureScreenShot("Vendor signed in the homepage");

//        5. My Account is visible
        JSUtils.scrollAllTheWayDownJS();
        ReusableMethod.getTextWithTimeout(pearlyMarketHomePage.myAccount, 3);
        ExtentReportUtils.pass("Scrolled down and found the my Account");

//        6- Navigate to the "My Account" section and click
        WaitUtils.waitFor(3);
        pearlyMarketHomePage.myAccount.click();
        ExtentReportUtils.passAndCaptureScreenShot("Vendor clicked on My Account");

//        7- Click on the "Addresses" tab.   (pearlyMarket MyAccount Page)
        ReusableMethod.clickWithTimeOut(pearlyMarketMyAccountPage.addresses, 2);
        ExtentReportUtils.passAndCaptureScreenShot("Vendor clicked on Addresses");
    }

    @Test
    public void addingBillingAddress_TestCase002() throws IOException {
        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketMyAccountPage pearlyMarketMyAccountPage = new PearlyMarketMyAccountPage();

        //        8- Locate the "Billing Address" section.
        ReusableMethod.verifyElementDisplayed(pearlyMarketMyAccountPage.billingAddress);
        ExtentReportUtils.pass("Vendor located on Billing Address");

//        9- Click on the "Add " button.
        ReusableMethod.clickWithTimeOut(pearlyMarketMyAccountPage.add, 2);
       ExtentReportUtils.passAndCaptureScreenShot("Vendor clicked on add button");

//        10- Fill in the required fields with valid data for the new billing address:
        //Enter First Name
        ReusableMethod.sendKeysWithTimeout(pearlyMarketMyAccountPage.firstName, ConfigReader.getProperty("billing_address_firstname"), 2);
        ExtentReportUtils.pass("Vendor entered firstname");

        //Enter Last Name
        ReusableMethod.sendKeysWithTimeout(pearlyMarketMyAccountPage.lastName, ConfigReader.getProperty("billing_address_lastname"), 2);
        ExtentReportUtils.pass("Vendor entered lastname");

        //Enter Country/Region
        ReusableMethod.clickWithTimeOut(pearlyMarketMyAccountPage.countryRegionField, 2);
        ReusableMethod.selectDropdownByValue(pearlyMarketMyAccountPage.Canada, "Canada");
        pearlyMarketMyAccountPage.Canada.click();
        ExtentReportUtils.pass("Vendor dropped down till Canada and clicked");

        //Enter Street Address
        ReusableMethod.sendKeysWithTimeout(pearlyMarketMyAccountPage.streetAddress, ConfigReader.getProperty("billing_street/address"), 5);
        ExtentReportUtils.pass("Vendor entered street Address");

        //Enter Town/City
        ReusableMethod.sendKeysWithTimeout(pearlyMarketMyAccountPage.townCity, ConfigReader.getProperty("billing_town/city"), 5);
        ExtentReportUtils.pass("Vendor entered Town/City");

        //Enter Province
        ReusableMethod.clickWithTimeOut(pearlyMarketMyAccountPage.province, 2);
        ReusableMethod.selectDropdownByValue(pearlyMarketMyAccountPage.province, "Alberta");
        pearlyMarketMyAccountPage.Alberta.click();
        ExtentReportUtils.pass("Vendor dropped down till Alberta and clicked");

        //Enter State-Zip Code
        ReusableMethod.sendKeysWithTimeout(pearlyMarketMyAccountPage.postalCode, ConfigReader.getProperty("billing_postal_code"), 5);
        ExtentReportUtils.pass("Vendor entered Postal Code");

        //Enter Phone Number
        ReusableMethod.sendKeysWithTimeout(pearlyMarketMyAccountPage.phone, ConfigReader.getProperty("billing_phone"), 5);
        ExtentReportUtils.pass("Vendor entered phone");


    }

    @Test
    public void addingBillingAddress_TestCase003() throws IOException {
        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketMyAccountPage pearlyMarketMyAccountPage = new PearlyMarketMyAccountPage();

        //Verify the registered email address filled in automatically.
        ReusableMethod.verifyElementDisplayed(pearlyMarketMyAccountPage.confirmedEmail);
        ExtentReportUtils.passAndCaptureScreenShot("Vendor's registered email displayed");

        ExtentReportUtils.flush();

//       11- Click on the "Save Address" button.
        ReusableMethod.clickWithTimeOut(pearlyMarketMyAccountPage.saveAddressButton,2);
        ExtentReportUtils.passAndCaptureScreenShot("Vendor Billing address is saved");
    }

    @Test
    public void addingBillingAddress_TestCase004() throws IOException {
        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketMyAccountPage pearlyMarketMyAccountPage = new PearlyMarketMyAccountPage();

//       12- Verify that the new billing address is successfully added and displayed in the "Billing Address" section.
        ReusableMethod.verifyElementDisplayed(pearlyMarketMyAccountPage.address_added);
        ExtentReportUtils.passAndCaptureScreenShot("Displayed Billing address saved successfully");

        Driver.closeDriver();
    }
}

