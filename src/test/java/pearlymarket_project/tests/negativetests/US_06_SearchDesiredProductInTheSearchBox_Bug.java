package src.test.java.pearlymarket_project.tests.negativetests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import src.test.java.pearlymarket_project.pages.PearlyMarketHomePage;
import src.test.java.pearlymarket_project.pages.PearlyMarketSearchingProductsPage;
import src.test.java.pearlymarket_project.pages.PearlyMarketSignInPage;

import src.test.java.pearlymarket_project.utilities.*;


import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class US_06_SearchDesiredProductInTheSearchBox_Bug {


    @Test
    public void signInAndSearchProduct() throws InterruptedException {

        ExtentReportUtils.info("The test starts..");
        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketSignInPage pearlyMarketSignInPage = new PearlyMarketSignInPage();

        //Go to the url
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));

        ExtentReportUtils.pass("Signing-in");
        //Click on sign in
        ReusableMethod.clickWithTimeOut(pearlyMarketHomePage.signInHome, 3);


        //Enter username or email
        ReusableMethod.sendKeysWithTimeout(pearlyMarketSignInPage.usernameOrEmail,ConfigReader.getProperty("seyma_email"), 3);


        //Enter password
        ReusableMethod.sendKeysWithTimeout(pearlyMarketSignInPage.password, ConfigReader.getProperty("seyma_password"), 3);


        //Click on sign-in
        ReusableMethod.clickWithTimeOut(pearlyMarketSignInPage.signIn, 3);



        ExtentReportUtils.pass("User searches a product");


        PearlyMarketSearchingProductsPage pearlyMarketSearchingProductsPage = new PearlyMarketSearchingProductsPage();

        //Type a product name on the search box
        ReusableMethod.sendKeysWithTimeout( pearlyMarketHomePage.searchBox, "table"+Keys.ENTER, 4);



        //Verify :User should be able to see related items in the dropdown of search box.
        List<WebElement> items = Driver.getDriver().findElements(By.xpath("//h3[@class='woocommerce-loop-product__title']"));

        int idx = 0;

        ExtentReportUtils.fail("User sees unrelated products");

        ExtentReportUtils.flush();



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

        Driver.closeDriver();



    }





    }




