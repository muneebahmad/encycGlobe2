package com.ardentlabs.globalencyc.iofiles;

import android.content.Context;
import android.content.res.AssetManager;

import com.ardentlabs.globalencyc.data.SharedData;
import com.ardentlabs.globalencyc.models.GDPInfo;
import com.ardentlabs.globalencyc.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by muneebahmad on 04/04/15.
 */
public class GDPLoader {

    public static ArrayList<GDPInfo> loadedFromAssetsList = new ArrayList<>();

    public GDPLoader() {}

    /**
     *
     * @param context {@link #Context}
     */
    public static void read(Context context) {
        AssetManager am = context.getAssets();

        String tokens[] = null;
        String id;
        String name;
        String gdp;

        try {
            InputStream is = am.open(SharedData.FILENAME_COUNTRY_GDP);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line = br.readLine();
            int i = 1;

            while (line != null) {
                tokens = line.split("=");
                id = tokens[0];
                name = tokens[1];
                gdp = tokens[2];

                GDPInfo p = new GDPInfo(id, name, gdp);
                loadedFromAssetsList.add(p);
                //Log.log("GDP DETAILS READ LINE NO -> " + i);
                line = br.readLine();
                i++;
            }

            br.close();
            isr.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.log("ERROR IN GDP DETAILS LOADER WHILE LOOP");
        }
    }

    public static void print() {
        for (int i = 0; i < loadedFromAssetsList.size(); i++) {
            Log.log("ASSETS GDP DETAILS -> " + loadedFromAssetsList.get(i).getId() + " -> " +
                    loadedFromAssetsList.get(i).getName());
        }
    }

}/** end class. */
