package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Weather extends AppCompatActivity {

    /** The URL of the weather query result. */
    static final String URL = "http://api.openweathermap.org/data/2.5/weather?id=4914570&APPID=57e68cf6582d83cfb852527e4c18e9e5&units=imperial";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
    }

    /**
     * Method to get weather info from openweathermap.
     */
    public void getWeather() {
        Log.d("MyApp","I am here");

        JsonObjectRequest objectRequest = new JsonObjectRequest(JsonObjectRequest.Method.GET,
                URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //{"coord":{"lon":-88.21,"lat":40.11},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04d"}],"base":"stations","main":{"temp":49.28,"pressure":1008,"humidity":87,"temp_min":46,"temp_max":52},"visibility":16093,"wind":{"speed":10.29,"deg":130},"clouds":{"all":90},"dt":1574791169,"sys":{"type":1,"id":6026,"country":"US","sunrise":1574772634,"sunset":1574807401},"timezone":-21600,"id":4914570,"name":"Urbana","cod":200}
                try {
                    JSONObject main = response.getJSONObject("main");
                    JSONArray weatherArray = main.getJSONArray("weather");
                   // JSONObject weatherObject = weatherArray.getJSONObject()
                    System.out.println(main);
                } catch (JSONException e) {
                    System.out.println(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                return;
            }
        });
    }
}
