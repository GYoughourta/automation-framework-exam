package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.CartePage;
import org.qaway.pages.ProductPage;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCarte extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestCarte.class.getName());
    @Test
    public void addToCarte(){

        ProductPage productPage = new ProductPage(driver);



        LOG.info("current url: " + productPage.getSLHomePageUrl(driver));
        Assert.assertEquals("https://demo.nopcommerce.com/", productPage.getSLHomePageUrl(driver));
        LOG.info("url validation success");
        waitFor(3);
        productPage.hoverOverComputers(driver);
        productPage.clickOnDesktops(driver);

        Assert.assertTrue(productPage.notebooksHeaderIsDisplayed());
        LOG.info("Notebooks header display success");
        boolean clickAddToCarteProductPcIsDisplayed = productPage.clickAddToCarteProductPcIsDisplayed();
        Assert.assertTrue(clickAddToCarteProductPcIsDisplayed);
        LOG.info("click Add To Carte Product display success");
        productPage.clickAddToCarteProductPc();
        LOG.info("click Add To Carte Product Pc success");

        productPage.clickOnProductBook();
        LOG.info("click Product Books success");
        boolean getElementBookIsDisplayed = productPage.getElementBookIsDisplayed();
        Assert.assertTrue(getElementBookIsDisplayed);
        LOG.info("get element Book Is Displayed");
        productPage.clickAddToCarteBook();
        LOG.info("click Add To Carte Product book success");


    }
    @Test
    public void carte(){
        ProductPage productPage = new ProductPage(driver);
        CartePage cartePage = new CartePage(driver);
        waitFor(10);
        productPage.hoverOverComputers(driver);
        productPage.clickOnDesktops(driver);

        Assert.assertTrue(productPage.notebooksHeaderIsDisplayed());
        productPage.clickAddToCarteProductPc();
        LOG.info("click Add To Carte Product Pc success");

        productPage.clickOnProductBook();
        LOG.info("click Product Books success");
        boolean getElementBookIsDisplayed = productPage.getElementBookIsDisplayed();
        Assert.assertTrue(getElementBookIsDisplayed);
        LOG.info("get element Book Is Displayed");
        productPage.clickAddToCarteBook();
        LOG.info("click Add To Carte Product book success");

        boolean btnCarteIsDisplayed = cartePage.btnCarteIsDisplayed();
        Assert.assertTrue(btnCarteIsDisplayed);
        waitFor(10);
        cartePage.ClickOnCarte(driver);
        boolean shoppingIsDisplayed = cartePage.ShoppingIsDisplayed();
        Assert.assertTrue(shoppingIsDisplayed);
        LOG.info("Total prices products is : " + cartePage.getTotalPrices(driver));
        LOG.info("Total prices products is : " + cartePage.getPricesProductOnCarte());

        Assert.assertTrue(Utility.isSortedTotalAndSumPrices(cartePage.getPricesProductOnCarte(),cartePage.getTotalPrices(driver)));
        LOG.info("Total prices products is success");






    }
}
