package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Mood extends AppCompatActivity {

    private TextView requestBox;
    private EditText textBox;
    private String searchContent;
    private String[] searchTokens;
    private final String BASEURL = "https://www.pinterest.com/search/boards/?q=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);
        textBox = (EditText) findViewById(R.id.textBox);
        requestBox = (TextView) findViewById(R.id.requestForInput);
        requestBox.setVisibility(View.VISIBLE);
        textBox.setVisibility(View.VISIBLE);
        addKeyListener();
        searchContent = textBox.getEditableText().toString();
        String uRLToSearch = toURL(searchContent);
        Log.d("URL", uRLToSearch);
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
            uRL = uRL + token + "%20";
        }
        uRL =  uRL + "&rs=filter";
        return uRL;
    }

    // Use JSoup to parse HTML and get images, populate the images to ImageView of the page.
    // // JSoup Example 2 - Reading HTML page from URL Document doc;
    // try { doc = Jsoup.connect("http://google.com/").get();
    // title = doc.title(); }
    // catch (IOException e) { e.printStackTrace(); } System.out.println("Jsoup Can read HTML page from URL, title : " + title);
    //
    //Read more: https://javarevisited.blogspot.com/2014/09/how-to-parse-html-file-in-java-jsoup-example.html#ixzz67I3xgLm6
}
