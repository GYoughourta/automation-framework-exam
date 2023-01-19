package org.qaway.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

public class LoginPageClient extends CommonAPI {
    Logger LOG = LogManager.getLogger(LoginPageClient.class.getName());

    public LoginPageClient(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    //objects

    @FindBy(xpath = "//div[@class='page-title']/h1")
    WebElement welcomePleaseSignIn;
    @FindBy(css = ".email")
    WebElement mailField;
    @FindBy(css = "#Password")
    WebElement passwordField;
    @FindBy(css = ".button-1.login-button")
    WebElement loginBtn;
    @FindBy(css = ".button-1.register-button")
    WebElement registerBtn;





    public String getWelcomePleaseSignIn(){
        return getWebElementText(welcomePleaseSignIn);
    }

    //reusable steps
    public boolean usernameFieldIsDisplayed(){
        LOG.info("checking username field is displayed ...");
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
    public boolean registerBtnIsDisplayed(){
        LOG.info("checking register button is displayed ...");
        return isDisplayed(registerBtn);
    }

}
