package com.farrutapps.set.model;

import java.util.ArrayList;


public class Board {


    //members
    private ArrayList<Card> activeCards;
    private ArrayList<Card> selectedCards;
    private int score;
    private Stack stack;

    //constructor
    public Board() {

        stack = new Stack();

        for (int i = 0; i < 12; ++i) {
            activeCards.add(stack.pullCard());
        }
        score = 0;
    }

    //methods:
    public void addActiveCard(int number){
        for (int i=0; i<number; ++i){
            if(!stack.isEmpty())
            activeCards.add(stack.pullCard());
        }
    }
    public void cardAction(Card selectedCard){

        if(getSelectedCards().contains(selectedCard)){
            this.unselectCard(selectedCard);
        }
        else this.selectCard(selectedCard);
    }

    public void selectCard(Card selectedCard) {

        getSelectedCards().add(selectedCard);
        selectedCard.setIsSelected(true);

        if (getSelectedCards().size() == 3) {

            if (isSet()) {

                deleteSet();

                addActiveCard(3);

                score += 1;
            }
        }
    }

    public void unselectCard(Card selectedCard) {
        getSelectedCards().remove(selectedCard);
        selectedCard.setIsSelected(false);
    }

    public void deleteSet() {
        for (Card i : getSelectedCards()) {
            activeCards.remove(i);
        }
        getSelectedCards().clear();


    }


    public boolean isSet() {



        for (int i = 0; i < 4; ++i) {

            // TODO: @WZ - aqui es donde mola tener el ArrayList features. sino deberia hacer 4 de estos ifs gigantes. Cada uno con su getColour, getShape... aqui es getFeature(i) =)

            if ((getSelectedCards().get(0).getFeature(i) == getSelectedCards().get(1).getFeature(i) && getSelectedCards().get(2).getFeature(i) == getSelectedCards().get(0).getFeature(i))
                    || (getSelectedCards().get(0).getFeature(i) != getSelectedCards().get(1).getFeature(i) && getSelectedCards().get(2).getFeature(i) != getSelectedCards().get(0).getFeature(i)) && getSelectedCards().get(1).getFeature(i) != getSelectedCards().get(2).getFeature(i)) {
            } else return false;
        }

        return true;
    }

    // Getters and setters
    public ArrayList<Card> getActiveCards() {
        return activeCards;
    }


    public ArrayList<Card> findSolution(int mode) {

        ArrayList<Card> set = new ArrayList<>(3);

        // fk - different modes for different alogorithms. That way we can later on compare the performance of them.
        int counterCalculations = 0;

        //long startTime = System.nanoTime();
        //long elapsedTime=0;
        //elapsedTime=System.nanoTime()-startTime;

        switch (mode) {

            case 0: // brute force method.

                for (int i = 0; i < activeCards.size(); ++i) {
                    for (int j = 0; j < activeCards.size(); ++j) {
                        for (int k = 0; k < activeCards.size(); ++k) {

                            ++counterCalculations;

                            if (i != j && i != k && j != k) {
                                set.add(activeCards.get(i));
                                set.add(activeCards.get(j));
                                set.add(activeCards.get(k));

                                if (isSet()) {

                                    return set;
                                }
                            }

                        }
                    }
                }

                return set;

            case 1: //improved brute force method, without repetitions

                for (int i = 0; i < activeCards.size(); ++i) {
                    for (int j = i + 1; j < activeCards.size(); ++j) {
                        for (int k = j + 1; k < activeCards.size(); ++k) {

                            ++counterCalculations;

                            set.add(activeCards.get(i));
                            set.add(activeCards.get(j));
                            set.add(activeCards.get(k));

                            if (isSet()) {

                                return set;

                            }
                        }

                    }
                }
        }

        return set;

    }


    public ArrayList<Card> hint(boolean removeSecondCard) {

        ArrayList<Card> result = findSolution(1);
        result.remove(0);

        if (removeSecondCard == true) {
            result.remove(0);
        }

        return result;
    }


    public int getScore() {
        return score;
    }

    public ArrayList<Card> getSelectedCards() {
        return selectedCards;
    }
}