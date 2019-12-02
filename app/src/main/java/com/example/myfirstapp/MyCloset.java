package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyCloset extends AppCompatActivity {


    private Button shoesButton;

    private Button bottomsButton;

    private Button topsButton;

    private Button outerWearButton;

    private Button hatsButton;

    private Button accessoriesButton;

    private Button drawersButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_closet);


        shoesButton = (Button) findViewById(R.id.shoeButton);
        shoesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMyShoes();
            }
        });




    }




    public void openMyShoes() {
        Intent intentOpenMyShoes = new Intent(this, Shoes.class);
        startActivity(intentOpenMyShoes);
    }






}
