package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
    @FindBy(linkText = "Signup / Login")
    public static WebElement loginLink;
    @FindBy(linkText = "Contact us")
    public static WebElement contactUsLink;

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public void clickOnLoginSignUpLink(){
        loginLink.click();
    }
    public void clickOnContactUsLink(){
        contactUsLink.click();
    }
}
