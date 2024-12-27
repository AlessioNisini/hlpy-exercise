package co.hlpy.models;

public class Weather {

    private Integer id;
    private String main;

    public Weather() {
    }

    public Weather(Integer id, String main) {
        this.id = id;
        this.main = main;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }
}
