package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Clothing extends AppCompatActivity {

    private String type;
    private Color color;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    public Clothing(String setType, Color setColor) {

        type = setType;
        color = setColor;

    }

    public String getType() {
        return this.type;
    }

    public Color getColor() {
        return this.color;
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
            ImageView toReturnimageView;
            toReturnimageView.setImageBitmap(imageBitmap);
        }
    }






}
