package com.example.myfirstapp;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Mood extends AppCompatActivity {

    /** The URL of the weather query result. */
   // private final String URL = "https://api.pinterest.com/v1/boards/purrfectgrape/all-things-nail-y/pins/?access_token=AgGD0H6mBmTg62tl_BdXPAABRz1oFd2gSfuHINJGW14oDgCz-wGfADAAABAmRlylmaOgxo8AAAAA"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);
        ImageView blah = (ImageView)findViewById(R.id.image);
        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(blah);
    }

    // plan: Have the user input their mood and concatenate their search to:
    // https://www.pinterest.com/search/boards/?q=summer%20fashion&rs=filter
    // link these moods into a Pinterest board
    // retrieve the RSS link and
}
