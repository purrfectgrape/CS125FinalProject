package com.example.myfirstapp;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
        requestBox.setTextColor(Color.WHITE);
        requestBox.setTypeface(null, Typeface.BOLD);
        textBox.setVisibility(View.VISIBLE);
        textBox.setTextColor(Color.WHITE);
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
