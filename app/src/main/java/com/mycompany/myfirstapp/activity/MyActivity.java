package com.mycompany.myfirstapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.mycompany.myfirstapp.R;

import com.mycompany.myfirstapp.activity.weather.WeatherActivity;

public class MyActivity extends AppCompatActivity {

    public final static String EXTRA_CITY_NAME = "com.mycompany.myfirstapp.CITY_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                // Open settings
                break;
            case R.id.action_search:
                // Search
                break;
            default :
                return super.onOptionsItemSelected(item);

        }
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getWeather(View view) {
        Intent intent = new Intent(this, WeatherActivity.class);
        EditText editText = (EditText) findViewById(R.id.txt_city_name);
        String cityName = editText.getText().toString();
        intent.putExtra(EXTRA_CITY_NAME, cityName);
        startActivity(intent);
    }
}
