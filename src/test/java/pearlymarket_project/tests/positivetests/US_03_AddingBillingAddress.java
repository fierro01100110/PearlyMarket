package src.test.java.pearlymarket_project.tests.positivetests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import src.test.java.pearlymarket_project.pages.PearlyMarketAddressesPageB;
import src.test.java.pearlymarket_project.pages.PearlyMarketEditingBillingAddressPageB;
import src.test.java.pearlymarket_project.pages.PearlyMarketHomePageB;
import src.test.java.pearlymarket_project.pages.PearlyMarketMyAccountPageB;
import src.test.java.pearlymarket_project.utilities.*;

import java.io.IOException;

public class US_03_AddingBillingAddress {


    PearlyMarketHomePageB pearlyMarketHomePageB = new PearlyMarketHomePageB();
    PearlyMarketMyAccountPageB pearlyMarketMyAccountPageB = new PearlyMarketMyAccountPageB();
    PearlyMarketAddressesPageB pearlyMarketAddressesPageB = new PearlyMarketAddressesPageB();
    PearlyMarketEditingBillingAddressPageB pearlyMarketEditingBillingAddressPageB = new PearlyMarketEditingBillingAddressPageB();
     @Test
     public void addingBillingAddressTest_Tc_001() throws InterruptedException {

         ExtentReportUtils.info("Test Case 01");

//     User is on Home Page
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));


//     User signs in
        pearlyMarketHomePageB.signIn.click();
        pearlyMarketHomePageB.username.sendKeys("fin");
        pearlyMarketHomePageB.password.sendKeys("Ssppaarrooww");
        pearlyMarketHomePageB.rememberMeCheckBox.click();
        pearlyMarketHomePageB.signInButton.click();


//      My Account is visible
        JSUtils.scrollAllTheWayDownJS();
        ReusableMethod.getTextWithTimeout(pearlyMarketHomePageB.myAccount, 3);

//      User clicks on My Account
        WaitUtils.waitFor(3);
        pearlyMarketHomePageB.myAccount.click();

//      User clicks on Addresses icon
        pearlyMarketMyAccountPageB.addressesIcon.click();

//      User clicks on "ADD" under "Billing Address"
        pearlyMarketMyAccountPageB.addButton.click();

//      User enters "First name"
        pearlyMarketEditingBillingAddressPageB.firstName.sendKeys("Kendel");
        WaitUtils.waitFor(3);

//      User enters "Last name"
        pearlyMarketEditingBillingAddressPageB.lastName.sendKeys("Raphael");
        WaitUtils.waitFor(3);

//      User enters "Company Name"
        pearlyMarketEditingBillingAddressPageB.companyName.sendKeys("KR");
        WaitUtils.waitFor(3);

//      User selects "Country/Region"
        ReusableMethod.clickWithTimeOut(pearlyMarketEditingBillingAddressPageB.countryRegion, 2);
        ReusableMethod.selectDropdownByValue(pearlyMarketEditingBillingAddressPageB.countryRegion, "United States (US)");
        WaitUtils.waitFor(5);

//      User enters "Street address"
        pearlyMarketEditingBillingAddressPageB.streetAddress.sendKeys("777 Rainbow Road");
        WaitUtils.waitFor(3);

//      User enters "Town/City"
        pearlyMarketEditingBillingAddressPageB.townCity.sendKeys("Wonderland");
        WaitUtils.waitFor(5);

//        User enters "State"
        pearlyMarketEditingBillingAddressPageB.statesButton.click();
        for (WebElement w : pearlyMarketEditingBillingAddressPageB.allStates) {
            w.click();
        }
        WaitUtils.waitFor(3);

//        User enters "ZIP Code"
        pearlyMarketEditingBillingAddressPageB.zipCode.sendKeys("11123");
        WaitUtils.waitFor(3);

//        User enters "Phone Number"
        pearlyMarketEditingBillingAddressPageB.phone.sendKeys("555-222-432");
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("The billing address information is added successfully.");
        ExtentReportUtils.flush();
    }

        @Test
        public void addingBillingAddressTest_Tc_002() throws IOException {

            ExtentReportUtils.info("Test Case 02");

//         User verifies Auto-Fill of Registered Email Address

            ReusableMethod.verifyElementDisplayed(pearlyMarketEditingBillingAddressPageB.emailAddress);

            ExtentReportUtils.pass("The registered Email address is auto-filled.");
            ExtentReportUtils.flush();

        }


        @Test
        public void addingBillingAddressTest_Tc_003() throws IOException{

            ExtentReportUtils.info("Test Case 03");

//        User clicks on "Save Address".
         pearlyMarketEditingBillingAddressPageB.saveAddressButton.click();


//        User sees "Billing Address" is saved successfully" message.
           ReusableMethod.verifyElementDisplayed(pearlyMarketAddressesPageB.successAlert);

           ExtentReportUtils.pass("'Billing Address' is saved successfully");
           ExtentReportUtils.flush();

           Driver.closeDriver();
        }

}




























