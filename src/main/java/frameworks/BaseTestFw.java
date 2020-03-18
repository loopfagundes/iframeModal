package frameworks;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import static frameworks.DriverManagerFactoryFw.quitDriver;
import static frameworks.DriverManagerFactoryFw.setDriver;

public class BaseTestFw {

    private WebDriver driver;

    public WebDriver getDriver() {
        this.driver = setDriver(DriverTypeFw.CHROME);
        return driver;
    }

    @AfterEach
    public void tearDown() {
        quitDriver();
    }
}