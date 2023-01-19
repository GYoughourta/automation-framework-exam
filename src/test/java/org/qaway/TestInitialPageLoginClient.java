package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.HomePage;
import org.qaway.pages.LoginPageClient;
import org.qaway.utility.ExcelReader;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TestInitialPageLoginClient extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestInitialPageLoginClient.class.getName());
    ExcelReader excelReader = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data");

    @Test
    public void validateLandingPage(){

        LoginPageClient loginPageClient = new LoginPageClient(driver);
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLoginIn();
        LOG.info("click On Login In success");
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login page title");

        String actual = loginPageClient.getWelcomePleaseSignIn();
        Assert.assertEquals(expected, actual);
        LOG.info("welcome Please Sign In is displayed");

    }

   @Test
    public void validateLoginPageElementsClient(){
        LoginPageClient loginPageClient = new LoginPageClient(driver);
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLoginIn();
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login page title");

        String actual = loginPageClient.getWelcomePleaseSignIn();
        Assert.assertEquals(expected, actual);
        LOG.info("welcome Please Sign In is displayed");

        //username
        boolean userNameIsDisplayed = loginPageClient.usernameFieldIsDisplayed();
        Assert.assertTrue(userNameIsDisplayed);
        LOG.info("username field is displayed");

        //password
        boolean passwordFieldIsDisplayed = loginPageClient.passwordFieldIsDisplayed();
        Assert.assertTrue(passwordFieldIsDisplayed);
        LOG.info("password field is displayed");

        //login button
        boolean loginButtonIsDisplayed = loginPageClient.loginBtnIsDisplayed();
        Assert.assertTrue(loginButtonIsDisplayed);
        LOG.info("login button is displayed");

        boolean registerButtonIsDisplayed = loginPageClient.registerBtnIsDisplayed();
        Assert.assertTrue(registerButtonIsDisplayed);
        LOG.info("register button is displayed");
    }


}
