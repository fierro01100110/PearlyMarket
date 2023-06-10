package pearlymarket_project.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pearlymarket_project.pages.PearlyMarketHomePage;
import pearlymarket_project.pages.PearlyMarketSearchingProductsPage;
import pearlymarket_project.pages.PearlyMarketSignInPage;

import pearlymarket_project.utilities.*;


import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class US_06_SearchDesiredProductInTheSearchBox {


    @BeforeMethod
    public void signIn() throws InterruptedException {

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







    }

    @Test
    public void test1(){

        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketSearchingProductsPage pearlyMarketSearchingProductsPage = new PearlyMarketSearchingProductsPage();

        //Type a product name on the search box
        ReusableMethod.sendKeysWithTimeout( pearlyMarketHomePage.searchBox, "table"+Keys.ENTER, 4);



        //Verify :User should be able to see related items in the dropdown of search box.
        List<WebElement> items = Driver.getDriver().findElements(By.xpath("//h3[@class='woocommerce-loop-product__title']"));

        int idx = 0;

       for(WebElement w : items){

           List<WebElement> products = Driver.getDriver().findElements(By.xpath("//h3[@class='woocommerce-loop-product__title']"));


           if(w.getText().contains("Table")){
               System.out.println("Table related item");

               SoftAssert softAssertion = new SoftAssert();
               softAssertion.assertTrue(w.getText().contains("Table"));
               softAssertion.assertAll();
               idx++;


           }else{
               System.out.println("NOT Table related item");


               SoftAssert softAssertion = new SoftAssert();
               softAssertion.assertTrue(w.getText().contains("Table"));
               softAssertion.assertAll();
               idx++;

           }




       }





    }



    @Test
    public void test2() throws IOException {
        PearlyMarketSearchingProductsPage pearlyMarketSearchingProductsPage = new PearlyMarketSearchingProductsPage();
        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();



        //Type a product name on the search box
        ReusableMethod.sendKeysWithTimeout( pearlyMarketHomePage.searchBox, "table"+Keys.ENTER, 4);



        //User should select desired product
        ReusableMethod.clickWithTimeOut(pearlyMarketSearchingProductsPage.selectProductToAddToCart, 3);

        //User should be able to add the product to the cart
        ReusableMethod.clickWithTimeOut(pearlyMarketSearchingProductsPage.addToCartButton, 3);

        //Verify that the numbers on the cart icon increased/item added successfully

        WaitUtils.waitFor(3);

        int numOnCart = Integer.parseInt(WaitUtils.waitForVisibility(pearlyMarketSearchingProductsPage.numberOnCartIcon,3).getText());

        System.out.println("numOnCart = " + numOnCart);
        assertTrue(numOnCart>0);


        //User should be able to increase the amount of the product
        ReusableMethod.clickWithTimeOut(pearlyMarketSearchingProductsPage.plusButton, 2);

        ReusableMethod.clickWithTimeOut(pearlyMarketSearchingProductsPage.addToCartButton, 3);


        //User clicks on cart icon
        ReusableMethod.clickWithTimeOut(pearlyMarketSearchingProductsPage.numberOnCartIcon, 2);

        //User clicks on "View Cart" button
        JSUtils.clickWithTimeoutByJS(WaitUtils.waitForVisibility(pearlyMarketSearchingProductsPage.checkOutButton, 2));

        //User clicks on Place Order button to complete the purchase
        ReusableMethod.clickWithTimeOut(pearlyMarketSearchingProductsPage.placeOrder, 3);

        WaitUtils.waitFor(4);

        ExtentReportUtils.fail("Success purchase message doesn't appear. Purchase fails");
        ExtentReportUtils.flush();
        MediaUtils.takeScreenshotOfTheEntirePageAsString();




        }



    }




