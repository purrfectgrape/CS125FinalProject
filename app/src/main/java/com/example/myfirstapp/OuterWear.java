package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class OuterWear extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;

    private Button addButton;
    private Button removeButton;
    private LinearLayout myLayout;
    private ImageButton image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessories);

        addButton = (Button) findViewById(R.id.addButton);
        removeButton = (Button) findViewById(R.id.removeButton);
        image = (ImageButton) findViewById(R.id.imageView);
        myLayout = (LinearLayout) findViewById(R.id.layout);
        image.setVisibility(View.INVISIBLE);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myLayout.removeView(image);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            image = new ImageButton(this);
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(300, 300);
            image.setLayoutParams(param);
            image.setImageBitmap(photo);
            image.setTag(java.util.UUID.randomUUID().toString());
            myLayout.addView(image);
        }
    }

}