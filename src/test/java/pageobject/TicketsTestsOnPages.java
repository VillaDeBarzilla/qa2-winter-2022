package pageobject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pageobject.model.Passenger;
import pageobject.pages.HomePage;
import pageobject.pages.PassengerInfoPage;

public class TicketsTestsOnPages {
    private final String URL = "www.qaguru.lv:8089/tickets/";
    private final String FROM_AIRPORT = "RIX";
    private final String TO_AIRPORT = "BCN";
    private final By SELECT_PLACE = By.xpath(".//div[@class = 'line']/div[@class = 'seat']");


    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void successfulRegistrationTest(){
        Passenger passenger = new Passenger("Luke","Skywalker", "12345", 2,
                3, 4, "13-05-2018");

        baseFunc.openUrl(URL);

        //--- HOME PAGE
        HomePage homePage = new HomePage(baseFunc);
        homePage.selectAirports(FROM_AIRPORT, TO_AIRPORT);

        //--- PASSENGER INFO PAGE
        PassengerInfoPage infoPage = new PassengerInfoPage(baseFunc);
        infoPage.fillInPassengerForm(passenger);

        Assertions.assertEquals(passenger.getFirstName(), infoPage.getPassengerName(), "Names doesn't equals");
        Assertions.assertEquals(FROM_AIRPORT, infoPage.getFromSecond(),"Departures on top are not equals!");
        Assertions.assertEquals(FROM_AIRPORT, infoPage.getFromThird(), "Departures on bottom are not equals!");
        Assertions.assertEquals(TO_AIRPORT, infoPage.getToSecond(), "Arrivals on top are not equals!");
        Assertions.assertEquals(TO_AIRPORT, infoPage.getToThird(), "Arrivals on bottom are not equals!");
        Assertions.assertTrue(infoPage.getPrice().matches("[0-9].*"), "Price doesn't exist!");

        infoPage.clickOnBook();

        String seat = baseFunc.findElements(SELECT_PLACE).get(15).getText();
        baseFunc.findElements(SELECT_PLACE).get(15).click();
        String seatSecond = infoPage.checkSeat();
        seatSecond = seatSecond.split(" ")[3];

        Assertions.assertEquals(seat, seatSecond, "Seats doesn't match!");

        infoPage.clickBookLast();

        Assertions.assertEquals(infoPage.finalText(), "Thank You for flying with us!");

    }
}
