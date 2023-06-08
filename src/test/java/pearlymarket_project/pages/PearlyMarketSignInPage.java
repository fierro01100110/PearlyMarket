package pearlymarket_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pearlymarket_project.tests.positivetests.utilities.Driver;

public class PearlyMarketSignInPage {

    public PearlyMarketSignInPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Username or Email box in to sign in
    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameOrEmail;

    //Password to sign in
    @FindBy(id = "password")
    public WebElement password;

    //Sign In Box after typing username and password
    @FindBy(xpath = "//button[text()='Sign In']")
    public WebElement signIn;


}
