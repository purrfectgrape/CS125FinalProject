package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class Weather extends AppCompatActivity {

    /** The URL of the weather query result. */
    static final String URL = "http://api.openweathermap.org/data/2.5/weather?id=4914570&APPID=57e68cf6582d83cfb852527e4c18e9e5&units=imperial";

    /** Variable to hold the temperature from weather data. */
    private double temperature;

    /** Variable to hold the wind speed from weather data. */
    private double windSpeed;

    /** TextView to hold weather's description. */
    private TextView weatherDescription;

    /** Reference to the weather description. */
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        weatherDescription = (TextView) findViewById(R.id.description);
        getWeather();
    }

    /**
     * Method to get weather info from openweathermap.
     */
    public void getWeather() {

        JsonObjectRequest objectRequest = new JsonObjectRequest(JsonObjectRequest.Method.GET,
                URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject mainOb = response.getJSONObject("main");
                    temperature = mainOb.getDouble("temp");
                    JSONArray weatherArray = response.getJSONArray("weather");
                    JSONObject weatherOb = weatherArray.getJSONObject(0);
                    String descriptionString = weatherOb.getString("description");
                    JSONObject wind = response.getJSONObject("wind");
                    windSpeed = wind.getDouble("wind");
                    weatherDescription.setText(descriptionString);
                } catch (Exception e) {
                    System.out.println(e);
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
}
