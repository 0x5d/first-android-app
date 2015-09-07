package com.mycompany.myfirstapp.model.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by castillobg on 9/4/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    private String description;

    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
