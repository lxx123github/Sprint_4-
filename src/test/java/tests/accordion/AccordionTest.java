package tests.accordion;

import org.junit.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.SAMOKAT_URL;

public class AccordionTest extends BaseTest {
    @Test
    public void checkAccordion1(){
        basePage.goToUrl(SAMOKAT_URL);
        accordionPage.clickToStrelka1();
        accordionPage.checkTextInToAccordion1();
        basePage.closeDriver();


    }
    @Test
    public void checkAccordion2(){
        basePage.goToUrl(SAMOKAT_URL);
        accordionPage.clickToStrelka4();
        accordionPage.checkTextInToAccordion4();
        basePage.closeDriver();
    }
}
