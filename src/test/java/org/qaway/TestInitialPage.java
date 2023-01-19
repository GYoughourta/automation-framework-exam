package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.HomePage;
import org.qaway.utility.ExcelReader;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TestInitialPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestInitialPage.class.getName());
    ExcelReader excelReader = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data");
    @Test
    public void validateConnexionPage(){

        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

    }

    @Test
    public void validateHomePageElements(){
        HomePage homePage = new HomePage(driver);

        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page title");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        boolean logoHeaderIsDisplayed = homePage.logoHeaderIsDisplayed();
        Assert.assertTrue(logoHeaderIsDisplayed);
        LOG.info("logo header is displayed");

        boolean searchIsDisplayed = homePage.searchFieldIsDisplayed();
        Assert.assertTrue(searchIsDisplayed);
        LOG.info("search is displayed");

        boolean advertisingIsDisplayed = homePage.advertisingIsDisplayed();
        Assert.assertTrue(advertisingIsDisplayed);
        LOG.info("advertising is displayed");

        String expected1 = excelReader.getDataForGivenHeaderAndKey("key", "topic block title");
        String actual1 = homePage.welcomeToOurStore();
        Assert.assertEquals(expected1, actual1);
        LOG.info("Welcome to our store validation success");

    }

}
