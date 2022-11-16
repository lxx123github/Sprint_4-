package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static common.Config.BROWSER;

public class CommonActions {
    public static WebDriver createDriver(){
        WebDriver driver = null;
        switch (BROWSER){
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver= new ChromeDriver();
                break;
            case "MOZILLA":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
                driver= new FirefoxDriver();
                break;
            default:
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
}
