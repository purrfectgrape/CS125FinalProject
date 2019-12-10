package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
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

        bottomsButton = (Button) findViewById(R.id.boTTomsButton);
        bottomsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMyBottoms();
            }
        });

        topsButton = (Button) findViewById(R.id.topsButton);
        topsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMyTop();
            }
        });

        outerWearButton = (Button) findViewById(R.id.outerWearButton);
        outerWearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOuterWear();
            }
        });

        hatsButton = (Button) findViewById(R.id.hatsButton);
        hatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMyHats();
            }
        });


        accessoriesButton = (Button) findViewById(R.id.accessoriesButton);
        accessoriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMyAccessories();
            }
        });

        drawersButton = (Button) findViewById(R.id.drawersButton);
        drawersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMyDrawers();
            }
        });


    }



    public void openMyShoes() {
        Intent intentOpenMyShoes = new Intent(this, Shoes.class);
        startActivity(intentOpenMyShoes);
    }

    public void openMyBottoms() {
        Intent intentOpenMyButtoms = new Intent(this, Bottoms.class);
        startActivity(intentOpenMyButtoms);
    }

    public void openMyTop() {
        Intent intentOpenMyTops = new Intent(this, Tops.class);
        startActivity(intentOpenMyTops);
    }

    public void openOuterWear() {
        Intent intentOpenOuterWear = new Intent(this, OuterWear.class);
        startActivity(intentOpenOuterWear);
    }

    public void openMyHats() {
        Intent intentOpenMyHats = new Intent(this, Hats.class);
        startActivity(intentOpenMyHats);
    }

    public void openMyAccessories() {
        Intent intentOpenMyAccessories = new Intent(this, Accessories.class);
        startActivity(intentOpenMyAccessories);
    }

    public void openMyDrawers() {
        Intent intentOpenMyDrawers = new Intent(this, Drawers.class);
        startActivity(intentOpenMyDrawers);
    }

}
