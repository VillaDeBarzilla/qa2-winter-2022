package pageobject;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.model.Passenger;
import pageobject.pages.HomePage;
import pageobject.pages.PassengerInfoPage;
import pageobject.pages.SeatSelectionPage;
import pageobject.pages.SuccessfulRegistrationPage;

public class TicketsTestsOnPages {
    private final String URL = "www.qaguru.lv:8089/tickets/";
    private final String FROM_AIRPORT = "RIX";
    private final String TO_AIRPORT = "BCN";


    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void successfulRegistrationTest(){
        Passenger passenger = new Passenger("Luke","Skywalker", "12345", 2,
                3, 4, "13-05-2018");

        int seatNr = RandomUtils.nextInt(1, 35);

        baseFunc.openUrl(URL);

        HomePage homePage = new HomePage(baseFunc);
        homePage.selectAirports(FROM_AIRPORT, TO_AIRPORT);

        PassengerInfoPage infoPage = new PassengerInfoPage(baseFunc);
        infoPage.fillInPassengerForm(passenger);

        Assertions.assertEquals(passenger.getFirstName(), infoPage.getPassengerName(), "Names doesn't equals");
        Assertions.assertEquals(FROM_AIRPORT, infoPage.getFromSecond(),"Departures on top are not equals!");
        Assertions.assertEquals(FROM_AIRPORT, infoPage.getFromThird(), "Departures on bottom are not equals!");
        Assertions.assertEquals(TO_AIRPORT, infoPage.getToSecond(), "Arrivals on top are not equals!");
        Assertions.assertEquals(TO_AIRPORT, infoPage.getToThird(), "Arrivals on bottom are not equals!");
        Assertions.assertTrue(infoPage.getPrice().matches("[0-9].*"), "Price doesn't exist!");

        infoPage.clickOnBook();

        SeatSelectionPage seatSelection = new SeatSelectionPage(baseFunc);
        seatSelection.seatSelect(seatNr);
        int selectedSeat = seatSelection.getSelectedSeatNr();

        Assertions.assertEquals(seatNr, selectedSeat,"Wrong seat");

        seatSelection.clickBookLast();

        SuccessfulRegistrationPage successfulRegistration = new SuccessfulRegistrationPage(baseFunc);
        Assertions.assertTrue(successfulRegistration.isSuccessfulRegistrationPageAppears(), "Wrong text on successful registration page");

    }
      @AfterEach
      public void closeBrowser() {
          baseFunc.closeBrowserAfterTest();
      }
}
