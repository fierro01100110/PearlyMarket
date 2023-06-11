package src.test.java.pearlymarket_project.tests.negativetests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.test.java.pearlymarket_project.pages.AccountDetailsPage;
import src.test.java.pearlymarket_project.utilities.*;

import java.io.IOException;

public class US_05_UserEditAccountDetailsNegative {
    AccountDetailsPage accountDetailsPage = new AccountDetailsPage();
    JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();

    @Test
    public void testCase01() throws IOException {

//        1. Go to the https://pearlymarket.com
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));

//        2. User clicks Sign In button
        accountDetailsPage.SignInButton.click();

//        3. User types Email address or Username
        accountDetailsPage.userNameOrEmail.sendKeys(ConfigReader.getProperty("account_details_username"));

//        4. User types Password
        accountDetailsPage.password.sendKeys(ConfigReader.getProperty("account_details_password"));

//        5. User clicks Sign In Button
        accountDetailsPage.signIn.click();


//        6. User clicks My Account link
        WaitUtils.waitFor(2);
        js.executeScript("arguments[0].click();", accountDetailsPage.myAccountLink);

//        7. User clicks Account details link on the My Account Page
        accountDetailsPage.accountDetailsLink.click();

//        8. User removes First Name
        accountDetailsPage.accountFirstName.clear();

//      9. User types Last Name
        accountDetailsPage.accountLastName.sendKeys("Tester");

    //10. User clicks SAVE CHANGES button
        js.executeScript("arguments[0].click();", accountDetailsPage.saveChangesButton);
        WaitUtils.waitFor(2);

//        11. User should see the "FIRST NAME is a required field." message

        Assert.assertEquals(accountDetailsPage.alertMessage.getText(),"FIRST NAME is a required field.");
        ExtentReportUtils.pass("User was able to see FIRST NAME is a required field. message When missing First Name");
        ExtentReportUtils.passAndCaptureScreenShot("Missing First Name");
        ExtentReportUtils.flush();

    }

    @Test
    public void testCase02() throws IOException {
        //1. User remove Last Name
        accountDetailsPage.accountLastName.clear();

        //2. User types First Name
        accountDetailsPage.accountFirstName.sendKeys("Eagle");

        //3. User clicks SAVE CHANGES button

        js.executeScript("arguments[0].click();", accountDetailsPage.saveChangesButton);
        WaitUtils.waitFor(2);

//        4. User should see the "LAST NAME is a required field." message

        Assert.assertEquals(accountDetailsPage.alertMessage.getText(),"LAST NAME is a required field.");
        ExtentReportUtils.pass("User was able to see LAST NAME is a required field. message When missing Last Name");
        ExtentReportUtils.passAndCaptureScreenShot("Missing Last Name");
        ExtentReportUtils.flush();

    }

    @Test
    public void testCase03() {

        accountDetailsPage.accountFirstName.sendKeys("Eagle");
        accountDetailsPage.accountLastName.sendKeys("Tester");

        //1. User remove Display Name
        accountDetailsPage.accountDisplayName.clear();

        //2. User clicks SAVE CHANGES button

        js.executeScript("arguments[0].click();", accountDetailsPage.saveChangesButton);
        WaitUtils.waitFor(2);

//      3. User should see the "DISPLAY NAME is a required field." message
        Assert.assertEquals(accountDetailsPage.alertMessage.getText(),"DISPLAY NAME is a required field.");

    }

    @Test
    public void testCase04() {
        accountDetailsPage.accountFirstName.sendKeys("Eagle");
        accountDetailsPage.accountLastName.sendKeys("Tester");

 //    1. User remove Email Address
        accountDetailsPage.accountEmail.clear();

 //2. User clicks SAVE CHANGES button
        js.executeScript("arguments[0].click();", accountDetailsPage.saveChangesButton);
        WaitUtils.waitFor(2);

  //3. User should see the "EMAIL ADDRESS is a required field." message
        Assert.assertEquals(accountDetailsPage.alertMessage.getText(),"EMAIL ADDRESS is a required field.");
        ExtentReportUtils.pass("User was able to see EMAIL ADDRESS is a required field. message When missing Email Address");
        ExtentReportUtils.flush();
    }

    @Test
    public void testCase05() {
        accountDetailsPage.accountFirstName.sendKeys("Eagle");
        accountDetailsPage.accountLastName.sendKeys("Tester");
        JSUtils.scrollAllTheWayDownJS();
        WaitUtils.waitFor(2);
        //    1. When user doesn't type Current Password
        accountDetailsPage.currentPassword.clear();

    // 2. User types New Password
        accountDetailsPage.newPassword.sendKeys("Test006.com");

    //3. User types ConfirmPassword
        accountDetailsPage.comfirmPassword.sendKeys("Test006.com");

    //4. User clicks SAVE CHANGES button
        js.executeScript("arguments[0].click();", accountDetailsPage.saveChangesButton);
        WaitUtils.waitFor(2);

    //5. User should see the "please enter your current password." message
        Assert.assertEquals(accountDetailsPage.alertMessage.getText(),"Please enter your current password.");
        ExtentReportUtils.pass("User was able to see warning Please enter your current password. message When missing Current Password");
        ExtentReportUtils.flush();


    }

    @Test
    public void testCase06() {
        accountDetailsPage.accountFirstName.sendKeys("Eagle");
        accountDetailsPage.accountLastName.sendKeys("Tester");
        JSUtils.scrollAllTheWayDownJS();
        WaitUtils.waitFor(2);
//     1. User types Current Password
        accountDetailsPage.currentPassword.sendKeys("Test005.com");

//     2. User doesn't type new Password
        accountDetailsPage.newPassword.clear();

     //3. User doesn't type confirmPassword
        accountDetailsPage.comfirmPassword.clear();

//     4. User clicks SAVE CHANGES button
        js.executeScript("arguments[0].click();", accountDetailsPage.saveChangesButton);
        WaitUtils.waitFor(2);

//     5. User should see the "Please fill out all password fields." message
        Assert.assertEquals(accountDetailsPage.alertMessage.getText(),"Please fill out all password fields.");
        ExtentReportUtils.pass("User was able to see Please fill out all password fields. message When missing new and confirm Password");
        ExtentReportUtils.flush();
   }
    @Test
    public void testCase07() {
        accountDetailsPage.accountFirstName.sendKeys("Eagle");
        accountDetailsPage.accountLastName.sendKeys("Tester");
        JSUtils.scrollAllTheWayDownJS();
        WaitUtils.waitFor(2);
//        1. User types Current Password
        accountDetailsPage.currentPassword.sendKeys("Test005.com");

//        2. User types new Password
        accountDetailsPage.newPassword.sendKeys("Test006.com");

//        3. User doesn't type confirmPassword
        accountDetailsPage.comfirmPassword.clear();

//        4. User clicks SAVE CHANGES button
        js.executeScript("arguments[0].click();", accountDetailsPage.saveChangesButton);
        WaitUtils.waitFor(2);

//        5. User should see the "Please re-enter your password" message
        Assert.assertEquals(accountDetailsPage.alertMessage.getText(),"Please re-enter your password.");

        ExtentReportUtils.pass("User was able to see Please re-enter your password. message When missing confirm Password");
        ExtentReportUtils.flush();


    }

}

