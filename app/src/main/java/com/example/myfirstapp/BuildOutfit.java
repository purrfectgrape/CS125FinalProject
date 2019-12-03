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
     */
    private Button weatherButton;

    /**
     * Button mood - reference to the mood button.
     */
    private Button moodButton;
    /**
     * Button mood - reference to the mood Button.
     * Picture was taken from https://icon-library.net/icon/mood-icon-0.html.
     */
//    private ImageButton mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_outfit);

        weatherButton = (Button) findViewById(R.id.weather);
        moodButton = (Button) findViewById(R.id.mood);
        weatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToWeather();
            }
        });
        moodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMood();
            }
        });
    }

    public void goToWeather() {
        Intent intentGoToWeather = new Intent(this, Weather.class);
        startActivity(intentGoToWeather);
    }

    public void goToMood() {
        Intent intentGoToMood = new Intent(this, Mood.class);
        startActivity(intentGoToMood);
    }
}
