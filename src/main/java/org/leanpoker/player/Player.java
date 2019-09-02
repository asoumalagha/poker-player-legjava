package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.*;

import java.util.Map;

public class Player {

    static final String VERSION = "1.0";

    public static int betRequest(JsonElement request) {
        try {
            JsonObject data = request.getAsJsonObject();
            JsonArray players = data.get("players").getAsJsonArray();

            for (JsonElement player : players) {
                JsonObject playerObject = player.getAsJsonObject().get("LegJava").getAsJsonObject();
                Logger.log(playerObject.toString());
            /*if(playerObject.get("name").toString().equals("LegJava")){
                JsonArray wholeCards = playerObject.get("hole_cards").getAsJsonArray();
                Logger.log(wholeCards.getAsString());
                break;
            } else {
                Logger.log("Kiscica");
            }

             */

            }

        } catch (Exception e) {
            return 800;
        }
        return 800;
    }

    public static void showdown(JsonElement game) {

    }

}
