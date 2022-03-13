package testes.formulario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TestAlerts {

    private WebDriver driver;

    @Before
    public void inicializaBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\franc\\Documents\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "\\src\\main\\resources\\componentes.html");

    }

    @After
    public void fechaBrowser(){
        driver.quit();
    }

    @Test
    public void testaAlertSimples(){
        driver.findElement(By.id("alert")).click();

        // elementos externos a página - alterando o foco para o alerta
        Alert alert = driver.switchTo().alert();
        String textoAlert = alert.getText();
        assertEquals("Alert Simples", textoAlert);
        alert.accept(); // aceitando o alerta

        driver.findElement(By.id("elementosForm:nome")).sendKeys(textoAlert);

    }

    @Test
    public void testAlertaConfirmAccept(){

        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Confirm Simples", alert.getText());
        alert.accept();
        assertEquals("Confirmado", alert.getText());
        alert.accept();
    }


    @Test
    public void testAlertaConfirmDismiss(){
        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Confirm Simples", alert.getText());
        alert.dismiss();
        assertEquals("Negado", alert.getText());
        alert.accept();

    }

    @Test
    public void testAlertPrompt(){
        driver.findElement(By.id("prompt")).click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Digite um numero", alert.getText());

        // escrevendo no prompt
        alert.sendKeys("12");
        alert.accept();

        assertEquals("Era 12?", alert.getText());
        alert.accept();

        assertEquals(":D", alert.getText());
        alert.dismiss();

    }





}
