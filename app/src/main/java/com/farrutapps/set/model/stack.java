package com.farrutapps.set.model;

import java.util.ArrayList;
import java.util.Random;


public class Stack {
    //attributes
    private ArrayList<Card> stack;

    //constructor
    public Stack(){

        for (int a=0; a<3;++a){
            for (int b=0; b<3; ++b){
                for (int c=0; c<3; ++c){
                    for (int d=0; d<3; ++d){
                        stack.add(new Card(a,b,c,d));
                    }
                }
            }
        }

    mixStack();
    }

    //methods
    public void mixStack(){

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
