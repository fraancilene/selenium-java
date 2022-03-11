package testes.formulario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TesteBotoes {

    private WebDriver driver;

    @Before
    public void inicializaBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\franc\\Documents\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "\\src\\main\\resources\\componentes.html");

    }

//    @After
//    public void fechaBrowser(){
//        driver.quit();
//    }

    @Test
    public void testaBotaoSimples(){
        WebElement botao = driver.findElement(By.id("buttonSimple"));
        botao.click();
        assertEquals("Obrigado!",botao.getAttribute("value"));
    }

}
