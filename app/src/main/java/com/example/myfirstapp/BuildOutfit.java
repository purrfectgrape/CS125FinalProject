package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class BuildOutfit extends AppCompatActivity {

    /**
     * Button weather - reference to the weather Button.
     * Picture was taken from https://www.iconfinder.com/icons/3840014/cloud_color_icons_snow_sun_weather_icon.
     */
    private ImageButton weatherButton;

    /**
     * Button mood - reference to the mood Button.
     * Picture was taken from https://icon-library.net/icon/mood-icon-0.html.
     */
//    private ImageButton mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_outfit);

        weatherButton = (ImageButton) findViewById(R.id.weather);
        weatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToWeather();
            }
        });
    }

    public void goToWeather() {
        Intent intentGoToWeather = new Intent(this, Weather.class);
        startActivity(intentGoToWeather);
    }
}
