package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import com.pinterest.android.pdk.PDKCallback;
import com.pinterest.android.pdk.PDKClient;
import com.pinterest.android.pdk.PDKException;
import com.pinterest.android.pdk.PDKResponse;

import android.os.Bundle;

public class Mood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);
        PDKClient.configureInstance(this, '5069749331662255099');
        PDKClient.getInstance().onConnect(this);
    }
}
