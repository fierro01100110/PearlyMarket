package pearlymarket_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pearlymarket_project.utilities.Driver;



import pearlymarket_project.utilities.Driver;


public class PearlyMarketMyAccountPage {

    public PearlyMarketMyAccountPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }





    //For Addresses
    @FindBy(linkText = "Addresses")
    public WebElement addresses;

    @FindBy(xpath ="//h3[.='Billing address']" )
    public WebElement billingAddress;

    @FindBy(xpath ="(//a[text()='Add'])[1]" )
    public WebElement add;

    @FindBy(xpath ="//input[@id='billing_first_name']" )
    public WebElement firstName;

    @FindBy(xpath ="//input[@name='billing_last_name']" )
    public WebElement lastName;

    @FindBy(xpath ="(//span[@class='select2-selection__placeholder'])[1]" )
    public WebElement countryRegionField;

    @FindBy(xpath ="//li[text()='Canada']" )
    public WebElement Canada;

    @FindBy(xpath ="//input[@id='billing_address_1']" )
    public WebElement streetAddress;

    @FindBy(xpath ="//input[@id='billing_city']" )
    public WebElement townCity;

    @FindBy(xpath ="//span[text()='Select an option…']" )
    public WebElement province;

    @FindBy(xpath ="//li[text()='Alberta']" )
    public WebElement Alberta;

    @FindBy(xpath ="//input[@id='billing_postcode']" )
    public WebElement postalCode;

    @FindBy(xpath ="//input[@id='billing_phone']" )
    public WebElement phone;

    @FindBy(xpath ="//input[@id='billing_email']" )
    public WebElement confirmedEmail;

    @FindBy(xpath ="//button[text()='Save address']" )
    public WebElement saveAddressButton;

    @FindBy(xpath =" (//p['The following addresses will be used on the checkout page by default.'])[1]" )
    public WebElement address_added;

    @FindBy(xpath = "//a[text()='Edit Your Billing Address']")
    public WebElement editYourBillingAddress;




    //Store Manager element
    @FindBy(xpath = "//a[text()='Store Manager']")
    public WebElement storeManager;


    //Products element
    @FindBy(xpath = "(//span[@class='wcfmfa fa-cube'])[1]")
    public WebElement products;

    //Add New when you Hover Over to Products
    //@FindBy(xpath = "//span[@class='wcfm_sub_menu_items wcfm_sub_menu_items_product_manage moz_class']")
    //public WebElement addNewProducts;
    @FindBy(xpath = "//span[text()='Add New']")
    public WebElement addNewProducts;

}
