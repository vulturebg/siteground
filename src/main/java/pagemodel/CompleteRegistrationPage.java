package pagemodel;

import org.junit.Assert;
import org.openqa.selenium.By;
import selenium.DriverWrapper;
import utils.Plans;

/**
 * Complete register domain page implementation.
 */
public class CompleteRegistrationPage extends AbstractPage {
    private final static String EXPECTED_MESSAGE = "Domain %s is available for registration with your hosting account!";

    private final By LOC_MESSAGE = By.cssSelector(".fit .mb20");
    private final By LOC_SELECTED_PLAN = By.id("plan_change_string");

    public CompleteRegistrationPage(DriverWrapper driver) {
        super(driver);
    }

    /**
     * Checks if correct domain is available in congratulation message.
     *
     * @param domain expected domain.
     */
    public void checkCorrectDomainInMessage(String domain) {
        String actual = driver.waitAndGetText(LOC_MESSAGE);

        Assert.assertEquals("Successful message is not expected" ,
                String.format(EXPECTED_MESSAGE, domain),
                actual);
    }

    /**
     * Checks if given plan is selected in page.
     *
     * @param plan expected plan
     */
    public void checkCorrectDomainPlanSelected(Plans plan) {
        Assert.assertEquals("Selected plan does not match", driver.waitAndGetText(LOC_SELECTED_PLAN), plan.getLabel());
    }
}
