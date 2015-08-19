package com.ardentlabs.globalencyc.data;

import android.content.Context;

import com.ardentlabs.globalencyc.iofiles.CountryDetailsLoader;
import com.ardentlabs.globalencyc.iofiles.GDPLoader;
import com.ardentlabs.globalencyc.iofiles.HistoryLoader;
import com.ardentlabs.globalencyc.iofiles.HolidayDetailsLoader;
import com.ardentlabs.globalencyc.iofiles.PopulationLoader;
import com.ardentlabs.globalencyc.util.Log;

/**
 * Created by muneebahmad on 26/03/15.
 */
public class Loader {

    private static boolean isLoaded = false;
    private static int loadingProgress = 0;
    private static String state = "reading state...";

    public Loader() {}

    /**
     * START LOADING
     * @param context
     */
    public static void load(Context context) {
        loadCountryDetails(context);
    }

    /**
     * COUNTRY DETAILS
     * @param context
     */
    private static void loadCountryDetails(final Context context) {
        Thread countThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(300);
                    loadingProgress = 10;
                    state = "reading details...";
                    CountryDetailsLoader.load(context);
                    //CountryDetailsLoader.printFromAssets();
                } catch (InterruptedException e) {
                    Log.log("ERROR IN COUNTRY LOADER THREAD");
                } finally {
                    loadHolidayDetails(context);
                }
            }
        };
        countThread.start();
    }

    private static void loadHolidayDetails(final Context context) {
        Thread holidayThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(500);
                    loadingProgress = 40;
                    state = "reading holiday data...";
                    HolidayDetailsLoader.read(context);
                    //HolidayDetailsLoader.print();
                } catch (InterruptedException e) {
                    Log.log("ERROR IN HOLIDAY LOADER THREAD");
                } finally {
                    loadGDPDetails(context);
                }
            }
        };
        holidayThread.start();
    }

    /**
     *
     * @param context
     */
    private static void loadGDPDetails(final Context context){
       Thread gdpThread = new Thread() {
           @Override
           public void run() {
               try {
                   sleep(500);
                   loadingProgress = 50;
                   state = "reading gdp data...";
                   GDPLoader.read(context);
                   //GDPLoader.print();
               } catch (InterruptedException e) {
                   Log.log("ERROR IN GDP LOADER THREAD");
               } finally {
                    loadPopulationDetails(context);
               }
           }
       };
        gdpThread.start();
    }

    /**
     *
     * @param context
     */
    public static void loadPopulationDetails(final Context context) {
       Thread popThread = new Thread() {
           @Override
           public void run() {
               try {
                   sleep(500);
                   loadingProgress = 70;
                   state = "reading population data...";
                   PopulationLoader.read(context);
                   //PopulationLoader.print();
               } catch (InterruptedException e) {
                   e.printStackTrace();
                   Log.log("ERROR IN POP LOADER THREAD");
               } finally {
                    loadHistoryDetails(context);
               }
           }
       };
        popThread.start();
    }

    /**
     *
     * @param context
     */
    public static void loadHistoryDetails(final Context context) {
       Thread histThread = new Thread() {
           @Override
           public void run() {
               try {
                   sleep(500);
                   loadingProgress = 90;
                   state = "reading history data...";
                   HistoryLoader.read(context);
                   HistoryLoader.print();
               } catch (InterruptedException e) {
                   e.printStackTrace();
                   Log.log("ERROR IN HISTORY LOADER THREAD");
               } finally {
                    loadFinal(context);
               }
           }
       };
        histThread.start();
    }

    /**
     *
     * @param context
     */
    public static void loadFinal(final Context context) {
       Thread pThread = new Thread() {
           @Override
           public void run() {
               try {
                   sleep(3000);
                   loadingProgress = 100;
                   state = "complete... launching app";
               } catch (InterruptedException e) {
                   e.printStackTrace();
               } finally {

               }
           }
       };
        pThread.start();
    }

    /**
     *
     * @return loadingProgress int
     */
    public static int getLoadingProgress() {
        return loadingProgress;
    }

    /**
     *
     * @return the state String
     */
    public static String getState() {
        return state;
    }

}/** end class. */
