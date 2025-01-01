package co.hlpy.models;

public class WeatherReportDTO {

    private Long timestamp;
    private String summary;
    private Temperature temperature;
    private Temperature feltTemperature;
    private Integer pressure;
    private Integer humidity;
    private Double windSpeed;
    private String weather;

    public WeatherReportDTO() {
    }

    public WeatherReportDTO(Long timestamp, String summary, Temperature temperature, Temperature feltTemperature, Integer pressure, Integer humidity, Double windSpeed, String weather) {
        this.timestamp = timestamp;
        this.summary = summary;
        this.temperature = temperature;
        this.feltTemperature = feltTemperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.weather = weather;
    }

    public Temperature getFeltTemperature() {
        return feltTemperature;
    }

    public void setFeltTemperature(Temperature feltTemperature) {
        this.feltTemperature = feltTemperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public static WeatherReportDTO fromDay(Day day) {
        String weather = day.getWeather() == null || day.getWeather().isEmpty() ? "UNKNOWN" : day.getWeather().get(0).getMain();

        return new WeatherReportDTO(
            day.getDt(),
            day.getSummary(),
            day.getTemp(),
            day.getFeels_like(),
            day.getPressure(),
            day.getHumidity(),
            day.getWind_speed(),
            weather
        );
    }

}
