package org.leanpoker.player;

public class Logger {

    public static void log(String message) {
        System.err.println(message);
    }

    public static void log(Object object) {
        log(object.toString());
    }

}
