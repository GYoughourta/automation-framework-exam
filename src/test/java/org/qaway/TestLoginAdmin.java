package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.AdminLoginPage;
import org.qaway.pages.HomePage;
import org.qaway.pages.HomePagePlateforme;
import org.qaway.utility.ExcelReader;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TestLoginAdmin extends CommonAPI {

    String mail = Utility.decode(prop.getProperty("mail"));
    String password = Utility.decode(prop.getProperty("password"));
    ExcelReader excelReader = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data");
    Logger LOG = LogManager.getLogger(TestLoginAdmin.class.getName());
    String son = prop.getProperty("switch.son");
    String sonSon = prop.getProperty("switch.son.son");
    @Test
    public void validateLoginPageElementsAdmin(){
        HomePage homePage = new HomePage(driver);
        HomePagePlateforme homePagePlateforme = new HomePagePlateforme(driver);
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        Assert.assertTrue(homePage.PlatformIsDisplayed());
        LOG.info("Platform Is Displayed");
        homePage.clickOnByNopCommerce();
        LOG.info("click on NopCommerce success");
        homePagePlateforme.switchToWindowSon(driver,son);
        LOG.info("switch To Window Son success");

        Assert.assertTrue(homePagePlateforme.btnDemoIsDisplayed());
        LOG.info("button Demo Is Displayed");
        homePagePlateforme.clickBtnDemo();
        LOG.info("click on DEMO success");
        Assert.assertTrue(homePagePlateforme.btnAdminIsDisplayed());
        LOG.info("button Admin Is Displayed");
        waitFor(3);
        homePagePlateforme.clickBtnAdmin();
        LOG.info("click on button admin success");
        waitFor(3);
        homePagePlateforme.switchToWindowSon(driver,sonSon);
        LOG.info("switch To Window Son 2 success");
        String getTitleAdminLogin = adminLoginPage.getTitleLoginAdmin();
        waitFor(3);
        Assert.assertEquals(excelReader.getDataForGivenHeaderAndKey("key", "title admin"), getTitleAdminLogin);
        LOG.info("get Title Admin Login  success");

        //username
        boolean userNameIsDisplayed = adminLoginPage.mailFieldIsDisplayed();
        Assert.assertTrue(userNameIsDisplayed);
        LOG.info("mail field is displayed");

        //password
        boolean passwordFieldIsDisplayed = adminLoginPage.passwordFieldIsDisplayed();
        Assert.assertTrue(passwordFieldIsDisplayed);
        LOG.info("password field is displayed");

        //login button
        boolean loginButtonIsDisplayed = adminLoginPage.loginBtnIsDisplayed();
        Assert.assertTrue(loginButtonIsDisplayed);
        LOG.info("login button is displayed");
    }

    @Test
    public void loginWithValidCredentials() {
        HomePage homePage = new HomePage(driver);
        HomePagePlateforme homePagePlateforme = new HomePagePlateforme(driver);
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        homePage.clickOnByNopCommerce();
        LOG.info("click on NopCommerce success");
        homePagePlateforme.switchToWindowSon(driver,son);
        LOG.info("switch To Window Son success");
        homePagePlateforme.clickBtnDemo();
        LOG.info("click on DEMO success");
        homePagePlateforme.clickBtnAdmin();
        LOG.info("click on button admin success");
        waitFor(3);
        homePagePlateforme.switchToWindowSon(driver,sonSon);
        LOG.info("switch To Window Son 2 success");
        String getTitleAdminLogin = adminLoginPage.getTitleLoginAdmin();
        waitFor(3);
        Assert.assertEquals(excelReader.getDataForGivenHeaderAndKey("key", "title admin"), getTitleAdminLogin);
        LOG.info("get Title Admin Login  success");


        //enter mail
        adminLoginPage.typeMail(mail);
        LOG.info("enter username success");

        //enter password
        adminLoginPage.typePassword(password);
        LOG.info("enter password success");

        //click on login button
        adminLoginPage.clickOnLoginButton();
        LOG.info("login button click success");


    }
    @Test
    public void loginAttemptWithoutUsername() {
        HomePage homePage = new HomePage(driver);
        HomePagePlateforme homePagePlateforme = new HomePagePlateforme(driver);
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        homePage.clickOnByNopCommerce();
        LOG.info("click on NopCommerce success");
        homePagePlateforme.switchToWindowSon(driver,son);
        LOG.info("switch To Window Son success");
        homePagePlateforme.clickBtnDemo();
        LOG.info("click on DEMO success");
        homePagePlateforme.clickBtnAdmin();
        LOG.info("click on button admin success");
        waitFor(3);
        homePagePlateforme.switchToWindowSon(driver,sonSon);
        LOG.info("switch To Window Son 2 success");
        String getTitleAdminLogin = adminLoginPage.getTitleLoginAdmin();
        waitFor(3);
        Assert.assertEquals(excelReader.getDataForGivenHeaderAndKey("key", "title admin"), getTitleAdminLogin);
        LOG.info("get Title Admin Login  success");

        //enter username
        adminLoginPage.typeMail("");
        LOG.info("enter username success");

        //enter password
        adminLoginPage.typePassword(password);
        LOG.info("enter password success");

        //click on login button
        adminLoginPage.clickOnLoginButton();
        LOG.info("login button click success");
        waitFor(3);
        String textError = adminLoginPage.getErrorMessage(driver);
        LOG.info("error mail: "+ textError);
        Assert.assertEquals(excelReader.getDataForGivenHeaderAndKey("key", "invalid password error message"), textError);
        LOG.info("error mail validation success");
    }
    @Test
    public void loginAttemptWithoutPassword() {
        HomePage homePage = new HomePage(driver);
        HomePagePlateforme homePagePlateforme = new HomePagePlateforme(driver);
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        homePage.clickOnByNopCommerce();
        LOG.info("click on NopCommerce success");
        homePagePlateforme.switchToWindowSon(driver,son);
        LOG.info("switch To Window Son success");
        homePagePlateforme.clickBtnDemo();
        LOG.info("click on DEMO success");
        homePagePlateforme.clickBtnAdmin();
        LOG.info("click on button admin success");
        waitFor(3);
        homePagePlateforme.switchToWindowSon(driver,sonSon);
        LOG.info("switch To Window Son 2 success");
        String getTitleAdminLogin = adminLoginPage.getTitleLoginAdmin();
        waitFor(3);
        Assert.assertEquals(excelReader.getDataForGivenHeaderAndKey("key", "title admin"), getTitleAdminLogin);
        LOG.info("get Title Admin Login  success");

        //enter username
        adminLoginPage.typeMail(mail);
        LOG.info("enter username success");

        //enter password
        adminLoginPage.typePassword("");
        LOG.info("enter password success");

        //click on login button
        adminLoginPage.clickOnLoginButton();
        LOG.info("login button click success");
        String textError = adminLoginPage.getErrorMail(driver);
        LOG.info("error message: "+ textError);
        waitFor(3);
        Assert.assertEquals(excelReader.getDataForGivenHeaderAndKey("key", "error mail"),textError);
        LOG.info("error message validation success");
    }
}
