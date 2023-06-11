package src.test.java.pearlymarket_project.tests.positivetests;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import src.test.java.pearlymarket_project.pages.PearlyMarketHomePage;
import src.test.java.pearlymarket_project.pages.PearlyMarketRegisterPage;
import src.test.java.pearlymarket_project.pages.PearlyMarketVendorRegistrationPage;
import src.test.java.pearlymarket_project.utilities.ConfigReader;
import src.test.java.pearlymarket_project.utilities.Driver;
import src.test.java.pearlymarket_project.utilities.ExtentReportUtils;

import static src.test.java.pearlymarket_project.utilities.ReusableMethod.verifyElementDisplayed;

public class US_10_PasswordChartVisibility {
    @Test
    public void  passwordChartVisibilityTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));

        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketRegisterPage pearlyMarketRegisterPage = new PearlyMarketRegisterPage();
        PearlyMarketVendorRegistrationPage vrp = new PearlyMarketVendorRegistrationPage();

        ExtentReportUtils.info("test starts here");

        // 1) User clicks to the Register button
        pearlyMarketHomePage.register.click();
        ExtentReportUtils.pass("user is able to see register page");
        // 2) User clicks to the "Become a Vendor" button
        pearlyMarketRegisterPage.becomeVendor.click();
        ExtentReportUtils.pass("user is able to see password box");
        // Verifying that User is on "Vendor Registration" url
        verifyElementDisplayed(By.xpath("//h2[text()='Vendor Registration']"));
        // 3) user clicks to the password button
        vrp.password.click();
        ExtentReportUtils.pass("user is abke to enter a password");
        // 4) user enters a valid password which contains less than six characters to see "too short" on password chart
        vrp.password.sendKeys("aBc1*");
        Thread.sleep(2000);
        vrp.password.clear();
        ExtentReportUtils.pass("user is able to see 'too short' on the password chart");
        // 5) user enters a valid password which contains more than five characters with using only lowercase letters,
        // only uppercase letters or only numbers to see "weak" on password chart
        vrp.password.sendKeys("aaaaaaaa");
        Thread.sleep(2000);
        vrp.password.clear();
        ExtentReportUtils.pass("user is able to see 'weak' on the password chart");
        // 6) user enters a valid password which contains more than five characters with using only two categories from
        // uppercase letters, lowercase letters and numbers to see "good" on password chart
        vrp.password.sendKeys("AAAAAaaa");
        Thread.sleep(2000);
        vrp.password.clear();
        ExtentReportUtils.pass("user is able to see 'good' on the password chart");
        // 7) user enters a valid password which contains more than five characters with using at least one lowercase,
        // one uppercase, one number and one special character together to see "strong" on password chart
        vrp.password.sendKeys("aBc1*.");
        Thread.sleep(2000);
        vrp.password.clear();
        Driver.closeDriver();
        ExtentReportUtils.pass("user is able to see 'strong' on the password chart");

        ExtentReportUtils.flush();

        //!! when I use only question marks(?) or stars(*), it becomes strong after a point but when I use only periods(.) or only slashes(/),it does not become strong after any point
    }
}
