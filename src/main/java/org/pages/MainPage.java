package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    @FindBy(partialLinkText = "Logged in")
    public static WebElement menuLoggedIn;
    @FindBy(xpath = "//ul/li[5]/a")
    public static WebElement linkDeleteAccount;
    @FindBy(xpath = "//h2[@data-qa=\"account-deleted\"]/following-sibling::p[1]")
    public static WebElement txtAccountDeletion;
    @FindBy(xpath = "//ul/li[4]/a")
    public static WebElement linkLoggedOut;
    @FindBy(xpath = "//ul/li[4]/a")
    public static WebElement linkSignUpLogin;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void deleteAccount() {
        linkDeleteAccount.click();
    }

}
