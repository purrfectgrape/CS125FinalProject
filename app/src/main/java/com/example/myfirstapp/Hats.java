package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;

public class Hats extends Clothing {

    Map<String, ImageView> hatMapList = new HashMap<>();

    //ImageView hatImage =


    Hats(String setType, Color setColor) {
        super(setType, setColor);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hats);
    }




}
