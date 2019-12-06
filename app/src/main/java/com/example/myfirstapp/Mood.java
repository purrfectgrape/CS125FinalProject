package com.example.myfirstapp;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Mood extends AppCompatActivity {

    private EditText textBox;
    private String searchContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);
        addKeyListener();
        searchContent = textBox.getEditableText().toString();
    }

    public void addKeyListener() {

        textBox = (EditText) findViewById(R.id.textBox);

        // add a keylistener to keep track of user input
        textBox.setOnKeyListener(new View.OnKeyListener()  {
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                // if keydown and "enter" is pressed
                if ((event.getAction() == KeyEvent.ACTION_DOWN)
                        && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // display a floating message
                    Toast.makeText(Mood.this,
                            textBox.getText(), Toast.LENGTH_LONG).show();
                    return true;

                }
                return false;
            }
        });
    }

    // Input the searchContent into a Pinterest URL and parse its HTML.

    // plan: Have the user input their mood and concatenate their search to:
    // https://www.pinterest.com/search/boards/?q=summer%20fashion&rs=filter
    // Use JSoup to parse HTML and get images, populate the images to ImageView of the page.
    // // JSoup Example 2 - Reading HTML page from URL Document doc;
    // try { doc = Jsoup.connect("http://google.com/").get();
    // title = doc.title(); }
    // catch (IOException e) { e.printStackTrace(); } System.out.println("Jsoup Can read HTML page from URL, title : " + title);
    //
    //Read more: https://javarevisited.blogspot.com/2014/09/how-to-parse-html-file-in-java-jsoup-example.html#ixzz67I3xgLm6
}
