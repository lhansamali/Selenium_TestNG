package util;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.pages.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalTime;

@Log4j
public class ScreenShotsUtil extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(ScreenShotsUtil.class);

    public ScreenShotsUtil(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static void takeScreenShots(String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String localTime = LocalTime.now().toString().replace(":", "-").replace(".", "");
        String fileName = "screenshots/" + testName + "_" + localTime + ".png";
        try {
            File dest = new File(fileName);
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            log.info("ScreenShot is saved.{}", fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
