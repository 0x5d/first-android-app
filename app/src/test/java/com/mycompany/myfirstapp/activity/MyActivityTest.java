package com.mycompany.myfirstapp.activity;

import android.content.Intent;
import android.widget.EditText;

import com.mycompany.myfirstapp.BuildConfig;
import com.mycompany.myfirstapp.R;
import com.mycompany.myfirstapp.activity.weather.WeatherActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

/**
 * Created by castillobg on 9/8/15.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MyActivityTest {

    @Before
    public void setUp(){

    }

    @Test
    public void inputCityNameTest(){
        MyActivity activity = Robolectric.setupActivity(MyActivity.class);
        ((EditText) activity.findViewById(R.id.txt_city_name)).setText("Medellin");
        activity.findViewById(R.id.btn_get_weather).performClick();
        Intent expectedIntent = new Intent(activity, WeatherActivity.class);
        assertEquals(WeatherActivity.class.getName(), expectedIntent.getComponent().getClassName());
    }
}
