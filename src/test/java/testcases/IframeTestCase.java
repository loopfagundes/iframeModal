package testcases;

import frameworks.BaseTestFw;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import tasks.IframeTask;

public class IframeTestCase extends BaseTestFw {
    private WebDriver driver = getDriver();
    private IframeTask iframeTask = new IframeTask(driver);

    @BeforeEach
    public void setUp() {
        driver.get("http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=");
    }

    @Test
    void test() throws InterruptedException {
        iframeTask.chooseProduct();
        iframeTask.iframeQtyProduct();
    }
}

// aqui é so para pratica e teste com iframe, ver se funcionar.