package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class BasePage {

    public WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void goToUrl (String url){
        driver.get(url);
    }

    public void closeDriver (){
        driver.quit();
    }


    public WebElement waitElementIsVisible (WebElement element){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void waitForLoadElement(WebElement element){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clearAndType (WebElement element, String text) {
        element.sendKeys("");
        element.sendKeys(text);
    }

}
