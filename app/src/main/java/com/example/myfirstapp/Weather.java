package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    private String BASEURL = "http://api.openweathermap.org/data/2.5/weather?q=";

    /** Variable to hold the temperature from weather data. */
    private double temperature;

    /** TextView to hold weather's description. */
    private TextView weatherDescription;

    /** TextView to hold advice based on the temperature. */
    private TextView temperatureAdvice;

    private TextView requestBox;
    private EditText textBox;
    private String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        weatherDescription = (TextView) findViewById(R.id.description);
        temperatureAdvice = (TextView) findViewById(R.id.temperatureAdvice);
        textBox = (EditText) findViewById(R.id.textBox);
        requestBox = (TextView) findViewById(R.id.requestForInput);
        requestBox.setVisibility(View.VISIBLE);
        textBox.setVisibility(View.VISIBLE);
        addKeyListener();
    }

    public void addKeyListener() {
        // add a keylistener to keep track of user input
        textBox.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if ((event.getAction() == KeyEvent.ACTION_DOWN)
                        && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    URL = BASEURL + textBox.getEditableText().toString() + "&APPID=57e68cf6582d83cfb852527e4c18e9e5&units=imperial";
                    Toast.makeText(Weather.this,
                            textBox.getText(), Toast.LENGTH_LONG).show();
                    textBox.setVisibility(View.GONE);
                    requestBox.setVisibility(View.GONE);
                    getWeather();
                    return true;
                }
                return false;
            }
        });
    }
    /**
     * Method to get weather info from openweathermap. This code was adapted from:
     * https://www.youtube.com/watch?v=8-7Ip6xum6E.
     */
    public void getWeather() {
       // URL = BASEURL + textBox.getEditableText().toString() + "&APPID=57e68cf6582d83cfb852527e4c18e9e5&units=imperial";
        Log.d("CHECKING URL", URL);
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
                    advice(descriptionString);
                    tempAdvice(temperature);
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

    public void advice(String condition) {
        weatherDescription.setVisibility(View.VISIBLE);
        if (condition.contains("rain") || condition.contains("storm")
                || condition.contains("shower") || condition.contains("drizzle")) {
            weatherDescription.setText("The weather description says " + condition + ". Wear a raincoat!");
        } else if (condition.contains("wind")) {
            weatherDescription.setText("The weather description says " + condition + ". Wear a windbreaker!");
        } else if (condition.contains("snow")) {
            weatherDescription.setText("The weather description says " + condition + ". Bring your snowboots!");
        } else if (condition.contains("sun")) {
            weatherDescription.setText("The weather description says " + condition + ". Don't forget sunblock!");
        } else if (condition.contains("cloud") || condition.contains("clear")) {
            weatherDescription.setText("The weather description says " + condition + ". Wear something comfortable!");
        } else {
            weatherDescription.setText("The weather description says " + condition + ". Wear anything of your choice!");
        }
    }

    public void tempAdvice(double temperature) {
        temperatureAdvice.setVisibility(View.VISIBLE);
        if (temperature < 50) {
            temperatureAdvice.setText("The temperature is " + temperature + ". Layer up!");
        } else if (temperature < 70) {
            temperatureAdvice.setText("The temperature is " + temperature + ". Enjoy the cool weather!");
        } else {
            temperatureAdvice.setText("The temperature is " + temperature + ". Stay cool!");
        }
    }


}
