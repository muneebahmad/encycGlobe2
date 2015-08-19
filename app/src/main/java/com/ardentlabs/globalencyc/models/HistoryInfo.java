package com.ardentlabs.globalencyc.models;

/**
 * Created by muneebahmad on 05/04/15.
 */
public class HistoryInfo {

    private String date;
    private String year;
    private String event;
    private String description;

    /**
     *
     * @param date String
     * @param year String
     * @param event String
     * @param description String
     */
    public HistoryInfo(String date, String year, String event, String description) {
        this.date = date;
        this.year = year;
        this.event = event;
        this.description = description;
    }

    /**
     *
     * @return the date in format dd-mm
     */
    public String getDate() {
        return this.date;
    }

    /**
     *
     * @return the year
     */
    public String getYear() {
        return this.year;
    }

    /**
     *
     * @return the event
     */
    public String getEvent() {
        return this.event;
    }

    /**
     *
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

}/** end class. */
