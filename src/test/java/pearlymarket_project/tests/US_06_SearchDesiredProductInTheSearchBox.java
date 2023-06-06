package pearlymarket_project.tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pearlymarket_project.pages.PearlyMarketHomePage;
import pearlymarket_project.pages.PearlyMarketSignInPage;
import pearlymarket_project.utilities.ConfigReader;
import pearlymarket_project.utilities.Driver;

public class US_06_SearchDesiredProductInTheSearchBox {


    @BeforeMethod
    public void signIn() throws InterruptedException {

        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketSignInPage pearlyMarketSignInPage = new PearlyMarketSignInPage();

        //Go to the url
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));

        //Click on sign in
        pearlyMarketHomePage.signInHome.click();

        //Enter username or email
        pearlyMarketSignInPage.usernameOrEmail.sendKeys(ConfigReader.getProperty("seyma_email"));

        //Enter password
        pearlyMarketSignInPage.password.sendKeys(ConfigReader.getProperty("seyma_password"));
        Thread.sleep(2000);

        //Click on sign-in
        pearlyMarketSignInPage.signIn.click();

        Thread.sleep(2000);

        //Type a product name on the search box
        pearlyMarketHomePage.searchBox.sendKeys("table"+ Keys.ENTER);






    }

    @Test
    public void test1(){



    }
}
