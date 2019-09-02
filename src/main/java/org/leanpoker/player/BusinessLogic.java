package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.lang.reflect.Array;
import java.util.*;

public class BusinessLogic {


    private JsonArray listOfCardsRanks;
    private Set<String> stringSetOfCards = new HashSet<>();
    private HashMap<Integer, Integer> mapOfCards = new HashMap<>();
    private ArrayList<String> stringArrayOfRanks = new ArrayList<>();

    public BusinessLogic(JsonArray listOfCardRanks) {
        this.listOfCardsRanks = listOfCardRanks;
        createHashMap(listOfCardsRanks);
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

    public int countPairs(){
        int countPairs = 0;
        for(Map.Entry<Integer, Integer> entry: mapOfCards.entrySet()){
            if(entry.getValue() == 2){
                countPairs += 1;
            }
        }
        return countPairs;
    }

    public boolean checkDrill(){
        boolean isThereADrill = false;
        for(Map.Entry<Integer, Integer> entry: mapOfCards.entrySet()){
            if(entry.getValue() == 3){
                isThereADrill = true;
            }
        }
        return isThereADrill;
    }

    public boolean checkPoker(){
        boolean isThereAPoker = false;
        for(Map.Entry<Integer, Integer> entry: mapOfCards.entrySet()){
            if(entry.getValue() == 4){
                isThereAPoker = true;
            }
        }
        return isThereAPoker;
    }

    public boolean checkFullHouse(){
        boolean isThereFullHouse = false;
        boolean isThereADrill = false;
        boolean isThereAPair = false;


        for(Map.Entry<Integer, Integer> entry: mapOfCards.entrySet()){
            if(entry.getValue() == 3){
                isThereADrill = true;
            } else if(entry.getValue() == 2){
                isThereAPair = true;
            }
        }
        if(isThereADrill && isThereAPair){
            isThereFullHouse = true;
        }

        return isThereFullHouse;
    }


    public int createBet(){
        if (checkFullHouse()) {
            return 1000;
        } else if(checkPoker()){
            return 800;
        }else if(checkDrill()){
            return 600;
        }else if(countPairs() == 2){
            return 400;
        }else if(countPairs() == 1){
            return 250;
        }else {
            return 1000;
        }
    }

}
