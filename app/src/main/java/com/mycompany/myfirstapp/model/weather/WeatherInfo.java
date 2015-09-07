package com.mycompany.myfirstapp.model.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by castillobg on 9/4/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfo {

    private Weather[] weather;
    private String name;
    private String error;

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        if(name != null){
            return "Weather information for " + name + ":\n" + weather[0].toString();
        }
        else if(error != null){
            return error;
        }
        else {
            return "No data specified.";
        }
    }
}
