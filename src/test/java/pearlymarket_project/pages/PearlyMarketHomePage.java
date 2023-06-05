package pearlymarket_project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pearlymarket_project.utilities.Driver;

public class PearlyMarketHomePage {


    public PearlyMarketHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(xpath = "//span[text()='Register']")
    public WebElement register;
    @FindBy(xpath = "//input[@id='reg_username']")
    public WebElement usernameBox;
    @FindBy(xpath = "//input[@id='reg_email']")
    public WebElement emailBox;
    @FindBy(xpath = "//input[@id='reg_password']")
    public WebElement passwordBox;
    @FindBy(xpath = "//input[@id='register-policy']")
    public WebElement confirmBox;
    @FindBy(xpath = "//button[text()='Sign Up']")
    public WebElement signUpButton;
    @FindBy(xpath = "//p[text()='An account is already registered with that username. Please choose another.']")
    public WebElement usernameErrorMessage;
    @FindBy(xpath = "//p[text()='An account is already registered with your email address. ']")
    public WebElement existingCredentialsErrorMessage;
    @FindBy(xpath = "//p[text()='An account is already registered with your email address. ']")
    public WebElement existingEmailErrorMessage;
    @FindBy(xpath = "(//div//small)[1]")
    public WebElement weakPswMessage;


}
