package com.mycompany.myfirstapp.service;

import com.mycompany.myfirstapp.async.AsyncTaskObserver;
import com.mycompany.myfirstapp.http.WeatherRequest;
import com.mycompany.myfirstapp.model.weather.WeatherInfo;
import com.mycompany.myfirstapp.model.weather.task.GetWeatherAsyncTask;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by castillobg on 9/4/15.
 */
public class WeatherService {

    public void getWeatherForCity(String city, AsyncTaskObserver observer){
        WeatherRequest weatherRequest = new WeatherRequest();
        weatherRequest.setUrl("http://api.openweathermap.org/data/2.5/weather?q=" + city);
        weatherRequest.setObserver(observer);
        new GetWeatherAsyncTask().execute(weatherRequest);
    }
}
