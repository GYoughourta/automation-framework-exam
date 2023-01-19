package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.HomePage;
import org.qaway.pages.ProductPage;
import org.qaway.utility.ExcelReader;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TestSearchProductApple extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestSearchProductApple.class.getName());

    String apple = prop.getProperty("apple");


    @Test
    public void searchProductsApple() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        ExcelReader excelReader = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data");

        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        homePage.typeAppleInSearch(apple);
        LOG.info("type Apple In Search success");
        homePage.clickOnSearch();
        LOG.info("click on Search success");

        LOG.info("list of products apple: "+ productPage.getNameProducts());
        Assert.assertTrue(Utility.verifierName(productPage.getNameProducts()));
        LOG.info("Name Apple sorted success");
    }
    @Test
    public void clickPictureAndGetInfo(){
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        boolean searchIsDisplayed = homePage.searchFieldIsDisplayed();
        Assert.assertTrue(searchIsDisplayed);
        LOG.info("search is displayed");
        homePage.typeAppleInSearch(apple);
        LOG.info("type Apple In Search success");
        boolean searchBtnIsDisplayed = homePage.searchBtnIsDisplayed();
        Assert.assertTrue(searchBtnIsDisplayed);
        LOG.info("search is displayed");
        homePage.clickOnSearch();
        LOG.info("click on Search success");
        productPage.clickOnPicture();
        LOG.info("click on Picture Apple PC success");
        boolean nameProductIsDisplayed = productPage.NameProductIsDisplayed();
        Assert.assertTrue(nameProductIsDisplayed);
        LOG.info("get Name product Apple PC is displayed");
        LOG.info("information product : " + productPage.getInfoProduct());

    }
}
