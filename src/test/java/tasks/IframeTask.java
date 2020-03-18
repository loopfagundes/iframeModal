package tasks;

import appobjects.IframeAppObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class IframeTask {
    private WebDriver driver;
    private IframeAppObject iframeAppObject;
    private static final String size = "M";
    private static final int quantityProduct = 3;

    public IframeTask(WebDriver driver) {
        this.driver = driver;
        this.iframeAppObject = new IframeAppObject(driver);
    }

    public void chooseProduct() {
        iframeAppObject.getChooseProduct().click();
    }

    public void iframeQtyProduct() throws InterruptedException {
        iframeAppObject.getIframeQtyProductTextField().clear();
        iframeAppObject.getIframeQtyProductTextField().sendKeys(Integer.toString(quantityProduct)); // acho que nao é correta, mas funcionou.
        iframeAppObject.getSizeProductComboBox().selectByVisibleText(size); // esse tambem
        System.out.println(driver.getPageSource());

        /**
         * Ja tentei executar aqui e nao deu.
         * E entendi um pouco sobre getPageSource que tem dentro os elementos da pagina.
         * talvez que pode ser por causa eu coloquei "public static final String e Int" e dificil um pouco para validar ou por causa iframe?!
         */

        Thread.sleep(30);
        System.out.println(iframeAppObject.getValidateQuantityProduct().getText());
       //nao funcionou imprimir por motivo "unable to locate element"

        Assertions.assertEquals(quantityProduct, iframeAppObject.getValidateQuantityProduct().getText());
        //Antes null e agora deu error. E "unable to locate element" tambem.
    }
}