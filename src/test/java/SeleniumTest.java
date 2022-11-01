import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumTest {
    private final By ACCEPT_COOKIES_BTN = By.id("onetrust-accept-btn-handler");
    private final By LATVIA_SELECTION_LINK = By.linkText("Latvia");
    private final By LATVIA_PAGE_CHECK = By.tagName("h1");
    private final By ENTER_CITY_FIELD = By.id("pick-up-location");
    private final By CITY_FIELD_SELECTION = By.xpath("//div*[text(), 'all locations']");
    private final By CLICK_SUBMIT_BTN = By.id("location-submit");


    @Test
    public void openHomePageCheck() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://www.discovercars.com");
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));
        browser.findElement(ACCEPT_COOKIES_BTN).click();
        browser.findElement(LATVIA_SELECTION_LINK).click();

        if (browser.findElement(LATVIA_PAGE_CHECK).getText().contains("Car Rental in Latvia")) {
            System.out.println("Congratulations! You Found It!");
            }

        browser.findElement(ENTER_CITY_FIELD).sendKeys("Riga");
        browser.findElement(CITY_FIELD_SELECTION).click();
        browser.findElement(CLICK_SUBMIT_BTN).click();


    }
}
