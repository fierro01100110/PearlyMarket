package pearlymarket_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pearlymarket_project.utilities.Driver;

public class PearlyMarketMyStorePage {

    public PearlyMarketMyStorePage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "gallery_img_gimage_0_display")
    public WebElement photo;
    @FindBy(xpath = "//select[@id='product_type']")
    public WebElement productType;


    @FindBy(xpath = "//input[@id='is_virtual']")
    public WebElement virtualBox;
    @FindBy(xpath = "//input[@id='pro_title']")
    public WebElement productTitle;


    //Iframe of send key to short describtion
    @FindBy(xpath = "//iframe[@id='excerpt_ifr']")
    public WebElement iframeSd;

    //Iframe of send key to Description
    @FindBy(xpath = "//iframe[@id='description_ifr']")
    public WebElement iframeD;

   //first iframe short discription box
    @FindBy(xpath = "//body[@data-id='excerpt']")
    public WebElement shortDescription;

    //secinf iframe description box
    @FindBy(xpath = "//body[@data-id='description']")
    public WebElement description;

    @FindBy(xpath = "//input[@value='428']")
    public WebElement categories;

    //add new categories
    @FindBy(xpath = "//p[text()='+Add new category']")
    public WebElement addnewCategories;

    //category name
    @FindBy(xpath = "//input[@id='wcfm_new_cat']")
    public WebElement categoryName;
    //PARENT CATEGORY
    @FindBy(xpath = "//select[@id='wcfm_new_parent_cat']")
    public WebElement parentCategory;

    @FindBy(xpath = "//p[text()='+Add new Product brands']")
    public WebElement addNewProductBrand;

    //new product brand
    @FindBy(xpath = "//input[@id='wcfm_new_product_brand']")
    public WebElement productBrandsName;
    //dropdow for parent taxonomy
    @FindBy(xpath = "//select[@id='wcfm_new_parent_product_brand']")
    public WebElement parentTaxonomy;


}
