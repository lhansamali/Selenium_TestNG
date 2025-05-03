package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@data-qa=\"login-email\"]")
    public static WebElement inputLoginEmail;
    @FindBy(name = "password")
    public static WebElement inputLoginPassword;
    @FindBy(xpath = "//button[@data-qa=\"login-button\"]")
    public static WebElement btnLogin;
    @FindBy(xpath = "//form[@action=\"/login\"]/child::p")
    public static WebElement lblCredentialError;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
        CommonFunctions.wait(driver, inputLoginEmail);
        inputLoginEmail.sendKeys(email);
        inputLoginPassword.sendKeys(password);
        btnLogin.click();
    }
}
