package tests;

import org.commonmethods.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.pages.HomePage;
import org.pages.LoginPage;
import org.pages.MainPage;
import org.pages.RegisterPage;
import org.testdata.LoginUserData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.pages.MainPage.linkSignUpLogin;
import static org.pages.MainPage.menuLoggedIn;
import static org.pages.RegisterPage.*;
import static org.testdata.RegisterUserData.*;

public class RegisterUserTest extends BaseTest {
    RegisterPage registerPage;
    MainPage mainPage;
    HomePage homePage;
    LoginPage loginPage;
    public static String userName = "User" + CommonFunctions.generateRandomString(5);
    public static String userEmail = CommonFunctions.generateRandomString(5) + "@gmail.com";
    private static String userPassword = password();

    @BeforeMethod
    public void setUp() {
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        homePage = new HomePage(driver);
        homePage.clickOnLoginSignUpLink();
    }

    @Test(dataProvider = "RegisterUserData", priority = 1)
    public void verifyUserRegistration(AccountInfo accountInfo, UserInfo userInfo) {
        registerPage.registerUser(userName, userEmail);
        registerPage.enterAccountInfo(accountInfo.password(), accountInfo.day(), accountInfo.month(), accountInfo.year());

        //Check if the Years dropdown values are Sorted
        Select dropDownYears = new Select(drpDownYears);
        List<WebElement> years = dropDownYears.getOptions();
        Result result = getResult(years);
        softAssert.assertEquals(result.yearOptions(), result.sortedYears(), "Year is not Sorted");

        //Verify that successfully signed up
        registerPage.enterAddressInfo(
                userInfo.firstName(),
                userInfo.lastName(),
                userInfo.address(),
                userInfo.country(),
                userInfo.state(),
                userInfo.city(),
                userInfo.zipCode(),
                userInfo.mobile()
        );
        softAssert.assertTrue(txtAccountCreation.getText().contains("Congratulations! Your new account has been successfully created!"));
        btnContinue.click();

        //Verify User Name
        softAssert.assertTrue(MainPage.menuLoggedIn.getText().contains(userName));
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "verifyUserRegistration", priority = 2)
    public void deleteAccount() {
        loginPage.login(userEmail, userPassword);
        CommonFunctions.wait(driver, menuLoggedIn);
        mainPage.deleteAccount();
        CommonFunctions.wait(driver, MainPage.txtAccountDeletion);
        //Verify account deletion
        softAssert.assertEquals(MainPage.txtAccountDeletion.getText(), "Your account has been permanently deleted!");
        btnContinue.click();
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void registerWithExistingEmail() {
        linkSignUpLogin.click();
        String userName = "User" + CommonFunctions.generateRandomString(5);
        softAssert.assertEquals(lblNewSignUp.getText(), "New User Signup!");
        registerPage.registerUser(userName, LoginUserData.USER_EMAIL);
        softAssert.assertEquals(lblExistingEmailError.getText(), "Email Address already exist!");
        softAssert.assertAll();
    }


    private static Result getResult(List<WebElement> years) {
        List<String> yearOptions = new ArrayList<>();
        for (WebElement yearOption : years) {
            yearOptions.add(yearOption.getText());
        }
        yearOptions.remove(0);//Remove first element which contains String 'Year'
        List<String> sortedYears = new ArrayList<>(yearOptions);
        sortedYears.sort(Collections.reverseOrder());
        return new Result(yearOptions, sortedYears);
    }

    private record Result(List<String> yearOptions, List<String> sortedYears) {
    }

    record UserInfo(String firstName, String lastName, String address, String country, String state,
                    String city, String zipCode, String mobile) {
    }

    record AccountInfo(String password, String day, String month, String year) {
    }

    @DataProvider(name = "RegisterUserData")
    public Object[][] registerUserData() {

        return new Object[][]{
                {
                        new AccountInfo(userPassword, "2", "March", "1994"),
                        new UserInfo(firstName(), lastName(), address(), country, state, city, zipCode, mobile)

                }
        };
    }

}
