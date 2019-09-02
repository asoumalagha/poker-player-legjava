package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.*;

import java.util.Map;

public class Player {

    static final String VERSION = "1.0";

    public static int betRequest(JsonElement request) {
        Gson gson = new Gson();
        JsonObject data = request.getAsJsonObject();
        JsonObject players = data.get("players").getAsJsonObject();

        Map playersList = gson.fromJson(players, Map.class);

        String playersListString = playersList.get("LegJava").toString();

        Logger logger = new Logger();
        logger.log(playersListString);


        return 500;
    }

    public static void showdown(JsonElement game) {

    }

}
