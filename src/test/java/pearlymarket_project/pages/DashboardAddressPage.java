package pearlymarket_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pearlymarket_project.utilities.Driver;

public class DashboardAddressPage {



    public DashboardAddressPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath="//*[text()='Addresses'](1)")
    public WebElement dashboardAddres;
    @FindBy(xpath = "//a[text()='Addresses']")
    public WebElement dashboardAddress;







}
