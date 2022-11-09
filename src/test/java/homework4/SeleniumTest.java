package homework4;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumTest {
    private final By ACCEPT_COOKIES_BTN = By.id("onetrust-accept-btn-handler");
    private final By LATVIA_SELECTION_LINK = By.linkText("Latvia");
    private final By LATVIA_PAGE_CHECK = By.tagName("h1");
    private final By CHANGE_CURRENCY_MENU = By.id("currentCurrency");
    private final By SELECT_CURRENCY_CLICK = By.xpath(".//*[contains(@class, 'currency-code') and contains(text(), 'USD')]");
    private final By ENTER_CITY_FIELD = By.id("pick-up-location");
    private final By CITY_FIELD_SELECTION = By.xpath(".//*[contains(@class, 'hlt') and contains(text(), 'Riga')]");
    private final By CLICK_SUBMIT_BTN = By.id("location-submit");
    private final By CLICK_NEXT_BTN = By.xpath(".//div[@class = 'car-top-filter-control next']");
    private final By CLICK_PREV_BTN = By.xpath(".//div[@class = 'car-top-filter-control prev']");
    private final By CHOOSE_SMALL_CARS = By.xpath(".//div[@class = 'img small']");
    private final By CLICK_SORT_BY = By.xpath(".//a[contains(@class, 'dropdown-toggle')]");
    private final By SELECT_SORT_ITEM = By.xpath(".//li[contains(@class, 'dc-ui dropdown-item sort-by-list trigger-gtm-dynamic-event') and contains(text(), 'Price/rating')]");
    private final By CHECKBOX_GASOLINE = By.xpath(".//label[@for = 'fuel-type-ft-V']");
    private final By CHECKBOX_FOUR_SEATS = By.xpath(".//label[@for = 'number-of-seats-seats-4']");
    private final By RENTAL_CONDITIONS_OPEN = By.xpath(".//a[contains(@class, 'rental-conditions') and contains(text(), 'Rental Conditions')]");
    private final By RENTAL_CONDITIONS_CLOSE = By.xpath(".//div[@class = 'modal-close']");
    private final By CLICK_VIEW_BTN = By.xpath(".//a[contains(@data-id, '519-SKTB') and contains(@class, 'btn-book submit')]");

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
            System.out.println("Congratulations! You Found Latvia!");
        }

        browser.findElement(CHANGE_CURRENCY_MENU).click();
        browser.findElement(SELECT_CURRENCY_CLICK).click();
        wait.until(ExpectedConditions.elementToBeClickable(ENTER_CITY_FIELD));

        browser.findElement(ENTER_CITY_FIELD).sendKeys("Riga");
        wait.until(ExpectedConditions.elementToBeClickable(CITY_FIELD_SELECTION));
        browser.findElements(CITY_FIELD_SELECTION).get(0).click();
        browser.findElement(CLICK_SUBMIT_BTN).click();
        wait.until(ExpectedConditions.elementToBeClickable(CLICK_NEXT_BTN));
        browser.findElement(CLICK_NEXT_BTN).click();
        browser.findElement(CLICK_PREV_BTN).click();

        browser.findElement(CHOOSE_SMALL_CARS).click();
        browser.findElement(CLICK_SORT_BY).click();
        wait.until(ExpectedConditions.elementToBeClickable(SELECT_SORT_ITEM));
        browser.findElement(SELECT_SORT_ITEM).click();

        WebElement showSpecialOffers = browser.findElement(By.xpath(".//div[contains(@class, 'flt-type')]/div[@class = 'flt-head opened']/span[contains(@class, 'category-label trend') and contains(text(), 'Special offers')]"));
        System.out.println("I found" + " " + "«" + showSpecialOffers.getText() + "»" + " " + "block");

        browser.findElement(CHECKBOX_GASOLINE).click();
        browser.findElement(CHECKBOX_FOUR_SEATS).click();

        WebElement showingOutCar = browser.findElement(By.xpath(".//span[@class = 'showing-cars']"));
        WebElement totalCar = browser.findElement(By.xpath(".//span[@class = 'total-cars']"));
        System.out.println("I will show you" + " " + showingOutCar.getText() + " " + "cars out of" + " " + totalCar.getText() + " " + "cars");

        WebElement partialPrepayment = browser.findElements(By.xpath(".//span[contains(text(), 'Partial prepayment')]")).get(3);
        System.out.println("They got a" + " " + partialPrepayment.getText());

        browser.findElements(RENTAL_CONDITIONS_OPEN).get(4).click();
        wait.until(ExpectedConditions.elementToBeClickable(RENTAL_CONDITIONS_CLOSE));
        browser.findElement(RENTAL_CONDITIONS_CLOSE).click();

        WebElement numberOfBags = browser.findElements(By.xpath(".//span[contains(text(), '1 bag')]")).get(2);
        System.out.println("You can load" + " " + numberOfBags.getText());

        WebElement carRating = browser.findElements(By.xpath(".//div[@class = 'supplier-rating']")).get(4);
        System.out.println("The car rating is:" + " " + carRating.getText());

        WebElement rentalCost = browser.findElements(By.xpath(".//div[@class = 'price-item-price-main']")).get(4);
        System.out.println("Rental cost:" + " " + rentalCost.getText());

        browser.findElement(CLICK_VIEW_BTN).click();


    }
}
