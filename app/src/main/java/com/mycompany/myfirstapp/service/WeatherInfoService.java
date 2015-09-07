package com.mycompany.myfirstapp.service;

import com.mycompany.myfirstapp.api.WeatherInfoApi;

import java.io.IOException;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by castillobg on 9/4/15.
 */
public class WeatherInfoService {

    private WeatherInfoApi weatherInfoApi;

    public WeatherInfoService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        weatherInfoApi = retrofit.create(WeatherInfoApi.class);
    }

    public void getWeatherForCity(String city, Callback callback) throws IOException {
        weatherInfoApi.getWeatherForCity(city).enqueue(callback);
    }
}
