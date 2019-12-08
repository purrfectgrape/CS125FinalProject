package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;

public class Hats extends Clothing {

    private Map<Clothing, ImageView> hatMapList = new HashMap<>();

    //ImageView hatImage =


    Hats(String setType, Color setColor, String setName) {
        super(setType, setColor, setName);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hats);
        String type = "Hat";
        //Color

        Clothing argument = new Clothing();
        Button add = findViewById(R.id.addButton);
        Button remove = findViewById(R.id.removeButton);
        /*
        add.setOnClickListener(v -> {
            addHatstoMap();
        });
         */
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add.setVisibility(view.GONE);
                addHatstoMap();
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeHatsFromMap();
            }
        });

    }

    public void addHatstoMap(Clothing cloth, ImageView clothImage) {
        hatMapList.put(cloth, clothImage);
    }

    public void removeHatsFromMap(Clothing cloth, ImageView clothImaage) {
        hatMapList.remove(cloth, clothImaage);

    }









}
