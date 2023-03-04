package discovercars.pages;

import discovercars.BaseFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage {
    private final By ACCEPT_COOKIES_BTN = By.id("onetrust-accept-btn-handler");
    private final By SELECT_LATVIA = By.xpath(".//div[@class = 'tl-box']/a");
    private final By LATVIA_PAGE_CHECK = By.tagName("h1");
    private final By CLICK_CURRENCY_BTN = By.id("currentCurrency");
    private final By SELECT_CURRENCY = By.xpath(".//a[@data-currency = 'USD']");
    private final By SELECT_INPUT_FIELD = By.id("pick-up-location");
    private final By PICK_POINT_FROM_LIST = By.xpath(".//div[contains(@class , 'tt-suggestion tt-selectable')]");
    private final By CLICK_SEARCH_NOW = By.id("location-submit");

    private BaseFunc baseFunc;


    public MainPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void clickAcceptCookies() {
        baseFunc.click(ACCEPT_COOKIES_BTN);
    }

    public void selectLatvia() {
        List<WebElement> topLocations = baseFunc.findElements(SELECT_LATVIA);
        String country = "Latvia";
        for (WebElement link : topLocations) {
            if (link.getText().equals(country)) {
                baseFunc.wait.until(ExpectedConditions.elementToBeClickable(link));
                link.click();
                break;
            }
        }
    }

    public void changeCurrency() {
        baseFunc.findElement(CLICK_CURRENCY_BTN).click();
        baseFunc.findElement(SELECT_CURRENCY).click();
        baseFunc.waitForElementToBeVisible(SELECT_INPUT_FIELD);
        baseFunc.waitForElementToBeClickable(SELECT_INPUT_FIELD);
    }

    public void selectTownAndDates() {
        baseFunc.type(SELECT_INPUT_FIELD, "Riga");
        baseFunc.findElements(PICK_POINT_FROM_LIST).get(1).click();
    }

    public void clickSearchNow() {
        baseFunc.click(CLICK_SEARCH_NOW);
    }

}
