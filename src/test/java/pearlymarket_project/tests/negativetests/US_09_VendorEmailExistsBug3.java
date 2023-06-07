package pearlymarket_project.tests.negativetests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pearlymarket_project.pages.PearlyMarketHomePage;
import pearlymarket_project.pages.PearlyMarketRegisterPage;
import pearlymarket_project.pages.PearlyMarketVendorRegistrationPage;
import pearlymarket_project.utilities.ConfigReader;
import pearlymarket_project.utilities.Driver;
import pearlymarket_project.utilities.ReusableMethod;
import pearlymarket_project.utilities.WaitUtils;

import static pearlymarket_project.utilities.ReusableMethod.verifyElementDisplayed;

public class US_09_VendorEmailExistsBug3 {

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

        //User clicks email box and enters "gasimovf98@gmail.com"
        vrp.email.sendKeys(ConfigReader.getProperty("fierro_email"));

        //User clicks email verification box
        vrp.emailVerification.click();
        //User sees "Verification code sent to your email: gasimovf98@gmail.com"
        WaitUtils.waitFor(3);
        verifyElementDisplayed(By.xpath("//div[text()='Verification code sent to your email: gasimovf98@gmail.com.']"));

        //User types wrong email verification code
        vrp.emailVerification.sendKeys("604319");


        //User clicks password box
        vrp.password.click();
        //User types password
        vrp.password.sendKeys(ConfigReader.getProperty("fierro_vendor_password"));

        WaitUtils.waitFor(3);
        //User clicks confirm password box
        vrp.confirmPassword.click();
        //User confirms password
        vrp.confirmPassword.sendKeys(ConfigReader.getProperty("fierro_confirmpassword"));

        //User clicks "Register"
        vrp.registerButton.click();



        //BUG
        //User typed REUSED verification code
        String expectedMessage = "Verification code is incorrect";
        ReusableMethod.verifyActualAndExpectedTextMatch(expectedMessage,vrp.errorMessage);






        //My actual expected result from User Story 09

        //The message "This Email already exists. Please log in to the site and apply as vendor."
        // should appear if the user tries to register using a registered email address.
        WaitUtils.waitFor(3);

        String expectedData= "This Email already exists. Please login to the site and apply as vendor.";
        ReusableMethod.verifyActualAndExpectedTextMatch(expectedData,vrp.errorMessage);

        //Close driver
        Driver.closeDriver();


    }
}
