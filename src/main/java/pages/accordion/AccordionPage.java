package pages.accordion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class AccordionPage extends BasePage {


    public AccordionPage(WebDriver driver){
        super(driver);
    }
    private final String strelkaInAccordion = "(//div[@class='accordion__heading'])";
    private final String textInStrelkaInAccordion = "(//div[@class='accordion__panel'])";


    public String checkTextInToAccordion (String number){
        BasePage basePage = new BasePage(driver);
        AccordionPage accordionPage = new AccordionPage(driver);
        By selector =  By.xpath(strelkaInAccordion+"["+number+"]");
        accordionPage.clickToStrelka(selector);
        By selectorText = By.xpath(textInStrelkaInAccordion+"["+number+"]");
        basePage.waitElementIsVisible(driver.findElement(selectorText));
        String text = driver.findElement(selectorText).getText();
        return text;
    }
    public AccordionPage clickToStrelka (By selector){
        BasePage basePage = new BasePage(driver);
        basePage.scrollToElement(driver.findElement((By) selector));
        new WebDriverWait(driver, 10)
                .until(elementToBeClickable(selector));
        driver.findElement((By) selector).click();
        return this;
    }

}
