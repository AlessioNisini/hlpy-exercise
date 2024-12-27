package co.hlpy.models;

import java.util.Optional;

public class Temperature {

    private Double morn;
    private Double day;
    private Double eve;
    private Double night;
    private Optional<Double> min;
    private Optional<Double> max;

    public Temperature(){

    }

    public Temperature(Double morn, Double day, Double eve, Double night, Optional<Double> min, Optional<Double> max) {
        this.morn = morn;
        this.day = day;
        this.eve = eve;
        this.night = night;
        this.min = min;
        this.max = max;
    }

    public Double getMorn() {
        return morn;
    }

    public void setMorn(Double morn) {
        this.morn = morn;
    }

    public Double getDay() {
        return day;
    }

    public void setDay(Double day) {
        this.day = day;
    }

    public Double getEve() {
        return eve;
    }

    public void setEve(Double eve) {
        this.eve = eve;
    }

    public Double getNight() {
        return night;
    }

    public void setNight(Double night) {
        this.night = night;
    }

    public Optional<Double> getMin() {
        return min;
    }

    public void setMin(Optional<Double> min) {
        this.min = min;
    }

    public Optional<Double> getMax() {
        return max;
    }

    public void setMax(Optional<Double> max) {
        this.max = max;
    }
}
