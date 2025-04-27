package org.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BasePage {
    public static String BASE_URL="https://www.automationexercise.com/login";

    protected WebDriver driver;
    static {
        // Static block - executed when class loads
        WebDriverManager.chromedriver().setup();
    }

    public BasePage(WebDriver driver){
        this.driver=driver;
    }


}
