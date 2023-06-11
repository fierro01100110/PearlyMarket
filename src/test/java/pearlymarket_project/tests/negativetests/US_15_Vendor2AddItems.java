package pearlymarket_project.tests.negativetests;
import pearlymarket_project.utilities.JSUtils;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pearlymarket_project.pages.PearlyMarketHomePage;
import pearlymarket_project.pages.PearlyMarketMyAccountPage;
import pearlymarket_project.pages.PearlyMarketSignInPage;
import pearlymarket_project.pages.PearlyMarketVendorProductsPage;
import pearlymarket_project.utilities.ConfigReader;
import pearlymarket_project.utilities.Driver;
import pearlymarket_project.utilities.ReusableMethod;
import pearlymarket_project.utilities.WaitUtils;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class US_15_Vendor2AddItems {



    @BeforeClass
    public void testCase001(){

        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketSignInPage pearlyMarketSignInPage = new PearlyMarketSignInPage();
        PearlyMarketMyAccountPage pearlyMarketMyAccountPage = new PearlyMarketMyAccountPage();
        PearlyMarketVendorProductsPage pearlyMarketVendorProductsPage = new PearlyMarketVendorProductsPage();

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
        pearlyMarketHomePage.myAccount.click();

        //Wait for page to reload
        WaitUtils.waitFor(3);

        //User clicks to Store Manager
        pearlyMarketMyAccountPage.storeManager.click();

        //User hover overs to Product
        ReusableMethod.hoverOverOnElementActions(pearlyMarketMyAccountPage.products);

        //User clicks to Add New
        WaitUtils.waitFor(3);
        pearlyMarketMyAccountPage.addNewProducts.click();

        //User scrolls down
        for (int i=0; i<2;i++){
            ReusableMethod.scrollDownActions();
        }

        //User can see "Inventory, Shipping, Attributes, Linked, Seo, Advanced menus"
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorProductsPage.advanced);
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorProductsPage.attributes);
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorProductsPage.inventory);
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorProductsPage.seo);
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorProductsPage.linked);
        ReusableMethod.verifyElementDisplayed(pearlyMarketVendorProductsPage.shipping);


    }

    //THIS METHOD IS A SCENARIO WHEN USER CLICKS TO MANAGE STOCK
    @Test(priority = 1)
    public void testCase002(){

        PearlyMarketVendorProductsPage pearlyMarketVendorProductsPage = new PearlyMarketVendorProductsPage();

        //User enters Product SKU code
        pearlyMarketVendorProductsPage.skuBox.clear();
        pearlyMarketVendorProductsPage.skuBox.sendKeys("123567896324");

        //User clicks to Manage Stock
        pearlyMarketVendorProductsPage.manageStock.click();

        //Stock QTY
        WaitUtils.waitFor(2);
        //User clears the box
        pearlyMarketVendorProductsPage.stockQty.clear();
        //User types stock quantity
        pearlyMarketVendorProductsPage.stockQty.sendKeys("42");

        //Back Orders box
        //Checking if every option is selectable
        Select select = new Select(pearlyMarketVendorProductsPage.backOrders);
        List<WebElement> allOptions = select.getOptions();
        for (WebElement w : allOptions){
            w.click();

        }

        //Individuality Box
        pearlyMarketVendorProductsPage.solidIndividuality.click();


    }

    @Test(priority = 2)
    public void testCase02(){

        WaitUtils.waitFor(3);

        PearlyMarketVendorProductsPage pearlyMarketVendorProductsPage = new PearlyMarketVendorProductsPage();

        //User enters Product SKU code
        pearlyMarketVendorProductsPage.skuBox.clear();
        pearlyMarketVendorProductsPage.skuBox.sendKeys("123567896324");

        //User does not click to manage stock
        //User clicks to Manage Stock
        pearlyMarketVendorProductsPage.manageStock.click();


        //User clicks to Stock Status
        //Check if dropdown values are clickable
        Select select = new Select(pearlyMarketVendorProductsPage.stockStatus);
        List<WebElement> allOptions = select.getOptions();
        for (WebElement w : allOptions){
            WaitUtils.waitFor(2);
            w.click();
            WaitUtils.waitFor(4);

        }


        //User clicks to Individuality Box
        pearlyMarketVendorProductsPage.solidIndividuality.click();


    }

    @Test(priority = 3)
    public void testCase03(){

        WaitUtils.waitFor(3);

        PearlyMarketVendorProductsPage pearlyMarketVendorProductsPage = new PearlyMarketVendorProductsPage();

        //User selects Shipping Menu
        pearlyMarketVendorProductsPage.shipping.click();

        //User enters Weight
        pearlyMarketVendorProductsPage.weightBox.sendKeys("10");

        // User enters Dimensions
        pearlyMarketVendorProductsPage.lengthBox.sendKeys("3");
        pearlyMarketVendorProductsPage.widthBox.sendKeys("5");
        pearlyMarketVendorProductsPage.heightBox.sendKeys("1");

        //User selects Shipping Class
        //Checking if every shipping class clickable
        Select select = new Select(pearlyMarketVendorProductsPage.shippingClassBox);
        List<WebElement> allOptions = select.getOptions();
        int shippingClassSize = allOptions.size();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(shippingClassSize,shippingClassSize<1,"Shipping Class Box should not be empty");

        //User clicks Processing Time
        //User clicks all Processing Time
        Select select2 = new Select(pearlyMarketVendorProductsPage.processingTimeBox);
        List<WebElement> allProcessing = select2.getOptions();
        for (WebElement w : allProcessing){
            w.click();

        }

        softAssert.assertAll();


    }


    @Test(priority = 4)
    public void testCase04() throws InterruptedException {

        PearlyMarketVendorProductsPage pearlyMarketVendorProductsPage = new PearlyMarketVendorProductsPage();

        //User clicks Attributes menu
        pearlyMarketVendorProductsPage.attributes.click();




        //User select Color Options
        JSUtils.clickWithTimeoutByJS(pearlyMarketVendorProductsPage.colorCheck);

        //Check if all the options are clickable
        pearlyMarketVendorProductsPage.selectAllColors.click();

        WaitUtils.waitFor(2);

        //Check if all colors are deletable
        pearlyMarketVendorProductsPage.selectNoneColors.click();



        //ALERT
//        //User Adds New Color
//        pearlyMarketVendorProductsPage.addNewColor.click();
//        WaitUtils.waitFor(2);
//
//
//        String name = "Hello World";
//        ReusableMethod.acceptAlert();




        //User selects Size Options
        JSUtils.clickWithTimeoutByJS(pearlyMarketVendorProductsPage.sizeBox);

        //Checking if user can select all size
        JSUtils.clickWithTimeoutByJS(pearlyMarketVendorProductsPage.selectAllSize);

        //Checking non-select functionality
        JSUtils.clickWithTimeoutByJS(pearlyMarketVendorProductsPage.selectNoneSize);

        //User adds New Attribute
        pearlyMarketVendorProductsPage.addAttribute.click();

        //Add name
        pearlyMarketVendorProductsPage.addName.sendKeys("Hello");

        //Add Value
        pearlyMarketVendorProductsPage.addValue.sendKeys("Hi");


        //Close Driver
        Driver.closeDriver();


    }


}
