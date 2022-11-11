package tests.order;

import org.junit.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.SAMOKAT_URL;

public class OrderTest extends BaseTest {
    @Test
    public void checkOrderUpButton(){
        basePage.goToUrl(SAMOKAT_URL);
        orderPage.clickToUpOrderButton();
        orderPage.inputName();
        orderPage.inputSerName();
        orderPage.inputAddress();
        orderPage.chooseMetroStation();
        orderPage.inputNumber();
        orderPage.clickNextButton();
        orderPage.inputDate();
        orderPage.chooseRentalPeriod();
        orderPage.chooseColorClick();
        orderPage.clickOrderButton();
        orderPage.clickYesButton();
        orderPage.assertOrderComplete();
        basePage.closeDriver();
    }

    @Test
    public void checkOrderDownButton(){
        basePage.goToUrl(SAMOKAT_URL);
        orderPage.clickToDownOrderButton();
        orderPage.inputName();
        orderPage.inputSerName();
        orderPage.inputAddress();
        orderPage.chooseMetroStation();
        orderPage.inputNumber();
        orderPage.clickNextButton();
        orderPage.inputDate();
        orderPage.chooseRentalPeriod();
        orderPage.chooseColorClick();
        orderPage.clickOrderButton();
        orderPage.clickYesButton();
        orderPage.assertOrderComplete();
        basePage.closeDriver();
    }
}
