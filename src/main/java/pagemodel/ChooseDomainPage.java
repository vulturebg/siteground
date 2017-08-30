package pagemodel;

import org.junit.Assert;
import org.openqa.selenium.By;
import selenium.DriverWrapper;
import utils.Domains;

/**
 * Choose domain page implementation.
 */
public class ChooseDomainPage extends AbstractPage {
    private static final String DOMAIN_REGISTRATION_PRICE = "11.95 €/year Excl. VAT";

    private final By LOC_DOMAIN_INPUT = By.id("domainSelector");
    private final By LOC_DOMAIN_EXT = By.id("webhostingDomainSearchPreselectedTld");
    private final By LOC_PLAN_PRICE = By.cssSelector("#domain_registration .vatPriceElement");
    private final By LOC_NOTICE_TEXT = By.cssSelector("#domain_registration .vatNoticeText");
    private final By LOC_PROCEED_BTN = By.id("submitButton");

    private String domainExtSelector = "//dd[text()='%s']";

    public ChooseDomainPage(DriverWrapper driver) {
        super(driver);
    }

    /**
     * Checks correct domain registration price.
     */
    public void checkDomainRegistrationPrice() {
        String visibleRegistrationPrice = driver.getText(LOC_PLAN_PRICE)
                .concat(" ").concat(driver.getText(LOC_NOTICE_TEXT));
        Assert.assertEquals("Wrong domain registration page", DOMAIN_REGISTRATION_PRICE, visibleRegistrationPrice);
    }

    /**
     * Types domain name.
     *
     * @param domain selected domain name
     */
    public void pickDomainName(String domain, Domains domainExt) {
        driver.waitAndType(LOC_DOMAIN_INPUT, domain);
        driver.click(LOC_DOMAIN_EXT);
        // Ugly wait is used because the steps are executed too fast and when the domain extension
        // menu is open the driver selects not correct extension.
        driver.sleep(1000);
        driver.waitAndClick(By.xpath(String.format(domainExtSelector, domainExt.getExtension())));
        driver.click(LOC_PROCEED_BTN);
    }
}
