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
    WebElement inputName;
    @FindBy(xpath = "//input[@data-qa=\"signup-email\"]")
    WebElement inputEmail;
    @FindBy(xpath = "//button[text()=\"Signup\"]")
    WebElement btnsignUp;
    @FindBy(id = "uniform-id_gender2")
    WebElement radioBtnTitle_Mrs;
    @FindBy(id = "password")
    WebElement inputPassword;
    @FindBy(id = "days")
    WebElement drpDownDays;
    @FindBy(id = "months")
    WebElement drpDownMonths;
    @FindBy(id = "years")
    WebElement drpDownYears;
    @FindBy(id = "first_name")
    WebElement inputFirstName;
    @FindBy(id = "last_name")
    WebElement inputLastName;
    @FindBy(id = "address1")
    WebElement inputAddress1;
    @FindBy(name = "country")
    WebElement drpDownCountry;
    @FindBy(name = "state")
    WebElement inputState;
    @FindBy(name = "city")
    WebElement inputCity;
    @FindBy(name = "zipcode")
    WebElement inputZipCode;
    @FindBy(name = "mobile_number")
    WebElement inputMobileNumber;
    @FindBy(xpath = "//button[text()=\"Create Account\"]")
    WebElement btnCreateAcc;
    @FindBy(xpath = "//h2[@data-qa=\"account-created\"]/following-sibling::p")
    public static WebElement txtAccountCreation;
    @FindBy(xpath = "//a[text()=\"Continue\"]") public static WebElement btnContinue;


    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void registerUser(String userName, String userEmail) {
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(30));
        inputName.sendKeys(userName);
        wait.until(ExpectedConditions.elementToBeClickable(inputEmail));
        inputEmail.sendKeys(userEmail);
        clickSignUp();

    }

    public void enterAccountInfo(String password, String day, String month, String year) {
        radioBtnTitle_Mrs.click();
        inputPassword.sendKeys(password);
        Select days = new Select(drpDownDays);
        days.selectByVisibleText(day);

        Select months = new Select(drpDownMonths);
        months.selectByVisibleText(month);

        Select years = new Select(drpDownYears);
        years.selectByVisibleText(year);

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

}
