package src.test.java.pearlymarket_project.tests.positivetests;

import org.testng.annotations.Test;
import src.test.java.pearlymarket_project.pages.PearlyMarketHomePage;
import src.test.java.pearlymarket_project.pages.PearlyMarketSignInPage;
import src.test.java.pearlymarket_project.pages.PearlyMarketVendorMyAccountPage;
import src.test.java.pearlymarket_project.utilities.*;

import java.io.IOException;


public class US_11_SignInAsVendorTest {

    @Test
    public void signInAsVendor() throws InterruptedException, IOException {

        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketSignInPage pearlyMarketSignInPage = new PearlyMarketSignInPage();
        PearlyMarketVendorMyAccountPage pearlyMarketVendorMyAccountPage = new PearlyMarketVendorMyAccountPage();

        // Go to URL
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));

        // Click on sign in link
        pearlyMarketHomePage.signInHome.click();

        // User enters Vendor email
        //pearlyMarketSignInPage.usernameOrEmail.sendKeys(ConfigReader.getProperty("feyza_email"));
        ReusableMethod.sendKeysWithTimeout(pearlyMarketSignInPage.usernameOrEmail, ConfigReader.getProperty("feyza_email"), 1);

        // User enters password
        //pearlyMarketSignInPage.password.sendKeys(ConfigReader.getProperty("feyza_vendor_password"));
        ReusableMethod.sendKeysWithTimeout(pearlyMarketSignInPage.password, ConfigReader.getProperty("feyza_vendor_password"), 1);

        // Click on sign in
         pearlyMarketSignInPage.signIn.click();
         WaitUtils.waitFor(2);


        // Click on sign out to see "My Account
        pearlyMarketVendorMyAccountPage.signOut.click();
        WaitUtils.waitFor(2);

        // Assert "My Account" is displayed
        JSUtils.scrollAllTheWayDownJS();
        //Assert.assertTrue(pearlyMarketVendorMyAccountPage.myAccount.isDisplayed());
        ReusableMethod.getTextWithTimeout(pearlyMarketVendorMyAccountPage.myAccount, 3);

        // Store Manager is visible in Dashboard
        //verifyElementDisplayed(By.xpath("//a[text()='Store Manager']"));
        //Assert.assertTrue(pearlyMarketVendorMyAccountPage.storeManager.isDisplayed());
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorMyAccountPage.storeManager);
        MediaUtils.takeScreenshotOfTheEntirePage();

        // Orders is visible in Dashboard
        //Assert.assertTrue(pearlyMarketVendorMyAccountPage.orders.isDisplayed());
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorMyAccountPage.orders);
        MediaUtils.takeScreenshotOfTheEntirePage();

        // Downloads is visible in Dashboard
        //Assert.assertTrue(pearlyMarketVendorMyAccountPage.downloads.isDisplayed());
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorMyAccountPage.downloads);
        MediaUtils.takeScreenshotOfTheEntirePage();

        // Addresses is visible in Dashboard
        //Assert.assertTrue(pearlyMarketVendorMyAccountPage.addresses.isDisplayed());
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorMyAccountPage.addresses);
        MediaUtils.takeScreenshotOfTheEntirePage();

        // Account details is visible in Dashboard
        //Assert.assertTrue(pearlyMarketVendorMyAccountPage.accountDetails.isDisplayed());
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorMyAccountPage.accountDetails);
        MediaUtils.takeScreenshotOfTheEntirePage();

        // Wishlist is visible in Dashboard
        //Assert.assertTrue(pearlyMarketVendorMyAccountPage.wishlist.isDisplayed());
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorMyAccountPage.wishlist);
        MediaUtils.takeScreenshotOfTheEntirePage();

        // Support tickets is visible in Dashboard
        //Assert.assertTrue(pearlyMarketVendorMyAccountPage.supportTickets.isDisplayed());
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorMyAccountPage.supportTickets);
        MediaUtils.takeScreenshotOfTheEntirePage();

        // Followings is visible in Dashboard
        //Assert.assertTrue(pearlyMarketVendorMyAccountPage.followings.isDisplayed());
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorMyAccountPage.followings);
        MediaUtils.takeScreenshotOfTheEntirePage();

        // Log out is visible in Dashboard
        //Assert.assertTrue(pearlyMarketVendorMyAccountPage.logout.isDisplayed());
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorMyAccountPage.logout);
        MediaUtils.takeScreenshotOfTheEntirePage();

        // Close Driver
        Driver.closeDriver();


    }
}
