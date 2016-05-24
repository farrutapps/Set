package com.farrutapps.set.controller;
import com.farrutapps.set.model.Board;
import com.farrutapps.set.model.Card;

import java.util.ArrayList;


public class Controller {
    private static Board board;

    public Controller() {
        board = new Board();

    }

    public static ArrayList<Card> findSolution() {
        return board.findSolution(1);
    }

    public static ArrayList<Card> Hint(boolean removeSecondCard) {
        return board.hint(removeSecondCard);
    }

}