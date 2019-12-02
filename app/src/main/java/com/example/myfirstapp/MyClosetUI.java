package com.example.myfirstapp;

import android.os.Bundle;
import android.widget.Button;

public class MyClosetUI {

    private Button shoesButton;

    private Button bottomsButton;

    private Button topsButton;

    private Button outerWearButton;

    private Button hatsButton;

    private Button accessoriesButton;

    private Button drawersButton;

    public static MyCloset myEntireWardrobe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_closet);

        shoesButton = (Button) findViewById(R.id.shoesButton);
        shoesButton.setOnClickListener();


    }

    private addClothing(Clothing newClothing) {

        if(newClothing.typ)
    }



}



