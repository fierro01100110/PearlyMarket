package src.test.java.pearlymarket_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src.test.java.pearlymarket_project.utilities.Driver;

public class PearlyMarketRegisterPage {

    public PearlyMarketRegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()='Become a Vendor']")
    public WebElement becomeVendor;

    @FindBy(xpath = "//span[text()='Sign Out']")
    public WebElement successfulRegister ;

    //username
    @FindBy(xpath = "//input[@id='reg_username']")
    public WebElement nameBox;

    //email
    @FindBy(xpath = "(//input[@name='email'])[1]")
    public WebElement emailBox;

    //password
    @FindBy(xpath = "(//input[@name='password'])[1]")
    public WebElement passwordBox;

    //checkbox
    @FindBy(xpath = "(//input[@id='register-policy'])[1]")
    public WebElement checkBox;

    //confirmBox
    @FindBy(xpath = "//input[@id='register-policy']")
    public WebElement confirmBox;

    //sing-up
    @FindBy(xpath = "(//button[@name='register'])[1]")
    public WebElement signUpButton;

    //usernameBox
    @FindBy(xpath = "//input[@id='reg_username']")
    public WebElement usernameBox;
}
