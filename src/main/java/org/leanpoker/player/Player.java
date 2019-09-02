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
            JsonArray cardRanks = new JsonArray();
            JsonArray commCards = data.get("community_cards").getAsJsonArray();

            for (JsonElement player : players) {
                JsonObject playerObject = player.getAsJsonObject();

                if (playerObject.get("name").getAsString().equals("LegJava")) {
                    JsonArray holeCards = playerObject.get("hole_cards").getAsJsonArray();
                    for (JsonElement card : holeCards) {
                        //Logger.log(card.getAsString());
                        cardRanks.add(card.getAsJsonObject().get("rank"));
                    }
                    break;

                } else {
                    Logger.log("Kiscica");
                }
            }
            for(JsonElement card: commCards){
                cardRanks.add(card.getAsJsonObject().get("rank"));
            }
            Logger.log(cardRanks.getAsString());

        } catch (Exception e) {
            return 999;
        }
        return 999;
    }

    public static void showdown(JsonElement game) {

    }

}
