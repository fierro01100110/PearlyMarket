package pearlymarket_project.tests;
import org.testng.annotations.Test;
import pearlymarket_project.pages.PearlyMarketHomePage;
import pearlymarket_project.pages.PearlyMarketRegisterPage;
import pearlymarket_project.utilities.ConfigReader;
import pearlymarket_project.utilities.Driver;
import pearlymarket_project.utilities.ReusableMethod;


public class US_01_Register {

    /* User Story :  "Customer should sign up as a user on the website (Register)" */

    //Test Cases
        //User go to "https://pearlymarket.com/"
        //User clicks "Register" button
        //User clicks "Sing-Up" button
        //User clicks "UsernameBox"
        //User should enter username
        //User clicks email box
        //User should enter email address
        //User clicks password box
        //User should enter password
        //User should check "I agree to the privacy policy"
        //User clicks SIGN-UP button to register


        PearlyMarketRegisterPage pearlyMarketRegisterPage = new PearlyMarketRegisterPage();
        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();

        @Test
        public void US01RegisterTest() {

            // User go to "https://pearlymarket.com/"
            Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));

            //User clicks "Register" button
            pearlyMarketHomePage.register.click();

            //User clicks "Sing-Up" button
            pearlyMarketRegisterPage.signUpButton.click();

            //User clicks "UsernameBox"
            pearlyMarketRegisterPage.usernameBox.click();

            //User should enter username
            ReusableMethod.sendKeysWithTimeout(pearlyMarketHomePage.usernameBox,ConfigReader.getProperty("neslihan_username"),6);

            //User clicks "EmailBox"
            pearlyMarketRegisterPage.emailBox.click();

            //User should enter email address.
            ReusableMethod.sendKeysWithTimeout(pearlyMarketHomePage.emailBox,ConfigReader.getProperty("neslihan_email"),6);

            //User clicks "PasswordBox" button
            pearlyMarketRegisterPage.passwordBox.click();

            //User should enter password
            ReusableMethod.sendKeysWithTimeout(pearlyMarketHomePage.passwordBox,ConfigReader.getProperty("neslihan_password"),6);

            //User should check "I agree to the privacy policy"
            pearlyMarketRegisterPage.confirmBox.click();

            //User clicks SIGN-UP button to register
            pearlyMarketRegisterPage.signUpButton.click();

            Driver.closeDriver();
        }
}
