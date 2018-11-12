package myprojects.automation.assignment3;

import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;

/**
 * Base script functionality, can be used for all Selenium scripts.
 */
public abstract class BaseScript {

    /**
     *
     * @return New instance of {@link WebDriver} object. Driver type is based on passed parameters
     * to the automation project, returns {@link ChromeDriver} instance by default.
     */
    public static WebDriver getDriver() {
        String browser = Properties.getBrowser();
        WebDriver driver;
        String propertyName;
        String path;
        switch (browser) {
        case "firefox" :
            propertyName = "gecko";
            path = "geckodriver.exe";
            driver = new FirefoxDriver();
        case "googlechrome" :
            propertyName = "chrome";
            path = "chromedriver.exe";
            driver = new ChromeDriver();
        case "internet explorer" :
            propertyName = "ie";
            path = "IEDriverServer.exe";
            driver = new InternetExplorerDriver();
            default:
                propertyName = "chrome";
                path = "chromedriver.exe";
                driver = new ChromeDriver();

        System.setProperty(String.format("webdriver.%s.driver", propertyName), new File(BaseScript.class.getResource("/" + path).
                getFile()).getPath());
        return driver;
        }
    }

    /**
     * Creates {@link WebDriver} instance with timeout and browser window configurations.
     *
     * @return New instance of {@link EventFiringWebDriver} object. Driver type is based on passed parameters
     * to the automation project, returns {@link ChromeDriver} instance by default.
     */
    public static EventFiringWebDriver getConfiguredDriver() {
        WebDriver driver = getDriver();

       // TODO configure browser window (set timeouts, browser pindow position) and connect loggers.
        throw new UnsupportedOperationException("Method doesn't return configured WebDriver instance");
    }



}
