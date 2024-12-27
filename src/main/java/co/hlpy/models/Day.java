package co.hlpy.models;

import java.util.List;

public class Day {

    private Long dt;
    private String summary;
    private Temperature temp;
    private Temperature feels_like;
    private Integer pressure;
    private Integer humidity;
    private Double wind_speed;
    private List<Weather> weather;

    public Day() {
    }

    public Day(Long dt, Temperature feels_like, Integer humidity, Integer pressure, String summary, Temperature temp, List<Weather> weather, Double wind_speed) {
        this.dt = dt;
        this.feels_like = feels_like;
        this.humidity = humidity;
        this.pressure = pressure;
        this.summary = summary;
        this.temp = temp;
        this.weather = weather;
        this.wind_speed = wind_speed;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Temperature getTemp() {
        return temp;
    }

    public void setTemp(Temperature temp) {
        this.temp = temp;
    }

    public Temperature getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(Temperature feels_like) {
        this.feels_like = feels_like;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(Double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
}
