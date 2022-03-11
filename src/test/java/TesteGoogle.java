import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {

    @Test // utilizando JUnit
    public void testeGoogle() {
        // acressando o driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\franc\\Documents\\drivers\\chromedriver.exe");
        // Acessando browser
        WebDriver driver = new ChromeDriver();

        // Abrindo o browser
        driver.get("http://www.google.com");

        // fazendo a assertiva
        Assert.assertEquals("Google", driver.getTitle());

    }

    @Test
    public void testeFirefox() {
        // acressando o driver
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\franc\\Documents\\drivers\\geckodriver.exe");
        // Acessando browser
        WebDriver driver = new FirefoxDriver();

        // Abrindo o browser
        driver.get("http://www.google.com");

        // fazendo a assertiva
        Assert.assertEquals("Google", driver.getTitle());

    }


}
