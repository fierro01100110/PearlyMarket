package src.test.java.pearlymarket_project.tests.positivetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import src.test.java.pearlymarket_project.pages.PearlyMarketHomePage;
import src.test.java.pearlymarket_project.pages.PearlyMarketMyAccountPage;
import src.test.java.pearlymarket_project.pages.PearlyMarketMyStorePage;
import src.test.java.pearlymarket_project.pages.PearlyMarketSignInPage;
import src.test.java.pearlymarket_project.utilities.ConfigReader;
import src.test.java.pearlymarket_project.utilities.Driver;
import src.test.java.pearlymarket_project.utilities.ReusableMethod;
import src.test.java.pearlymarket_project.utilities.WaitUtils;

import java.util.ArrayList;
import java.util.List;

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

       //Checking if every option in dropdown is selectable
       WebElement dropdown=Driver.getDriver().findElement(By.xpath("//select[@id='product_type']"));
       Select options= new Select(dropdown);
          List<WebElement> dropdownOptions= options.getOptions();
       for (WebElement w : dropdownOptions){
           w.click();
           System.out.println(w.getText());
       }
       //user clicks virtual box
       ReusableMethod.clickWithTimeOut(pearlyMarketMyStorePage.virtualBox,3);
       //user adds a product photo
       WebElement chooseAFile = Driver.getDriver().findElement(By.id("gallery_img_gimage_0_display"));
       String userHome = System.getProperty("user.home");
       String pathOfPhone=userHome+"\\OneDrive\\Desktop\\phone.png";
       ReusableMethod.sendKeysWithTimeout(chooseAFile,pathOfPhone,3);    //failssss?????

       //user adds product title
       ReusableMethod.sendKeysWithTimeout(pearlyMarketMyStorePage.productTitle,"Phone",3);
       //switch to iframes to type in text field of short describtion
         ReusableMethod.switchIframeByWebElement("//iframe[@id='excerpt_ifr']");
       WaitUtils.waitFor(3);

  //user fills the text field
     ReusableMethod.sendKeysWithTimeout(pearlyMarketMyStorePage.shortDescription,"hi",3);
       //swith back to default page from iframe
     Driver.getDriver().switchTo().defaultContent();
       WaitUtils.waitFor(3);
       //switch to an iframe of description text field
       ReusableMethod.switchIframeByWebElement("//iframe[@id='description_ifr']");
       //user fills the description text field
       ReusableMethod.sendKeysWithTimeout(pearlyMarketMyStorePage.description,"hello",3);
       //switch back to default page
       Driver.getDriver().switchTo().defaultContent();
       //user select a category
  ReusableMethod.clickWithTimeOut(pearlyMarketMyStorePage.categories,3);
       //user adds New Categories.
 ReusableMethod.clickWithTimeOut(pearlyMarketMyStorePage.addnewCategories,3);
         //user adds a new category
 ReusableMethod.sendKeysWithTimeout(pearlyMarketMyStorePage.categoryName,"ABC",3);
      //user sleect a parent category from a dropwdown
       ReusableMethod.selectByVisibleText(pearlyMarketMyStorePage.parentCategory,"      Mobile");

  ReusableMethod.clickWithTimeOut(pearlyMarketMyStorePage.productBrandsName,3);
  //user add new product brand
       ReusableMethod.clickWithTimeOut(pearlyMarketMyStorePage.addNewProductBrand,3);
       //user types a product name
       ReusableMethod.sendKeysWithTimeout(pearlyMarketMyStorePage.productBrandsName,"CBA",3);
       //user select an element from dropdown
       ReusableMethod.selectByVisibleText(pearlyMarketMyStorePage.parentTaxonomy,"         Samsung");

  //verift that vategories, product brand, product type and photo are clickable
  ReusableMethod.verifyElementClickable(pearlyMarketMyStorePage.categories);
  ReusableMethod.verifyElementClickable(pearlyMarketMyStorePage.productBrandsName);
  ReusableMethod.verifyElementClickable(pearlyMarketMyStorePage.productType);
  ReusableMethod.verifyElementClickable(pearlyMarketMyStorePage.photo);
  for (WebElement w:dropdownOptions){
      ReusableMethod.verifyElementClickable(w);
  }






   }


}
