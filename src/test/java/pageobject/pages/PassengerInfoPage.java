package pageobject.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import pageobject.BaseFunc;
import pageobject.model.FlightInfo;

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

    private BaseFunc baseFunc;

    public PassengerInfoPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }
    public void fillInPassengerForm(FlightInfo info) {
        baseFunc.type(FIRST_NAME, info.getPassenger().getFirstName());
        baseFunc.type(LAST_NAME, info.getPassenger().getLastName());
        baseFunc.type(DISCOUNT, info.getDiscount());
        baseFunc.type(ADULTS, info.getAdultCount());
        baseFunc.type(CHILDREN, info.getChildCount());
        baseFunc.type(BAG, info.getBagsCount());
        baseFunc.selectByText(FLIGHT, info.getFlightDate());

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

}

