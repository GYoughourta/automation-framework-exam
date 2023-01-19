package org.qaway.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

public class AdminLoginPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(AdminLoginPage.class.getName());

    public AdminLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='page-title']/h1")
    WebElement getTitleLogin;
    @FindBy(css = "#Email")
    WebElement mailField;
    @FindBy(css = "#Password")
    WebElement passwordField;
    @FindBy(css = ".button-1.login-button")
    WebElement loginBtn;

    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']/ul/li")
    WebElement errorMessage;
    @FindBy(css = "#Email-error")
    WebElement errorMail;

    public String getTitleLoginAdmin(){
        return getTitleLogin.getText();
    }
    public boolean mailFieldIsDisplayed(){
        LOG.info("checking mail field is displayed ...");
        return isDisplayed(mailField);
    }
    public boolean passwordFieldIsDisplayed(){
        LOG.info("checking password field is displayed ...");
        return isDisplayed(passwordField);
    }
    public boolean loginBtnIsDisplayed(){
        LOG.info("checking login button is displayed ...");
        return isDisplayed(loginBtn);
    }


    //reusable steps

    public void typeMail(String mail){
        type(mailField, mail);
    }

    public void typePassword(String password){
        type(passwordField, password);
    }

    public void clickOnLoginButton(){
        clickOn(loginBtn);
    }
    public String getErrorMessage(WebDriver driver){
        waitForElementToBeAvailable(driver,errorMessage);
        return getWebElementText(errorMessage);
    }
    public String getErrorMail(WebDriver driver){
        waitForElementToBeAvailable(driver,errorMail);
        return getWebElementText(errorMail);
    }

    public void login(){
        clickOnLoginButton();
        System.out.println("login process success");
    }


}
