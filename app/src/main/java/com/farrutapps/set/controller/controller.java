package com.farrutapps.set.controller;
import com.farrutapps.set.model.board;
import com.farrutapps.set.model.stack;
import com.farrutapps.set.model.card;

import java.util.ArrayList;


public class controller {
    private board board;



    public controller(){
        board = new board();

    }

    public ArrayList<Integer> findSolution(){
        ArrayList<card> activeCards = board.getActiveCards();
        ArrayList<Integer> set = new ArrayList<>(3);

        // TODO: implement findSolution algorithm

        return set;
    }

    public ArrayList<Integer> hint(boolean removeSecondCard){

        ArrayList<Integer> result = findSolution();
        result.remove(0);

        if(removeSecondCard==true) {
            result.remove(0);
        }

        return result;
    }

}
