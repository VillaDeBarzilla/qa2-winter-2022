package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Current;
import model.Minutely;
import model.Weather;
import model.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.List;
import java.util.Map;

public class WeatherStepDefs {

    private long cityId;
    private WeatherResponse response;

    @Given("city ID is: {long}")
    public void set_city_id(long cityId) {
        this.cityId = cityId;
    }

    @When("we are requesting weather forecast")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityId);
    }

    @Then("coordinates are:")
    public void check_coordinates(Map<String, Double> params) {
        Assertions.assertEquals(params.get("latitude"), response.getLat(), "Wrong latitude!");
        Assertions.assertEquals(params.get("longitude"), response.getLon(), "Wrong longitude!");
    }

    @Then("timezone information is:")
    public void check_timezone(Map<String, String> params) {
        Assertions.assertEquals(params.get("timezone"), response.getTimezone(), "Wrong timezone!");
        Assertions.assertEquals(params.get("offset"), String.valueOf(response.getTimezoneOffset()), "Wrong timezone offset!");
    }

    @Then("current weather data is:")
    public void check_current_weather(Map<String, String> params) {
        Assertions.assertEquals(params.get("time"), String.valueOf(response.getCurrent().getDt()), "Wrong time!");
        Assertions.assertEquals(params.get("sunrise"), String.valueOf(response.getCurrent().getSunrise()), "Wrong sunrise!");
        Assertions.assertEquals(params.get("sunset"), String.valueOf(response.getCurrent().getSunset()), "Wrong sunset!");
        Assertions.assertEquals(params.get("temperature"), String.valueOf(response.getCurrent().getTemp()), "Wrong temperature!");
        Assertions.assertEquals(params.get("feels_like"), String.valueOf(response.getCurrent().getFeelsLike()), "Wrong feels like!");
        Assertions.assertEquals(params.get("pressure"), String.valueOf(response.getCurrent().getPressure()), "Wrong pressure!");
        Assertions.assertEquals(params.get("humidity"), String.valueOf(response.getCurrent().getHumidity()), "Wrong humidity!");
        Assertions.assertEquals(params.get("dew_point"), String.valueOf(response.getCurrent().getDewPoint()), "Wrong dew point!");
        Assertions.assertEquals(params.get("ultraviolet"), String.valueOf(response.getCurrent().getUvi()), "Wrong ultraviolet!");
        Assertions.assertEquals(params.get("clouds"), String.valueOf(response.getCurrent().getClouds()), "Wrong clouds!");
        Assertions.assertEquals(params.get("visibility"), String.valueOf(response.getCurrent().getVisibility()), "Wrong visibility!");
        Assertions.assertEquals(params.get("wind_speed"), String.valueOf(response.getCurrent().getWindSpeed()), "Wrong wind speed!");
        Assertions.assertEquals(params.get("wind_deg"), String.valueOf(response.getCurrent().getWindDeg()), "Wrong wind deg!");
        Assertions.assertEquals(params.get("wind_gust"), String.valueOf(response.getCurrent().getWindGust()), "Wrong wind gust!");

    }

    @Then("current cloud information is:")
    public void current_cloud_information(Map<String, String> params) {
        Weather weather = new Weather();

        Assertions.assertEquals(params.get("id"), String.valueOf(weather.getCurrent().getWeather()), "Wrong id!");
        Assertions.assertEquals(params.get("main"), response.getWeatherList(), "Wrong main!");
        Assertions.assertEquals(params.get("description"), weather.getDescription(), "Wrong description!");
        Assertions.assertEquals(params.get("icon"), weather.getIcon(), "Wrong icon!");

    }


    @Then("minutely forecast is:")
    public void minutely_forecast(Map<String, String> params) {
        Minutely minutely = new Minutely();
        Assertions.assertEquals(params.get("time"), String.valueOf(minutely.getDt()), "Wrong time!");
        Assertions.assertEquals(params.get("precipitation"), String.valueOf(minutely.getPrecipitation()), "Wrong precipitation!");
    }

    @Then("hourly forecast is:")
    public void hourly_forecast(Map<String, String> params) {

    }

    @Then("hourly cloud information is:")
    public void hourly_cloud_information(Map<String, String> params) {

    }

    @Then("daily forecast is:")
    public void daily_forecast(Map<String, String> params) {

    }

    @Then("daily temperature information is:")
    public void daily_temperature_information(Map<String, Double> params) {

    }

    @Then("daily feels like information is:")
    public void daily_feels_like(Map<String, Double> params) {

    }

    @Then("daily cloud information is:")
    public void daily_cloud_information(Map<String, String> params) {

    }


    @Then("alert Nr. {int} received:")
    public void check_alert(int index, Map<String, String> params) {

    }

    @Then("tags for an alert Nr. {int} are:")
    public void check_tags(int index, List<String> tags) {


    }

}
