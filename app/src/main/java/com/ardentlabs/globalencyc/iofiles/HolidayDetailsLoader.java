package com.ardentlabs.globalencyc.iofiles;

import android.content.Context;
import android.content.res.AssetManager;

import com.ardentlabs.globalencyc.data.SharedData;
import com.ardentlabs.globalencyc.models.HolidayInfo;
import com.ardentlabs.globalencyc.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by muneebahmad on 31/03/15.
 */
public class HolidayDetailsLoader {

    public static ArrayList<HolidayInfo> loadedFromAssetsList = new ArrayList<>();

    public HolidayDetailsLoader() {}

    /**
     *
     * @param context {@link #Context}
     */
    public static void read(Context context) {
        AssetManager am = context.getAssets();

        String tokens[] = null;
        String id;
        String name;
        String day;
        String type;
        String date;
        String holiday;
        String comments;

        try {
            InputStream is = am.open(SharedData.FILENAME_HOLIDAYS);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line = br.readLine();

            int i = 1;

            while (line != null) {
                tokens = line.split("=");
                id = tokens[0];
                name = tokens[1];
                day = tokens[2];
                type = tokens[3];
                date = tokens[4];
                holiday = tokens[5];
                comments = tokens[6];

                HolidayInfo p = new HolidayInfo(id, name, day, type, date, holiday, comments);
                loadedFromAssetsList.add(p);

                //Log.log("HOLIDAY DETAILS READ LINE NO -> " + i);
                line = br.readLine();
                i++;
            }

            br.close();
            isr.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.log("ERROR IN HOLIDAY DETAILS LOADER WHILE LOOP");
        }
    }

    public static void print() {
        for (int i = 0; i < loadedFromAssetsList.size(); i++) {
            Log.log("ASSETS HOLIDAY DETAILS -> " + loadedFromAssetsList.get(i).getId() + " -> " +
                    loadedFromAssetsList.get(i).getName());
        }
    }

}/** end class. */
