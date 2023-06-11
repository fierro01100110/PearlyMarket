package pearlymarket_project.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import pearlymarket_project.pages.*;
import pearlymarket_project.utilities.*;

public class US_17_ShopAsAVendorTest {

    @Test
    public void vendorShoppingTest(){


        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketSignInPage pearlyMarketSignInPage = new PearlyMarketSignInPage();
        PearlyMarketMyAccountPage pearlyMarketMyAccountPage = new PearlyMarketMyAccountPage();
        ShopPage shopPage = new ShopPage();
        BillingDetailsPage billingDetailsPage = new BillingDetailsPage();

        //User Navigates to URL
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));

        //User clicks to Sign In
        pearlyMarketHomePage.signInHome.click();

        //User types email
        pearlyMarketSignInPage.usernameOrEmail.sendKeys(ConfigReader.getProperty("fierro_email"));

        //User types password
        pearlyMarketSignInPage.password.sendKeys(ConfigReader.getProperty("fierro_vendor_password"));

        //User clicks to sign in
        pearlyMarketSignInPage.signIn.click();

        //Wait for page to reload
        WaitUtils.waitFor(3);

        //User scrolls down
        for (int i=0; i<4;i++) {
            ReusableMethod.scrollDownActions();
        }
        WaitUtils.waitFor(3);



        //User clicks to My Account
        JSUtils.clickWithTimeoutByJS(pearlyMarketHomePage.myAccountt);


        //User clicks to Orders
        pearlyMarketMyAccountPage.orders.click();

        //User clicks to Browse Products
        pearlyMarketMyAccountPage.browseProducts.click();


        //User hover overs to pillow
        ReusableMethod.hoverOverOnElementActions(shopPage.yastikKlifi);


        //User adds pillow in to cart
        shopPage.pillowAdd.click();

        //User clicks to Cart
        shopPage.cartButton.click();

        //Shopping Cart Menu
        ReusableMethod.verifyElementDisplayed(shopPage.shoppingCard);

       //User checks out
        shopPage.checkout.click();

        WaitUtils.waitFor(2);


        //User adds a first name
        ReusableMethod.sendKeysWithTimeout(billingDetailsPage.billingFirstName,"fierro",3);

        //User adds last name
        ReusableMethod.sendKeysWithTimeout(billingDetailsPage.billingLastName,"gasimov",3);

        //User adds Country
        //Checking if every Country options are clickable
        billingDetailsPage.countryBox.click();

        for (WebElement w : billingDetailsPage.allCountries){
            WaitUtils.waitFor(3);
            w.click();
        }


        //User puts a street address
        ReusableMethod.sendKeysWithTimeout(billingDetailsPage.billingAddress,"123 hello street",3);

        //User types town
        ReusableMethod.sendKeysWithTimeout(billingDetailsPage.billingCity,"world",3);

        //User selects a Province
        //Checking if all Provinces are clickable
        billingDetailsPage.billingState.click();

        for (WebElement w : billingDetailsPage.allProvince){
            WaitUtils.waitFor(3);
            w.click();
        }
















    }

}
