package stepdefs;


import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Reservation;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import pageobject.BaseFunc;
import pageobject.model.FlightInfo;
import pageobject.model.Passenger;
import pageobject.pages.HomePage;
import pageobject.pages.PassengerInfoPage;
import pageobject.pages.SeatSelectionPage;
import pageobject.pages.SuccessfulRegistrationPage;
import requesters.TicketsRequester;

import java.util.List;
import java.util.Map;

public class TicketsStepDef {
    private FlightInfo flightInfo;
    private HomePage homePage;
    private PassengerInfoPage infoPage;
    private SeatSelectionPage seatPage;
    private Passenger passenger;
    private List<Reservation> reservations;
    private Reservation reservationFromApi;
    int seatNr = RandomUtils.nextInt(1, 35);

    private BaseFunc baseFunc = new BaseFunc();

    private final String URL = "http://www.qaguru.lv:8089/tickets";

    @Given("flight info:")
    public void set_flight_info(Map<String, String> params) {
        flightInfo = new FlightInfo(params.get("departure"), params.get("destination"),
                params.get("discount"), Integer.parseInt(params.get("adultCount")),
                Integer.parseInt(params.get("childCount")), Integer.parseInt(params.get("bagsCount")),
                params.get("flightDate"), Integer.parseInt(params.get("seatNr")));
    }

    @Given("passenger info is:")
    public void set_passenger_info(Map<String, String> params) {
        Passenger passenger = new Passenger(params.get("firstName"), params.get("lastName"));
        flightInfo.setPassenger(passenger);
    }

    @Given("home page open")
    public void home_page_open() {
        baseFunc.openUrl(URL);
        homePage = new HomePage(baseFunc);
    }

    @When("we are selecting airports")
    public void selecting_airports() {
        homePage.selectAirports(flightInfo.getDeparture(), flightInfo.getDestination());
        infoPage = new PassengerInfoPage(baseFunc);
    }

    @Then("selected airports appears on the next page")
    public void selected_airports_appears() {
        Assertions.assertEquals(flightInfo.getDeparture(), infoPage.getFromSecond(), "Wrong departure!");
        Assertions.assertEquals(flightInfo.getDestination(), infoPage.getToSecond(), "Wrong destination!");
    }

    @When("we are filling in passenger registration form")
    public void fill_registration_form() {
        infoPage.fillInPassengerForm(flightInfo);

        Assertions.assertEquals(flightInfo.getDeparture(), "RIX", "Wrong departure!");
        Assertions.assertEquals(flightInfo.getDestination(), "BCN", "Wrong destination!");
        Assertions.assertEquals(flightInfo.getDiscount(), "12345", "Wrong discount!");
        Assertions.assertEquals(String.valueOf(flightInfo.getAdultCount()), "1", "Wrong adult count!");
        Assertions.assertEquals(String.valueOf(flightInfo.getChildCount()), "2", "Wrong child count!");
        Assertions.assertEquals(String.valueOf(flightInfo.getBagsCount()), "4", "Wrong bags count!");
        Assertions.assertEquals(flightInfo.getFlightDate(), "13-05-2018", "Wrong flight date!");
    }

    @When("requesting price")
    public void request_price() {
        Assertions.assertEquals(String.valueOf(infoPage.getPrice()), "280", "Price doesn't match!");
    }

    @Then("passenger name and airports appears")
    public void passenger_name_and_airport() {
        Assertions.assertEquals(flightInfo.getPassenger().getFirstName(), infoPage.getPassengerName(), "Wrong name in get price page!");
        Assertions.assertEquals(flightInfo.getDeparture(), infoPage.getFromSecond(), "Wrong destination in get price page!");
        Assertions.assertEquals(flightInfo.getDestination(), infoPage.getToSecond(), "Wrong departure in get price page!");
    }

    @Then("price is 280 EUR")
    public void price_confirmation() {
        int price = Integer.parseInt(infoPage.getPrice());
        if (price != 280) {
            System.out.println("Price is more or less than 280");
        }
    }

    @When("we are pressing Book button")
    public void pressing_book_button() {
        infoPage.clickOnBook();
    }

    @When("selecting seat")
    public void selecting_seat() {
        SeatSelectionPage seat = new SeatSelectionPage(baseFunc);
        seat.seatSelect(seatNr);
    }

    @Then("correct seat number appears")
    public void seat_number_appears() {
        SeatSelectionPage seat = new SeatSelectionPage(baseFunc);
        Assertions.assertEquals(seatNr, seat.getSelectedSeatNr(), "Wrong seat!");
    }

    @When("we are booking selected ticket")
    public void booking_selected_seat() {
        SeatSelectionPage seat = new SeatSelectionPage(baseFunc);
        seat.clickBookLast();
    }

    @When("successful registration message appears")
    public void registration_message_appears() {
        SuccessfulRegistrationPage successfulRegistration = new SuccessfulRegistrationPage(baseFunc);
        Assertions.assertTrue(successfulRegistration.isSuccessfulRegistrationPageAppears(), "Wrong text on successful registration page");

    }

    @When("we are requesting reservations data")
    public void request_reservation_data() throws JsonProcessingException {
        TicketsRequester requester = new TicketsRequester();
        reservations = requester.getReservations();
    }

    @Then("current reservation is in the list")
    public void find_reservation() {
        for (Reservation r : reservations) {
            if (r.getName().equals(flightInfo.getPassenger().getFirstName())) {
                reservationFromApi = r;
                break;
            }
        }
        Assertions.assertNotNull(reservationFromApi, "Reservation isn't found");
    }

    @Then("all reservation data is correct")
    public void check_reservation_data() {
        Assertions.assertEquals(flightInfo.getPassenger().getFirstName(), reservationFromApi.getName(), "Wrong name from api");
        Assertions.assertEquals(flightInfo.getPassenger().getLastName(), reservationFromApi.getSurname(), "Wrong last name from api");
        Assertions.assertEquals(flightInfo.getDeparture(), reservationFromApi.getDeparture(), "Wrong departure from api");
        Assertions.assertEquals(flightInfo.getDestination(), reservationFromApi.getDestination(), "Wrong destination from api");
        Assertions.assertEquals(flightInfo.getDiscount(), reservationFromApi.getDiscount(), "Wrong discount from api");
        Assertions.assertEquals(flightInfo.getAdultCount(), reservationFromApi.getAdults(), "Wrong adult count from api");
        Assertions.assertEquals(flightInfo.getChildCount(), reservationFromApi.getChildren(), "Wrong children count from api");
        Assertions.assertEquals(flightInfo.getBagsCount(), reservationFromApi.getBagCount(), "Wrong bags count from api");
        Assertions.assertEquals(flightInfo.getFlightDate().split("-")[0], reservationFromApi.getFlight(), "Wrong flight date from api");
        Assertions.assertEquals(seatNr, reservationFromApi.getSeat(), "Wrong seat nr. from api");
    }

    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowserAfterTest();
    }
}
