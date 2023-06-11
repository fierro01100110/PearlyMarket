package pearlymarket_project.tests.negativetests;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pearlymarket_project.pages.*;
import pearlymarket_project.utilities.*;

import java.util.ResourceBundle;


public class US_16_AddSimpleProductAsAVendor {


        //US-16  : User should be able to add Simple Product as a Vendor

        //Test Cases
        //I should use US_09 to register the website as a Vendor
        //Simple Product should be default
        //Virtual ve Downloadable should be selectable
        //User should be able to write Product Title
        //User should be able to write Price ve Sale Price
        //User should be able to select categories
        //User should be able to see that the new product has been added in the Product section.

    @Test
        public void goToTheWebsiteAsAVendorTest() {

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
        for (int i = 0; i < 4; i++) {
            ReusableMethod.scrollDownActions();
        }


//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement myAccountButton = driver.findElement(By.name("//h2[text()='My Account']");
//        js.executeScript("arguments[0].click();",myAccountButton);


        WaitUtils.waitFor(3);
        //User clicks to My Account
        JSUtils.clickWithTimeoutByJS(pearlyMarketHomePage.myAccount);
        // pearlyMarketHomePage.myAccountt.click();

        //Wait for page to reload
        WaitUtils.waitFor(3);

        //User clicks to Store Manager
        pearlyMarketMyAccountPage.storeManager.click();

        //User navigates to Product Manage URL
        Driver.getDriver().get(ConfigReader.getProperty("products_manage_url"));

        //click add new button
        //pearlyMarketVendorProductsPage.addNew.sendKeys(Keys.PAGE_DOWN, Keys.ENTER);

        //"Simple Product" should be default
       Assert.assertTrue(pearlyMarketVendorProductsPage.simpleProduct.isDisplayed());
        // ReusableMethod.verifyElementDisplayed(pearlyMarketVendorProductsPage.simpleProduct);

        //Virtual ve Downloadable should be selectable
        pearlyMarketVendorProductsPage.virtualBox.click();
        pearlyMarketVendorProductsPage.downloadableBox.click();

        //User should be able to write Product Title
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(pearlyMarketVendorProductsPage.productTitle).sendKeys(Keys.TAB,"Comb").perform();

        //User should be able to write Price ve Sale Price
        actions.moveToElement(pearlyMarketVendorProductsPage.price).sendKeys(Keys.TAB,"40").perform();
        actions.moveToElement(pearlyMarketVendorProductsPage.salePrice).sendKeys(Keys.TAB,"50").perform();

        //User should be able to select categories
        pearlyMarketVendorProductsPage.selectableCategories.click();

        //User should be able to click Add New Category
        pearlyMarketVendorProductsPage.addNewCategory.click();

        //Vendor should write a name for the product that will be added
        pearlyMarketVendorProductsPage.categoryName.sendKeys("Comb");

        //Vendor should select a parent category for the product
        ReusableMethod.selectByVisibleText(pearlyMarketVendorProductsPage.parentCategory, "Uncategorized");
        //pearlyMarketVendorProductsPage.parentCategory.click();

        //Vendor should see has been added product
        Assert.assertTrue(pearlyMarketVendorProductsPage.addedProduct.isDisplayed());

    }
}
