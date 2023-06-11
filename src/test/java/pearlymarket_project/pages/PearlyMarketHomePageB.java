package src.test.java.pearlymarket_project.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src.test.java.pearlymarket_project.utilities.Driver;

public class PearlyMarketHomePageB {

    public PearlyMarketHomePageB(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//span[.='Sign In']")
    public WebElement signIn;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='rememberme']")
    public WebElement rememberMeCheckBox;

    @FindBy(xpath = "//button[@value='Sign In']")
    public WebElement signInButton;

    @FindBy(xpath = "//li[@id='menu-item-1079']")
    public WebElement myAccount;











}
