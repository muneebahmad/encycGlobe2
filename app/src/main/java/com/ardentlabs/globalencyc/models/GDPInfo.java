package com.ardentlabs.globalencyc.models;

/**
 * Created by muneebahmad on 04/04/15.
 */
public class GDPInfo {

    private String id;
    private String name;
    private String gdp;

    /**
     *
     * @param id
     * @param name
     * @param gdp
     */
    public GDPInfo(String id, String name, String gdp) {
        this.id = id;
        this.name = name;
        this.gdp = gdp;
    }

    /**
     *
     * @return the id int
     */
    public int getId() {
        return Integer.parseInt(this.id);
    }

    /**
     *
     * @return the name String
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return the gdp String
     */
    public String getGdp() {
        return this.gdp;
    }

    /**
     *
     * @return the gdp int
     */
    public int getGdpInt() {
        return Integer.parseInt(gdp);
    }

}/** end class. */
