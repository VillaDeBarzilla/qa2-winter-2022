package stepdefs;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pageobject.BaseFunc;
import pageobject.model.FlightInfo;
import pageobject.model.Passenger;
import pageobject.pages.HomePage;
import pageobject.pages.PassengerInfoPage;

import java.util.Map;

public class TicketsStepDef {
    private FlightInfo flightInfo;
    private HomePage homePage;
    private PassengerInfoPage infoPage;
    private Passenger passenger;
    private BaseFunc baseFunc;

    private final String URL = "http://www.qaguru.lv:8089/tickets";
    @Given("flight info:")
    public void set_flight_info(Map<String, String> params) {
        flightInfo = new FlightInfo(params.get("departure"), params.get("destination"),
                Integer.parseInt(params.get("discount")), Integer.parseInt(params.get("adultCount")),
                Integer.parseInt(params.get("childCount")), Integer.parseInt(params.get("bagsCount")),
                params.get("flightDate"), Integer.parseInt(params.get("seatNr")));

    }

    @Given("passenger info is:")
    public void set_passenger_info (Map<String, String> params){
        Passenger passenger = new Passenger(params.get("name"), params.get("surname"));
        flightInfo.setPassenger(passenger);
    }

    @Given("home page open")
    public void home_page_open(){
        baseFunc.openUrl(URL);
        homePage = new HomePage(baseFunc);
    }

    @When("we are selecting airports")
    public void selecting_airports(){
        homePage.selectAirports(flightInfo.getDeparture(), flightInfo.getDestination());
        infoPage = new PassengerInfoPage(baseFunc);
    }

    @Then("selected airports appears on the next page")
    public void selected_airports_appears(){
        Assertions.assertEquals(flightInfo.getDestination(), infoPage.getFromSecond(),"Wrong departure!");
        Assertions.assertEquals(flightInfo.getDeparture(), infoPage.getToSecond(), "Wrong destination!");
    }

    @When("we are filling in passenger registration form")
    public void fill_registration_form(){
        Assertions.assertEquals(passenger.getFirstName(), "Luke", "Wrong passenger name!");
        Assertions.assertEquals(passenger.getLastName(), "Skywalker", "Wrong passenger lastname!");
        Assertions.assertEquals(String.valueOf(flightInfo.getDiscount()), "12345", "Wrong discount code!");
        Assertions.assertEquals(String.valueOf(flightInfo.getAdultCount()), "1", "Wrong adult count!");
        Assertions.assertEquals(String.valueOf(flightInfo.getChildCount()), "2", "Wrong child count!");
        Assertions.assertEquals(String.valueOf(flightInfo.getBagsCount()), "4", "Wrong bags count!");
        Assertions.assertEquals(String.valueOf(flightInfo.getFlightDate()), "13-05-2018", "Wrong flight date!");
        Assertions.assertEquals(flightInfo.getSeatNr(), flightInfo.getSeatNr(), "Wrong seat number!");
    }
}
