package com.farrutapps.set.model;

import java.util.ArrayList;
import java.util.Random;


public class stack {
    //attributes
    private ArrayList<card> stack;

    //constructor
    public stack(){

        for (int a=0; a<3;++a){
            for (int b=0; b<3; ++b){
                for (int c=0; c<3; ++c){
                    for (int d=0; d<3; ++d){
                        stack.add(new card(a,b,c,d));
                    }
                }
            }
        }

    mixStack();
    }

    //methods
    void mixStack(){

        ArrayList<card> tempStack = stack;
        int stacksize=stack.size();
        stack.clear();

        Random randomNumbers = new Random();
        int randomIndex;

        for (int i=0; i<stacksize;++i){
            randomIndex = randomNumbers.nextInt(tempStack.size() - 1);
            stack.add(tempStack.get(randomIndex));
            tempStack.remove(randomIndex);
        }
    }

    card pullCard(){

        card returncard;
        returncard=stack.get(0);
        stack.remove(0);
        return returncard;
        }

    boolean isEmpty(){
        if (stack.isEmpty()){
            return true;
        }
        else return false;
    }

}
