package pearlymarket_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pearlymarket_project.utilities.Driver;

public class PearlyMarketVendorMyAccountPage {

    public PearlyMarketVendorMyAccountPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
    // For Vendor page sign out
    @FindBy(xpath = "//span[text()='Sign Out']")
    public WebElement signOut;

    // For Vendor My Account
    @FindBy(xpath = "//h2[text()='My Account']")
    public WebElement myAccount;

    // Dashboard elements are visible
    // For Store Manager
    @FindBy(xpath = "//a[text()='Store Manager']")
    public WebElement storeManager;

    // For Orders
    @FindBy(xpath = "//a[text()='Orders']")
    public WebElement orders;

    // For Downloads
    @FindBy(xpath = "//a[text()='Downloads']")
    public WebElement downloads;

    // For Addresses
    @FindBy(xpath = "//a[text()='Addresses']")
    public WebElement addresses;

    // For Account details
    @FindBy(xpath = "//a[text()='Account details']")
    public WebElement accountDetails;

    // For Wishlist
    @FindBy(xpath = "(//a[text()='Wishlist'])[1]")
    public WebElement wishlist;

    // For Support tickets
    @FindBy(xpath = "//a[text()='Support Tickets']")
    public WebElement supportTickets;

    // For Followings
    @FindBy(xpath = "//a[text()='Followings']")
    public WebElement followings;

    // For Log out
    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logout;


    //myAccount1
    @FindBy(xpath = "(//*[text()='My Account'])[2]")
    public WebElement myAccount1;


}
