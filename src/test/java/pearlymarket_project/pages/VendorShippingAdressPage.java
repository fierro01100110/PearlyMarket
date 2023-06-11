package src.test.java.pearlymarket_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src.test.java.pearlymarket_project.utilities.Driver;

public class VendorShippingAdressPage {


    public VendorShippingAdressPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath="//input[@name='shipping_first_name']")
    public WebElement vendorFirstName;
    @FindBy(xpath="//input[@name='shipping_last_name']")
    public WebElement vendorLastName;
    @FindBy(xpath="//span[@role='textbox'[1]]")
    public WebElement vendorCountry;
    @FindBy(xpath="//input[@name='shipping_address_1']")
    public WebElement  vendorStreetAddress ;
    @FindBy(xpath="//input[@name='shipping_city']")
    public WebElement vendorCity;
    @FindBy(xpath="//span[@id='select2-shipping_state-container']")
    public WebElement vendorProvince;
    @FindBy(xpath="//input[@name='shipping_postcode']")
    public WebElement  vendorPostalCode;
    @FindBy(xpath="//button[@name='save_address']")
    public WebElement saveAddress;






}
