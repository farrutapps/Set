package com.farrutapps.set.model;

import java.util.ArrayList;


public class board {
   //members
    private ArrayList<card> activeCards;
    private ArrayList<card> selectedCards;
    private int score;
    private stack stack;

    //constructor
    public board(){
        stack = new stack();

        for(int i=0; i<12; ++i){
            activeCards.add(stack.pullCard());
        }
        score = 0;
    }

    //methods:
    public void selectCard(card selectedCard){
        selectedCards.add(selectedCard);
    }

    public void unselectCard(card selectedCard){
        selectedCards.remove(selectedCard);
    }

    public void deleteSet(){
        for(card i:selectedCards){
                activeCards.remove(i);
        }
        selectedCards.clear();

        score += 1;
    }

    // TODO: move method into controller??
    public boolean isSet(){

            for(int i=0; i<4; ++i){

                // TODO: @WZ - aqui es donde mola tener el ArrayList features. sino deberia hacer 4 de estos ifs gigantes. Cada uno con su getColour, getShape... aqui es getFeature(i) =)

                if((selectedCards.get(0).getFeature(i)==selectedCards.get(1).getFeature(i) && selectedCards.get(2).getFeature(i)==selectedCards.get(0).getFeature(i))
                    || (selectedCards.get(0).getFeature(i)!=selectedCards.get(1).getFeature(i) && selectedCards.get(2).getFeature(i)!=selectedCards.get(0).getFeature(i)) && selectedCards.get(1).getFeature(i)!=selectedCards.get(2).getFeature(i)){}

                else return false;
            }

        return true;
    }
}



