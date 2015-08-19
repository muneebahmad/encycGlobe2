package com.ardentlabs.globalencyc.iofiles;

import android.content.Context;
import android.content.res.AssetManager;

import com.ardentlabs.globalencyc.data.SharedData;
import com.ardentlabs.globalencyc.models.PopulationInfo;
import com.ardentlabs.globalencyc.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by muneebahmad on 05/04/15.
 */
public class PopulationLoader {

    public static ArrayList<PopulationInfo> loadedFromAssetsList = new ArrayList<>();

    public PopulationLoader() {}

    /**
     *
     * @param context {@link #Context}
     */
    public static void read(Context context) {
        AssetManager am = context.getAssets();

        String tokens[] = null;
        String country;
        String population;

        try {
            InputStream is = am.open(SharedData.FILENAME_POPULATION);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line = br.readLine();
            int i =  1;

            while (line != null) {
                tokens = line.split("=");
                country = tokens[2];
                population = tokens[3];

                PopulationInfo p = new PopulationInfo(country, population);
                loadedFromAssetsList.add(p);

                //Log.log("POPULATION DETAILS READ LINE NO -> " + i);
                line = br.readLine();
                i++;
            }
            br.close();
            isr.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.log("ERROR IN POPULATION DETAILS LOADER WHILE LOOP");
        }
    }

    public static void print() {
        for (int i = 0; i < loadedFromAssetsList.size(); i++) {
            Log.log("ASSETS POPULATION DETAILS -> " + loadedFromAssetsList.get(i).getCountry() + " -> " +
                    loadedFromAssetsList.get(i).getPopulation());
        }
    }

}/** end class. */
