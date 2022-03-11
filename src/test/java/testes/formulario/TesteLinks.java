package testes.formulario;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TesteLinks {

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
    public void testeLinkSemId(){

        // pegando elemento pelo texto visivel do link
        WebElement link = driver.findElement(By.linkText("Voltar"));
        link.click();
        WebElement linkResult = driver.findElement(By.id("resultado"));
        assertEquals("Voltou!", linkResult.getText() );
    }

    @Test
    public void buscaTextoNaPagina(){
        // forma 1 - não recomendada
        //assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));

        // forma 2
        assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());

    }

    @Test
    public void buscaSpan(){
        // busca pela classe
        assertEquals("Cuidado onde clica, muitas armadilhas...",
                driver.findElement(By.className("facilAchar")).getText());
    }











}

