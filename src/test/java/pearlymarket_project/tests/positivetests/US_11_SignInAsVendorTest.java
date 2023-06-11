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

        ExtentReportUtils.pass("Test start...");

        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketSignInPage pearlyMarketSignInPage = new PearlyMarketSignInPage();
        PearlyMarketVendorMyAccountPage pearlyMarketVendorMyAccountPage = new PearlyMarketVendorMyAccountPage();

        // Go to URL
        ExtentReportUtils.pass("Going to the url ..."+ConfigReader.getProperty("pearlymarket_home_page"));
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));

        // Click on sign in link
        ExtentReportUtils.pass("Clicking on sing in link...");
        pearlyMarketHomePage.signInHome.click();

        // User enters Vendor email
        //pearlyMarketSignInPage.usernameOrEmail.sendKeys(ConfigReader.getProperty("feyza_email"));
        ExtentReportUtils.pass("Entering email as Vendor... ");
        ReusableMethod.sendKeysWithTimeout(pearlyMarketSignInPage.usernameOrEmail, ConfigReader.getProperty("feyza_email"), 1);

        // User enters password
        //pearlyMarketSignInPage.password.sendKeys(ConfigReader.getProperty("feyza_vendor_password"));
        ExtentReportUtils.pass("Entering password as Vendor...");
        ReusableMethod.sendKeysWithTimeout(pearlyMarketSignInPage.password, ConfigReader.getProperty("feyza_vendor_password"), 1);

        ExtentReportUtils.passAndCaptureScreenShot("Credentials are entered...");

        // Click on sign in
        ExtentReportUtils.pass("Clicking sign in...");
        pearlyMarketSignInPage.signIn.click();
        WaitUtils.waitFor(2);


        // Click on sign out to see "My Account
        ExtentReportUtils.pass("Clicking sign out...");
        pearlyMarketVendorMyAccountPage.signOut.click();
        WaitUtils.waitFor(2);

        // Assert "My Account" is displayed
        JSUtils.scrollAllTheWayDownJS();
        //Assert.assertTrue(pearlyMarketVendorMyAccountPage.myAccount.isDisplayed());
        ExtentReportUtils.pass("Verifying the My account page...");
        ReusableMethod.getTextWithTimeout(pearlyMarketVendorMyAccountPage.myAccount, 3);

        // Store Manager is visible in Dashboard
        //verifyElementDisplayed(By.xpath("//a[text()='Store Manager']"));
        //Assert.assertTrue(pearlyMarketVendorMyAccountPage.storeManager.isDisplayed());
        ExtentReportUtils.pass("Verifying the Store Manager...");
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorMyAccountPage.storeManager);
        MediaUtils.takeScreenshotOfTheEntirePage();

        // Orders is visible in Dashboard
        //Assert.assertTrue(pearlyMarketVendorMyAccountPage.orders.isDisplayed());
        ExtentReportUtils.pass("Verifying the Orders...");
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorMyAccountPage.orders);
        MediaUtils.takeScreenshotOfTheEntirePage();

        // Downloads is visible in Dashboard
        //Assert.assertTrue(pearlyMarketVendorMyAccountPage.downloads.isDisplayed());
        ExtentReportUtils.pass("Verifying the downloads...");
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorMyAccountPage.downloads);
        MediaUtils.takeScreenshotOfTheEntirePage();

        // Addresses is visible in Dashboard
        //Assert.assertTrue(pearlyMarketVendorMyAccountPage.addresses.isDisplayed());
        ExtentReportUtils.pass("Verifying the Addresses...");
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorMyAccountPage.addresses);
        MediaUtils.takeScreenshotOfTheEntirePage();

        // Account details is visible in Dashboard
        //Assert.assertTrue(pearlyMarketVendorMyAccountPage.accountDetails.isDisplayed());
        ExtentReportUtils.pass("Verifying the Account details...");
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorMyAccountPage.accountDetails);
        MediaUtils.takeScreenshotOfTheEntirePage();

        // Wishlist is visible in Dashboard
        //Assert.assertTrue(pearlyMarketVendorMyAccountPage.wishlist.isDisplayed());
        ExtentReportUtils.pass("Verifying the Wishlist...");
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorMyAccountPage.wishlist);
        MediaUtils.takeScreenshotOfTheEntirePage();

        // Support tickets is visible in Dashboard
        //Assert.assertTrue(pearlyMarketVendorMyAccountPage.supportTickets.isDisplayed());
        ExtentReportUtils.pass("Verifying the Support tickets...");
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorMyAccountPage.supportTickets);
        MediaUtils.takeScreenshotOfTheEntirePage();

        // Followings is visible in Dashboard
        //Assert.assertTrue(pearlyMarketVendorMyAccountPage.followings.isDisplayed());
        ExtentReportUtils.pass("Verifying the Followings...");
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorMyAccountPage.followings);
        MediaUtils.takeScreenshotOfTheEntirePage();

        // Log out is visible in Dashboard
        //Assert.assertTrue(pearlyMarketVendorMyAccountPage.logout.isDisplayed());
        ExtentReportUtils.pass("Verifying the Log out..");
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorMyAccountPage.logout);
        MediaUtils.takeScreenshotOfTheEntirePage();

        ExtentReportUtils.passAndCaptureScreenShot("Test is complete...");

        // Close Driver
        ExtentReportUtils.flush();
        Driver.closeDriver();


    }
}
