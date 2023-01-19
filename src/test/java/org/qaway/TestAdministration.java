package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.AdminAreaDemoPage;
import org.qaway.pages.AdminLoginPage;
import org.qaway.pages.HomePage;
import org.qaway.pages.HomePagePlateforme;
import org.qaway.utility.ExcelReader;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class TestAdministration extends CommonAPI {


    ExcelReader excelReader = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data");
    Logger LOG = LogManager.getLogger(TestAdministration.class.getName());
    String son = prop.getProperty("switch.son");
    String sonSon = prop.getProperty("switch.son.son");

    String mail = prop.getProperty("new.mail");
    String password = prop.getProperty("new.password");
    String name = prop.getProperty("name");
    String male = prop.getProperty("radio.val");
    String role = prop.getProperty("role");
    String val1 = prop.getProperty("checkbox1");
    String val2 = prop.getProperty("checkbox2");
    String val3 = prop.getProperty("checkbox3");

    @Test
    public void switchToECommercePlatform(){

        HomePage homePage = new HomePage(driver);
        HomePagePlateforme homePagePlateforme = new HomePagePlateforme(driver);
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        Assert.assertTrue(homePage.PlatformIsDisplayed());
        LOG.info("Platform Is Displayed");
        homePage.clickOnByNopCommerce();
        LOG.info("click on NopCommerce success");
        System.out.println(son);
        waitFor(3);
        homePagePlateforme.switchToWindowSon(driver,son);
        LOG.info("switch To Window Son success");
        List<Boolean> section = homePagePlateforme.sectionIsDisplayed();
        for (Boolean sectionIsDisplayed:section){
            Assert.assertTrue(sectionIsDisplayed);


        }
        LOG.info("Six section Is Displayed");
        String getPlatformText = homePagePlateforme.getPlatformText();
        Assert.assertEquals(excelReader.getDataForGivenHeaderAndKey("key", "Platform commerce"), getPlatformText);
        LOG.info("Platform validation success");


        homePagePlateforme.clickBtnDemo();
        LOG.info("click on DEMO success");
        homePagePlateforme.clickBtnAdmin();
        LOG.info("click on button admin success");
        waitFor(3);
        homePagePlateforme.switchToWindowSon(driver,sonSon);
        LOG.info("switch To Window Son 2 success");
        String getTitleAdminLogin = adminLoginPage.getTitleLoginAdmin();
        Assert.assertEquals(excelReader.getDataForGivenHeaderAndKey("key", "title admin"), getTitleAdminLogin);
        LOG.info("get Title Admin Login  success");

    }
    @Test
    public void addNewAdministrator(){
        HomePage homePage = new HomePage(driver);
        HomePagePlateforme homePagePlateforme = new HomePagePlateforme(driver);
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        AdminAreaDemoPage adminAreaDemoPage = new AdminAreaDemoPage(driver);

        homePage.clickOnByNopCommerce();
        homePagePlateforme.swishToLoginAdmin(driver ,son,sonSon);

        //login
        adminLoginPage.login();
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login admin title");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title login validation success");
        waitFor(3);
        adminAreaDemoPage.ClickRegisteredCustomer(driver);
        LOG.info("Click Registered Customer success");
        adminAreaDemoPage.ClickAddNew(driver);
        LOG.info("Click add new Registered Customer success");

        adminAreaDemoPage.typeNewMail(mail);
        LOG.info("type mail success");
        adminAreaDemoPage.typeNewPassword(password);
        LOG.info("type password success");
        adminAreaDemoPage.typeNewName(name);
        LOG.info("type name success");
        homePage.clickRadioButton(male);
        LOG.info("click radio male success");
        waitFor(3);
        adminAreaDemoPage.clickRoles();
        LOG.info("click roles success");
        waitFor(3);
        adminAreaDemoPage.clickChoixAdministrators(driver);
        LOG.info("choix administrators success");
        adminAreaDemoPage.selectVendor(driver);
        adminAreaDemoPage.clickSave();
        LOG.info("click success");


    }
    @Test(dependsOnMethods = {"addNewAdministrator"})
    public void checkNewAdministrator(){
        HomePage homePage = new HomePage(driver);
        HomePagePlateforme homePagePlateforme = new HomePagePlateforme(driver);
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        AdminAreaDemoPage adminAreaDemoPage = new AdminAreaDemoPage(driver);

        homePage.clickOnByNopCommerce();
        homePagePlateforme.swishToLoginAdmin(driver ,son,sonSon);

        //login
        adminLoginPage.login();
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login admin title");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title login validation success");
        adminAreaDemoPage.ClickRegisteredCustomer(driver);
        LOG.info("Click Registered Customer success");

        Assert.assertTrue(adminAreaDemoPage.checkMailValidate(mail));
        LOG.info("check mail validate success");
        waitFor(10);
        Assert.assertTrue(adminAreaDemoPage.checkNameValidate(name));
        LOG.info("check name validate success");
        Assert.assertTrue(adminAreaDemoPage.checkRolesValidate(role));
        LOG.info("check roles validate success");


    }

    @Test
    public void downloadOrder(){
        HomePage homePage = new HomePage(driver);
        HomePagePlateforme homePagePlateforme = new HomePagePlateforme(driver);
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        AdminAreaDemoPage adminAreaDemoPage = new AdminAreaDemoPage(driver);

        homePage.clickOnByNopCommerce();
        homePagePlateforme.swishToLoginAdmin(driver ,son,sonSon);

        //login
        adminLoginPage.login();
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login admin title");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title login validation success");

        adminAreaDemoPage.clickSales();
        LOG.info("click sales success");
        adminAreaDemoPage.clickOrders();
        LOG.info("click orders success");
        adminAreaDemoPage.clickCheckboxButton(val1,val2,val3);
        LOG.info("check Box success");
        Assert.assertTrue(adminAreaDemoPage.checkboxIsSelected(val1));
        LOG.info("check Box 1 is selected success");
        Assert.assertTrue(adminAreaDemoPage.checkboxIsSelected(val2));
        LOG.info("check Box 2 is selected success");
        Assert.assertTrue(adminAreaDemoPage.checkboxIsSelected(val3));
        LOG.info("check Box 3 is selected success");

        Assert.assertTrue(adminAreaDemoPage.setBtnDownloadIsDisplayed());
        LOG.info("button download PDF is displayed");
        adminAreaDemoPage.clickBtnDownload();
        LOG.info("click button download PDF success");
        Assert.assertTrue(adminAreaDemoPage.setBtnDownloadPdfSelectedIsDisplayed());
        LOG.info("download PDF selected is displayed");
        adminAreaDemoPage.clickBtnDownloadPdfSelected();
        LOG.info("click button download PDF selected success");



    }
    @Test
    public void deleteProduct(){

        HomePage homePage = new HomePage(driver);
        HomePagePlateforme homePagePlateforme = new HomePagePlateforme(driver);
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        AdminAreaDemoPage adminAreaDemoPage = new AdminAreaDemoPage(driver);

        homePage.clickOnByNopCommerce();
        homePagePlateforme.swishToLoginAdmin(driver ,son,sonSon);

        //login
        adminLoginPage.login();
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login admin title");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title login validation success");
        Assert.assertTrue(adminAreaDemoPage.btnCatalogIsDisplayed());
        LOG.info("button catalog is displayed");
        adminAreaDemoPage.clickCatalog();
        LOG.info("click catalog success");
        Assert.assertTrue(adminAreaDemoPage.setProductIsDisplayed());
        LOG.info("products is displayed");
        adminAreaDemoPage.clickOnProduct();
        LOG.info("click on product success");
        adminAreaDemoPage.selectAllProduct(driver);
        adminAreaDemoPage.clickCheckGiftCard();
        LOG.info("click gift carte success");
        Assert.assertTrue(adminAreaDemoPage.btnDeleteIsDisplayed());
        LOG.info("button delete is displayed");
        adminAreaDemoPage.clickBtnDelete();
        LOG.info("click on delete success");
        LOG.info("alert: " + adminAreaDemoPage.getTextAlert());
        adminAreaDemoPage.clickAcceptAlert();
        LOG.info("accept alert success");

    }
    @Test
    public void totalBestsellers() {

        HomePage homePage = new HomePage(driver);
        HomePagePlateforme homePagePlateforme = new HomePagePlateforme(driver);
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        AdminAreaDemoPage adminAreaDemoPage = new AdminAreaDemoPage(driver);

        homePage.clickOnByNopCommerce();
        homePagePlateforme.swishToLoginAdmin(driver, son, sonSon);

        //login
        adminLoginPage.login();
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login admin title");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title login validation success");
        Assert.assertTrue(adminAreaDemoPage.reportsIsDisplayed());
        LOG.info("reports is displayed");
        adminAreaDemoPage.clickReports();
        LOG.info("click reports success");
        adminAreaDemoPage.clickBestsellers();
        LOG.info("click bestsellers success");
        LOG.info("Total amount is : " + adminAreaDemoPage.getTotalAmount(driver));
        LOG.info("all amount is : " + adminAreaDemoPage.getAmountsTaxOnBestsellers());

        Assert.assertTrue(Utility.isSortedTotalAndSumPrices(adminAreaDemoPage.getAmountsTaxOnBestsellers(),adminAreaDemoPage.getTotalAmount(driver)));
        LOG.info("Total amounts tax bestsellers is success");



    }

    @Test
    public void systemInformation() {
        HomePage homePage = new HomePage(driver);
        HomePagePlateforme homePagePlateforme = new HomePagePlateforme(driver);
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        AdminAreaDemoPage adminAreaDemoPage = new AdminAreaDemoPage(driver);

        homePage.clickOnByNopCommerce();
        homePagePlateforme.swishToLoginAdmin(driver, son, sonSon);

        //login
        adminLoginPage.login();
        Assert.assertTrue(adminAreaDemoPage.systemIsDisplayed());
        LOG.info("system is displayed");
        adminAreaDemoPage.clickBtnSystem();
        LOG.info("click button system  success");
        adminAreaDemoPage.clickBtnSystemInfo();
        LOG.info("click button system info success");
        Assert.assertTrue(adminAreaDemoPage.titleSystemIsDisplayed());
        LOG.info("Title : " + adminAreaDemoPage.getTitleSystemInfo());
        LOG.info("table system info is : " + adminAreaDemoPage.getInfoSystem());


    }
}
