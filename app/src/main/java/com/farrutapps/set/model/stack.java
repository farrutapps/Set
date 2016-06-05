package com.farrutapps.set.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Stack {
    //attributes
    private ArrayList<Card> stack;

    //constructor
    public Stack(){

        this.stack = new ArrayList<Card>();

        generateCards();
        mixStack();
    }

    private void generateCards() {

        for (int colour=0; colour<3;++colour){
            for (int shape=0; shape<3; ++shape){
                for (int filling=0; filling<3; ++filling){
                    for (int number=0; number<3; ++number){
                        stack.add(new Card(colour,shape,filling,number));
                    }
                }
            }
        }

    }

    //methods
    public void mixStack(){
/*
        ArrayList<Card> tempStack = stack;
        int stackSize=stack.size();
        stack.clear();

        Random randomNumbers = new Random();
        int randomIndex;

        for (int i=0; i<stackSize;++i){
            randomIndex = randomNumbers.nextInt(tempStack.size() - 1);
            stack.add(tempStack.get(randomIndex));
            tempStack.remove(randomIndex);
        }
    */
        Collections.shuffle(this.stack);
    }


    Card pullCard(){

        Card returnCard;
        returnCard=stack.get(0);
        stack.remove(0);
        return returnCard;
        }

    boolean isEmpty(){
        if (stack.isEmpty()){
            return true;
        }
        else return false;
    }

}
