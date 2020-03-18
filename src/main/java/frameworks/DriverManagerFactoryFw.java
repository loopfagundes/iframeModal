package frameworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;

import java.util.concurrent.TimeUnit;

public class DriverManagerFactoryFw {
    private static WebDriver driver;

    private static WebDriver getManager(DriverTypeFw type) {
        switch (type) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case IE:
                WebDriverManager.iedriver().setup();
                MutableCapabilities caps = new MutableCapabilities();
                caps.setCapability(CapabilityType.BROWSER_NAME, BrowserType.IE);
                caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                driver = new InternetExplorerDriver();
                break;

            case CHROME_HEADLESS:
                WebDriverManager.chromedriver().setup();
                ChromeOptions option_headless = new ChromeOptions();
                option_headless.addArguments("--headless");
                option_headless.addArguments("--windows-size(1366, 768)");
                driver = new ChromeDriver(option_headless);
                break;

            default:
                break;
        }

        return driver;
    }

    public static WebDriver setDriver(DriverTypeFw type) {
        if(driver == null) {
            driver = getManager(type);
        }
        return driver;
    }

    public static void quitDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}