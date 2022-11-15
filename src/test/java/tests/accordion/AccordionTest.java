package tests.accordion;

import org.junit.Before;
import org.junit.Test;
import pages.accordion.AccordionPage;
import pages.base.BasePage;
import tests.base.BaseTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static constants.Constant.Urls.SAMOKAT_URL;
import static org.junit.Assert.assertEquals;



//@RunWith(Parameterized.class)
//public class AccordionTest extends BaseTest {
//    @Test
//    public void checkAccordion1(){
//
//        basePage.goToUrl(SAMOKAT_URL);
//        //accordionPage.clickToStrelka1();
//        //accordionPage.checkTextInToAccordion1();
//        basePage.closeDriver();
//    }

    @RunWith(Parameterized.class)
    public class AccordionTest extends BaseTest{
        private final String number;
        private final String expected;
        public AccordionTest(String number, String expected) {
            this.number = number;
            this.expected = expected;
        }
        @Parameterized.Parameters
        public static   Object[][] getSumData() {
            return new Object[][] {
                    { "1", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                    { "2", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                    { "3", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                    { "4", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                    { "5", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                    { "6", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                    { "7", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                    { "8", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},

            };
        }

        @Test
        public void checkTextInAccordion() {
            BasePage basePage = new BasePage(driver);
            basePage.goToUrl(SAMOKAT_URL);
            AccordionPage accordionPage = new AccordionPage(driver);
            String actual = accordionPage.checkTextInToAccordion(number);
            assertEquals(expected, actual);
        }
    }



