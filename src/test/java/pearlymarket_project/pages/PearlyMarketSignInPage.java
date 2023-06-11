package src.test.java.pearlymarket_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src.test.java.pearlymarket_project.utilities.Driver;

public class PearlyMarketSignInPage {

    public PearlyMarketSignInPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameOrEmail;

    @FindBy(id = "password")
    public WebElement password;

    //Username or Email box in to sign in


    //Password to sign in

    //Sign In Box after typing username and password
    @FindBy(xpath = "//button[text()='Sign In']")
    public WebElement signIn;


}
