package pearlymarket_project.tests;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pearlymarket_project.pages.PearlyMarketHomePage;
import pearlymarket_project.pages.PearlyMarketRegisterPage;
import pearlymarket_project.pages.PearlyMarketSignInPage;
import pearlymarket_project.pages.PearlyMarketVendorRegistrationPage;
import pearlymarket_project.utilities.ConfigReader;
import pearlymarket_project.utilities.Driver;

public class US_04_ShippingAddressIsAdded {

    @Test

    public void shippingAddressIsAdded() throws InterruptedException {

        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketSignInPage pearlyMarketSignInPage = new PearlyMarketSignInPage();
        PearlyMarketRegisterPage pearlyMarketRegisterPage = new PearlyMarketRegisterPage();
        PearlyMarketVendorRegistrationPage pearlyMarketVendorRegistrationPage = new PearlyMarketVendorRegistrationPage();

        // Go to website
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));
        // Click on sign in
        pearlyMarketHomePage.signInHome.click();
        // Enter username or email
        pearlyMarketSignInPage.usernameOrEmail.sendKeys(ConfigReader.getProperty("hakan_email"));
        Thread.sleep(2000);
        // Enter password
        pearlyMarketSignInPage.password.sendKeys(ConfigReader.getProperty("hakan_password"));
        Thread.sleep(2000);
        //Click on sign-in
        pearlyMarketSignInPage.signIn.click();








    }
}
