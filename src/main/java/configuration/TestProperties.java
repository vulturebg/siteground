package configuration;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Class for loading test execution properties.
 */
public class TestProperties {
    private final static String URL_PROPERTY = "application.url";
    private final static String WEBDRIVER_TIMEOUT = "webdriver.timeout";

    private Properties testProperties;

    public TestProperties() {
        try {
            testProperties = new Properties();
            testProperties.load(new FileInputStream("src\\main\\resources\\test.properties"));
        } catch(Exception e) {
            System.out.println("Could not load properties file");
        }
    }

    public String getUrl() {
        return testProperties.getProperty(URL_PROPERTY);
    }

    public int getTimeout() {
        return Integer.parseInt(testProperties.getProperty(WEBDRIVER_TIMEOUT));
    }
}
