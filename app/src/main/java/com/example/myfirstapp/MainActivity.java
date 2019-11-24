package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /**
     * Button myClosetButton - reference to the ClosetButton.
     */
    private Button myClosetButton;

    /**
     * Button buildOutfit - reference to buildOutfit.
     */
    private Button myBuildOutfit;

    /**
     * Button outfitLogbook - reference to outfitLogBook.
     */
    private Button myOutfitLogbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myClosetButton = (Button) findViewById(R.id.myCloset);
        myClosetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMyCloset();
            }
        });

        myBuildOutfit = (Button) findViewById(R.id.buildOutfit);
        myBuildOutfit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBuildOutfit();

            }
        });


        myOutfitLogbook = (Button) findViewById(R.id.outfitLogbook);
        myOutfitLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOutfitLogbook();

            }
        });
    }

    public void openMyCloset() {
        Intent intentMyCloset = new Intent(this, MyCloset.class);
        startActivity(intentMyCloset);
    }


    public void openBuildOutfit() {
        Intent intentBuildOutfit = new Intent(this, BuildOutfit.class);
        startActivity(intentBuildOutfit);
    }

    public void openOutfitLogbook() {
        Intent intentOutfitLogBook = new Intent(this, OutfitLogbook.class);
        startActivity(intentOutfitLogBook);
    }
}
