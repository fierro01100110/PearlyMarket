package pearlymarket_project.tests;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import pearlymarket_project.pages.*;
import pearlymarket_project.utilities.ConfigReader;
import pearlymarket_project.utilities.Driver;
import pearlymarket_project.utilities.WaitUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static pearlymarket_project.utilities.WaitUtils.waitForClickablility;

public class US_04_ShippingAddressIsAdded {

    @Test

    public void shippingAddressIsAdded() throws InterruptedException, IOException {

        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketSignInPage pearlyMarketSignInPage = new PearlyMarketSignInPage();
        PearlyMarketShippingAddressPage pearlyMarketShippingAddressPage = new PearlyMarketShippingAddressPage();
        WaitUtils waitUtils = new WaitUtils();

        // Go to website
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));
        // Click on sign in
        pearlyMarketHomePage.signInHome.click();
        Thread.sleep(2000);
        // Enter username or email
        pearlyMarketSignInPage.usernameOrEmail.sendKeys(ConfigReader.getProperty("hakan_email"));
        Thread.sleep(2000);
        // Enter password
        pearlyMarketSignInPage.password.sendKeys(ConfigReader.getProperty("hakan_password"));
        Thread.sleep(2000);
        //Click on sign-in
        pearlyMarketSignInPage.signIn.click();
        Thread.sleep(2000);
        //Click on Sign out
        pearlyMarketShippingAddressPage.signOut.click();
        Thread.sleep(2000);
        //Click on Addresses button
        pearlyMarketShippingAddressPage.addressesButton.click();
        Thread.sleep(2000);
        //Click on Edit Shipping Address Arrow
        pearlyMarketShippingAddressPage.editShippingAddressButton.click();
        Thread.sleep(2000);

        //Enter Shipping first name
        pearlyMarketShippingAddressPage.shippingFirstName.clear();
        pearlyMarketShippingAddressPage.shippingFirstName.sendKeys("Jurgen");
        Thread.sleep(2000);
        //Enter Shipping last name
        pearlyMarketShippingAddressPage.shippingLastName.clear();
        pearlyMarketShippingAddressPage.shippingLastName.sendKeys("Gianluca");
        //Enter Shipping Company Name
        pearlyMarketShippingAddressPage.shippingCompanyName.clear();
        pearlyMarketShippingAddressPage.shippingCompanyName.sendKeys("Nokia");
        //Click Shipping Country/Region
        pearlyMarketShippingAddressPage.shippingCountryRegion.click();
        //Click Country Mexico
        pearlyMarketShippingAddressPage.countryMexico.click();
        //Enter Shipping Street Address
        pearlyMarketShippingAddressPage.shippingStreetAddress.clear();
        pearlyMarketShippingAddressPage.shippingStreetAddress.sendKeys("Mexicana Street");
        //Enter Shipping Street Address line 2
        pearlyMarketShippingAddressPage.shippingStreetAddressLine2.sendKeys("Unit 5");
        //Enter Shipping Town/City
        pearlyMarketShippingAddressPage.shippingTownCity.clear();
        pearlyMarketShippingAddressPage.shippingTownCity.sendKeys("New Mexico");
        //Click Shipping State
        pearlyMarketShippingAddressPage.shippingState.click();
        //Click Shipping State Veracruz
        pearlyMarketShippingAddressPage.shippingStateVeracruz.click();
        //Enter Shipping Postcode
        pearlyMarketShippingAddressPage.shippingPostcode.clear();
        pearlyMarketShippingAddressPage.shippingPostcode.sendKeys("91700");
        Thread.sleep(2000);
        //Take Screenshot
        File image = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//getting local date in this format
        //                     CURRENT PROJECT FOLDER         foldername   subfoldername imagename
        String path = System.getProperty("user.dir")+"/test-output/Reports/Screenshots/"+now+"image.png";
        //        3. Save the image in the path as a file
        FileUtils.copyFile(image,new File(path));
        //Click Save Address Button
        pearlyMarketShippingAddressPage.saveShippingAddressButton.submit();
        Thread.sleep(2000);

        Driver.closeDriver();
























    }
}
