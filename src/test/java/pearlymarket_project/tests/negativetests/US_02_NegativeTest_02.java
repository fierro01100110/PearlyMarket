package pearlymarket_project.tests.negativetests;

import org.testng.annotations.Test;
import pearlymarket_project.pages.PearlyMarketHomePage;
import pearlymarket_project.tests.positivetests.utilities.ConfigReader;
import pearlymarket_project.tests.positivetests.utilities.Driver;
import pearlymarket_project.tests.positivetests.utilities.ReusableMethod;

public class US_02_NegativeTest_02 {
    @Test
    public void registeredUsernameTest(){

        PearlyMarketHomePage pearlyMarketHomePage= new PearlyMarketHomePage();
        // user visits home page
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));
        // user clicks Register button
        pearlyMarketHomePage.register.click();
        // user enters an already existing username
        ReusableMethod.sendKeysWithTimeout(pearlyMarketHomePage.usernameBox,ConfigReader.getProperty("andrey_username"),6);
        // user enters an already existing email
        ReusableMethod.sendKeysWithTimeout(pearlyMarketHomePage.emailBox,ConfigReader.getProperty("andrey_new_email"),6);
        // user enters a password
        ReusableMethod.sendKeysWithTimeout(pearlyMarketHomePage.passwordBox,ConfigReader.getProperty("andrey_password"),6);
        // user clicks the confrim box "I agree to the privacy policy"
        ReusableMethod.clickWithTimeOut(pearlyMarketHomePage.confirmBox,3);
        // user clicks sign up button
        ReusableMethod.clickWithTimeOut(pearlyMarketHomePage.signUpButton,3);
        //verift that user see the error message "An account is already registered with your email address."
       // ReusableMethod.verifyElementDisplayed(pearlyMarketHomePage.errorMessage);
        ReusableMethod.
                verifyActualAndExpectedTextMatch(ConfigReader.getProperty("register_with_existingUsernameMessage"),
                        pearlyMarketHomePage.usernameErrorMessage);

    }



}
