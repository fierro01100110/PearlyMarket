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



}
