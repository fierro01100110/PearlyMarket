package pearlymarket_project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pearlymarket_project.pages.PearlyMarketHomePage;
import pearlymarket_project.pages.PearlyMarketSignInPage;
import pearlymarket_project.pages.PearlyMarketVendorMyAccountPage;
import pearlymarket_project.utilities.ConfigReader;
import pearlymarket_project.utilities.Driver;

public class US_11_SignInAsVendorTest {

    @Test
    public void signInAsVendor() throws InterruptedException {

        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketSignInPage pearlyMarketSignInPage = new PearlyMarketSignInPage();
        PearlyMarketVendorMyAccountPage pearlyMarketVendorMyAccountPage = new PearlyMarketVendorMyAccountPage();

        // Go to URL
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));

        // Click on sign in link
        pearlyMarketHomePage.signInHome.click();

        // User enters Vendor email
        pearlyMarketSignInPage.usernameOrEmail.sendKeys(ConfigReader.getProperty("feyza_email"));

        // User enters Vendor password
        pearlyMarketSignInPage.password.sendKeys(ConfigReader.getProperty("feyza_vendor_password"));
        Thread.sleep(2000);

        // Click on sign in
        pearlyMarketSignInPage.signIn.click();
        Thread.sleep(2000);

        // Click on sign out to see "My Account"
        pearlyMarketVendorMyAccountPage.signOut.click();

        // Assert "My Account" is displayed
        Assert.assertTrue(pearlyMarketVendorMyAccountPage.myAccount.isDisplayed());
        System.out.println("My Account is visible");

        // Store Manager is visible in Dashboard
        //verifyElementDisplayed(By.xpath("//a[text()='Store Manager']"));
        Assert.assertTrue(pearlyMarketVendorMyAccountPage.storeManager.isDisplayed());

        // Orders is visible in Dashboard
        Assert.assertTrue(pearlyMarketVendorMyAccountPage.orders.isDisplayed());

        // Downloads is visible in Dashboard
        Assert.assertTrue(pearlyMarketVendorMyAccountPage.downloads.isDisplayed());

        // Addresses is visible in Dashboard
        Assert.assertTrue(pearlyMarketVendorMyAccountPage.addresses.isDisplayed());

        // Account details is visible in Dashboard
        Assert.assertTrue(pearlyMarketVendorMyAccountPage.accountDetails.isDisplayed());

        // Wishlist is visible in Dashboard
        Assert.assertTrue(pearlyMarketVendorMyAccountPage.wishlist.isDisplayed());

        // Support tickets is visible in Dashboard
        Assert.assertTrue(pearlyMarketVendorMyAccountPage.supportTickets.isDisplayed());

        // Followings is visible in Dashboard
        Assert.assertTrue(pearlyMarketVendorMyAccountPage.followings.isDisplayed());

        // Log out is visible in Dashboard
        Assert.assertTrue(pearlyMarketVendorMyAccountPage.logout.isDisplayed());

        // Close Driver
        Driver.closeDriver();
    }
}
