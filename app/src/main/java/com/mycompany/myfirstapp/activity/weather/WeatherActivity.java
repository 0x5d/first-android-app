package com.mycompany.myfirstapp.activity.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.async.AsyncTaskObserver;
import com.mycompany.myfirstapp.model.weather.WeatherInfo;
import com.mycompany.myfirstapp.service.WeatherService;

import java.io.IOException;

import com.mycompany.myfirstapp.activity.MyActivity;

public class WeatherActivity extends AppCompatActivity implements AsyncTaskObserver {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String cityName = intent.getStringExtra(MyActivity.EXTRA_CITY_NAME);
        setContentView(R.layout.activity_weather);
        getWeather(cityName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void getWeather(String cityName) {
        new WeatherService().getWeatherForCity(cityName, this);
    }

    @Override
    public void onTaskFinished(Object response) {
        String res = (String) response;
        // TODO: 9/4/15 Parse to a WeatherInfo and update text view with response. 
    }
}
