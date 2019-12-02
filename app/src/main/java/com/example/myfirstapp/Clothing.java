package com.example.myfirstapp;

import android.graphics.Color;

public class Clothing {

    private String type;
    private Color color;

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

}
