package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class OutfitLogbook extends AppCompatActivity {

    private ImageView myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outfit_logbook);
        myImage = (ImageView) findViewById(R.id.imageView);
        Picasso.get().load("https://ae01.alicdn.com/kf/HTB1risRn1ySBuNjy1zdq6xPxFXaU/Toddler-Baby-Kid-Girl-Floral-Outfits-Little-Girls-Strap-Vest-Tops-Shorts-2Pcs-Clothing-Set-1.jpg").into(myImage);
    }
}
