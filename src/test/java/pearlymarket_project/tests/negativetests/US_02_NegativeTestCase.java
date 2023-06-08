package pearlymarket_project.tests.negativetests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pearlymarket_project.pages.PearlyMarketHomePage;
import pearlymarket_project.pages.PearlyMarketRegisterPage;
import pearlymarket_project.tests.positivetests.utilities.ConfigReader;
import pearlymarket_project.tests.positivetests.utilities.Driver;
import pearlymarket_project.tests.positivetests.utilities.ReusableMethod;

public class US_02_NegativeTestCase {
         Faker faker =new Faker();

    @Test
    public void tets1(){
        PearlyMarketHomePage pearlyMarketHomePage= new PearlyMarketHomePage();
        PearlyMarketRegisterPage pearlyMarketRegisterPage=new PearlyMarketRegisterPage();
        // user visits home page
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));
        // user clicks Register button
        pearlyMarketHomePage.register.click();
     String fakeUsername=faker.name().username();
     String fakeEmail=faker.internet().emailAddress();
     String  fakePassword=faker.internet().password();
        // user enters an already existing username
        ReusableMethod.sendKeysWithTimeout(pearlyMarketHomePage.usernameBox,fakeUsername,3);
        // user enters an already existing email
        ReusableMethod.sendKeysWithTimeout(pearlyMarketHomePage.emailBox,fakeEmail,6);
        // user enters a password
        ReusableMethod.sendKeysWithTimeout(pearlyMarketHomePage.passwordBox,fakePassword,6);
        // user clicks the confrim box "I agree to the privacy policy"
        ReusableMethod.clickWithTimeOut(pearlyMarketHomePage.confirmBox,3);
        // user clicks sign up button
        ReusableMethod.clickWithTimeOut(pearlyMarketHomePage.signUpButton,3);
        //verify that user sees sign out button/gi
       ReusableMethod.verifyElementDisplayed(pearlyMarketRegisterPage.successfulRegister);


    }


}
