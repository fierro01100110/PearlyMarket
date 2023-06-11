package src.test.java.pearlymarket_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src.test.java.pearlymarket_project.utilities.Driver;

public class ShopPage {


    public ShopPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }


    //Pillow
    @FindBy(xpath = "(//img[@alt='YASTIK KILIFI'])[2]")
    public WebElement yastikKlifi;


    //Pillow Add To cart
    @FindBy(xpath = "(//a[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart'])[1]")
    public WebElement pillowAdd;


    //Cart
    @FindBy(xpath = "(//i[@class='w-icon-cart'])[1]")
    public WebElement cartButton;

    //Shopping Card Display
    @FindBy(xpath = "//h4[text()='Shopping Cart']")
    public WebElement shoppingCard;

    //Shopping Cart Menu ==> Add Cart
    @FindBy(xpath = "//a[text()='Checkout']")
    public WebElement checkout;
}
