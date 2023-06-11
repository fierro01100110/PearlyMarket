package src.test.java.pearlymarket_project.tests.positivetests;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.test.java.pearlymarket_project.pages.AccountDetailsPage;
import src.test.java.pearlymarket_project.pages.PearlyMarketHomePage;


import src.test.java.pearlymarket_project.utilities.*;

import src.test.java.pearlymarket_project.utilities.*;

import java.io.IOException;



public class US_05_UserEditAccountDetails {
    PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
    AccountDetailsPage accountDetailsPage = new AccountDetailsPage();

    Faker faker = new Faker();
    String username = faker.name().username();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();
    String newPassword = faker.internet().password();
    String changedName = faker.name().firstName();
    String changedLastName = faker.name().lastName();
    String changedDisplayName = faker.name().name();
    String changedEmail = faker.internet().emailAddress();


    @Test
    public void testCase01() {
        // 1. Go to the https://pearlymarket.com
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));
        ExtentReportUtils.pass("Go to home page: "+ ConfigReader.getProperty("pearlymarket_home_page"));

        //2. User clicks Register button
        pearlyMarketHomePage.register.click();

        //3. User types username
        pearlyMarketHomePage.usernameBox.sendKeys(username);

        //4. User types Email Address
        pearlyMarketHomePage.emailBox.sendKeys(email);

        //5. User types Password
        pearlyMarketHomePage.passwordBox.sendKeys(password);

        //6. User checks "I agree to the privacy policy"
        pearlyMarketHomePage.confirmBox.click();

        //7. User clicks Sign Up button
        pearlyMarketHomePage.signUpButton.click();

        //9. User clicks Sign Out button

        accountDetailsPage.signOut.click();

        //10. User clicks Log Out link
        accountDetailsPage.logOut.click();

        Assert.assertTrue(accountDetailsPage.signIn.isDisplayed());

        ExtentReportUtils.pass("User completed registration process");

        ExtentReportUtils.flush();

    }

    @Test
    public void testCase02() throws IOException {

        // 1. Go to the https://pearlymarket.com
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));

        //2. User clicks Sign In button
        accountDetailsPage.SignInButton.click();

        //3. User types Email address or Username
        accountDetailsPage.userNameOrEmail.sendKeys(username);

        //4. User types password
        accountDetailsPage.password.sendKeys(password);

        //5. User clicks Sign In Button
        accountDetailsPage.signIn.click();
        ExtentReportUtils.pass("User Signed In the website");

        //6. User clicks My Account link
        WaitUtils.waitFor(2);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", accountDetailsPage.myAccountLink);

        //User see the My Account Page
        Assert.assertTrue(accountDetailsPage.myAccountText.isDisplayed());
        ExtentReportUtils.pass("User entered on My Account Page");
        ExtentReportUtils.passAndCaptureScreenShot("User is on My Account Page");

        ExtentReportUtils.flush();
    }

    @Test
    public void testCase03() throws IOException {

        //1. User clicks Account details link on the My Account Page
        accountDetailsPage.accountDetailsLink.click();

        //2. User should be able to see Account Details page
        Assert.assertEquals(accountDetailsPage.getAccountDetailsText.getText(), "Account Details");
         ExtentReportUtils.pass("User entered Account Details page");
         ExtentReportUtils.passAndCaptureScreenShot("User entered Account Details page");

        WaitUtils.waitFor(5);

        ExtentReportUtils.flush();
    }

    @Test
    public void testCase04() {


//        1. User types other First Name that want to change
        accountDetailsPage.accountFirstName.clear();
        accountDetailsPage.accountFirstName.sendKeys(changedName);
        WaitUtils.waitFor(2);

        //2. User types other Last name that want to change
        accountDetailsPage.accountLastName.clear();
        accountDetailsPage.accountLastName.sendKeys(changedLastName);
        WaitUtils.waitFor(2);

        // 3. User types other display Name that want to change
        accountDetailsPage.accountDisplayName.clear();
        accountDetailsPage.accountDisplayName.sendKeys(changedDisplayName);
        WaitUtils.waitFor(2);

        //  4. User types other Email address that want to change
        accountDetailsPage.accountEmail.clear();
        accountDetailsPage.accountEmail.sendKeys(changedEmail);
        WaitUtils.waitFor(2);
        ExtentReportUtils.pass("User entered First, Last, Display Name and Email");


        // 5. User clicks SAVE CHANGES button
        WaitUtils.waitFor(3);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", accountDetailsPage.saveChangesButton);
        WaitUtils.waitFor(2);


        // 6. User should be able to see Account details changed successfully message
        Assert.assertEquals(accountDetailsPage.changesSuccesfullyMessage.getText(), "Account details changed successfully.");
        WaitUtils.waitFor(3);

        //7. User should be able to see the changed First Name
        Assert.assertEquals(accountDetailsPage.accountFirstName.getAttribute("value"), changedName);

//       8. User should be able to see  the changed Last Name
        Assert.assertEquals(accountDetailsPage.accountLastName.getAttribute("value"), changedLastName);

//      9. User should be able to see  the changed Display Name
        Assert.assertEquals(accountDetailsPage.accountDisplayName.getAttribute("value"), changedDisplayName);

//        10.  User should be able to see the changed Email address
        Assert.assertEquals(accountDetailsPage.accountEmail.getAttribute("value"), changedEmail);

        ExtentReportUtils.pass("User saved First, Last, Display Name and Email");

        ExtentReportUtils.flush();

    }

    @Test
    public void testCase05() {
//   1. User writes some text into the Biography section
        ReusableMethod.switchIframeByWebElement("//iframe[@id='user_description_ifr']");
        accountDetailsPage.biographyTextArea.sendKeys("Welcome to Account Details Page");
        Driver.getDriver().switchTo().defaultContent();
        WaitUtils.waitFor(2);

  //  2. User clicks SAVE CHANGES button
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", accountDetailsPage.saveChangesButton);

//    3. User should be able to see "Account details changed successfully" message
        Assert.assertEquals(accountDetailsPage.changesSuccesfullyMessage.getText(), "Account details changed successfully.");

//    4. User should be able to see "Welcome to Account Details Page" text in the Biography section
        ReusableMethod.switchIframeByWebElement("//iframe[@id='user_description_ifr']");
        Assert.assertTrue(accountDetailsPage.biographyTextArea.getText().contains("Welcome to Account Details Page"));
        ExtentReportUtils.pass("User enter text and saved in Biography section");
        ExtentReportUtils.flush();
    }

    @Test
    public void testCase06() {

//   1. User writes current password
        Driver.getDriver().navigate().refresh();
        WaitUtils.waitFor(5);
        JSUtils.setValueByJS(accountDetailsPage.currentPassword, password);

        // 2. User writes New Password
        JSUtils.setValueByJS(accountDetailsPage.newPassword, newPassword);

//       3. User writes Confirm Password
        JSUtils.setValueByJS(accountDetailsPage.comfirmPassword, newPassword);

//        4. User clicks SAVE CHANGES button
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", accountDetailsPage.saveChangesButton);

//        5.  User should be able to see "Account details changed successfully" message
        Assert.assertEquals(accountDetailsPage.changesSuccesfullyMessage.getText(), "Account details changed successfully.");
        ExtentReportUtils.pass("User was able to change password.");
        ExtentReportUtils.flush();
    }

    @Test
    public void testCase07(){

        //1. User clicks Sign Out button

        accountDetailsPage.signOut.click();

        //2. User clicks Log Out link
        accountDetailsPage.logOut.click();
        WaitUtils.waitForPageToLoad(3);

        //3. User types Email address or Username
        accountDetailsPage.userNameOrEmail.sendKeys(changedEmail);

        //4. User types password
        accountDetailsPage.password.sendKeys(newPassword);

        //5. User clicks Sign In Button
        accountDetailsPage.signIn.click();

        //6. User clicks My Account link
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", accountDetailsPage.myAccountLink);


        //7. User clicks Account details link on the My Account Page
        Driver.getDriver().navigate().refresh();
        WaitUtils.waitFor(5);
        JSUtils.clickWithTimeoutByJS(accountDetailsPage.accountDetailsLink);
        //8. User should be able to see Account Details page
        WaitUtils.waitFor(3);
        Assert.assertEquals(accountDetailsPage.getAccountDetailsText.getText(), "Account Details");
        ExtentReportUtils.pass("User was able to go Account Details Page with New Password and New Username");
        ExtentReportUtils.flush();


   }


}







