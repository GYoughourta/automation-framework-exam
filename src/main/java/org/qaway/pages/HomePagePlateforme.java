package org.qaway.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class HomePagePlateforme extends CommonAPI {

    Logger LOG = LogManager.getLogger(HomePagePlateforme.class.getName());

    public HomePagePlateforme(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath ="//div[@class='home-banner-text-section']/h1")
    WebElement elementPlatform;
    @FindBy(xpath = "//div[@class='stats-section']/div")
    List<WebElement> section;
    @FindBy(xpath = "//div[@class='home-banner-button']/a[2]")
    WebElement btnDEMO;
    @FindBy(css = ".btn.admin-button")
    WebElement clickAdmin;


    public List<Boolean> sectionIsDisplayed(){
        List<Boolean> elementSections = new ArrayList<>();
        for (WebElement elementSection: section){
            elementSections.add(isDisplayed(elementSection));
        }

        return elementSections;
    }

    public String getPlatformText(){
        return elementPlatform.getText();
    }
    public void switchToWindowSon(WebDriver driver,String Son){
        switchToWindow(driver, Integer.parseInt(Son));
    }
    public void clickBtnDemo(){
        clickOn(btnDEMO);
    }
    public boolean btnDemoIsDisplayed(){
        return isDisplayed(btnDEMO);
    }
    public void clickBtnAdmin(){
        clickOn(clickAdmin);
    }
    public boolean btnAdminIsDisplayed(){
        return isDisplayed(clickAdmin);
    }

    public void swishToLoginAdmin(WebDriver driver,String son,String sonSon){

        switchToWindowSon(driver,son);
        LOG.info("switch To Window Son success");
        clickBtnDemo();
        LOG.info("click on DEMO success");
        clickBtnAdmin();
        LOG.info("click on button admin success");
        waitFor(3);
        switchToWindowSon(driver,sonSon);
        LOG.info("switch To Window Son 2 success");
    }


}
