package pages.order;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.accordion.AccordionPage;
import pages.base.BasePage;

import java.time.Duration;

import static constants.Constant.DataForOrder.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class OrderPage extends BasePage {

    public OrderPage(WebDriver driver){
        super(driver);
    }

    private final By upOrderButton = By.xpath("//button[@class='Button_Button__ra12g']");
    // private final By downOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");
    private final By downOrderButton = By.xpath("//div[@class='Home_FinishButton__1_cWm']");


    private final By nameField = By.xpath("(//div/input[@type='text'])[2]");
    private final By serNameField = By.xpath("(//div/input[@type='text'])[3]");

    private final By addressField = By.xpath("(//div/input[@type='text'])[4]");

    private final By metroStationField = By.xpath("//input[@class='select-search__input' and @placeholder='* Станция метро']");
    private final By chooseMetroStationField = By.xpath(".//button[@value=1]");
    private final By rentalPeriodField = By.xpath("//div[@class='Dropdown-control' and @aria-haspopup='listbox']");
    private final By chooseRentalPeriod = By.xpath("(.//div[@class='Dropdown-option'])[1]");
    private final By chooseDayInCalendar = By.xpath("//div[@class='react-datepicker__day react-datepicker__day--001 react-datepicker__day--selected']");

    private final By numberField = By.xpath("(//div/input[@type='text'])[5]");
    private final By nextButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private final By dateField = By.xpath("(//input[@type='text'])[2]");
    private final By colorBlack = By.xpath("(//input[@id='black'])");

    private final By orderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By yesButton = By.xpath("(//button[@class='Button_Button__ra12g Button_Middle__1CSJM'])[2]");

    private final By orderComplete = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");


    public OrderPage clickToUpOrderButton (){
        new WebDriverWait(driver, 10)
                .until(elementToBeClickable(upOrderButton));
        driver.findElement(upOrderButton).click();
        return this;
    }

    public OrderPage clickToDownOrderButton (){
        BasePage basePage = new BasePage(driver);

        basePage.scrollToElement(driver.findElement(downOrderButton));
        new WebDriverWait(driver, 15)
                .until(elementToBeClickable(downOrderButton));
        driver.findElement(downOrderButton).click();
        return this;
    }

    public OrderPage inputName(){
        BasePage basePage = new BasePage(driver);
        basePage.clearAndType(driver.findElement(nameField),NAME);
        return this;
    }

    public OrderPage inputSerName(){
        BasePage basePage = new BasePage(driver);
        basePage.clearAndType(driver.findElement(serNameField),SURNAME);
        return this;
    }

    public OrderPage inputAddress(){
        BasePage basePage = new BasePage(driver);
        basePage.clearAndType(driver.findElement(addressField),ADDRESS);
        return this;
    }

    public OrderPage chooseMetroStation(){
        driver.findElement(metroStationField).click();

        new WebDriverWait(driver, 3)
                .until((ExpectedConditions.visibilityOfElementLocated(chooseMetroStationField)));

        WebElement metroStation = driver.findElement(chooseMetroStationField);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", metroStation );

        metroStation.click();
        return this;
    }

    public OrderPage inputNumber(){
        BasePage basePage = new BasePage(driver);
        basePage.clearAndType(driver.findElement(numberField),NUMBER);
        return this;
    }


    public OrderPage clickNextButton(){
            new WebDriverWait(driver, 10)
                    .until(elementToBeClickable(nextButton));
            driver.findElement(nextButton).click();
        return this;
    }

    public OrderPage inputDate(){
        BasePage basePage = new BasePage(driver);
        basePage.clearAndType(driver.findElement(dateField),DATE);
        driver.findElement(chooseDayInCalendar).click();
        return this;
    }

    public OrderPage chooseRentalPeriod(){
        driver.findElement(rentalPeriodField).click();
        new WebDriverWait(driver, 3)
                .until((ExpectedConditions.visibilityOfElementLocated(rentalPeriodField)));

        WebElement period = driver.findElement(chooseRentalPeriod);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", period );

        period.click();
        return this;
    }

    public OrderPage chooseColorClick (){
        driver.findElement(colorBlack).click();
        return this;
    }

    public OrderPage clickOrderButton (){
        driver.findElement(orderButton).click();
        return this;
    }

    public OrderPage clickYesButton (){
        driver.findElement(yesButton).click();
        return this;
    }

    public OrderPage assertOrderComplete (){
        assertThat(driver.findElement(orderComplete).getText(), is("Заказ оформлен"));
        return this;
    }
}
