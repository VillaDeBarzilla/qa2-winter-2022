package model;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Daily {
    private long dt;
    private long sunrise;
    private long sunset;
    private long moonrise;
    private long moonset;
    @JsonProperty("moon_phase")
    private double moonPhase;
    private Temperature temperature;
    private FeelsLike feelsLike;
    private List<Weather> weatherList;


    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

    public long getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(long moonrise) {
        this.moonrise = moonrise;
    }

    public long getMoonset() {
        return moonset;
    }

    public void setMoonset(long moonset) {
        this.moonset = moonset;
    }

    public double getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(double moonPhase) {
        this.moonPhase = moonPhase;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public FeelsLike getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(FeelsLike feelsLike) {
        this.feelsLike = feelsLike;
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }
}
