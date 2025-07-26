package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DynamicContentLoad {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.worldometers.info/coronavirus/#countries");
        WebElement table=driver.findElement(By.id("main_table_countries_today"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(table));

        List<WebElement> rows=table.findElements(By.xpath(" //tbody/tr"));
        for(int i=4;i<=10;i++){
            List<WebElement> cells=rows.get(i).findElements(By.tagName("td"));
            if(cells.size()>=7){
                String totalCases=cells.get(2).getText().replaceAll("\\D", "");
                if(totalCases.isEmpty()){
                    System.out.println("Total cases are Empty or Non numeric");
                }else {
                    try {
                        Integer.parseInt(totalCases);
                        System.out.println(totalCases+" Valid Numeric");
                    }catch (NumberFormatException num){
                        System.out.println("Not a valid number format"+num);
                    }
                }
            }

        }
        driver.quit();
    }
}
