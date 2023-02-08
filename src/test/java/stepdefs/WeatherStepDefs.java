package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class WeatherStepDefs {

    @Given("city ID is: {long}")
    public void set_city_id(long id) {

    }

    @When("we are requesting weather forecast")
    public void request_weather() {

    }

    @Then("coordinates are:")
    public void check_coordinates(Map<String, Double> params) {

    }

    @Then("timezone information is:")
    public void check_timezone(Map<String, String> params) {

    }

    @Then("current weather data is:")
    public void check_current_weather(Map<String, String> params) {

    }

    @Then("current cloud information is is:")
    public void current_cloud_information(Map<String, Long> params){

    }

    @Then("hourly forecast is:")
    public void hourly_forecast(Map<String, String> params){

    }

    @Then("hourly cloud information is:")
    public void hourly_cloud_information(Map<String, String> params){

    }

    @Then("daily forecast is:")
    public void daily_forecast(Map<String, String> params){

    }

    @Then("daily temperature information is:")
    public void daily_temperature_information(Map<String, Double> params){

    }

    @Then("daily feels like information is:")
    public void daily_feels_like(Map<String, Double> params){

    }

    @Then("daily cloud information is:")
    public void daily_cloud_information(Map<String, String> params){

    }

    @Then("minutely forecast is:")
    public void minutely_forecast(Map<String, String> params){

    }

    @Then("alert Nr. {int} received:")
    public void check_alert(int index, Map<String, String> params) {

    }

    @Then("tags for an alert Nr. {int} are:")
    public void check_tags(int index, List<String> tags) {


    }
}
