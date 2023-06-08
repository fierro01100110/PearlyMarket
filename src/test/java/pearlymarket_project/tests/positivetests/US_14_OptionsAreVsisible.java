package pearlymarket_project.tests.positivetests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pearlymarket_project.pages.PearlyMarketHomePage;
import pearlymarket_project.pages.PearlyMarketMyAccountPage;
import pearlymarket_project.pages.PearlyMarketMyStorePage;
import pearlymarket_project.pages.PearlyMarketSignInPage;
import pearlymarket_project.utilities.ConfigReader;
import pearlymarket_project.utilities.Driver;
import pearlymarket_project.utilities.ReusableMethod;
import pearlymarket_project.utilities.WaitUtils;

import java.util.ArrayList;

public class US_14_OptionsAreVsisible {

   @BeforeMethod
    public void OptionsAreVisibleTest(){
       PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
       PearlyMarketSignInPage pearlyMarketSignInPage = new PearlyMarketSignInPage();
       //Go to the url
       Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));
      //Click on sign in
      ReusableMethod.clickWithTimeOut(pearlyMarketHomePage.signInHome, 3);
      //Enter username or email
      ReusableMethod.sendKeysWithTimeout(pearlyMarketSignInPage.usernameOrEmail,ConfigReader.getProperty("andrey_fake_email"), 3);


      //Enter password
      ReusableMethod.sendKeysWithTimeout(pearlyMarketSignInPage.password, ConfigReader.getProperty("andrey_vendor_psw"), 3);


      //Click on sign-in
      ReusableMethod.clickWithTimeOut(pearlyMarketSignInPage.signIn, 3);
       //Click on mY Account
      ReusableMethod.clickWithTimeOut(pearlyMarketHomePage.myAccount, 3);


   }
   @Test
    public void test1() throws Exception {
       PearlyMarketMyAccountPage pearlyMarketMyAccountPage =new PearlyMarketMyAccountPage();
       PearlyMarketMyStorePage pearlyMarketMyStorePage= new PearlyMarketMyStorePage();
       //User clicks the Store Manager
       ReusableMethod.clickWithTimeOut(pearlyMarketMyAccountPage.storeManager, 3);
       //User clicks the Products
       ReusableMethod.clickWithTimeOut(pearlyMarketMyAccountPage.products, 3);
       //User clicks the Add New Product
       ReusableMethod.clickWithTimeOut(pearlyMarketMyAccountPage.addNewProducts, 3);
       //verify that user sees add product page
       ReusableMethod.verifyElementDisplayed(pearlyMarketMyStorePage.photo);
       //User sees the options in the dropwdown box

       ReusableMethod.selectDropdownByValue(pearlyMarketMyStorePage.productType,"Variable Product");
       ReusableMethod.sendKeysWithTimeout(pearlyMarketMyStorePage.productTitle,"Phone",3);
         ReusableMethod.switchIframeByWebElement("//iframe[@id='excerpt_ifr']");
       WaitUtils.waitFor(3);


     ReusableMethod.sendKeysWithTimeout(pearlyMarketMyStorePage.shortDescription,"hi",3);
     Driver.getDriver().switchTo().defaultContent();
       WaitUtils.waitFor(3);
       ReusableMethod.switchIframeByWebElement("//iframe[@id='description_ifr']");

       ReusableMethod.sendKeysWithTimeout(pearlyMarketMyStorePage.description,"hello",3);
       Driver.getDriver().switchTo().defaultContent();
//       ReusableMethod.sendKeysWithTimeout(pearlyMarketMyStorePage.shortDescription,"sd",3);
   //ReusableMethod.clickWithTimeOut(pearlyMarketMyStorePage.description,3);





   }
//
//   @Test
//    public void test2(){
//       PearlyMarketMyStorePage pearlyMarketMyStorePage= new PearlyMarketMyStorePage();
//       ReusableMethod.selectDropdownByValue(pearlyMarketMyStorePage.productType,"Variable Product");
//      // ReusableMethod.selectDropdownByValue(pearlyMarketMyStorePage.productType,"Variable Product");
//
//
//   }

}
