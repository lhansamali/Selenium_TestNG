package tests;

import org.openqa.selenium.WebDriver;
import org.commonmethods.CommonFunctions;
import org.pages.LoginPage;
import org.pages.MainPage;
import org.testdata.LoginUserData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.pages.BasePage.BASE_URL;
import static org.pages.BasePage.initiateBrowser;
import static org.pages.LoginPage.lblCredentialError;
import static org.pages.MainPage.*;

public class LoginTest {

    LoginPage loginPage;
    WebDriver driver;
    SoftAssert softAssert;
    MainPage mainPage;
    String userEmail = LoginUserData.USER_EMAIL;
    String password = LoginUserData.PASSWORD;

    @BeforeMethod
    public void setUp() {
        softAssert = new SoftAssert();
        driver = initiateBrowser(BASE_URL);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    @Test
    public void verifyCorrectLogin() {
        loginPage.login(userEmail, password);
        CommonFunctions.wait(driver, menuLoggedIn);
        softAssert.assertEquals(menuLoggedIn.getText(), "Logged in as 8L0mE");
        softAssert.assertAll();

    }

    @Test
    public void verifyIncorrectCredentials() {
        String invalidUserEmail = CommonFunctions.generateRandomString(4) + "@yahoo.com";
        String invalidPassword = CommonFunctions.generateRandomString(4);
        loginPage.login(invalidUserEmail, invalidPassword);
        softAssert.assertEquals(lblCredentialError.getText(), "Your email or password is incorrect!");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "verifyCorrectLogin")
    public void verifyLogOut() {
        linkLoggedOut.click();
        softAssert.assertEquals(linkSignUpLogin.getText(), " Signup / Login");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
