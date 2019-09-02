package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.lang.reflect.Array;
import java.util.*;

public class BusinessLogic {


    private JsonArray listOfCardsRanks;
    private Set<Integer> intListOfRanks;
    private Set<String> stringSetOfCards;
    private HashMap<Integer, Integer> mapOfCards;
    private ArrayList<String> stringArrayOfRanks;

    public BusinessLogic(JsonArray listOfCardRanks) {
        this.listOfCardsRanks = listOfCardRanks;
    }

    public int createBet(){
        return 0;
    }

    public void createHashMap(JsonArray listOfCardsRanks) throws ClassCastException{
        for(JsonElement rank: listOfCardsRanks){
            String rankString = rank.getAsString();
            switch (rankString) {
                case "J":
                    rankString = "11";
                    break;
                case "Q":
                    rankString = "12";
                    break;
                case "K":
                    rankString = "13";
                    break;
                case "A":
                    rankString = "14";
                    break;
            }

            stringArrayOfRanks.add(rankString);
            stringSetOfCards.add(rankString);
        }

        for(String rankString: stringSetOfCards) {
            int howMany = Collections.frequency(stringArrayOfRanks, rankString);
            mapOfCards.put(Integer.valueOf(rankString), howMany);
        }
    }

}
