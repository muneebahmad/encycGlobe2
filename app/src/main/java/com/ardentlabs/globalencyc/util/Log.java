package com.ardentlabs.globalencyc.util;

/**
 * Created by muneebahmad on 24/03/15.
 */
public class Log {

    public Log() {}

    /**
     *
     * @param message
     */
    public static void log(String message) {
        android.util.Log.e("GLOBAL ENCYC ", " -> " + message);
    }

}/** end class. */
