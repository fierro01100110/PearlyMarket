package pearlymarket_project.tests.negativetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pearlymarket_project.pages.PearlyMarketHomePage;
import pearlymarket_project.pages.PearlyMarketRegisterPage;
import pearlymarket_project.pages.PearlyMarketVendorRegistrationPage;
import pearlymarket_project.utilities.ConfigReader;
import pearlymarket_project.utilities.Driver;
import pearlymarket_project.utilities.ReusableMethod;
import pearlymarket_project.utilities.WaitUtils;


import static pearlymarket_project.utilities.ReusableMethod.verifyElementDisplayed;

public class US_09_VendorEmailExistsBug {


    @Test
    public void vendorEmailExistsTest() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));

        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketRegisterPage pearlyMarketRegisterPage = new PearlyMarketRegisterPage();
        PearlyMarketVendorRegistrationPage vrp = new PearlyMarketVendorRegistrationPage();


        //1. User clicks Register
        pearlyMarketHomePage.register.click();
        //2.User clicks "Become a Vendor"
        pearlyMarketRegisterPage.becomeVendor.click();


        //Verifying that User is on "Vendor Registration" url
        verifyElementDisplayed(By.xpath("//h2[text()='Vendor Registration']"));

        //User clicks email box and enters existed email "gasimovf98@gmail.com"
        vrp.email.sendKeys(ConfigReader.getProperty("fierro_email"));

        //User clicks email verification box
        vrp.emailVerification.click();
        //User sees "Verification code sent to your email: gasimovf98@gmail.com"
        WaitUtils.waitFor(3);


       if (Driver.getDriver().findElement(By.xpath("//div[text()='Verification code sent to your email: gasimovf98@gmail.com.']")).isDisplayed()){
           throw new InterruptedException("Verification code should not be sent to existed email");
       }



        //User types email verification code
        vrp.emailVerification.sendKeys("587697");



        //User clicks password box
        vrp.password.click();
        //User types password
        vrp.password.sendKeys("fierro_vendor_password");

        WaitUtils.waitFor(3);
        //User clicks confirm password box
        vrp.confirmPassword.click();
        //User confirms password
        vrp.confirmPassword.sendKeys("fierro_confirmpassword");

        //User clicks "Register"
        vrp.registerButton.click();

        //The message "This Email already exists. Please log in to the site and apply as vendor."
        // should appear if the user tries to register using a registered email address.
        WaitUtils.waitFor(3);

        String expectedText= "This Email already exists. Please log in to the site and apply as vendor.";
        ReusableMethod.verifyActualAndExpectedTextMatch(expectedText,vrp.existedAccountMessage);

        //Close driver
        Driver.closeDriver();


    }

}
