package pearlymarket_project.tests.positivetests;

import org.testng.annotations.Test;
import pearlymarket_project.pages.*;
import pearlymarket_project.utilities.ConfigReader;
import pearlymarket_project.utilities.Driver;
import pearlymarket_project.utilities.ReusableMethod;

public class US_13_VendorShippingAddress {


    @Test
    public void vendorShipping() {
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));
        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        VendorMyAccountPage vendorMyAccountPage = new VendorMyAccountPage();
        ReusableMethod.clickWithTimeOut(pearlyMarketHomePage.myAccount, 3);
        vendorMyAccountPage.username.sendKeys("Gul Neva");
        vendorMyAccountPage.password.sendKeys("ranataha3319");
        ReusableMethod.clickWithTimeOut(vendorMyAccountPage.signIn, 3);
        DashboardAddressPage dashboardAddressesPage=new DashboardAddressPage();
        dashboardAddressesPage.dashboardAddress.click();
        AddressesPage addressesPage=new AddressesPage();
        addressesPage.EditYourShippingAddress.click();
        VendorShippingAdressPage vendorShippingAdressPage=new VendorShippingAdressPage();
        ReusableMethod.sendKeysWithTimeout( vendorShippingAdressPage.vendorFirstName,ConfigReader.getProperty("vendorfirstname"),6);
        ReusableMethod.sendKeysWithTimeout(vendorShippingAdressPage.vendorLastName,ConfigReader.getProperty("vendorlastName"),6);
        ReusableMethod.sendKeysWithTimeout(vendorShippingAdressPage.vendorCountry,ConfigReader.getProperty("vendorCountry"),6);
        ReusableMethod.sendKeysWithTimeout(vendorShippingAdressPage.vendorStreetAddress,ConfigReader.getProperty("vendorStreetAdress"),6);
        ReusableMethod.sendKeysWithTimeout(vendorShippingAdressPage.vendorCity,ConfigReader.getProperty("vendorCity"),6);
        ReusableMethod.sendKeysWithTimeout(vendorShippingAdressPage.vendorProvince,ConfigReader.getProperty("vendorProvince"),6);
        ReusableMethod.sendKeysWithTimeout(vendorShippingAdressPage.vendorPostalCode,ConfigReader.getProperty("vendorPostalCode"),6);
        ReusableMethod.clickWithTimeOut(vendorShippingAdressPage.saveAddress,3);
    }









}
