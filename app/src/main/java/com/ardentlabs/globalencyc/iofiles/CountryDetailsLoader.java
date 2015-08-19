package com.ardentlabs.globalencyc.iofiles;

import android.content.Context;
import android.content.res.AssetManager;

import com.ardentlabs.globalencyc.data.SharedData;
import com.ardentlabs.globalencyc.models.CountryDetailsInfo;
import com.ardentlabs.globalencyc.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by muneebahmad on 26/03/15.
 */
public class CountryDetailsLoader {

    public static ArrayList<CountryDetailsInfo> loadedFromAssetsList = new ArrayList<>();

    public CountryDetailsLoader() {}

    public static void load(Context context) {
        AssetManager am = context.getAssets();
        String tokens[] = null;
        String id;
        String name;
        String capital;
        String officialName;
        String majorReligion;
        String literacy;
        String languages;
        String majorCities;
        String climate;
        String population;
        String area;
        String formation;
        String highPoint;
        String gdp;
        String currency;
        String code;
        String callingCode;
        String internetTLD;
        String continent;
        String organization;
        String birthRate;
        String lat;
        String lng;

        try {
            InputStream in = am.open(SharedData.FILENAME_COUNTRY_DETAILS);
            InputStreamReader inr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(inr);

            String line = br.readLine();
            int i = 1;
            while (line != null) {
                tokens = line.split("=");
                id = tokens[0];
                name = tokens[1];
                capital = tokens[2];
                officialName = tokens[3];
                majorReligion = tokens[4];
                formation = tokens[5];
                population = tokens[6];
                area = tokens[7];
                gdp = tokens[8];
                literacy = tokens[9];
                languages = tokens[10];
                majorCities = tokens[11];
                climate = tokens[12];
                birthRate = tokens[13];
                currency = tokens[14];
                highPoint = tokens[15];
                code = tokens[16];
                callingCode = tokens[17];
                internetTLD = tokens[18];
                continent = tokens[19];
                organization = tokens[20];
                lat = tokens[21];
                lng = tokens[22];

                CountryDetailsInfo.Builder builder = new CountryDetailsInfo.Builder();
                builder.setId(Integer.parseInt(id));
                builder.setName(name);
                builder.setCapital(capital);
                builder.setOfficailName(officialName);
                builder.setMajorReligion(majorReligion);
                builder.setLiteracy(literacy);
                builder.setLanguages(languages);
                builder.setMajorCities(majorCities);
                builder.setClimate(climate);
                builder.setBirthRate(birthRate);
                builder.setPopulation(population);
                builder.setArea(area);
                builder.setFormation(formation);
                builder.setHighPoint(highPoint);
                builder.setGdp(gdp);
                builder.setCurrency(currency);
                builder.setCode(code);
                builder.setCallingCode(callingCode);
                builder.setInternetTLD(internetTLD);
                builder.setContinent(continent);
                builder.setOrganization(organization);
                builder.setLat(lat);
                builder.setLng(lng);

                CountryDetailsInfo cInfo = builder.build();

                loadedFromAssetsList.add(cInfo);

                Log.log("COUNTRY DETAILS READ LINE NO ->" + i);
                line = br.readLine();
                i++;
            }

            br.close();
            inr.close();
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
            Log.log("ERROR IN COUNTRY DETAILS LOADING WHILE LOOP");
        }
    }

    public static void printFromAssets() {
        for (int i = 0; i < loadedFromAssetsList.size(); i++) {
            Log.log("ASSETS COUNTRY DETAILS -> " + loadedFromAssetsList.get(i).getId() + " -> " +
                    loadedFromAssetsList.get(i).getName());
        }
    }

    /**
     *
     * @param context
     * @param keyword
     */
    public static void searchCountries(Context context, String keyword) {

    }

}/** end class. */
