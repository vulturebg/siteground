package pagemodel;

import org.openqa.selenium.By;
import selenium.DriverWrapper;
import utils.Plans;

/**
 * Choose plan page implementation.
 */
public class ChoosePlanPage extends AbstractPage {
    private String PLAN_SELECTOR_PATTERN = "div.owl-item:nth-of-type(%d) a.bblue";

    public ChoosePlanPage(DriverWrapper driver) {
        super(driver);
    }

    /**
     * Selects hosting plan.
     *
     * @param plan plan to choose
     */
    public void selectPlan(Plans plan) {
        By planLocator = By.cssSelector(String.format(PLAN_SELECTOR_PATTERN, plan.getValue()));
        driver.waitAndClick(planLocator);
    }
}
