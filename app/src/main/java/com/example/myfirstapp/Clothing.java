package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;

public class Clothing extends AppCompatActivity {

    private String type;
    private String color;
    private String name;

    private Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

    private Map<String, ImageView> clothingMaplist = new HashMap<String, ImageView>();

    Clothing(String setType, String setColor, String setName) {

        type = setType;
        color = setColor;
        name = setName;

    }

    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outfit_logbook);
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView toReturnimageView = findViewById(R.id.imageView3);
            toReturnimageView.setImageBitmap(imageBitmap);
        }
    }
}
