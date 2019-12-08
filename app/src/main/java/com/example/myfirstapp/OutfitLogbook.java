package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class OutfitLogbook extends AppCompatActivity {

    private ImageView myImage;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outfit_logbook);
        myImage = (ImageView) findViewById(R.id.imageView);

    }
}
