import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testes {

    @Test // utilizando JUnit
    public void testeGoogle() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\franc\\Documents\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // definindo posição e tamanho do browser
        //driver.manage().window().setPosition(new Point(100, 100));
        //driver.manage().window().maximize(); // iniciar com o browser maximizado
        driver.manage().window().setSize(new Dimension(1200, 765));

        driver.get("http://www.google.com");

        // fazendo a assertiva
        Assert.assertEquals("Google", driver.getTitle());

        // fechando o browser
        driver.quit(); // fecha todas que estiverem abertas e mata a instancia do driver
        //driver.close(); // fecha apenas uma aba do browser

    }
}
