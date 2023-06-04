package pearlymarket_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pearlymarket_project.utilities.Driver;

public class PearlyMarketVendorRegistrationPage {
    public PearlyMarketVendorRegistrationPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    //For email box
    @FindBy(xpath = "//input[@name='user_email']")
    public WebElement email;


    //For email verification
    @FindBy(xpath = "//input[@name='wcfm_email_verified_input']")
    public WebElement emailVerification;



    //For password
    @FindBy(xpath = "//input[@name='passoword']")
    public WebElement password;


    //Confirm password
    @FindBy(xpath = "//input[@id='confirm_pwd']")
    public WebElement confirmPassword;


    //For register button
    @FindBy(xpath = "//input[@value='Register']")
    public WebElement registerButton;


}
