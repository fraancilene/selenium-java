package testes.formulario.cadastro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestaCadastro {

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
    public void testaCadastroComSucesso(){
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Francilene");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Silva");
        driver.findElement(By.id("elementosForm:sexo:1")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();


        Select escolaridade = new Select(driver.findElement(By.id("elementosForm:escolaridade")));
        escolaridade.selectByVisibleText("Superior");

        Select esporte = new Select(driver.findElement(By.id("elementosForm:esportes")));
        esporte.selectByVisibleText("Corrida");

        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Testando cadastro com Sucesso");
        driver.findElement(By.id("elementosForm:cadastrar")).click();

        assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado"));
        assertEquals("Nome: Francilene", driver.findElement(By.id("descNome")).getText());
        assertEquals("Sobrenome: Silva", driver.findElement(By.id("descSobrenome")).getText());
        assertEquals("Sexo: Feminino", driver.findElement(By.id("descSexo")).getText());
        assertEquals("Comida: Frango", driver.findElement(By.id("descComida")).getText());
        assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
        assertEquals("Esportes: Corrida", driver.findElement(By.id("descEsportes")).getText());
        assertEquals("Sugestoes: Testando cadastro com Sucesso", driver.findElement(By.id("descSugestoes")).getText());
    }
}
