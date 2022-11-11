package homework4;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumTest {
    private final By ACCEPT_COOKIES_BTN = By.id("onetrust-accept-btn-handler");
    private final By LATVIA_SELECTION_LINK = By.linkText("Latvia");
    private final By LATVIA_PAGE_CHECK = By.tagName("h1");
    private final By CHANGE_CURRENCY_MENU = By.id("currentCurrency");
    private final By SELECT_CURRENCY_CLICK = By.xpath(".//*[contains(@class, 'currency-code') and contains(text(), 'USD')]");
    private final By ENTER_CITY_FIELD = By.id("pick-up-location");
    private final By CITY_FIELD_SELECTION = By.xpath(".//*[contains(@class, 'hlt') and contains(text(), 'Riga')]");
    private final By CLICK_SUBMIT_BTN = By.id("location-submit");
    private final By FIND_LOADING_ANIMATION = By.xpath(".//div[@class = 'spinner-container']");
    private final By FIND_FIRST_TEXT = By.xpath(".//div[contains(@class, 'mb-8')]");
    private final By FIND_SECOND_TEXT = By.xpath(".//div[contains(@class, 'mb-24')]");
    private final By CLICK_NEXT_BTN = By.xpath(".//div[@class = 'car-top-filter-control next']");
    private final By CLICK_PREV_BTN = By.xpath(".//div[@class = 'car-top-filter-control prev']");
    private final By CHOOSE_SMALL_CARS = By.xpath(".//div[@class = 'img small']");
    private final By CLICK_SORT_BY = By.xpath(".//a[contains(@class, 'dropdown-toggle')]");
    private final By SELECT_SORT_ITEM = By.xpath(".//li[contains(@class, 'dc-ui dropdown-item sort-by-list trigger-gtm-dynamic-event') and contains(text(), 'Price/rating')]");
    private final By CHECKBOX_GASOLINE = By.xpath(".//label[@for = 'fuel-type-ft-V']");
    private final By CHECKBOX_FOUR_SEATS = By.xpath(".//label[@for = 'number-of-seats-seats-4']");
    private final By FILTERED_CARS = By.xpath(".//div[@class = 'car-box filtered']");
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

        //---------FIRST PAGE--------------
        //---------CLICK ON ACCEPT COOKIES
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));
        browser.findElement(ACCEPT_COOKIES_BTN).click();

        //---------FIND AND SELECT COUNTRY
        browser.findElement(LATVIA_SELECTION_LINK).click();
        if (browser.findElement(LATVIA_PAGE_CHECK).getText().contains("Car Rental in Latvia")) {
            System.out.println("Congratulations! You Found Latvia!");
        }

        //---------CHANE CURRENCY
        browser.findElement(CHANGE_CURRENCY_MENU).click();
        browser.findElement(SELECT_CURRENCY_CLICK).click();

        //---------SELECT PLACE AND CLICK SUBMIT
        wait.until(ExpectedConditions.elementToBeClickable(ENTER_CITY_FIELD));
        browser.findElement(ENTER_CITY_FIELD).sendKeys("Riga");
        wait.until(ExpectedConditions.elementToBeClickable(CITY_FIELD_SELECTION));
        browser.findElements(CITY_FIELD_SELECTION).get(0).click();
        browser.findElement(CLICK_SUBMIT_BTN).click();

        //---------------LOADING PAGE------------------

        if (browser.findElement(FIND_LOADING_ANIMATION).isDisplayed()){
            System.out.println("I found loading animation.");
        }
        if (browser.findElement(FIND_FIRST_TEXT).isDisplayed()){
            System.out.println("I found first text.");
        }
        if (browser.findElement(FIND_SECOND_TEXT).isDisplayed()){
            System.out.println("I found second text.");
        }

        //--------------RESULT PAGE----------------
        //--------------CLICKING CAROUSEL
        wait.until(ExpectedConditions.elementToBeClickable(CLICK_NEXT_BTN));
        browser.findElement(CLICK_NEXT_BTN).click();
        browser.findElement(CLICK_PREV_BTN).click();

        //--------------SELECT SMALL CARS FROM A LIST
        browser.findElement(CHOOSE_SMALL_CARS).click();

        //--------------SORT BY PRICE/RATING
        browser.findElement(CLICK_SORT_BY).click();
        wait.until(ExpectedConditions.elementToBeClickable(SELECT_SORT_ITEM));
        browser.findElement(SELECT_SORT_ITEM).click();

        //--------------BLOCK WITH SPECIAL OFFERS
        WebElement showSpecialOffers = browser.findElement(By.xpath(".//div[contains(@class, 'flt-type')]/div[@class = 'flt-head opened']/span[contains(@class, 'category-label trend') and contains(text(), 'Special offers')]"));        System.out.println("I found" + " " + "«" + showSpecialOffers.getText() + "»" + " " + "block");

        //--------------FILTER/CHECKBOXES
        browser.findElement(CHECKBOX_GASOLINE).click();
        browser.findElement(CHECKBOX_FOUR_SEATS).click();

        //--------------GET LIST OF FILTERED CARS
        List<WebElement> filteredCars = browser.findElements(FILTERED_CARS);
        for (WebElement link : filteredCars) {
            System.out.println("I filtered" + " " + filteredCars.size() + " " + "cars for you");
        }


        //-------------QUANTITY OF FILTERED CARS
        WebElement showingOutCar = browser.findElement(By.xpath(".//span[@class = 'showing-cars']"));
        WebElement totalCar = browser.findElement(By.xpath(".//span[@class = 'total-cars']"));
        System.out.println("I will show you" + " " + showingOutCar.getText() + " " + "cars out of" + " " + totalCar.getText() + " " + "cars");

        //-------------PARTIAL PREPAYMENT FOUNDED
        WebElement partialPrepayment = browser.findElements(By.xpath(".//span[contains(text(), 'Partial prepayment')]")).get(3);
        System.out.println("They got a" + " " + partialPrepayment.getText());

        //-------------CODE IS NOT OK, BUT I WILL FIX IT
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
