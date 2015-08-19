package com.ardentlabs.globalencyc.models;

/**
 * Created by muneebahmad on 26/03/15.
 */
public class CountryDetailsInfo {

    private int id;
    private String name;
    private String capital;
    private String officialName;
    private String majorReligion;
    private String formation;
    private String population;
    private String area;
    private String gdp;
    private String literacy;
    private String languages;
    private String majorCities;
    private String climate;
    private String birthRate;
    private String currency;
    private String highPoint;
    private String code;
    private String callingCode;
    private String internetTLD;
    private String continent;
    private String organization;
    private String lat;
    private String lng;

    public CountryDetailsInfo() {}

    /**
     * OVERLOADED.
     * @param builder
     */
    private CountryDetailsInfo(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.capital = builder.capital;
        this.officialName = builder.officialName;
        this.majorReligion = builder.majorReligion;
        this.literacy = builder.literacy;
        this.languages = builder.languages;
        this.majorCities = builder.majorCities;
        this.climate = builder.climate;
        this.population = builder.population;
        this.area = builder.area;
        this.formation = builder.formation;
        this.highPoint = builder.highPoint;
        this.gdp = builder.gdp;
        this.currency = builder.currency;
        this.code = builder.code;
        this.callingCode = builder.callingCode;
        this.internetTLD = builder.internetTLD;
        this.continent = builder.continent;
        this.organization = builder.organization;
        this.birthRate = builder.birthRate;
        this.lat = builder.lat;
        this.lng = builder.lng;
    }

    public static class Builder {

        private int id;
        private String name;
        private String capital;
        private String officialName;
        private String majorReligion;
        private String literacy;
        private String languages;
        private String majorCities;
        private String climate;
        private String population;
        private String area;
        private String formation;
        private String highPoint;
        private String gdp;
        private String currency;
        private String code;
        private String callingCode;
        private String internetTLD;
        private String continent;
        private String organization;
        private String birthRate;
        private String lat;
        private String lng;

        public Builder() {}

        /**
         *
         * @param id
         * @return
         */
        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        /**
         *
         * @param name
         * @return
         */
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         *
         * @param capital
         * @return
         */
        public Builder setCapital(String capital) {
            this.capital = capital;
            return this;
        }

        /**
         *
         * @param officialName
         * @return
         */
        public Builder setOfficailName(String officialName) {
            this.officialName = officialName;
            return this;
        }

        /**
         *
         * @param majorReligion
         * @return
         */
        public Builder setMajorReligion(String majorReligion) {
            this.majorReligion = majorReligion;
            return this;
        }

        /**
         *
         * @param literacy
         * @return
         */
        public Builder setLiteracy(String literacy) {
            this.literacy = literacy;
            return this;
        }

        /**
         *
         * @param languages
         * @return
         */
        public Builder setLanguages(String languages) {
            this.languages = languages;
            return this;
        }

        /**
         *
         * @param majorCities
         * @return
         */
        public Builder setMajorCities(String majorCities) {
            this.majorCities = majorCities;
            return this;
        }

        /**
         *
         * @param climate
         * @return
         */
        public Builder setClimate(String climate) {
            this.climate = climate;
            return this;
        }

        /**
         *
         * @param birthRate
         * @return
         */
        public Builder setBirthRate(String birthRate) {
            this.birthRate = birthRate;
            return this;
        }

        /**
         *
         * @param population
         * @return
         */
        public Builder setPopulation(String population) {
            this.population = population;
            return this;
        }

        /**
         *
         * @param area
         * @return
         */
        public Builder setArea(String area) {
            this.area = area;
            return this;
        }

        /**
         *
         * @param formation
         * @return
         */
        public Builder setFormation(String formation) {
            this.formation = formation;
            return this;
        }

        /**
         *
         * @param highPoint
         * @return
         */
        public Builder setHighPoint(String highPoint) {
            this.highPoint = highPoint;
            return this;
        }

        /**
         *
         * @param gdp
         * @return
         */
        public Builder setGdp(String gdp) {
            this.gdp = gdp;
            return this;
        }

        /**
         *
         * @param currency
         * @return
         */
        public Builder setCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        /**
         *
         * @param code
         * @return
         */
        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        /**
         *
         * @param callingCode
         * @return
         */
        public Builder setCallingCode(String callingCode) {
            this.callingCode = callingCode;
            return this;
        }

        /**
         *
         * @param internetTLD
         * @return
         */
        public Builder setInternetTLD(String internetTLD) {
            this.internetTLD = internetTLD;
            return this;
        }

        /**
         *
         * @param continent
         * @return
         */
        public Builder setContinent(String continent) {
            this.continent = continent;
            return this;
        }

        /**
         *
         * @param organization
         * @return
         */
        public Builder setOrganization(String organization) {
            this.organization = organization;
            return this;
        }

        /**
         *
         * @param lat
         * @return
         */
        public Builder setLat(String lat) {
            this.lat = lat;
            return this;
        }

        /**
         *
         * @param lng
         * @return
         */
        public Builder setLng(String lng) {
            this.lng = lng;
            return this;
        }


        /**
         * BUILD THE OBJECT.
         * @return
         */
        public CountryDetailsInfo build() {
            return new CountryDetailsInfo(this);
        }

    }/** end inner class. */

    /**
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the capital
     */
    public String getCapital() {
        return this.capital;
    }

    /**
     * @return the officialName
     */
    public String getOfficialName() {
        return this.officialName;
    }

    /**
     * @return the majorReligion
     */
    public String getMajorReligion() {
        return this.majorReligion;
    }

    /**
     * @return the literacy
     */
    public String getLiteracy() {
        return this.literacy;
    }

    /**
     * @return the languages
     */
    public String getLanguages() {
        return this.languages;
    }

    /**
     * @return the majorCities
     */
    public String getMajorCities() {
        return this.majorCities;
    }

    /**
     * @return the climate
     */
    public String getClimate() {
        return this.climate;
    }

    /**
     * @return the population
     */
    public String getPopulation() {
        return this.population;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return this.area;
    }

    /**
     * @return the formation
     */
    public String getFormation() {
        return this.formation;
    }

    /**
     * @return the highPoint
     */
    public String getHighPoint() {
        return this.highPoint;
    }

    /**
     * @return the gdp
     */
    public String getGdp() {
        return this.gdp;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
        return this.currency;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * @return the callingCode
     */
    public String getCallingCode() {
        return this.callingCode;
    }

    /**
     * @return the internetTLD
     */
    public String getInternetTLD() {
        return this.internetTLD;
    }

    /**
     * @return the continent
     */
    public String getContinent() {
        return this.continent;
    }

    /**
     * @return the organization
     */
    public String getOrganization() {
        return this.organization;
    }

    /**
     *
     * @return lat double
     */
    public double getLat() {
        return Double.valueOf(this.lat);
    }

    /**
     *
     * @return lng double
     */
    public double getLng() {
        return Double.valueOf(this.lng);
    }

    /**
     *
     * @return the birth rate
     */
    public String getBirthRate() {
        return this.birthRate;
    }

}/** end class. */
