package frameworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilsFw {
    private WebDriver driver;
    private static final int WAIT_SEC = 30;

    public static void waitElementClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_SEC);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void visibilityOfElementLocated(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_SEC);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void presenceOfElementLocated(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_SEC);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void visibilityOf(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_SEC);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void visibilityOf(WebDriver driver, WebElement element, int timeOutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}