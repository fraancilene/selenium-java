package testes.formulario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class FramesEjanelas {

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
    public void testaFrame(){
        // alterando o foco para o frame para conseguir buscar o elemento
        driver.switchTo().frame("frame1");

        driver.findElement(By.id("frameButton")).click();
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        assertEquals("Frame OK!", message);
        alert.accept();

        // voltando o foco para a página principal
        driver.switchTo().defaultContent();

        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys(message);

    }

    @Test
    public void testaPoUpSimples(){

        driver.findElement(By.id("buttonPopUpEasy")).click();

        // alterando o foco para a janela pop up
        driver.switchTo().window("Popup");
        driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");

        // fechando a pop up
        driver.close();

        // voltando o foco para a tela principal
        driver.switchTo().window("");

        driver.findElement(By.tagName("textarea")).sendKeys("E agora?");

    }

    public void testaPopUpSemIdentificador(){
        driver.findElement(By.id("buttonPopUpHard")).click();

    }
}
