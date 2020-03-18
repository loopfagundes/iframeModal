package appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class IframeAppObject {
    private WebDriver driver;

    public IframeAppObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getChooseProduct() {
        WebElement element = driver.findElement(By.cssSelector("#center_column > ul > li:nth-child(5) > div > div.left-block > div"));
        Actions action = new Actions(driver); // <- vou tentar criar uma classe e metodo dentro do framework, nao sei se necessario?!
        action.moveToElement(element).build().perform();
        return element.findElement(By.cssSelector("a.quick-view"));
    }

    public WebElement getIframeQtyProductTextField() {
        driver.switchTo().defaultContent(); // <- é correto?
        WebElement iframeElement = driver.findElement(By.cssSelector(".fancybox-iframe"));
        WebDriver iframeDriver = driver.switchTo().frame(iframeElement);
        return iframeDriver.findElement(By.id("quantity_wanted"));
    }

    public Select getSizeProductComboBox() {
        return new Select(driver.findElement(By.id("group_1")));
    }

    public WebElement getValidateQuantityProduct() {
        return driver.findElement(By.id("layer_cart_product_quantity"));
        //é os elementos dos atributos para validar se correta quantidade dos produtos.
    }
}