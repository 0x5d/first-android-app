package com.mycompany.myfirstapp.activity.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.mycompany.myfirstapp.R;

import java.io.IOException;

import com.mycompany.myfirstapp.activity.MyActivity;
import com.mycompany.myfirstapp.service.WeatherInfoService;

import retrofit.Callback;
import retrofit.Response;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String cityName = intent.getStringExtra(MyActivity.EXTRA_CITY_NAME);
        if(cityName != null){
            getWeatherForCity(cityName);
        }
        else {
            double lat = intent.getDoubleExtra(MyActivity.EXTRA_LAT, 0d);
            double lon = intent.getDoubleExtra(MyActivity.EXTRA_LNG, 0d);
            getWeatherForCoords(lat, lon);
        }
        setContentView(R.layout.activity_weather);
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

    private void getWeatherForCity(String cityName) {
        WeatherInfoService weatherInfoService = new WeatherInfoService();
        final TextView textView = new TextView(this);
        textView.setTextSize(20);
        try {
            weatherInfoService.getWeatherForCity(cityName, new Callback() {
                @Override
                public void onResponse(Response response) {
                    textView.setText(response.body().toString());
                    setContentView(textView);
                }

                @Override
                public void onFailure(Throwable t) {
                    textView.setText("Something went wrong!");
                    setContentView(textView);
                }
            });
        } catch (IOException e) {
            textView.setText("Something went wrong!");
            setContentView(textView);
        }
    }

    private void getWeatherForCoords(double lat, double lon) {
        WeatherInfoService weatherInfoService = new WeatherInfoService();
        final TextView textView = new TextView(this);
        textView.setTextSize(20);
        try {
            weatherInfoService.getWeatherForCoords(lat, lon, new Callback() {
                @Override
                public void onResponse(Response response) {
                    textView.setText(response.body().toString());
                    setContentView(textView);
                }

                @Override
                public void onFailure(Throwable t) {
                    textView.setText("Something went wrong!");
                    setContentView(textView);
                }
            });
        } catch (IOException e) {
            textView.setText("Something went wrong!");
            setContentView(textView);
        }
    }
}
