package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.*;


public class Player {

    static final String VERSION = "1.0";

    public static int betRequest(JsonElement request) {
        JsonObject data = request.getAsJsonObject();
        JsonArray players = data.get("players").getAsJsonArray();

        for(JsonElement player: players){
            JsonObject jsonObject = player.getAsJsonObject();
            if(jsonObject.get("name").toString().equals("LegJava")){
                JsonArray wholeCards = jsonObject.get("hole_cards").getAsJsonArray();
                for(JsonElement card: wholeCards){
                    String cardString = card.toString();
                    Logger.log(cardString);
                }
                break;
            }

        }


        return 0;
    }

    public static void showdown(JsonElement game) {

    }

}
