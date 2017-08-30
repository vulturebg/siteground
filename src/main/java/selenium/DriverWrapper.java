package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import configuration.TestProperties;

/**
 * Created by Branimir on 8/29/2017.
 */
public class DriverWrapper {
    private final TestProperties PROPERTIES = new TestProperties();
    private final WebDriver SELENIUM = DriverFactory.create();

    /**
     * Waits for element to be visible.
     * @param locator element locator
     *
     * @return
     */
    public WebElement waitForElementVisibility(By locator) {
        return new WebDriverWait(SELENIUM, PROPERTIES.getTimeout())
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Gets underlying WebDriver instance.
     *
     * @return selenium WebDriver instance
     */
    public WebDriver getWebDriver() {
        return SELENIUM;
    }

    /**
     * Clicks element without waiting.
     *
     * @param locator element locator
     */
    public void click(By locator) {
        SELENIUM.findElement(locator).click();
    }

    /**
     * Types text without waiting.
     *
     * @param locator element locator
     * @param text input text
     */
    public void type(By locator, String text) {
        SELENIUM.findElement(locator).sendKeys(text);
    }

    /**
     * Waits for element visibility and clicks.
     *
     * @param locator element locator
     */
    public void waitAndClick(By locator) {
        waitForElementVisibility(locator).click();
    }

    /**
     * Waits for element and types text.
     *
     * @param locator element locator
     * @param text text to type
     */
    public void waitAndType(By locator, String text) {
        waitForElementVisibility(locator).sendKeys(text);
    }

    /**
     * Waits for element and gets text text.
     *
     * @param locator element locator
     * @return element text
     */
    public String waitAndGetText(By locator) {
        return waitForElementVisibility(locator).getText();
    }

    /**
     * Gets element text.
     *
     * @param locator element locator
     * @return element text
     */
    public String getText(By locator) {
        return SELENIUM.findElement(locator).getText();
    }

    /**
     * Sleeps the thread for ugly wait.
     *
     * @param millis
     */
    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch(Exception e) { }
    }
}
