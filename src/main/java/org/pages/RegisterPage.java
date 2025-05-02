package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends BasePage {
    @FindBy(name = "name")
    public static WebElement inputName;
    @FindBy(xpath = "//input[@data-qa=\"signup-email\"]")
    public static WebElement inputEmail;
    @FindBy(xpath = "//button[text()=\"Signup\"]")
    public static WebElement btnsignUp;
    @FindBy(id = "uniform-id_gender2")
    public static WebElement radioBtnTitle_Mrs;
    @FindBy(id = "password")
    public static WebElement inputPassword;
    @FindBy(id = "days")
    public static WebElement drpDownDays;
    @FindBy(id = "months")
    public static WebElement drpDownMonths;
    @FindBy(id = "years")
    public static WebElement drpDownYears;
    @FindBy(id = "first_name")
    public static WebElement inputFirstName;
    @FindBy(id = "last_name")
    public static WebElement inputLastName;
    @FindBy(id = "address1")
    public static WebElement inputAddress1;
    @FindBy(name = "country")
    public static WebElement drpDownCountry;
    @FindBy(name = "state")
    public static WebElement inputState;
    @FindBy(name = "city")
    public static WebElement inputCity;
    @FindBy(name = "zipcode")
    public static WebElement inputZipCode;
    @FindBy(name = "mobile_number")
    public static WebElement inputMobileNumber;
    @FindBy(xpath = "//button[text()=\"Create Account\"]")
    public static WebElement btnCreateAcc;
    @FindBy(xpath = "//h2[@data-qa=\"account-created\"]/following-sibling::p")
    public static WebElement txtAccountCreation;
    @FindBy(xpath = "//a[text()=\"Continue\"]")
    public static WebElement btnContinue;
    @FindBy(id = "newsletter")
    public static WebElement chckNewsLetter;
    @FindBy(id = "optin")
    public static WebElement chckSpecialOffers;
    @FindBy(xpath = "//ul/li[10]/a")
    public static WebElement menuLoggedIn;
    @FindBy(xpath = "//ul/li[5]/a")
    public static WebElement linkDeleteAccount;
    @FindBy(xpath = "//h2[@data-qa=\"account-deleted\"]/following-sibling::p[1]")
    public static WebElement txtAccountDeletion;


    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void registerUser(String userName, String userEmail) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        inputName.sendKeys(userName);
        wait.until(ExpectedConditions.elementToBeClickable(inputEmail));
        inputEmail.sendKeys(userEmail);
        clickSignUp();

    }

    public void enterAccountInfo(String password, String day, String month, String year) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(radioBtnTitle_Mrs));
        radioBtnTitle_Mrs.click();
        inputPassword.sendKeys(password);
        Select days = new Select(drpDownDays);
        days.selectByVisibleText(day);

        Select months = new Select(drpDownMonths);
        months.selectByVisibleText(month);

        Select years = new Select(drpDownYears);
        years.selectByVisibleText(year);

        chckNewsLetter.click();
        chckSpecialOffers.click();

    }

    public void enterAddressInfo(String firstName, String lastName, String address, String country, String state, String city, String zipCode, String mobile) {
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputAddress1.sendKeys(address);
        Select selectCountry = new Select(drpDownCountry);
        selectCountry.selectByVisibleText(country);
        inputCity.sendKeys(city);
        inputState.sendKeys(state);
        inputZipCode.sendKeys(zipCode);
        inputMobileNumber.sendKeys(mobile);
        clickCreateAccount();
    }

    public void clickCreateAccount() {
        btnCreateAcc.click();
    }

    public void clickSignUp() {
        btnsignUp.click();
    }

    public void deleteAccount() {
        linkDeleteAccount.click();
    }

}
