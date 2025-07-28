package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BasePage {
    @FindBy(xpath = "//h2[@class=\"title text-center\"]")
    public static WebElement txtAllProducts;
    @FindBy(xpath = "//div[@class=\"features_items\"]/div[@class=\"col-sm-4\"][1]/div/child::div[@class=\"choose\"]/ul/li")
    public static WebElement btnViewProductsOfFirstProduct;
    @FindBy(xpath = "//div[@class=\"product-information\"]/h2")
    public static WebElement txtProductName;
    @FindBy(xpath = "//div[@class=\"product-information\"]/p[1]")
    public static WebElement txtCategory;
    @FindBy(xpath = "//div[@class=\"product-information\"]/p[2]")
    public static WebElement txtAvailability;
    @FindBy(xpath = "//div[@class=\"product-information\"]/p[3]")
    public static WebElement txtCondition;
    @FindBy(xpath = "//div[@class=\"product-information\"]/span")
    public static WebElement txtPrice;
    @FindBy(xpath = "//div[@class=\"product-information\"]/p[4]")
    public static WebElement txtBrand;

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnViewProductOfFirstProduct() {
        btnViewProductsOfFirstProduct.click();
    }
}
