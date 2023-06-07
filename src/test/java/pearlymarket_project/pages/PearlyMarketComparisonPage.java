package pearlymarket_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pearlymarket_project.utilities.Driver;

public class PearlyMarketComparisonPage {

    public PearlyMarketComparisonPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "(//button[@title='Quick View'])[1]")
    public WebElement quickView;

    @FindBy(xpath = "(//button[@data-product='13178']")
    public WebElement compareProduct;


    }

