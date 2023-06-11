package pearlymarket_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pearlymarket_project.utilities.Driver;

public class PearlyMarketMyAccountPageB {

    public PearlyMarketMyAccountPageB(){
        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(xpath = "//span[@class='icon-box-icon icon-addresses']")
    public WebElement addressesIcon;

    @FindBy(xpath = "//a[@href='https://pearlymarket.com/my-account-2/edit-address/billing/']")
    public WebElement addButton;

    @FindBy(xpath = "//a[@href='https://pearlymarket.com/my-account-2/edit-address/billing/']")
    public WebElement editYourBillingAddress;

}
