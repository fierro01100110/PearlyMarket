package pearlymarket_project.tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pearlymarket_project.pages.PearlyMarketComparisonPage;
import pearlymarket_project.pages.PearlyMarketHomePage;
import pearlymarket_project.utilities.ConfigReader;
import pearlymarket_project.utilities.Driver;
import pearlymarket_project.utilities.ReusableMethod;
import pearlymarket_project.utilities.WaitUtils;

public class US_007_ComparisonBox {

    PearlyMarketComparisonPage pearlyMarketComparisonPage = new PearlyMarketComparisonPage();


    @Test
    public void TC_001(){

        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();

        //Go to the home page
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));
        WaitUtils.waitFor(3);



        //User select a product and Click "compare" button

       //new Actions(Driver.getDriver()).moveToElement(pearlyMarketComparisonPage.quickView).perform();
       // ReusableMethod.hoverOverOnElementActions(pearlyMarketComparisonPage.quickView);







    }
}
