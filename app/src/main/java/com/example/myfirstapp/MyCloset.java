package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

//import java.util.ArrayList;

import java.util.List;


public class MyCloset extends AppCompatActivity {


    private Button shoesButton;

    private Button bottomsButton;

    private Button topsButton;

    private Button outerWearButton;

    private Button hatsButton;

    private Button accessoriesButton;

    private Button drawersButton;

    private static List<Clothing> allClothings;

    private Button addClothing;

    private List myShoes;

    private List myBottoms;

    private List myTops;

    private List myOuterWear;

    private List myHats;

    private List myAccessories;

    private List myDrawers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_closet);

        shoesButton = (Button) findViewById(R.id.shoeButton);
        shoesButton.setOnClickListener();


    }

    private addClothing(Clothing newClothing) {
        if(newClothing.typ)
    }




}




