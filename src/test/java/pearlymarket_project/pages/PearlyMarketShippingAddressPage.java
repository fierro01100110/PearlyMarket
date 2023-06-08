package pearlymarket_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pearlymarket_project.utilities.Driver;

public class PearlyMarketShippingAddressPage {

    public PearlyMarketShippingAddressPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    //Sign Out Button
    @FindBy(xpath= "//span[text()='Sign Out']")
    public WebElement signOut;

    //Addresses Button
    @FindBy(xpath = "//a[text()='Addresses']")
    public WebElement addressesButton;

    //Shipping First Name
    @FindBy(xpath = "//input[@id='shipping_first_name']")
    public WebElement shippingFirstName;

    //Shipping Last Name
    @FindBy(xpath = "//input[@id='shipping_last_name']")
    public WebElement shippingLastName;

    //Shipping Company Name
    @FindBy(xpath = "//input[@id='shipping_company']")
    public WebElement shippingCompanyName;

    //Shipping Country/Region
    @FindBy(xpath = "//span[@id='select2-shipping_country-container']")
    public WebElement shippingCountryRegion;

    //Shipping Street Address
    @FindBy(xpath = "//input[@id='shipping_address_1']")
    public WebElement shippingStreetAddress;

    //Shipping Street Address line 2
    @FindBy(xpath = "//input[@id='shipping_address_2']")
    public WebElement shippingStreetAddressLine2;

    //Shipping Town/City
    @FindBy(xpath = "//input[@id='shipping_city']")
    public WebElement shippingTownCity;

    //Shipping State
    @FindBy(xpath = "//span[@id='select2-shipping_state-container']")
    public WebElement shippingState;

    //Shipping State Veracruz
    @FindBy(xpath = "//span[@id='select2-shipping_state-container']")
    public WebElement shippingStateVeracruz;

    //Shipping Postcode
    @FindBy(xpath = "//input[@id='shipping_postcode']")
    public WebElement shippingPostcode;

    //Save Shipping Address Button
    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement saveShippingAddressButton;

    //Edit Shipping Address Button
    @FindBy(xpath = "(//a[@class='edit btn btn-link btn-primary btn-underline mb-4'])[2]")
    public WebElement editShippingAddressButton;

    //Shipping Country Mexico
    @FindBy(xpath = "//span[@id='select2-shipping_country-container']")
    public WebElement countryMexico;












}