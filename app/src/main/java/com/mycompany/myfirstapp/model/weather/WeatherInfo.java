package com.mycompany.myfirstapp.model.weather;

/**
 * Created by castillobg on 9/4/15.
 */
public class WeatherInfo {

    private Weather weather;
    private String name;
    private String error;

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString(){
        if(name != null){
            return "Weather information for " + name + ":\n" + weather.toString();
        }
        else if(error != null){
            return error;
        }
        else {
            return "No data specified.";
        }
    }
}
