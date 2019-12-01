package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//import java.util.ArrayList;

import java.util.List;


public class MyCloset extends AppCompatActivity {


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
    }


    public class Clothing {

        private String type;
        private String color;


        public Clothing(String setType, String setColor) {

            type = setType;
            color = setColor;
        }

    }


    public class Shoes extends Clothing(String setShoes, shoeColor) {

        super(setShoes, shoeColor);

        myShoes.add(setShoes);

    }


    public class Bottoms extends Clothing(String setBottoms, bottomColor) {

        super(setBottoms, bottomColor);

        myBottoms.add(setBottoms);

    }


    public class Tops extends Clothing(String setTop, topColor) {

        super(setTop, topColor);

        myTops.add(setTop);

    }

    public class OuterWear extends Clothing(String setOuterWear, outerWearColor) {

        super(setOuterWear, outerWearColor);

        myOuterWear.add(setOuterWear);

    }

    public class Hats extends Clothing(String setHat, hatColor) {

        super(setHat, hatColor);

        myHats.add(setHat);

    }

    public class Accessories extends Clothing(String setAccessories, accessoriesColor) {

        super(setAccessories, accessoriesColor);

        myAccessories.add(setAccessories);

    }

    public class Drawers extends Clothing(String setDrawers, drawersColor) {

        super(setDrawers, drawersColor);

        myDrawers.add(setDrawers);

    }

}
