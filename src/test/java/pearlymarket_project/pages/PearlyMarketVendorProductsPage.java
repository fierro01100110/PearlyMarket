package pearlymarket_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pearlymarket_project.utilities.Driver;

public class PearlyMarketVendorProductsPage {

    public PearlyMarketVendorProductsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Inventory element
    @FindBy(xpath = "//*[text()='Inventory']")
    public WebElement inventory;

    //Shipping element
    @FindBy(xpath = "//*[text()='Shipping']")
    public WebElement shipping;

    //Attributes element
    @FindBy(xpath = "(//*[text()='Attributes'])[1]")
    public WebElement attributes;

    //Linked element
    @FindBy(xpath = "//*[text()='Linked']")
    public WebElement linked;

    //SEO element NOT RECOMMENDED XPATH!!!!
    @FindBy(xpath = "/html/body/div[1]/main/div/div/div/div/div/div[2]/div[2]/form/div[3]/div[1]/div[22]/div/text()")
    public WebElement seoNotRecommended;

    //Seo element
    @FindBy(xpath = "(//div[@class='page_collapsible_content_holder'])[8]")
    public WebElement seo;

    //Advanced element
    @FindBy(xpath = "//*[text()='Advanced']")
    public WebElement advanced;

    //SKU==>SKU Box element
    @FindBy(xpath = "//input[@id='sku']")
    public WebElement skuBox;

    //SKU==>Manage Stock
    @FindBy(xpath = "//input[@name='manage_stock']")
    public WebElement manageStock;

    //SKU==>Stock QTY
    @FindBy(xpath = "//input[@id='stock_qty']")
    public WebElement stockQty;

    //SKU==>Back Orders box
    @FindBy(xpath = "//select[@id='backorders']")
    public WebElement backOrders;

    //SKU==>Solid Individuality box
    @FindBy(xpath = "//input[@id='sold_individually']")
    public WebElement solidIndividuality;

    //SKU==>Stock Status
    @FindBy(xpath = "//select[@id='stock_status']")
    public WebElement stockStatus;

    //Shipping==> Weight box
    @FindBy(xpath = "//input[@name='weight']")
    public WebElement weightBox;

    //Shipping==> Length
    @FindBy(xpath = "//input[@name='length']")
    public WebElement lengthBox;

    //Shipping==> Width
    @FindBy(xpath = "//input[@name='width']")
    public WebElement widthBox;

    //Shipping==> Height
    @FindBy(xpath = "//input[@name='height']")
    public WebElement heightBox;

    //Shipping==> Shipping Class
    @FindBy(xpath = "//select[@id='shipping_class']")
    public WebElement shippingClassBox;

    //Shipping==> Precessing Time
    @FindBy(xpath = "//select[@id='_wcfmmp_processing_time']")
    public WebElement processingTimeBox;

    //Attributes==>Color box
    @FindBy(xpath = "//input[@id='attributes_is_active_1']")
    public WebElement colorBox;

    //Attributes==>Size box
    @FindBy(xpath = "//input[@id='attributes_is_active_2']")
    public WebElement sizeBox;


    //Attributes==>Size Whole Box
    @FindBy(xpath = "//div[@class='multi_input_block wcfm_attributes_blocks wcfm_defined_attributes wcfm_attributes_block_pa_size ui-sortable-handle']")
    public WebElement sizeWholeBox;

    //Attributes==>Color Whole Box
    @FindBy(xpath = "//div[@class='multi_input_block wcfm_attributes_blocks wcfm_defined_attributes wcfm_attributes_block_pa_color ui-sortable-handle']")
    public WebElement colorWholeBox;

}
