package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{
    @FindBy(linkText = "Signup / Login")
    public static WebElement loginLink;
    @FindBy(linkText = "Contact us")
    public static WebElement contactUsLink;
    @FindBy(xpath = "//a[@href='/products']")
    public static WebElement productsLink;

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public void clickOnLoginSignUpLink(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(loginLink));
        loginLink.click();
    }
    public void clickOnContactUsLink(){
        contactUsLink.click();
    }
    public void clickOnProductsLink(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(productsLink));
        productsLink.click();
    }
}
