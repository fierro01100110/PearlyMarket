package src.test.java.pearlymarket_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src.test.java.pearlymarket_project.utilities.Driver;



public class PearlyMarketComparisonPage {

    public PearlyMarketComparisonPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

//SIGN IN
    @FindBy(xpath = "//span[.='Sign In']")
    public WebElement signIn;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@value='Sign In']")
    public WebElement signInSubmit;


    @FindBy(xpath = "(//button[@title='Quick View'])[1]")
    public WebElement quickView;


//SELECTING PRODUCT BUTTON
    @FindBy(xpath = "(//a[.='Blue Ski Boots'])[1]")
    public WebElement Product1;

    @FindBy(xpath = "//a[.='Black Winter Skating']")
    public WebElement Product2;

    @FindBy(xpath = "(//a[.='Kitchen Table'])[1]")
    public WebElement Product3;

    @FindBy(xpath = "(//a[.='Home Sofa'])[1]")
    public WebElement Product4;

    @FindBy(xpath = "(//a[.='HD Television'])[1]")
    public WebElement Product5;




// COMPARISON BUTTONS
    @FindBy(xpath = "//*[@class='compare btn-product-icon'][@data-product_id='13202']")
    public WebElement comparisonButton1;

    @FindBy(xpath = "//*[@class='compare btn-product-icon'][@data-product_id='13178']")
    public WebElement comparisonButton2;

    @FindBy(xpath = "//*[@class='compare btn-product-icon'][@data-product_id='13193']")
    public WebElement comparisonButton3;


    @FindBy(xpath = "//*[@class='compare btn-product-icon'][@data-product_id='13192']")
    public WebElement comparisonButton4;

    @FindBy(xpath = "//*[@data-product_id='13186'][@class='compare btn-product-icon']")
    public WebElement comparisonbutton5;





//GOING BACK TO HOME PAGE

    @FindBy(xpath = "//div[@class='compare-popup-overlay']")
    public WebElement clickAnEmptySpot;

    @FindBy(xpath =  "(//a[@title='Pearly Market - Pearly Market'])[1]")
    public WebElement clickBackToHomePage;






//REMOVE PRODUCT
    @FindBy(xpath="//a[@class='btn-remove remove_from_compare fas fa-times']")
    public WebElement removeProduct1;


   @FindBy(xpath = "//mark[.=\'3\']")
    public  WebElement total3Product;


//START COMPARE BUTTON
    @FindBy(xpath = "//a[.='Start Compare !']")
    public WebElement clickStartCompare;

    @FindBy(xpath = "//div[@data-id='bc2148c']")
    public WebElement startCompareButton;

    @FindBy(xpath = "//*[text()='Start Compare !']")
    public WebElement startCompareButton1;

//Start compare button
    @FindBy(xpath = "//a[text()='Start Compare !']")
    public WebElement startCompare;


//DELETE ALL BUTTON

    @FindBy(xpath = "//a[.='Clean All']")
    public WebElement cleanAllButton;

    @FindBy(xpath = "//a[@class='compare-clean']")
    public WebElement cleanAllButton1;



}

