package com.mycompany.myfirstapp.api;

import com.mycompany.myfirstapp.model.weather.WeatherInfo;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface WeatherInfoApi {
    @GET("/data/2.5/weather")
    Call<WeatherInfo> getWeatherForCity(@Query("q") String city);

    @GET("/data/2.5/weather")
    Call<WeatherInfo> getWeatherForCoords(@Query("lat") double lat, @Query("lon") double lon);
}