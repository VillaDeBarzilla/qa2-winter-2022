package pageobject.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.BaseFunc;
import pageobject.model.Passenger;

public class PassengerInfoPage {
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

    private final By CLICK_BOOK_LAST = By.id("book3");

    private final By FINAL_TEXT = By.xpath(".//div[@class = 'finalTxt']");
    private BaseFunc baseFunc;

    public PassengerInfoPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void fillInPassengerForm(Passenger passenger) {
        baseFunc.type(FIRST_NAME, passenger.getFirstName());
        baseFunc.type(LAST_NAME, passenger.getLastName());
        baseFunc.type(DISCOUNT, passenger.getDiscount());
        baseFunc.type(ADULTS, passenger.getAdultsCount());
        baseFunc.type(CHILDREN, passenger.getChildrenCount());
        baseFunc.type(BAG, passenger.getBagCount());
        baseFunc.selectByText(FLIGHT, passenger.getDate());

        baseFunc.click(CLICK_GET_PRICE);
        baseFunc.waitForElementsCountToBe(GET_RESULTS, 5);

    }

    public String getFromSecond() {
        return baseFunc.findElements(GET_RESULTS).get(0).getText();
    }

    public String getToSecond() {
        return baseFunc.findElements(GET_RESULTS).get(1).getText();
    }

    public String getFromThird() {
        return baseFunc.findElements(GET_RESULTS).get(3).getText();
    }

    public String getToThird() {
        return baseFunc.findElements(GET_RESULTS).get(4).getText();
    }

    public String getPassengerName() {
        String name = baseFunc.findElements(GET_RESULTS).get(2).getText();
        return name.replaceAll("!", "");
    }

    public String getPrice() {
        String price = baseFunc.findElement(GET_PRICE).getText();
        return StringUtils.substringBetween(price, "for ", " EUR");
    }

    public void clickOnBook() {
        baseFunc.click(CLICK_BOOK);
    }

    public String seatSelection() {
        return baseFunc.findElements(SELECT_PLACE).get(15).getText();
    }

    public String checkSeat() {
        return baseFunc.findElement(CHECK_PLACE_NUMBER).getText();
    }

    public void clickBookLast(){
        baseFunc.click(CLICK_BOOK_LAST);
    }

    public String finalText(){
        return baseFunc.findElement(FINAL_TEXT).getText();
    }
}
