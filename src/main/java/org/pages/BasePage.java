package org.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasePage {
    public static String BASE_URL = "https://www.automationexercise.com/login";

    protected WebDriver driver;

    static {
        // Static block - executed when class loads
        WebDriverManager.chromedriver().setup();
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriver initiateBrowser(String baseURL) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(baseURL);
        return driver;
    }


}
