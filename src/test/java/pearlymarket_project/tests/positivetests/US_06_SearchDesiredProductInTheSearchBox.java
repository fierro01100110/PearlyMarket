package pearlymarket_project.tests.positivetests;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pearlymarket_project.pages.PearlyMarketHomePage;
import pearlymarket_project.pages.PearlyMarketSearchingProductsPage;
import pearlymarket_project.pages.PearlyMarketSignInPage;
import pearlymarket_project.utilities.*;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

public class US_06_SearchDesiredProductInTheSearchBox {

    @BeforeMethod
    public void signIn() throws InterruptedException {

        ExtentReportUtils.info("The test starts..");
        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketSignInPage pearlyMarketSignInPage = new PearlyMarketSignInPage();

        //Go to the url
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));

        //Click on sign in
        ReusableMethod.clickWithTimeOut(pearlyMarketHomePage.signInHome, 3);


        //Enter username or email
        ReusableMethod.sendKeysWithTimeout(pearlyMarketSignInPage.usernameOrEmail,ConfigReader.getProperty("seyma_email"), 3);


        //Enter password
        ReusableMethod.sendKeysWithTimeout(pearlyMarketSignInPage.password, ConfigReader.getProperty("seyma_password"), 3);


        //Click on sign-in
        ReusableMethod.clickWithTimeOut(pearlyMarketSignInPage.signIn, 3);

        ExtentReportUtils.pass("Signing-in");



    }



    @Test
    public void test1() throws IOException {
        PearlyMarketSearchingProductsPage pearlyMarketSearchingProductsPage = new PearlyMarketSearchingProductsPage();
        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();


        ExtentReportUtils.pass("User searches for a product");

        //Type a product name on the search box
        ReusableMethod.sendKeysWithTimeout( pearlyMarketHomePage.searchBox, "table"+ Keys.ENTER, 4);



        //User should select desired product
        ReusableMethod.clickWithTimeOut(pearlyMarketSearchingProductsPage.selectProductToAddToCart, 3);

        ExtentReportUtils.pass("User adds the desired product into the cart");

        //User should be able to add the product to the cart
        ReusableMethod.clickWithTimeOut(pearlyMarketSearchingProductsPage.addToCartButton, 3);

        //Verify that the numbers on the cart icon increased/item added successfully

        ExtentReportUtils.pass("User sees that the number on cart icon is increasing after adding");
        WaitUtils.waitFor(3);

        int numOnCart = Integer.parseInt(WaitUtils.waitForVisibility(pearlyMarketSearchingProductsPage.numberOnCartIcon,4).getText());

        System.out.println("numOnCart = " + numOnCart);
        assertTrue(numOnCart>0);


        //User should be able to increase the amount of the product
        ReusableMethod.clickWithTimeOut(pearlyMarketSearchingProductsPage.plusButton, 2);

        ReusableMethod.clickWithTimeOut(pearlyMarketSearchingProductsPage.addToCartButton, 3);


        //User clicks on cart icon
        ReusableMethod.clickWithTimeOut(pearlyMarketSearchingProductsPage.numberOnCartIcon, 2);

        //User clicks on "View Cart" button
        JSUtils.clickWithTimeoutByJS(WaitUtils.waitForVisibility(pearlyMarketSearchingProductsPage.checkOutButton, 2));

        ExtentReportUtils.pass("User completes the order");
        //User clicks on Place Order button to complete the purchase
        ReusableMethod.clickWithTimeOut(pearlyMarketSearchingProductsPage.placeOrder, 3);

        WaitUtils.waitFor(4);

        //Verify that the purchase is successful.
        ReusableMethod.verifyElementDisplayed(pearlyMarketSearchingProductsPage.orderReceivedMessage);

        ExtentReportUtils.pass("Purchase is success.");
        ExtentReportUtils.flush();

        Driver.closeDriver();



    }



}
