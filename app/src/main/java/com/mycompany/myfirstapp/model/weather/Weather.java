package com.mycompany.myfirstapp.model.weather;

/**
 * Created by castillobg on 9/4/15.
 */
public class Weather {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
