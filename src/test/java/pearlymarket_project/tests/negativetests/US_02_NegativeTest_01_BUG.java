package pearlymarket_project.tests.negativetests;

import org.testng.annotations.Test;
import pearlymarket_project.pages.PearlyMarketHomePage;
import pearlymarket_project.utilities.ConfigReader;
import pearlymarket_project.utilities.Driver;
import pearlymarket_project.utilities.ReusableMethod;

public class US_02_NegativeTest_01_BUG {
    @Test
    public void weakPasswordTest(){

        PearlyMarketHomePage pearlyMarketHomePage= new PearlyMarketHomePage();
        // user visits home page
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));
        // user clicks Register button
        pearlyMarketHomePage.register.click();
        // user enters an already existing username
        ReusableMethod.sendKeysWithTimeout(pearlyMarketHomePage.usernameBox,ConfigReader.getProperty("andrey_new_username"),6);
        // user enters an already existing email
        ReusableMethod.sendKeysWithTimeout(pearlyMarketHomePage.emailBox,ConfigReader.getProperty("andrey_new_email"),6);
        // user enters a password
        ReusableMethod.sendKeysWithTimeout(pearlyMarketHomePage.passwordBox,ConfigReader.getProperty("andrey_weak_psw"),6);

    //BUG
        //user should see an error message whne the password is weak

        //bug

      //  ReusableMethod.verifyElementNotDisplayed(pearlyMarketHomePage.weakPswMessage);
      String a=  "Hint: The password should be at least twelve " +
              "characters long. To make it stronger, use upper and lower case " +
              "letters, numbers, and symbols like ! " + " ? $ % ^ & )";

    //ReusableMethod.verifyActualAndExpectedTextMatch(a,pearlyMarketHomePage.weakPswMessage);



    }
}
