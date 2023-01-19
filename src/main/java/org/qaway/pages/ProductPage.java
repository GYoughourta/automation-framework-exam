package org.qaway.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qaway.base.CommonAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductPage extends CommonAPI {

    String price;
    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    Logger LOG = LogManager.getLogger(ProductPage.class.getName());


    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li[1]/a")
    WebElement computer;
    @FindBy (xpath = "//ul[@class='top-menu notmobile']/li[1]/ul/li[2]/a")
    WebElement desktop;
    @FindBy(css = ".page-title")
    WebElement NotebooksHeader;
    @FindBy(css = ".price.actual-price")
    List<WebElement> itemsPrice;
    @FindBy(xpath = "//*[@id='products-orderby']")
    WebElement filterDropdown;
    @FindBy(xpath = "//h2[@class='product-title']/a")
    List<WebElement> searchAppleProducts;
    @FindBy(xpath = "(//div[@class='picture']/a/img)[1]")
    WebElement clickPicture;
    @FindBy(xpath = "//div[@class='product-name']/h1")
    WebElement nameProduct;
    @FindBy(xpath = "//table[@class='data-table']/tbody/tr/td[1]")
    List<WebElement> specificationsProductApple;
    @FindBy(xpath = "//table[@class='data-table']/tbody/tr/td[2]")
    List<WebElement> infoProductApple;
    @FindBy(xpath = "(//button[@class='button-2 product-box-add-to-cart-button'])[2]")
    WebElement elementPc;
    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li[5]/a")
    WebElement elementBook;
    @FindBy(xpath = "(//button[@class='button-2 product-box-add-to-cart-button'])[1]")
    WebElement elementAddToCarteBook;
    @FindBy(xpath = "//div[@class='page-title']/h1")
    WebElement getElementBook;



    public String getSLHomePageUrl(WebDriver driver){
        return getPageUrl(driver);
    }


    public void hoverOverComputers(WebDriver driver){
        waitForElementToBeAvailable(driver, computer);
        hoverOver(driver, computer);
        LOG.info("hover over computers success");
    }
    public void clickOnDesktops(WebDriver driver){
        waitForElementToBeAvailable(driver, desktop);
        clickOn(desktop);
        LOG.info("click on desktops success");
    }


    public boolean notebooksHeaderIsDisplayed(){
        return isDisplayed(NotebooksHeader);
    }
    public void selectLowerToHigherFromFilter(WebDriver driver){
        waitForElementToBeAvailable(driver, filterDropdown);
        selectFromDropdown(filterDropdown, "Price: Low to High");
        LOG.info("price low to high select success");
    }
    public List<String> getItemsPrice(){
        List<String> prices = new ArrayList<>();
        for (WebElement itemPrice: itemsPrice){
            price = itemPrice.getText().replace("$","");
            price = price.replace("€","");
            price = price.replace(",","");
            prices.add(price);
        }
        return prices;
    }
    public List<String> getNameProducts(){
        List<String> products = new ArrayList<>();
        for (WebElement NameProduct: searchAppleProducts){
            products.add(NameProduct.getText().substring(0,5));
        }
        return products;
    }
    public void clickOnPicture(){

        clickOn(clickPicture);

    }
    public boolean NameProductIsDisplayed(){

        return isDisplayed(nameProduct);
    }

    public Map<String,String> getInfoProduct(){
        Map<String, String> info = new HashMap<>();
        for (int i = 0; i < infoProductApple.size();i++){

                info.put(specificationsProductApple.get(i).getText(),infoProductApple.get(i).getText());
        }
        return info;
    }
    public boolean clickAddToCarteProductPcIsDisplayed(){
        return isDisplayed(elementPc);
    }
    public void clickAddToCarteProductPc(){
        clickOn(elementPc);
    }

    public void clickOnProductBook(){
        clickOn(elementBook);
    }
    public boolean getElementBookIsDisplayed(){
        return isDisplayed(getElementBook);
    }
    public void clickAddToCarteBook(){
        clickOn(elementAddToCarteBook);
    }
}
