package pagemodel;

import configuration.TestProperties;
import selenium.DriverWrapper;

/**
 * Abstract page parent of all application pages.
 */
public abstract class AbstractPage {
    private final TestProperties PROPERTIES = new TestProperties();
    protected DriverWrapper driver;

    protected AbstractPage(DriverWrapper driver) {
        this.driver = driver;
    }

    /**
     * Loads url from properties file.
     */
    public void load() {
        driver.getWebDriver().get(PROPERTIES.getUrl());
        driver.getWebDriver().manage().window().maximize();
    }

    /**
     * Closes current WebDriver window.
     */
    public void close() {
        driver.getWebDriver().close();
        driver.getWebDriver().quit();
    }
}
