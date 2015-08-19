package com.ardentlabs.globalencyc.models;

/**
 * Created by muneebahmad on 05/04/15.
 */
public class PopulationInfo {

    private String country;
    private String population;

    /**
     *
     * @param country
     * @param population
     */
    public PopulationInfo(String country, String population) {
        this.country = country;
        this.population = population;
    }

    /**
     *
     * @return the country name String
     */
    public String getCountry() {
        return this.country;
    }

    /**
     *
     * @return the population in String
     */
    public String getPopulation() {
        return this.population;
    }

}/** end class. */
