package pearlymarket_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pearlymarket_project.utilities.Driver;

public class PearlyMarketMyAccountPage {

    public PearlyMarketMyAccountPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }


    //Store Manager element
    @FindBy(xpath = "//a[text()='Store Manager']")
    public WebElement storeManager;


    //Products element
    @FindBy(xpath = "(//span[@class='wcfmfa fa-cube'])[1]")
    public WebElement products;

    //Add New when you Hover Over to Products
    @FindBy(xpath = "//span[text()='Add New']")
    public WebElement addNewProducts;
}
