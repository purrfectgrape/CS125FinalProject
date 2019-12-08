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

    private Map<String, ImageView> clothingMaplist = new HashMap<String, ImageView>();


    static final int REQUEST_IMAGE_CAPTURE = 1;

    public Clothing(String setType, String setColor, String setName) {

        type = setType;
        color = setColor;
        name = setName;

    }

    public String getType() {
        return this.type;
    }

    public Color getColor() {
        return this.color;
    }

    public String getName() {
        return this.name;
    }

    public void setType(String setType) {
        type = setType;
    }

    public void setColor(Color setColor) {
        color = setColor;
    }

    public void setName(String setName) {
        name = setName;
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
            ImageView toReturnimageView = findViewById(R.id.imageView);
            toReturnimageView.setImageBitmap(imageBitmap);
        }
    }


}
