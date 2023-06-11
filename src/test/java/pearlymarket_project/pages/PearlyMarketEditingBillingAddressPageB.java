package src.test.java.pearlymarket_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src.test.java.pearlymarket_project.utilities.Driver;
import java.util.List;


public class PearlyMarketEditingBillingAddressPageB {

    public PearlyMarketEditingBillingAddressPageB(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//input[@name='billing_first_name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='billing_last_name']")
    public WebElement lastName;

    @FindBy(xpath ="//input[@name='billing_company']" )
    public WebElement companyName;

    @FindBy(xpath = "//select[@name='billing_country']")
    public WebElement countryRegion;

    @FindBy(xpath = "//input[@id='billing_address_1']" )
    public WebElement streetAddress;

    @FindBy(xpath = "//input[@name='billing_city']")
    public WebElement townCity;

    @FindBy(xpath = "//input[@name='billing_state']")
    public WebElement stateCountry;

    //Click states button
    @FindBy(xpath = "(//span[@class='select2-selection__arrow'])[2]")
    public WebElement statesButton;

    //Get all States
    @FindBy(xpath = "//ul[@class='select2-results__options']")
    public List<WebElement> allStates;

    @FindBy(xpath = "//input[@name='billing_phone']")
    public WebElement phone;

    @FindBy(xpath = "//input[@name='billing_postcode']")
    public WebElement zipCode;

    @FindBy(xpath = "//input[@name='billing_email']")
    public WebElement emailAddress;

    @FindBy(xpath = "//button[@name='save_address']")
    public WebElement saveAddressButton;





}
