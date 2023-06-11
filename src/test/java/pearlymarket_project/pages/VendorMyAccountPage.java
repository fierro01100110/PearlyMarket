package src.test.java.pearlymarket_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src.test.java.pearlymarket_project.utilities.Driver;

public class VendorMyAccountPage {

    public VendorMyAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;
    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;
    @FindBy(xpath = "//*[@name='login']")
    public WebElement signIn;






}
