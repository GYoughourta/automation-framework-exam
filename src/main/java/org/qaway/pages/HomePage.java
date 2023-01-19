package org.qaway.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends CommonAPI {
    Logger LOG = LogManager.getLogger(HomePage.class.getName());

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy (css = ".header-logo")
    WebElement logoHeader;

    @FindBy (css = ".search-box-text.ui-autocomplete-input")
    WebElement search;
    @FindBy (css = ".slider-wrapper.theme-custom")
    WebElement advertising;
    @FindBy(xpath = "//div[@class='topic-block-title']/h2")
    WebElement welcomeToOurStore;

    @FindBy(css=".ico-login")
    WebElement clickLogin;
    @FindBy(css=".button-1.search-box-button")
    WebElement clickSearch;
    @FindBy(xpath = "//input[@type='radio']")
    List<WebElement> radioButtons;
    @FindBy(xpath = "//div[@class='footer-powered-by']/a")
    WebElement ByNopCommerce;




    public boolean searchFieldIsDisplayed(){
        return isDisplayed(search);
    }
    public boolean logoHeaderIsDisplayed(){
        return isDisplayed(logoHeader);
    }
    public boolean advertisingIsDisplayed(){
        return isDisplayed(advertising);
    }
    public String welcomeToOurStore(){

        return welcomeToOurStore.getText();
    }
    public void clickOnLoginIn(){
        clickOn(clickLogin);
    }

    public void typeAppleInSearch(String apple){
        type(search, apple);
    }

    public boolean searchBtnIsDisplayed(){
        return isDisplayed(clickSearch);
    }
    public void clickOnSearch(){
        clickOn(clickSearch);
    }
    public void clickRadioButton(String value ){
        for (WebElement radioButton: radioButtons) {
            if (getAttribute(radioButton).equalsIgnoreCase(value)){

                radioButton.click();
            }
        }
    }

    public void clickOnByNopCommerce(){

        clickOn(ByNopCommerce);
    }
    public boolean PlatformIsDisplayed(){
        return isDisplayed(ByNopCommerce);
    }


}
