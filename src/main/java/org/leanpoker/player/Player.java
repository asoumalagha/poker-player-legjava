package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.*;

import java.util.Map;

public class Player {

    static final String VERSION = "1.0";

    public static int betRequest(JsonElement request) {
        JsonObject data = request.getAsJsonObject();
        JsonArray players = data.get("players").getAsJsonArray();

        for(JsonElement player: players){
            Logger.log(player.toString());
            /*JsonObject jsonObject = player.getAsJsonObject();
            if(jsonObject.get("name").toString().equals("LegJava")){
                JsonArray wholeCards = jsonObject.get("hole_cards").getAsJsonArray();
                Logger.log(wholeCards.getAsString());
                break;
            } else {
                Logger.log("Kiscica");
            }*/

        }


        return 500;
    }

    public static void showdown(JsonElement game) {

    }

}
