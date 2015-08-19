package com.ardentlabs.globalencyc.iofiles;

import android.content.Context;
import android.content.res.AssetManager;

import com.ardentlabs.globalencyc.data.SharedData;
import com.ardentlabs.globalencyc.models.Dater;
import com.ardentlabs.globalencyc.models.HistoryInfo;
import com.ardentlabs.globalencyc.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by muneebahmad on 05/04/15.
 */
public class HistoryLoader {

    public static ArrayList<HistoryInfo> loadedFromAssetsList = new ArrayList<>();

    public HistoryLoader() {}

    public static void read(Context context) {
        AssetManager am = context.getAssets();

        String tokens[] = null;
        String date;
        String year;
        String event;
        String description;

        try {
            InputStream is = am.open(SharedData.FILENAME_HISTORY);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line = br.readLine();
            int i =  1;

            while (line != null) {
                tokens = line.split("=");
                date = tokens[0];
                year = tokens[1];
                event = tokens[2];
                description = tokens[3];

                if (date.equals(Dater.getDateInOrder())) {
                    HistoryInfo p = new HistoryInfo(date, year, event, description);
                    loadedFromAssetsList.add(p);
                }
                //Log.log("HISTORY DETAILS READ LINE NO -> " + i);
                line = br.readLine();
                i++;
            }

            is.close();
            isr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.log("ERROR IN HISTORY DETAILS LOADER WHILE LOOP");
        }
    }

    public static void print() {
        for (int i = 0; i < loadedFromAssetsList.size(); i++) {
            Log.log("ASSETS HISTORY DETAILS -> " + loadedFromAssetsList.get(i).getDate() + " -> " +
                    loadedFromAssetsList.get(i).getYear());
        }
    }

}/** end class. */
