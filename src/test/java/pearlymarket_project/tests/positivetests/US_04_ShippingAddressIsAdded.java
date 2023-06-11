

package src.test.java.pearlymarket_project.tests.positivetests;


import org.testng.annotations.Test;

import src.test.java.pearlymarket_project.pages.PearlyMarketHomePage;
import src.test.java.pearlymarket_project.pages.PearlyMarketShippingAddressPage;
import src.test.java.pearlymarket_project.pages.PearlyMarketSignInPage;
import src.test.java.pearlymarket_project.utilities.ConfigReader;
import src.test.java.pearlymarket_project.utilities.Driver;

import src.test.java.pearlymarket_project.pages.*;
import src.test.java.pearlymarket_project.utilities.ConfigReader;
import src.test.java.pearlymarket_project.utilities.Driver;
import src.test.java.pearlymarket_project.utilities.ExtentReportUtils;

import src.test.java.pearlymarket_project.utilities.WaitUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class US_04_ShippingAddressIsAdded {

    @Test

    public void shippingAddressIsAdded() throws InterruptedException, IOException {


        ExtentReportUtils.pass("Test Starts");

        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();

        PearlyMarketSignInPage pearlyMarketSignInPage = new PearlyMarketSignInPage();
        PearlyMarketShippingAddressPage pearlyMarketShippingAddressPage = new PearlyMarketShippingAddressPage();
        WaitUtils waitUtils = new WaitUtils();

        // Go to website
        ExtentReportUtils.pass("Going to the URL..."+ConfigReader.getProperty("pearlyMarketHomePage"));
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));
        // Click on sign in
        ExtentReportUtils.pass("Clicking sign in...");
        pearlyMarketHomePage.signInHome.click();
        WaitUtils.waitFor(2);
        // Enter username or email
        ExtentReportUtils.pass("Entering username");
        pearlyMarketSignInPage.usernameOrEmail.sendKeys(ConfigReader.getProperty("hakan_email"));
        WaitUtils.waitFor(2);
        // Enter password
        ExtentReportUtils.pass("Entering password");
        pearlyMarketSignInPage.password.sendKeys(ConfigReader.getProperty("hakan_password"));
        WaitUtils.waitFor(2);
        //Click on sign-in
        ExtentReportUtils.pass("Clicking sign in...");
        pearlyMarketSignInPage.signIn.click();
        WaitUtils.waitFor(2);
        //Click on Sign out
        ExtentReportUtils.pass("Clicking sign out");
        pearlyMarketShippingAddressPage.signOut.click();
        WaitUtils.waitFor(2);
        //Click on Addresses button
        ExtentReportUtils.pass("Clicking on Addresses Button...");
        pearlyMarketShippingAddressPage.addressesButton.click();
        WaitUtils.waitFor(2);
        //Click on Edit Shipping Address Button
        ExtentReportUtils.pass("Clicking on Edit Shipping Address Button...");
        pearlyMarketShippingAddressPage.editShippingAddressButton.click();
        WaitUtils.waitFor(2);
        //Enter Shipping first name
        pearlyMarketShippingAddressPage.shippingFirstName.clear();
        ExtentReportUtils.pass("Entering Shipping First Name...");
        pearlyMarketShippingAddressPage.shippingFirstName.sendKeys("Jurgen");
        WaitUtils.waitFor(2);
        //Enter Shipping last name
        pearlyMarketShippingAddressPage.shippingLastName.clear();
        ExtentReportUtils.pass("Entering Shipping Last Name...");
        pearlyMarketShippingAddressPage.shippingLastName.sendKeys("Gianluca");
        WaitUtils.waitFor(2);
        //Enter Shipping Company Name
        pearlyMarketShippingAddressPage.shippingCompanyName.clear();
        ExtentReportUtils.pass("Entering Shipping Company Name...");
        pearlyMarketShippingAddressPage.shippingCompanyName.sendKeys("Nokia");
        WaitUtils.waitFor(2);
        //Click Shipping Country/Region
        ExtentReportUtils.pass("Clicking Shipping Country/Region...");
        pearlyMarketShippingAddressPage.shippingCountryRegion.click();
        WaitUtils.waitFor(2);
        //Click Country Mexico
        ExtentReportUtils.pass("Clicking Country Mexico");
        pearlyMarketShippingAddressPage.countryMexico.click();
        WaitUtils.waitFor(2);
        //Enter Shipping Street Address
        pearlyMarketShippingAddressPage.shippingStreetAddress.clear();
        ExtentReportUtils.pass("Entering Shipping Street Address...");
        pearlyMarketShippingAddressPage.shippingStreetAddress.sendKeys("Mexicana Street");
        WaitUtils.waitFor(2);
        //Enter Shipping Street Address line 2
        pearlyMarketShippingAddressPage.shippingStreetAddressLine2.clear();
        ExtentReportUtils.pass("Entering Shipping Street Address Line 2...");
        pearlyMarketShippingAddressPage.shippingStreetAddressLine2.sendKeys("Unit 5");
        WaitUtils.waitFor(2);
        //Enter Shipping Town/City
        pearlyMarketShippingAddressPage.shippingTownCity.clear();
        ExtentReportUtils.pass("Entering shipping Town/City...");
        pearlyMarketShippingAddressPage.shippingTownCity.sendKeys("New Mexico");
        WaitUtils.waitFor(2);
        //Click Shipping State
        ExtentReportUtils.pass("Clicking Shipping State");
        pearlyMarketShippingAddressPage.shippingState.click();
        WaitUtils.waitFor(2);
        //Click Shipping State Veracruz
        ExtentReportUtils.pass("Clicking Shipping State Veracruz");
        pearlyMarketShippingAddressPage.shippingStateVeracruz.click();
        WaitUtils.waitFor(2);
        //Enter Shipping Postcode
        pearlyMarketShippingAddressPage.shippingPostcode.clear();
        ExtentReportUtils.pass("Entering Shipping Postcode...");
        pearlyMarketShippingAddressPage.shippingPostcode.sendKeys("91700");
        WaitUtils.waitFor(2);
        //Take Screenshot - Shipping address is entered
        ExtentReportUtils.passAndCaptureScreenShot("Shipping Address is entered");
        //Click Save Address Button
        ExtentReportUtils.pass("Shipping address is saved");
        pearlyMarketShippingAddressPage.saveShippingAddressButton.submit();
        WaitUtils.waitFor(2);

        ExtentReportUtils.flush();
        Driver.closeDriver();
    }
}
