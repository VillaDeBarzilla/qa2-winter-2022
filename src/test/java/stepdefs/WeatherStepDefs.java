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

        Assertions.assertEquals(params.get("id"), String.valueOf(response.getCurrent().getWeather().get(0).getId()), "Wrong id!");
        Assertions.assertEquals(params.get("main"), response.getCurrent().getWeather().get(0).getMain(), "Wrong main!");
        Assertions.assertEquals(params.get("description"), response.getCurrent().getWeather().get(0).getDescription(), "Wrong description!");
        Assertions.assertEquals(params.get("icon"), String.valueOf(response.getCurrent().getWeather().get(0).getIcon()), "Wrong icon!");
    }


    @Then("minutely forecast is:")
    public void minutely_forecast(Map<String, String> params) {
        Assertions.assertEquals(params.get("time"), String.valueOf(response.getMinutely().get(0).getDt()), "Wrong time!");
        Assertions.assertEquals(params.get("precipitation"), String.valueOf(response.getMinutely().get(0).getPrecipitation()), "Wrong precipitation!");
    }

    @Then("hourly forecast is:")
    public void hourly_forecast(Map<String, String> params) {
        Assertions.assertEquals(params.get("time"), String.valueOf(response.getHourly().get(0).getDt()), "Wrong hourly time!");
        Assertions.assertEquals(params.get("temperature"), String.valueOf(response.getHourly().get(0).getTemp()), "Wrong hourly temperature!");
        Assertions.assertEquals(params.get("feels_like"), String.valueOf(response.getHourly().get(0).getFeelsLike()), "Wrong hourly feels like!");
        Assertions.assertEquals(params.get("pressure"), String.valueOf(response.getHourly().get(0).getPressure()), "Wrong hourly pressure!");
        Assertions.assertEquals(params.get("humidity"), String.valueOf(response.getHourly().get(0).getHumidity()), "Wrong hourly humidity!");
        Assertions.assertEquals(params.get("dew_point"), String.valueOf(response.getHourly().get(0).getDewPoint()), "Wrong hourly dew point!");
        Assertions.assertEquals(params.get("ultraviolet"), String.valueOf(response.getHourly().get(0).getUvi()), "Wrong hourly ultraviolet!");
        Assertions.assertEquals(params.get("clouds"), String.valueOf(response.getHourly().get(0).getClouds()), "Wrong hourly clouds!");
        Assertions.assertEquals(params.get("visibility"), String.valueOf(response.getHourly().get(0).getVisibility()), "Wrong hourly visibility!");
        Assertions.assertEquals(params.get("wind_speed"), String.valueOf(response.getHourly().get(0).getWindSpeed()), "Wrong hourly wind speed!");
        Assertions.assertEquals(params.get("wind_deg"), String.valueOf(response.getHourly().get(0).getWindDeg()), "Wrong hourly wind deg!");
        Assertions.assertEquals(params.get("wind_gust"), String.valueOf(response.getHourly().get(0).getWindGust()), "Wrong hourly wind gust!");
        Assertions.assertEquals(params.get("pop"), String.valueOf(response.getHourly().get(0).getPop()), "Wrong hourly pop!");
    }

    @Then("hourly cloud information is:")
    public void hourly_cloud_information(Map<String, String> params) {
        Assertions.assertEquals(params.get("id"), String.valueOf(response.getHourly().get(0).getWeather().get(0).getId()), "Wrong hourly cloud information id!");
        Assertions.assertEquals(params.get("main"), String.valueOf(response.getHourly().get(0).getWeather().get(0).getMain()), "Wrong hourly cloud information main!");
        Assertions.assertEquals(params.get("description"), String.valueOf(response.getHourly().get(0).getWeather().get(0).getDescription()), "Wrong hourly cloud information description!");
        Assertions.assertEquals(params.get("icon"), String.valueOf(response.getHourly().get(0).getWeather().get(0).getIcon()), "Wrong hourly cloud information icon!");
    }

    @Then("daily forecast is:")
    public void daily_forecast(Map<String, String> params) {
        Assertions.assertEquals(params.get("time"), String.valueOf(response.getDaily().get(0).getDt()), "Wrong daily time!");
        Assertions.assertEquals(params.get("sunrise"), String.valueOf(response.getDaily().get(0).getSunrise()), "Wrong daily sunrise!");
        Assertions.assertEquals(params.get("sunset"), String.valueOf(response.getDaily().get(0).getSunset()), "Wrong daily sunset!");
        Assertions.assertEquals(params.get("moonrise"), String.valueOf(response.getDaily().get(0).getMoonrise()), "Wrong daily moonrise!");
        Assertions.assertEquals(params.get("moonset"), String.valueOf(response.getDaily().get(0).getMoonset()), "Wrong daily moonset!");
        Assertions.assertEquals(params.get("moon_phase"), String.valueOf(response.getDaily().get(0).getMoonPhase()), "Wrong daily moon phase!");
        Assertions.assertEquals(params.get("pressure"), String.valueOf(response.getDaily().get(0).getPressure()), "Wrong daily pressure!");
        Assertions.assertEquals(params.get("humidity"), String.valueOf(response.getDaily().get(0).getHumidity()), "Wrong daily humidity!");
        Assertions.assertEquals(params.get("dew_point"), String.valueOf(response.getDaily().get(0).getDewPoint()), "Wrong daily dew point!");
        Assertions.assertEquals(params.get("wind_speed"), String.valueOf(response.getDaily().get(0).getWindSpeed()), "Wrong daily wind speed!");
        Assertions.assertEquals(params.get("wind_deg"), String.valueOf(response.getDaily().get(0).getWindDeg()), "Wrong daily wind deg!");
        Assertions.assertEquals(params.get("wind_gust"), String.valueOf(response.getDaily().get(0).getWindGust()), "Wrong daily wind gust!");
        Assertions.assertEquals(params.get("clouds"), String.valueOf(response.getDaily().get(0).getClouds()), "Wrong daily clouds!");
        Assertions.assertEquals(params.get("pop"), String.valueOf(response.getDaily().get(0).getPop()), "Wrong daily pop!");
        Assertions.assertEquals(params.get("rain"), String.valueOf(response.getDaily().get(0).getRain()), "Wrong daily rain!");
        Assertions.assertEquals(params.get("ultraviolet"), String.valueOf(response.getDaily().get(0).getUvi()), "Wrong daily ultraviolet");
    }

    @Then("daily temperature information is:")
    public void daily_temperature_information(Map<String, Double> params) {
        Assertions.assertEquals(params.get("day"), response.getDaily().get(0).getTemp().getDay(), "Wrong daily day temperature!");
        Assertions.assertEquals(params.get("minimum"), response.getDaily().get(0).getTemp().getMin(), "Wrong daily minimum temperature!");
        Assertions.assertEquals(params.get("maximum"), response.getDaily().get(0).getTemp().getMax(), "Wrong daily maximum temperature!");
        Assertions.assertEquals(params.get("night"), response.getDaily().get(0).getTemp().getNight(), "Wrong daily night temperature!");
        Assertions.assertEquals(params.get("evening"), response.getDaily().get(0).getTemp().getEve(), "Wrong daily evening temperature!");
        Assertions.assertEquals(params.get("morning"), response.getDaily().get(0).getTemp().getMorn(), "Wrong daily morning temperature!");

    }

    @Then("daily feels like information is:")
    public void daily_feels_like(Map<String, Double> params) {
        Assertions.assertEquals(params.get("day"), response.getDaily().get(0).getFeelsLike().getDay(), "Wrong daily feels like day temperature!");
        Assertions.assertEquals(params.get("night"), response.getDaily().get(0).getFeelsLike().getNight(), "Wrong daily feels like night temperature!");
        Assertions.assertEquals(params.get("evening"), response.getDaily().get(0).getFeelsLike().getEve(), "Wrong daily feels like evening temperature!");
        Assertions.assertEquals(params.get("morning"), response.getDaily().get(0).getFeelsLike().getMorn(), "Wrong daily feels like morning temperature!");
    }

    @Then("daily cloud information is:")
    public void daily_cloud_information(Map<String, String> params) {
        Assertions.assertEquals(params.get("id"), String.valueOf(response.getDaily().get(0).getWeather().get(0).getId()), "Wrong daily cloud information id!");
        Assertions.assertEquals(params.get("main"), String.valueOf(response.getDaily().get(0).getWeather().get(0).getMain()), "Wrong daily cloud information main!");
        Assertions.assertEquals(params.get("description"), String.valueOf(response.getDaily().get(0).getWeather().get(0).getDescription()), "Wrong daily cloud information description!");
        Assertions.assertEquals(params.get("icon"), String.valueOf(response.getDaily().get(0).getWeather().get(0).getIcon()), "Wrong daily cloud information icon!");
    }


    @Then("alert Nr. {int} received:")
    public void check_alert(int index, Map<String, String> params) {
        Assertions.assertEquals(params.get("sender"), response.getAlerts().get(0).getSenderName(), "Wrong sender in alert nr. " + index);
        Assertions.assertEquals(params.get("event"), response.getAlerts().get(0).getEvent(), "Wrong event in alert nr. " + index);
        Assertions.assertEquals(params.get("start"), String.valueOf(response.getAlerts().get(0).getStart()), "Wrong start in alert nr. " + index);
        Assertions.assertEquals(params.get("end"), String.valueOf(response.getAlerts().get(0).getEnd()), "Wrong end in alert nr. " + index);
        Assertions.assertEquals(params.get("description"), response.getAlerts().get(0).getDescription(), "Wrong description in alert nr. " + index);
    }

    @Then("tags for an alert Nr. {int} are:")
    public void check_tags(int index, List<String> tags) {

    }

}
