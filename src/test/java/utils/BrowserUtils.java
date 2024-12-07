package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;

import static utils.ConstantUtils.SCREENSHOTS_PATH;

public class BrowserUtils {
    public static WebDriver getDriver(String browser){
        switch (browser.toLowerCase()){
            case "edge" : {
                return new EdgeDriver();
            }
            case "chrome": {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--start-maximized");
                    return new ChromeDriver(options);
            }
            default: {
                    return new ChromeDriver();
            }

        }
    }

    public static void generateScreenshots(String filename, WebDriver driver, boolean alertOn) throws IOException {
        if (alertOn)
            driver.switchTo().alert().accept();
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File saveFile = new File(SCREENSHOTS_PATH + "/" + filename + ".png");
        FileUtils.copyFile(screenshotFile,saveFile);

    }
}
