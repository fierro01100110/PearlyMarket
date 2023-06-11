package pearlymarket_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pearlymarket_project.utilities.Driver;

import java.util.List;

public class BillingDetailsPage {
    public BillingDetailsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    //First name box
    @FindBy(xpath = "//input[@name='billing_first_name']")
    public WebElement billingFirstName;


    //Last name box
    @FindBy(xpath = "//input[@name='billing_last_name']")
    public WebElement billingLastName;

    //Country box
    @FindBy(xpath = "//span[@id='select2-billing_country-container']")
    public WebElement countryBox;


    //Country Options
    @FindBy(xpath = "//ul[@id='select2-billing_country-results']")
    public List<WebElement> allCountries;

    //Address
    @FindBy(xpath = "//input[@id='billing_address_1']")
    public WebElement billingAddress;

    //City
    @FindBy(xpath = "//input[@id='billing_city']")
    public WebElement billingCity;

    //Province
    @FindBy(xpath = "//span[@id='select2-billing_state-container']")
    public WebElement billingState;



    //Province List
    @FindBy(xpath = "//ul[@id='select2-billing_state-results']")
    public List<WebElement> allProvince;
}
