package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.*;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestComputer extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestComputer.class.getName());


    @Test
    public void computer(){

        ProductPage productPage = new ProductPage(driver);



        LOG.info("current url: " + productPage.getSLHomePageUrl(driver));
        Assert.assertEquals("https://demo.nopcommerce.com/", productPage.getSLHomePageUrl(driver));
        LOG.info("url validation success");
        productPage.hoverOverComputers(driver);
        productPage.clickOnDesktops(driver);

        Assert.assertTrue(productPage.notebooksHeaderIsDisplayed());
        LOG.info("Notebooks header display success");
    }
    @Test
    public void filterFromLowToHigh() {

        ProductPage productPage = new ProductPage(driver);

        productPage.hoverOverComputers(driver);
        productPage.clickOnDesktops(driver);
        Assert.assertTrue(productPage.notebooksHeaderIsDisplayed());
        LOG.info("Notebooks header display success");

        productPage.selectLowerToHigherFromFilter(driver);
        waitFor(3);
        LOG.info("list of prices: "+ productPage.getItemsPrice());
        double[] finalPrices = Utility.listToArrayOfDoubles(productPage.getItemsPrice());
        Assert.assertTrue(Utility.isSorted(finalPrices));
        LOG.info("items sorted success");
    }




}
