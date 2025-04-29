import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.CommonFunctions;
import org.pages.RegisterPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.pages.BasePage.BASE_URL;
import static org.pages.RegisterPage.txtAccountCreation;

public class RegisterUserTest {
    WebDriver driver;
    RegisterPage registerPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        softAssert = new SoftAssert();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        registerPage = new RegisterPage(driver);
    }

    @Test(dataProvider="RegisterUserData")
    public void verifyUserRegistration(String password,String day,String month,String year) {
        String userName = "User" + CommonFunctions.generateRandomString(5);
        String userEmail = CommonFunctions.generateRandomString(5) + "@gmail.com";
        String firstName = "FirstName" + CommonFunctions.generateRandomString(2);
        String lastName = "LastName" + CommonFunctions.generateRandomString(3);
        String address = "First Road";
        registerPage.registerUser(userName, userEmail);
        registerPage.enterAccountInfo(password,day,month,year);
        registerPage.enterAddressInfo(firstName, lastName, address, "Australia", "West", "Sydney", "8888", "666666666");
        softAssert.assertEquals(txtAccountCreation.getText(), "Congratulations! Your new account has been successfully created!");
        registerPage.btnContinue.click();
        softAssert.assertAll();
    }
    @DataProvider(name="RegisterUserData")
    public Object[][] registerUserData() {
        return new Object[][] {
                {CommonFunctions.generateRandomString(10),"2","March","1994" },
        };
    }
    @AfterMethod
    public void tearDown() {
         driver.quit();
    }

}
