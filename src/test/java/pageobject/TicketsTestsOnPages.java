package pageobject;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.model.FlightInfo;
import pageobject.model.Passenger;
import pageobject.pages.HomePage;
import pageobject.pages.PassengerInfoPage;
import pageobject.pages.SeatSelectionPage;
import pageobject.pages.SuccessfulRegistrationPage;

public class TicketsTestsOnPages {
    private final String URL = "www.qaguru.lv:8089/tickets/";
    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void successfulRegistrationTest(){
        Passenger passenger = new Passenger("Luke","Skywalker");

        int seatNr = RandomUtils.nextInt(1, 35);

        FlightInfo info = new FlightInfo("RIX", "BCN", 12345, 1,
                2, 4, "13-05-2018", seatNr);
        info.setPassenger(passenger);

        baseFunc.openUrl(URL);

        HomePage homePage = new HomePage(baseFunc);
        homePage.selectAirports(info.getDestination(), info.getDeparture());

        PassengerInfoPage infoPage = new PassengerInfoPage(baseFunc);
        infoPage.fillInPassengerForm(info);

        Assertions.assertEquals(passenger.getFirstName(), infoPage.getPassengerName(), "Names doesn't equals");
        Assertions.assertEquals(info.getDestination(), infoPage.getFromSecond(),"Departures on top are not equals!");
        Assertions.assertEquals(info.getDestination(), infoPage.getFromThird(), "Departures on bottom are not equals!");
        Assertions.assertEquals(info.getDeparture(), infoPage.getToSecond(), "Arrivals on top are not equals!");
        Assertions.assertEquals(info.getDeparture(), infoPage.getToThird(), "Arrivals on bottom are not equals!");
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
