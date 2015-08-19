package com.ardentlabs.globalencyc.data;

/**
 * Created by muneebahmad on 24/03/15.
 */
public class SharedData {

    private static SharedData sInstance = null;

    private int index = 0;

    public static final String FILENAME_CONTINENTS = "continents.ge";
    public static final String FILENAME_COUNTRY_AREA = "country_area.ge";
    public static final String FILENAME_COUNTRY_DETAILS = "country_details2.ge";
    public static final String FILENAME_COUNTRY_GDP = "country_gdp.ge";
    public static final String FILENAME_HOLIDAYS = "holidays.ge";
    public static final String FILENAME_POPULATION = "population.ge";
    public static final String FILENAME_HISTORY = "history.ge";

    public static final String ASIA_NAME = "Asia";
    public static final String ASIA_AREA = "44, 579, 000 km²";
    public static final String ASIA_POPULATION = "4164252000";
    public static final String ASIA_NUM_COUNTRIES = "49";
    public static final String ASIA_POPULATION_DENSITY = "95.0/km²";
    public static final String ASIA_HIGH_POINT = "Mount Everest";

    public static final String AFRICA_NAME = "Africa";
    public static final String AFRICA_AREA = "30,370,000 km²";
    public static final String AFRICA_POPULATION = "1022234000";
    public static final String AFRICA_NUM_COUNTRIES = "57";
    public static final String AFRICA_POPULATION_DENSITY = "33.7/km²";
    public static final String AFRICA_HIGH_POINT = "Mount Kilimanjaro";

    public static final String N_AMERICA_NAME = "North America";
    public static final String N_AMERICA_AREA = "24,490,000 km²";
    public static final String N_AMERICA_POPULATION = "542056000";
    public static final String N_AMERICA_NUM_COUNTRIES = "23";
    public static final String N_AMERICA_POPULATION_DENSITY = "22.1/km²";
    public static final String N_AMERICA_HIGH_POINT = "Mount McKinley";

    public static final String S_AMERICA_NAME = "South America";
    public static final String S_AMERICA_AREA = "17,840,000 km²";
    public static final String S_AMERICA_POPULATION = "392555000";
    public static final String S_AMERICA_NUM_COUNTRIES = "12";
    public static final String S_AMERICA_POPULATION_DENSITY = "22.0/km²";
    public static final String S_AMERICA_HIGH_POINT = "Aconcagua";

    public static final String ANTARCTICA_NAME = "Antarctica";
    public static final String ANTARCTICA_AREA = "13,720,000 km²";
    public static final String ANTARCTICA_POPULATION = "0";
    public static final String ANTARCTICA_NUM_COUNTRIES = "0";
    public static final String ANTARCTICA_POPULATION_DENSITY = "0/km²";
    public static final String ANTARCTICA_HIGH_POINT = "Vinson Massif";

    public static final String EUROPE_NAME = "Europe";
    public static final String EUROPE_AREA = "10,180,000 km²";
    public static final String EUROPE_POPULATION = "738199000";
    public static final String EUROPE_NUM_COUNTRIES = "50";
    public static final String EUROPE_POPULATION_DENSITY = "72.5/km²";
    public static final String EUROPE_HIGH_POINT = "Mount Elbrusf";

    public static final String AUSTRALIA_NAME = "Australia";
    public static final String AUSTRALIA_AREA = "9,008,500 km²";
    public static final String AUSTRALIA_POPULATION = "29127000";
    public static final String AUSTRALIA_NUM_COUNTRIES = "3";
    public static final String AUSTRALIA_POPULATION_DENSITY = "3.2/km²";
    public static final String AUSTRALIA_HIGH_POINT = "Puncak Jaya";

    /**
     * ENUM Activated classes
     */
    public static enum ActivatedClasses {
        COUNTRIES_DETAILS,
        COUNTRIES_HOLIDAYS,
        COUNTRIES_GDP,
        COUNTRIES_POPULATION,
        COUNTRIES_CONTINENT,
        TODAY_IN_HISTORY,
        TELL_A_FRIEND,
        MAIN_MENU
    }

    public SharedData() {}

    private ActivatedClasses activatedClasses;

    /**
     *
     * @param activatedClasses {@link #SharedData.ActivatedClasses} active class.
     */
    public void setActivatedClasses(ActivatedClasses activatedClasses) {
        this.activatedClasses = activatedClasses;
    }

    /**
     *
     * @return active {@link #SharedData.ActivatedClasses}
     */
    public ActivatedClasses getActivatedClasses() {
        return this.activatedClasses;
    }

    /**
     *
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     *
     * @return index int
     */
    public int getIndex() {
        return this.index;
    }

    /**
     *
     * @return new instance of {@link #SharedData}
     */
    public static SharedData getInstance() {
        synchronized (SharedData.class) {
            if (sInstance == null) {
                sInstance = new SharedData();
            }
            return sInstance;
        }
    }

}/** end class. */
