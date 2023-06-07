package pearlymarket_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pearlymarket_project.utilities.Driver;

public class PearlyMarketSearchingProductsPage {

    public PearlyMarketSearchingProductsPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    //The unrelated product
    @FindBy(linkText = "Comfortable Backpack")
    public WebElement unrelatedProduct;

    //The product that will be added to the cart
    @FindBy(linkText = "Food Table")
    public WebElement selectProductToAddToCart;

    //ADD TO CART button in chosen item
    @FindBy(xpath = "//button[text()='Add to cart']")
    public WebElement addToCartButton;

    //Number on cart icon
    @FindBy(xpath = "(//span[@class='cart-count'])[1]")
    public WebElement numberOnCartIcon;

    //View Cart button after clicking on cart icon
    @FindBy(xpath = "//a[.='View cart']")
    public WebElement viewCartButton;


}
