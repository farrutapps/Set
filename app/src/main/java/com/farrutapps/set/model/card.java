package com.farrutapps.set.model;

import java.util.ArrayList;


public class card {

    //members:
    ArrayList<Integer> features;

    //constructor
    public card(int colour, int shape, int texture, int number) {
        this.features.add(colour);
        this.features.add(shape);
        this.features.add(texture);
        this.features.add(number);
    }

    public int getFeature(int index) {
        return features.get(index);
    }
}
