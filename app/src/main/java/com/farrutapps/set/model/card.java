package com.farrutapps.set.model;

import java.util.ArrayList;


public class Card {

    //members:
    ArrayList<Integer> features;
    private boolean isSelected=false;


    //constructor
    public Card(int colour, int shape, int texture, int number) {
        this.features.add(colour);
        this.features.add(shape);
        this.features.add(texture);
        this.features.add(number);
    }

    public int getFeature(int index) {
        return features.get(index);
    }


    public boolean isSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
