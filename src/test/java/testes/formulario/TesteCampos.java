package testes.formulario;

import org.junit.After;
import org.junit.Assert;
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

public class TesteCampos {

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
    public void testaTextfield(){
       // buscando um campo pelo id e escrevendo na caixa de texto
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
        assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
    }

    @Test
    public void testaTextArea(){
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste de escrita TextArea");
        assertEquals("Teste de escrita TextArea", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
    }

    @Test
    public void testaRadioButton(){
        // buscando um campo pelo id e clicando
       driver.findElement(By.id("elementosForm:sexo:0")).click();
       assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());

    }

    @Test
    public void testaCheckBox(){
        // buscando um campo pelo id e clicando
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());

    }

    @Test
    public void TestaDropdownSimples(){
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select dropdown = new Select(element);
        //dropdown.selectByIndex(3);
        //dropdown.selectByValue("superior");
        dropdown.selectByVisibleText("Especializacao"); // recomendado
        assertEquals("Especializacao",dropdown.getFirstSelectedOption().getText() );
    }

    @Test
    public void TestaDropdownSimples2(){
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select dropdown = new Select(element);

        // verificando os valores disponiveis no dropdown
        List<WebElement> options = dropdown.getOptions();

        // verificando a quantidade de opções do dropdown
        assertEquals(8, options.size());

        // verificando se há determinada opção
        boolean encontrou = false;
        for (WebElement option: options){
            if (option.getText().equals("Mestrado")){
                encontrou = true;
                break;
            }
        }
        assertTrue(encontrou);

    }

    @Test
    public void TestaDropdownMultiplaEscolha(){
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText("Natacao");
        dropdown.selectByVisibleText("Corrida");
        dropdown.selectByVisibleText("O que eh esporte?");

        List<WebElement> allSelectedOptions = dropdown.getAllSelectedOptions();
        assertEquals(3, allSelectedOptions.size());

        dropdown.deselectByVisibleText("Corrida");
        allSelectedOptions = dropdown.getAllSelectedOptions();
        assertEquals(2, allSelectedOptions.size());



    }
}
