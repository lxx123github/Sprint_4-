package tests.base;

import common.CommonActions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import pages.accordion.AccordionPage;
import pages.base.BasePage;
import pages.order.OrderPage;

import static constants.Constant.Urls.SAMOKAT_URL;

public class BaseTest {
    protected static WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected AccordionPage accordionPage = new AccordionPage(driver);
    protected OrderPage orderPage = new OrderPage(driver);





}
