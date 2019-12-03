package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class Weather extends AppCompatActivity {

    /** The URL of the weather query result. */
    private final String URL = "http://api.openweathermap.org/data/2.5/weather?id=4914570&APPID=57e68cf6582d83cfb852527e4c18e9e5&units=imperial";

    /** Variable to hold the temperature from weather data. */
    private double temperature;

    private String[] cityNames = {"Urbana", "Champaign", "Other"};

    /** TextView to hold weather's description. */
    private TextView weatherDescription;

    /** Spinner to store a dropdown of cities. */
    private Spinner citySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        weatherDescription = (TextView) findViewById(R.id.description);
        getWeather();
    }

    /**
     * Method to get weather info from openweathermap. This code was adapted from:
     * https://www.youtube.com/watch?v=8-7Ip6xum6E.
     */
    public void getWeather() {

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET,
                URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject mainOb = response.getJSONObject("main");
                    temperature = mainOb.getDouble("temp");
                    JSONArray weatherArray = response.getJSONArray("weather");
                    JSONObject weatherOb = weatherArray.getJSONObject(0);
                    String descriptionString = weatherOb.getString("description");
                    returnAdvice(descriptionString);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        RequestQueue newRequest = Volley.newRequestQueue(this);
        newRequest.add(objectRequest);
    }

    public void returnAdvice(String condition) {
        if (condition.contains("rain")) {
            weatherDescription.setText("The current weather is " + condition + ". Wear a raincoat!");
        } else if (condition.contains("wind")) {
            weatherDescription.setText("The current weather is " + condition + ". Wear a windbreaker!");
        } else if (condition.contains("snow")) {
            weatherDescription.setText("The current weather is " + condition + ". Bring your snowboots!");
        } else if (condition.contains("sun")) {
            weatherDescription.setText("The current weather is " + condition + ". Don't forget sunblock!");
        } else if (condition.contains("cloud")) {
            weatherDescription.setText("The current weather is " + condition + ". Wear something comfortable!");
        } else {
            weatherDescription.setText("The current weather is " + condition + ". Wear anything of your choice!");
        }
    }

}
