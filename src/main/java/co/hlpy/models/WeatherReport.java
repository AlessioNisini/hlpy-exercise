package co.hlpy.models;

import java.util.List;

public class WeatherReport {

    private String lat;
    private String lon;
    private List<Day> daily;

    public WeatherReport() {
    }

    public WeatherReport(List<Day> daily, String lon, String lat) {
        this.daily = daily;
        this.lon = lon;
        this.lat = lat;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public List<Day> getDaily() {
        return daily;
    }

    public void setDaily(List<Day> daily) {
        this.daily = daily;
    }
}
