package tests;

import org.openqa.selenium.WebDriver;
import org.pages.BasePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import static org.pages.BasePage.BASE_URL;

public class BaseTest {
   public SoftAssert softAssert;
   public WebDriver driver;
    @BeforeMethod
    public void init(){
        softAssert=new SoftAssert();
        driver= BasePage.initiateBrowser(BASE_URL);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
