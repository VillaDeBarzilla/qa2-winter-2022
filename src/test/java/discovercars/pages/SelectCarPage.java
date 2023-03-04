package discovercars.pages;

import discovercars.BaseFunc;
import discovercars.model.CarInfo;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SelectCarPage {
    private final By CLICK_NEXT_BTN = By.xpath(".//div[@class = 'car-top-filter-control next']");
    private final By CLICK_PREV_BTN = By.xpath(".//div[@class = 'car-top-filter-control prev']");
    private final By CHOOSE_SMALL_CARS = By.xpath(".//div[@class = 'img small']");
    private final By CLICK_SORT_BY = By.xpath(".//a[contains(@class, 'dropdown-toggle')]");
    private final By SELECT_SORT_ITEM = By.xpath(".//li[contains(@class, 'dc-ui dropdown-item sort-by-list trigger-gtm-dynamic-event') and contains(text(), 'Price/rating')]");
    private final By CHECKBOX_GASOLINE = By.xpath(".//label[@for = 'fuel-type-ft-V']");
    private final By CHECKBOX_FOUR_SEATS = By.xpath(".//label[@for = 'number-of-seats-seats-4']");
    private final By FILTERED_CARS = By.xpath(".//div[@class = 'car-box filtered']");
    private final By PARTIAL_PREPAYMENT = By.xpath(".//span[contains(text(), 'Partial prepayment')]");
    private final By GET_SEATS_COUNT = By.xpath(".//ul[contains(@class, 'dc-list-md text-14')]/li/span");
    private final By GET_FUEL_TYPE = By.xpath(".//li[@class = 'fuel-V']/span");
    private final By RENTAL_CONDITIONS_OPEN = By.xpath(".//a[contains(@class, 'rental-conditions') and contains(text(), 'Rental Conditions')]");
    private final By RENTAL_CONDITIONS_CLOSE = By.xpath(".//div[@class = 'modal-close']");
    private BaseFunc baseFunc;

    public SelectCarPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    CarInfo carInfo = new CarInfo();

    public void clickCarousel() {
        baseFunc.findElement(CLICK_NEXT_BTN).click();
        baseFunc.waitForElementToBeClickable(CLICK_PREV_BTN);
        baseFunc.findElement(CLICK_PREV_BTN).click();
    }

    public void selectSmallCars() {
        baseFunc.findElement(CHOOSE_SMALL_CARS).click();
    }

    public void sortElements() {
        baseFunc.findElement(CLICK_SORT_BY).click();
        baseFunc.wait.until(ExpectedConditions.elementToBeClickable(SELECT_SORT_ITEM));
        baseFunc.findElement(SELECT_SORT_ITEM).click();

    }

    public void checkCheckboxes() {
        baseFunc.findElement(CHECKBOX_GASOLINE).click();
        baseFunc.findElement(CHECKBOX_FOUR_SEATS).click();
    }

    public void rentalConditions() {
        baseFunc.findElements(RENTAL_CONDITIONS_OPEN).get(0).click();
        baseFunc.waitForElementToBeClickable(RENTAL_CONDITIONS_CLOSE);
        baseFunc.findElement(RENTAL_CONDITIONS_CLOSE).click();
    }

    public void getCarList() {
        String partPrep = baseFunc.findElements(FILTERED_CARS).get(0).findElement(PARTIAL_PREPAYMENT).getText();
        String seats = baseFunc.findElements(FILTERED_CARS).get(0).findElement(GET_SEATS_COUNT).getText();
        String fuel = baseFunc.findElements(FILTERED_CARS).get(0).findElement(GET_FUEL_TYPE).getText();
        Assertions.assertEquals(partPrep, carInfo.getPartialPrepayment(), "Partial prepayment isn't found");
        Assertions.assertEquals(seats, carInfo.getSeatsCount(), "Wrong seats count");
        Assertions.assertEquals(fuel, carInfo.getFuel(), "Wrong fuel type");
    }
}
