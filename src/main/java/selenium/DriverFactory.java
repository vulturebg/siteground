package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Branimir on 8/30/2017.
 */
public class DriverFactory {
    private static final String DRIVERS_PATH = "src\\main\\resources\\drivers";

    public static WebDriver create() {
        System.setProperty("webdriver.chrome.driver", DRIVERS_PATH.concat("\\chromedriver.exe"));
        return new ChromeDriver();
    }
}
