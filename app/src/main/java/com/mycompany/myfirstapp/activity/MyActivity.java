package com.mycompany.myfirstapp.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mycompany.myfirstapp.R;

import com.mycompany.myfirstapp.activity.weather.WeatherActivity;

public class MyActivity extends AppCompatActivity implements OnMapReadyCallback {

    public final static String EXTRA_CITY_NAME = "com.mycompany.myfirstapp.CITY_NAME";
    public final static String EXTRA_LAT = "com.mycompany.myfirstapp.LAT";
    public final static String EXTRA_LNG = "com.mycompany.myfirstapp.LNG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.map);
        SupportMapFragment mapFragment = (SupportMapFragment) fragment;
        mapFragment.getMapAsync(this);
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

    public void getWeatherForCity(View view) {
        Intent intent = new Intent(this, WeatherActivity.class);
        EditText editText = (EditText) findViewById(R.id.txt_city_name);
        String cityName = editText.getText().toString();
        intent.putExtra(EXTRA_CITY_NAME, cityName);
        startActivity(intent);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.getUiSettings().setZoomControlsEnabled(true);
        map.getUiSettings().setZoomGesturesEnabled(true);
        map.getUiSettings().setMyLocationButtonEnabled(true);
        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Intent intent = new Intent(MyActivity.this, WeatherActivity.class);
                intent.putExtra(EXTRA_LAT, latLng.latitude);
                intent.putExtra(EXTRA_LNG, latLng.longitude);
                startActivity(intent);
            }
        });
        // Add a marker, and move the camera.
        LatLng medellin = new LatLng(6.25184, -75.56359);
        map.addMarker(new MarkerOptions().position(medellin).title("Home city"));
        map.moveCamera(CameraUpdateFactory.newLatLng(medellin));
    }
}
