import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumTest {
    @Test
    public void openHomePageCheck() {
        System.setProperty("webdriver.chrome.driver" , "C://chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("http://www.discovercars.com");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.close();

    }
}
