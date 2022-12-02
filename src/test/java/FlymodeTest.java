import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FlymodeTest {
    private final By FROM = By.id("afrom");
    private final By TO = By.id("bfrom");
    private final By GOGOGO = By.xpath(".//span[@class = 'gogogo']");

    private final By FIRST_NAME = By.id("name");
    private final By LAST_NAME = By.id("surname");
    private final By DISCOUNT = By.id("discount");
    private final By ADULTS = By.id("adults");
    private final By CHILDREN = By.id("children");
    private final By BAG = By.id("bugs");
    private final By FLIGHT = By.id("flight");
    private final By CLICK_GET_PRICE = By.xpath(".//span[@onclick = 'setLang();']");

    private final By GET_RESULTS = By.xpath(".//span[@class = 'bTxt']");
    private final By GET_PRICE = By.id("response");
    private final By CLICK_BOOK = By.id("book2");

    private final By SELECT_PLACE = By.xpath(".//div[@class = 'line']/div[@class = 'seat']");
    private final By CHECK_PLACE_NUMBER = By.xpath(".//div[@class = 'line']");

    private final By CLICK_BOOK_FINAL = By.id("book3");
    private final By FINAL_TEXT = By.xpath(".//div[@class = 'finalTxt']");


    private WebDriver browser;
    private WebDriverWait wait;

    @Test
    public void reservationCheck() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://www.qaguru.lv:8089/tickets/");
        wait = new WebDriverWait(browser, Duration.ofSeconds(10));

        //--- FIRST PAGE
        select(FROM, "RIX");
        select(TO, "BCN");

        String selectedFrom = new Select(browser.findElement(FROM)).getFirstSelectedOption().getText();

        String selectedTo = new Select(browser.findElement(TO)).getFirstSelectedOption().getText();

        browser.findElement(GOGOGO).click();

        //--- SECOND PAGE
        textFields(FIRST_NAME, "Luke");
        textFields(LAST_NAME, "Skywalker");
        textFields(DISCOUNT, "12345");
        textFields(ADULTS, "1");
        textFields(CHILDREN, "2");
        textFields(BAG, "4");
        select(FLIGHT, "13");

        browser.findElement(CLICK_GET_PRICE).click();

        //--- THIRD PAGE
        List<WebElement> results = browser.findElements(GET_RESULTS);
        String fromSecond = results.get(0).getText();
        String toSecond = results.get(1).getText();
        String resultName = results.get(2).getText();
        resultName = resultName.replaceAll("!", "");
        String fromThird = results.get(3).getText();
        String toThird = results.get(4).getText();

        List<WebElement> getPrice = browser.findElements(GET_PRICE);
        String gettingAllText = getPrice.get(0).getText();
        String getFinalPrice = gettingAllText.split(" ")[10];

        String nameField = browser.findElement(FIRST_NAME).getAttribute("value");

        Assertions.assertEquals(selectedFrom, fromSecond, "Departures on top are not equals!");
        Assertions.assertEquals(selectedTo, toSecond, "Arrivals on top are not equals!");
        Assertions.assertEquals(nameField, resultName, "Names are not equals");
        Assertions.assertEquals(selectedFrom, fromThird, "Departures on bottom are not equals!");
        Assertions.assertEquals(selectedTo, toThird, "Arrivals on bottom are not equals!");
        System.out.println(getFinalPrice + " EUR is a total price for a flight");

        browser.findElement(CLICK_BOOK).click();

        List<WebElement> seat = browser.findElements(SELECT_PLACE);
        String selectSeat = seat.get(15).getText();
        seat.get(15).click();

        WebElement checkSeat = browser.findElement(CHECK_PLACE_NUMBER);
        String gettingSeatNumber = checkSeat.getText();
        String checkSeatNumber = gettingSeatNumber.split(" ")[3];

        Assertions.assertEquals(selectSeat, checkSeatNumber, "Seat are don't match");

        browser.findElement(CLICK_BOOK_FINAL).click();

        String finalText = browser.findElement(FINAL_TEXT).getText();

        Assertions.assertEquals(finalText, "Thank You for flying with us!");

        System.out.println("Code by Eduards Barzilovics© supported by qaguru.lv©");

    }

    private void select(By locator, String value) {
        WebElement we = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Select select = new Select(we);
        select.selectByValue(value);
    }

    private void textFields(By locator, String text) {
        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        input.clear();
        input.sendKeys(text);
    }

    @AfterEach
    public void closeBrowser() {
        browser.close();
    }
}
