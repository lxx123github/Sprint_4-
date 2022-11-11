package pages.accordion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class AccordionPage extends BasePage {


    public AccordionPage(WebDriver driver){
        super(driver);
    }

    private final By strelkaInAccordion1 = By.xpath("(//div[@class='accordion__heading'])[1]");
    private final By textInStrelkaInAccordion1 = By.xpath("(//div[@class='accordion__panel'])[1]");
    private final By strelkaInAccordion4 = By.xpath("(//div[@class='accordion__heading'])[4]");
    private final By textInStrelkaInAccordion4 = By.xpath("(//div[@class='accordion__panel'])[4]");

    private final By header = By.className("Header_LogoScooter__3lsAR");


    public AccordionPage clickToStrelka1 (){
        BasePage basePage = new BasePage(driver);
        basePage.scrollToElement(driver.findElement(strelkaInAccordion1));
        new WebDriverWait(driver, 10)
            .until(elementToBeClickable(strelkaInAccordion1));
        driver.findElement(strelkaInAccordion1).click();
        return this;
    }

    public AccordionPage clickToStrelka4 (){
        BasePage basePage = new BasePage(driver);
        basePage.scrollToElement(driver.findElement(strelkaInAccordion4));
        new WebDriverWait(driver, 10)
                .until(elementToBeClickable(strelkaInAccordion4));
        driver.findElement(strelkaInAccordion4).click();
        return this;
    }

    public AccordionPage checkTextInToAccordion1 (){
        BasePage basePage = new BasePage(driver);
        basePage.waitElementIsVisible(driver.findElement(textInStrelkaInAccordion1));
        assertThat(driver.findElement(textInStrelkaInAccordion1).getText(), is("Сутки — 400 рублей. Оплата курьеру — наличными или картой."));
        return this;
    }

    public AccordionPage checkTextInToAccordion4 (){
        BasePage basePage = new BasePage(driver);
        basePage.waitElementIsVisible(driver.findElement(textInStrelkaInAccordion4));
        assertThat(driver.findElement(textInStrelkaInAccordion4).getText(), is("Только начиная с завтрашнего дня. Но скоро станем расторопнее."));
        return this;
    }

}
