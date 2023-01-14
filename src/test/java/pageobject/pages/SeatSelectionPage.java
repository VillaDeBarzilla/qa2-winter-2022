package pageobject.pages;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.BaseFunc;

import java.util.List;

public class SeatSelectionPage {
    private final By SELECT_SEAT = By.xpath(".//div[@class = 'line']/div[@class = 'seat']");
    private final By CHECK_SEAT_NUMBER = By.xpath(".//div[@class = 'line']");
    private final By CLICK_BOOK_LAST = By.id("book3");



    private BaseFunc baseFunc;

    public SeatSelectionPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void seatSelect(int seatNr) {
        baseFunc.waitForMinElementsAmount(SELECT_SEAT, 30);

        List<WebElement> seats = baseFunc.findElements(SELECT_SEAT);

        boolean isSeatFound = false;
        for (WebElement we : seats){
            if (Integer.parseInt(we.getText()) == seatNr){
                baseFunc.click(we);
                isSeatFound = true;
                break;
            }
        }
        Assertions.assertTrue(isSeatFound, "Seat Nr." + seatNr + " isn't found");
    }

    public int getSelectedSeatNr(){
        String selectedSeatInfo = baseFunc.findElement(CHECK_SEAT_NUMBER).getText();
        return Integer.parseInt(StringUtils.getDigits(selectedSeatInfo));
    }
    public void clickBookLast(){
        baseFunc.click(CLICK_BOOK_LAST);
    }


}
