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

public class AdminAreaDemoPage extends CommonAPI {


    Logger LOG = LogManager.getLogger(AdminAreaDemoPage.class.getName());

    public AdminAreaDemoPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "(//a[@class='small-box-footer'])[3]")
    WebElement addNewAdmin;
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement addNew;
    @FindBy(css = "#Email")
    WebElement newMail;
    @FindBy(css = "#Password")
    WebElement newPassword;
    @FindBy(css = "#FirstName")
    WebElement elementName;
    @FindBy(xpath = "(//div[@class='k-multiselect-wrap k-floatwrap'])[2]")
    WebElement role;
    @FindBy(xpath = "//select[@id='SelectedCustomerRoleIds']")
    WebElement failRoles;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement btnSave;
    //div[@class='k-list-scroller'])[2]/ul/li[1]
    @FindBy(xpath = "//ul[@id='SelectedCustomerRoleIds_listbox']/li[1]")
    WebElement choixAdministrators;
    @FindBy(xpath = "(//a[@class='nav-link active'])[2]")
    WebElement btnCustomer;
    @FindBy(css = "#VendorId")
    WebElement elementVendor;
    @FindBy(xpath = "//table[@id='customers-grid']/tbody/tr[1]/td[2]")
    WebElement checkMail;
    @FindBy(xpath = "//table[@id='customers-grid']/tbody/tr[1]/td[3]")
    WebElement checkName;
    @FindBy(xpath = "//table[@id='customers-grid']/tbody/tr[1]/td[4]")
    WebElement checkRole;
    @FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/li[3]")
    WebElement elementSales;
    @FindBy(xpath = "//li[@class='nav-item has-treeview menu-is-opening menu-open']/ul/li[1]/a")
    WebElement elementOrders;
    @FindBy(xpath = "//input[@name='checkbox_orders']")
    List<WebElement> checkbox;
    @FindBy(css = ".btn.btn-info.dropdown-toggle.dropdown-icon")
    WebElement btnDownload;
    @FindBy(css = "#pdf-invoice-selected")
    WebElement DownloadPdfSelected;
    @FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/li[2]")
    WebElement catalog;

    @FindBy(xpath = "//li[@class='nav-item has-treeview menu-is-opening menu-open']/ul/li[1]/a")
    WebElement product;
    @FindBy(xpath = "//select[@name='products-grid_length']")
    WebElement elementSelect;
    @FindBy(xpath = "(//input[@name='checkbox_products'])[44]")
    WebElement checkGiftCart;
    @FindBy(css = "#delete-selected")
    WebElement deleteGiftCarte;

    //on realité c'est pas une alert
    @FindBy(xpath = "(//div[@class='modal-body'])[1]")
    WebElement alertText;
    @FindBy(xpath = "//button[@id='delete-selected-action-confirmation-submit-button']")
    WebElement acceptAlert;
    @FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/li[9]")
    WebElement reports;
    @FindBy(xpath = "//li[@class='nav-item has-treeview menu-is-opening menu-open']/ul/li[3]/a")
    WebElement bestsellers;
    @FindBy(xpath = "//table[@id='salesreport-grid']/tbody/tr/td[3]")
    List<WebElement> totalAmountTax;
    @FindBy(xpath = "//table[@class='table table-bordered table-hover table-striped dataTable']/tfoot/tr/td[3]/div/span")
    WebElement totalAllAmount;

    @FindBy(xpath = "//label[@class='col-form-label']")
    List<WebElement> elements;
    @FindBy(xpath = "//div[@class='form-text-row']")
    List<WebElement> info;
    @FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/li[8]")
    WebElement btnSystem;
    @FindBy(xpath = "//li[@class='nav-item has-treeview menu-is-opening menu-open']/ul/li[1]/a")
    WebElement btnSystemInfo;
    @FindBy(css = ".float-left")
    WebElement titleSystem;

    public boolean titleSystemIsDisplayed(){
        return isDisplayed(titleSystem);
    }
    public String getTitleSystemInfo(){
        return getWebElementText(titleSystem);
    }
    public boolean systemIsDisplayed(){
        return isDisplayed(btnSystem);
    }
    public void clickBtnSystem(){
        clickOn(btnSystem);
    }
    public void clickBtnSystemInfo(){
        clickOn(btnSystemInfo);
    }
    public Map<String,String> getInfoSystem(){
        Map<String, String> mapInfo = new HashMap<>();
        for (int i = 0; i < elements.size();i++){

            mapInfo.put(elements.get(i).getText(),info.get(i).getText());
        }
        return mapInfo;
    }


    String amount;

    public void ClickRegisteredCustomer(WebDriver driver){

        waitForElementToBeAvailable(driver,addNewAdmin);
        clickOn(addNewAdmin);
    }
    public void ClickAddNew(WebDriver driver){

        waitForElementToBeAvailable(driver,addNew);
        clickOn(addNew);
    }


    public void typeNewMail(String mail){
        type(newMail,mail);

    }
    public void typeNewPassword(String password){
        type(newPassword,password);
    }
    public void typeNewName(String Name){
        type(elementName,Name);
    }
    public void clickRoles(){
        clickOn(role);
    }
    public void clickChoixAdministrators(WebDriver driver){
        waitForElementToBeAvailable(driver, choixAdministrators);
        clickOn(choixAdministrators);
    }
    public void selectVendor(WebDriver driver){
        waitForElementToBeAvailable(driver, elementName);
        selectFromDropdown(elementVendor, "Vendor 1");
        LOG.info("Vendor 1 select success");
    }
    public void clickSave(){
        clickOn(btnSave);
    }
    public void clickCustomers(){
        clickOn(btnCustomer);
    }
    public boolean checkMailValidate(String mail){

        if (getWebElementText(checkMail).equalsIgnoreCase(mail))
            return true;
        return false;

    }
    public boolean checkNameValidate(String name){

        if (getWebElementText(checkName).equalsIgnoreCase(name))
            return true;
        return false;

    }
    public boolean checkRolesValidate(String role){

        if (getWebElementText(checkRole).equalsIgnoreCase(role))
            return true;
        return false;

    }
    public void clickSales(){
        clickOn(elementSales);
    }
    public void clickOrders(){
        clickOn(elementOrders);
    }
    public void clickCheckboxButton(String value1,String value2,String value3 ){
        for (WebElement checkboxButton: checkbox) {
            if(getAttribute(checkboxButton).equalsIgnoreCase(value1))
                clickOn(checkboxButton);

            if(getAttribute(checkboxButton).equalsIgnoreCase(value2))
                clickOn(checkboxButton);
            if(getAttribute(checkboxButton).equalsIgnoreCase(value3))
                clickOn(checkboxButton);
        }
    }
    public boolean checkboxIsSelected(String value) {
        for (WebElement checkboxButton : checkbox) {
            if (getAttribute(checkboxButton).equalsIgnoreCase(value))
                return isSelected(checkboxButton);
        }
        return false;
    }
    public void clickBtnDownload(){
        clickOn(btnDownload);
    }
    public boolean setBtnDownloadIsDisplayed(){
        return isDisplayed(btnDownload);
    }
    public void clickBtnDownloadPdfSelected(){
        clickOn(DownloadPdfSelected);
    }
    public boolean setBtnDownloadPdfSelectedIsDisplayed(){
        return isDisplayed(DownloadPdfSelected);
    }
    public boolean btnCatalogIsDisplayed(){
        return isDisplayed(catalog);
    }

    public void clickCatalog(){
        clickOn(catalog);
    }
    public boolean setProductIsDisplayed(){
        return isDisplayed(product);
    }
    public void clickOnProduct(){
        clickOn(product);
    }
    public void selectAllProduct(WebDriver driver){
        waitForElementToBeAvailable(driver, elementSelect);
        selectFromDropdown(elementSelect, "100");
        LOG.info("check 100 product select success");
    }
    public void clickCheckGiftCard(){
        clickOn(checkGiftCart);
    }
    public boolean btnDeleteIsDisplayed(){
        return isDisplayed(deleteGiftCarte);
    }
    public void clickBtnDelete(){
        clickOn(deleteGiftCarte);
    }
    public String getTextAlert(){
        return getWebElementText(alertText);
    }
    public void clickAcceptAlert(){
        clickOn(acceptAlert);
    }
    public boolean reportsIsDisplayed(){
        return isDisplayed(reports);
    }
    public void clickReports(){

        clickOn(reports);
    }
    public void clickBestsellers(){
        clickOn(bestsellers);
    }

    public List<Double> getAmountsTaxOnBestsellers(){
        List<Double> amounts = new ArrayList<>();
        for (WebElement itemPrice: totalAmountTax){
            amount = itemPrice.getText().replace("$","");
            amount = amount.replace(",","");
            amounts.add(Double.valueOf(amount));

        }
        return amounts;
    }
    public double getTotalAmount(WebDriver driver){
        waitForElementToBeAvailable(driver, totalAllAmount);
        amount = totalAllAmount.getText();
        amount = amount.replace("$","");
        amount = amount.replace(",","");
        return Double.parseDouble(amount);
    }
}
