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

public class CartePage extends CommonAPI {
    String price;

    Logger LOG = LogManager.getLogger(HomePage.class.getName());

    public CartePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".ico-cart")
    WebElement elementBtn;
    @FindBy(xpath = "//div[@class='page-title']/h1")
    WebElement getElementShopping;
    @FindBy(xpath = "//table[@class='cart']/tbody/tr/td[6]/span")
    List<WebElement> elementsPrices;
    @FindBy(xpath = "//table[@class='cart-total']/tbody/tr[4]/td[2]/span/strong")
    WebElement elementTotal;

    public boolean btnCarteIsDisplayed(){

        return isDisplayed(elementBtn);
    }
    public void ClickOnCarte(WebDriver driver){
        waitForElementToBeAvailable(driver, elementBtn);
        clickOn(elementBtn);
    }
    public boolean ShoppingIsDisplayed(){

        return isDisplayed(getElementShopping);
    }

    public List<Double> getPricesProductOnCarte(){
        List<Double> prices = new ArrayList<>();
        for (WebElement itemPrice: elementsPrices){
            price = itemPrice.getText().replace("$","");
            price = price.replace("€","");
            price = price.replace(",","");
            prices.add(Double.valueOf(price));

        }
        return prices;
    }

    public double getTotalPrices(WebDriver driver){
        waitForElementToBeAvailable(driver, elementTotal);
        price = elementTotal.getText();
        price = price.replace("€","");
        price = price.replace("$","");
        price = price.replace(",","");
        return Double.parseDouble(price);
    }
}
