package com.ardentlabs.globalencyc.models;

/**
 * Created by muneebahmad on 31/03/15.
 */
public class HolidayInfo {

    private String id;
    private String name;
    private String day;
    private String type;
    private String date;
    private String holiday;
    private String comments;

    public HolidayInfo() {}

    /**
     *
     * @param id
     * @param name
     * @param day
     * @param type
     * @param date
     * @param holiday
     * @param comments
     */
    public HolidayInfo(String id, String name, String day, String type, String date, String holiday,
                       String comments) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.type = type;
        this.date = date;
        this.holiday = holiday;
        this.comments = comments;
    }

    /**
     *
     * @return the id
     */
    public String getId() {
        return this.id;
    }

    /**
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return the day
     */
    public String getDay() {
        return this.day;
    }

    /**
     *
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     *
     * @return the date
     */
    public String getDate() {
        return this.date;
    }

    /**
     *
     * @return the holiday
     */
    public String getHoliday() {
        return this.holiday;
    }

    /**
     *
     * @return the comments
     */
    public String getComments() {
        return this.comments;
    }

}/** end class. */
