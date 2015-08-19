package com.ardentlabs.globalencyc.models;

import com.ardentlabs.globalencyc.util.Log;

import java.util.Calendar;

/**
 * Created by muneebahmad on 01/04/15.
 */
public class Dater {

    private static Calendar calendar = Calendar.getInstance();

    private static String strMonth;
    private static int day;
    private static int month;

    private static final String JAN = "January";
    private static final String FEB = "February";
    private static final String MAR = "March";
    private static final String APR = "April";
    private static final String MAY = "May";
    private static final String JUN = "June";
    private static final String JUL = "July";
    private static final String AUG = "August";
    private static final String SEP = "September";
    private static final String OCT = "October";
    private static final String NOV = "November";
    private static final String DEC = "December";

    public Dater() {}

    /**
     *
     * @return int day of Month
     */
    public static int getDeviceDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     *
     * @return Month
     */
    public static int getDeviceMonth() {
        return calendar.get(Calendar.MONTH);
    }

    /**
     * PRINT TO LOG IF NEEDED
     */
    public static void printDate() {
        Log.log("DATE -> " + getDeviceDay() + ", " + getDeviceMonth());
    }

    /**
     *
     * @return date in format mm, dd
     */
    public static String getDate() {
        day = getDeviceDay();
        month = getDeviceMonth();

        switch (month) {
            case 0:
                strMonth = JAN;
                break;
            case 1:
                strMonth = FEB;
                break;
            case 2:
                strMonth = MAR;
                break;
            case 3:
                strMonth = APR;
                break;
            case 4:
                strMonth = MAY;
                break;
            case 5:
                strMonth = JUN;
                break;
            case 6:
                strMonth = JUL;
                break;
            case 7:
                strMonth = AUG;
                break;
            case 8:
                strMonth = SEP;
                break;
            case 9:
                strMonth = OCT;
                break;
            case 10:
                strMonth = NOV;
                break;
            case 11:
                strMonth = DEC;
                break;
        }

        return strMonth + ", " + day;
    }

    /**
     *
     * @return date in format dd-mm
     */
    public static String getDateInOrder() {
        day = getDeviceDay();
        month = getDeviceMonth();
        String stMonth = "Jan";

        switch (month) {
            case 0:
                stMonth = "Jan";
                break;
            case 1:
                stMonth = "Feb";
                break;
            case 2:
                stMonth = "Mar";
                break;
            case 3:
                stMonth = "Apr";
                break;
            case 4:
                stMonth = "May";
                break;
            case 5:
                stMonth = "Jun";
                break;
            case 6:
                stMonth = "Jul";
                break;
            case 7:
                stMonth = "Aug";
                break;
            case 8:
                stMonth = "Sep";
                break;
            case 9:
                stMonth = "Oct";
                break;
            case 10:
                stMonth = "Nov";
                break;
            case 11:
                stMonth = "Dec";
                break;
        }

        return day + "-" + stMonth;
    }

}/** end class. */
