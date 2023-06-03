package pearlymarket_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pearlymarket_project.utilities.Driver;

public class PearlyMarketRegisterPage {


    public PearlyMarketRegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }



    @FindBy(xpath = "//a[text()='Become a Vendor']")
    public WebElement becomeVendor;
}