package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IPLMatches {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();


        driver.get("https://www.iplt20.com/matches/points-table");
        WebElement table=driver.findElement(By.xpath("//div[@class=\"points-table-page\"]//table[@class=\"ih-td-tab\"]"));
        List<WebElement> rows=table.findElements(By.xpath("//tbody[@id=\"pointsdata\"]/tr"));

        Map<String,Double> scoreMap=new HashMap<>();
        for(WebElement row:rows){
            List<WebElement> cells=row.findElements(By.tagName("td"));
            if(cells.size()>=6){
                String teamName=cells.get(2).getText();
                double nrrText=Double.parseDouble(cells.get(7).getText());
                scoreMap.put(teamName,nrrText);
            }
        }
        getScoreDescendingOrder(scoreMap);
        driver.quit();
    }
    public static void getScoreDescendingOrder(Map<String,Double> map){
       List<Map.Entry<String,Double>> mapList=new ArrayList<>(map.entrySet());
       mapList.sort(Map.Entry.<String,Double>comparingByValue().reversed());
       System.out.println(mapList);
    }

}
