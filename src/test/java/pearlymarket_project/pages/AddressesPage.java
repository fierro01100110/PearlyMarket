package pearlymarket_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pearlymarket_project.utilities.Driver;

public class AddressesPage {


    public AddressesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath="//*[text()='Shipping address']")
    public WebElement textShippingaddress;
    @FindBy(xpath="//*[text()='Edit Your Shipping Address']")
    public WebElement EditYourShippingAddress;







}
