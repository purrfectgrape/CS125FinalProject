package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BuildOutfit extends AppCompatActivity {

    /**
     * Button backButton - reference to the backButton.
     */
    private Button backButton;

    /**
     * Button weather - reference to the weather Button.
     */
//    private Button weather;

    /**
     * Button mood - reference to the mood Button.
     * Picture was taken from https://icon-library.net/icon/mood-icon-0.html.
     */
//    private Button mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_outfit);

        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });

//        weather = (Button) findViewById(R.id.weather);
//        weather.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                goToWeather();
//            }
//        });
    }

    public void goBack() {
        Intent intentGoBack = new Intent(this, MainActivity.class);
        startActivity(intentGoBack);
    }

//    public void goToWeather() {
//        Intent intentGoToWeather = new Intent(this, Weather.class);
//        startActivity(intentGoToWeather);
//    }
}
