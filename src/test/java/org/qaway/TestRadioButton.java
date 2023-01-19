package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.HomePage;
import org.qaway.pages.ProductPage;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRadioButton extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestRadioButton.class.getName());
    String value = prop.getProperty("value");
    @Test
    public void radio(){
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        LOG.info("current url: " + productPage.getSLHomePageUrl(driver));
        Assert.assertEquals("https://demo.nopcommerce.com/", productPage.getSLHomePageUrl(driver));
        LOG.info("url validation success");
        waitFor(10);
        homePage.clickRadioButton(value);
        LOG.info("click on radio button success");



    }
}
