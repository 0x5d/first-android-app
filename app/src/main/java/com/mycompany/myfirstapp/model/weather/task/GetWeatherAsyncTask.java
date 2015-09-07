package com.mycompany.myfirstapp.model.weather.task;

import android.os.AsyncTask;

import com.mycompany.myfirstapp.http.WeatherRequest;
import com.mycompany.myfirstapp.model.weather.Weather;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by castillobg on 9/4/15.
 */
public class GetWeatherAsyncTask extends AsyncTask<WeatherRequest, Integer, WeatherRequest> {

    @Override
    protected WeatherRequest doInBackground(WeatherRequest... args) {
        WeatherRequest weatherRequest = args[0];
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(weatherRequest.getUrl())
                .build();
        try {
            Response response = client.newCall(request).execute();
            weatherRequest.setResponse(response.body().string());
        }
        catch(IOException e){
            String errorResponse = "{ \"error\" : \"No weather information found for " + args[0] + "\"}";
            weatherRequest.setResponse(errorResponse);
        }
        return weatherRequest;
    }

    @Override
    protected void onPostExecute(WeatherRequest weatherRequest) {
        weatherRequest.getObserver().onTaskFinished(weatherRequest.getResponse());
    }
}
