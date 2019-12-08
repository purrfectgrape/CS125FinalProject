package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mood extends AppCompatActivity {

    private TextView requestBox;
    private EditText textBox;
    private String searchContent;
    private String[] searchTokens;
    private final String BASEURL = "https://www.google.com/search?q=";
    private WebView webResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);
        textBox = (EditText) findViewById(R.id.textBox);
        requestBox = (TextView) findViewById(R.id.requestForInput);
        webResult = (WebView) findViewById(R.id.webResult);
        requestBox.setVisibility(View.VISIBLE);
        textBox.setVisibility(View.VISIBLE);
        webResult.setVisibility(View.GONE);
        addKeyListener();
    }

    public void addKeyListener() {
        // add a keylistener to keep track of user input
        textBox.setOnKeyListener(new View.OnKeyListener()  {
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if ((event.getAction() == KeyEvent.ACTION_DOWN)
                        && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // display a floating message
                    Toast.makeText(Mood.this,
                            textBox.getText(), Toast.LENGTH_LONG).show();
                    textBox.setVisibility(View.GONE);
                    requestBox.setVisibility(View.GONE);
                    webResult.setVisibility(View.VISIBLE);
                    searchContent = textBox.getEditableText().toString();
                    final String uRLToSearch = toURL(searchContent);
                    webResult.setWebViewClient(new WebViewClient());
                    webResult.getSettings().setJavaScriptEnabled(true);
                    webResult.loadUrl(BASEURL + searchContent);
                    return true;
                }
                return false;
            }
        });
    }

    public String toURL(String searchText) {
        searchTokens = searchText.trim().split(" ");
        String uRL = BASEURL;
        for (String token : searchTokens) {
            uRL = uRL + "+" + token;
        }
        return uRL;
    }

}
