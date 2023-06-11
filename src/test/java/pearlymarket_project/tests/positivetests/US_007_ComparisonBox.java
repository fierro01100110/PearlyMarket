package src.test.java.pearlymarket_project.tests.positivetests;
import org.testng.annotations.Test;
import src.test.java.pearlymarket_project.pages.PearlyMarketComparisonPage;
import src.test.java.pearlymarket_project.pages.PearlyMarketHomePage;
import src.test.java.pearlymarket_project.pages.PearlyMarketSignInPage;
import src.test.java.pearlymarket_project.utilities.*;

public class US_007_ComparisonBox {


    PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
    PearlyMarketComparisonPage pearlyMarketComparisonPage = new PearlyMarketComparisonPage();
    PearlyMarketSignInPage pearlyMarketSignInPage = new PearlyMarketSignInPage();




    @Test
    public void TC_001(){
        ExtentReportUtils.info("The test starts");


        //Go to the home page
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));

        //Sign In
        pearlyMarketComparisonPage.signIn.click();
        WaitUtils.waitFor(3);

        pearlyMarketComparisonPage.username.sendKeys("vanilla");
        pearlyMarketComparisonPage.password.sendKeys("12345");
        pearlyMarketComparisonPage.signInSubmit.click();
        WaitUtils.waitFor(3);


        //User select a product and click compare button
        ReusableMethod.scrollDownActions();
        WaitUtils.waitFor(2);
        ReusableMethod.hoverOverOnElementActions(pearlyMarketComparisonPage.Product1);
        WaitUtils.waitFor(2);
        pearlyMarketComparisonPage.Product1.click();
        WaitUtils.waitFor(3);
        pearlyMarketComparisonPage.comparisonButton1.click();
        WaitUtils.waitFor(2);

        //User goes to home page
        pearlyMarketComparisonPage.clickAnEmptySpot.click();
        JSUtils.clickWithTimeoutByJS(pearlyMarketComparisonPage.clickBackToHomePage);
        ReusableMethod.arrowDownActions();

        //User select a product and click compare button
        ReusableMethod.scrollDownActions();
        WaitUtils.waitFor(2);
        ReusableMethod.hoverOverOnElementActions(pearlyMarketComparisonPage.Product2);
        WaitUtils.waitFor(2);
        pearlyMarketComparisonPage.Product2.click();
        WaitUtils.waitFor(3);
        pearlyMarketComparisonPage.comparisonButton2.click();
        WaitUtils.waitFor(2);

        //User goes to home page
        pearlyMarketComparisonPage.clickAnEmptySpot.click();
        JSUtils.clickWithTimeoutByJS(pearlyMarketComparisonPage.clickBackToHomePage);
        ReusableMethod.arrowDownActions();

        //User select a product and click compare button
        ReusableMethod.scrollDownActions();
        WaitUtils.waitFor(2);
        ReusableMethod.hoverOverOnElementActions(pearlyMarketComparisonPage.Product3);
        WaitUtils.waitFor(2);
        pearlyMarketComparisonPage.Product3.click();
        WaitUtils.waitFor(2);
        pearlyMarketComparisonPage.comparisonButton3.click();
        WaitUtils.waitFor(2);

        //User goes to home page
        pearlyMarketComparisonPage.clickAnEmptySpot.click();
        JSUtils.clickWithTimeoutByJS(pearlyMarketComparisonPage.clickBackToHomePage);
        ReusableMethod.arrowDownActions();

        //User select a product and click compare button
        ReusableMethod.scrollDownActions();
        WaitUtils.waitFor(2);
        ReusableMethod.hoverOverOnElementActions(pearlyMarketComparisonPage.Product4);
        WaitUtils.waitFor(2);
        pearlyMarketComparisonPage.Product4.click();
        WaitUtils.waitFor(2);
        pearlyMarketComparisonPage.comparisonButton4.click();
        WaitUtils.waitFor(2);

        ExtentReportUtils.pass("Four products add into comparison bar");
        ExtentReportUtils.flush();


    }



    @Test
    public void TC_002(){

        ExtentReportUtils.info("The test starts");
//        User clicks the x(remove) button to remove one of the selected product from comparison box
        ReusableMethod.clickWithTimeOut(pearlyMarketComparisonPage.removeProduct1, 3);

        WaitUtils.waitFor(3);


//        User goes home page
        ReusableMethod.clickWithTimeOut( pearlyMarketComparisonPage.clickAnEmptySpot, 3);
        WaitUtils.waitFor(2);
        ReusableMethod.clickWithTimeOut(pearlyMarketComparisonPage.clickBackToHomePage, 3);
        WaitUtils.waitFor(3);

//        3- User selects another product and click on "compare" button
        ReusableMethod.clickWithTimeOut(pearlyMarketComparisonPage.Product5, 3);
        WaitUtils.waitFor(3);
        pearlyMarketComparisonPage.comparisonbutton5.click();

        ExtentReportUtils.pass("First product removed and another product added");
        ExtentReportUtils.flush();



    }



    @Test
    public void TC_003() throws InterruptedException {
        ExtentReportUtils.info("The test starts");

        //User clicks "Start Compare" button

        ReusableMethod.clickWithTimeOut(pearlyMarketComparisonPage.startCompare, 3);
     Thread.sleep(3000);

        Driver.getDriver().navigate().back();

        WaitUtils.waitFor(2);

        pearlyMarketComparisonPage.comparisonbutton5.click();

        ReusableMethod.clickWithTimeOut(pearlyMarketComparisonPage.cleanAllButton1, 3);


        ExtentReportUtils.pass("All products compared and then deleted");
        ExtentReportUtils.flush();

    }






}
