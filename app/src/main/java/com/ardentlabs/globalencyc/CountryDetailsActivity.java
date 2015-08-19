package com.ardentlabs.globalencyc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.ardentlabs.globalencyc.data.ResourcesManager;
import com.ardentlabs.globalencyc.data.SharedData;
import com.ardentlabs.globalencyc.iofiles.CountryDetailsLoader;
import com.ardentlabs.globalencyc.ui.AboutDialog;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by muneebahmad on 28/03/15.
 */
public class CountryDetailsActivity extends ActionBarActivity
        implements View.OnClickListener {

    private TextView titleView;
    private Animation titleAnim;

    private TextView captialView;
    private TextView continentView;
    private TextView mapView;

    //->
    private TextView officialName;
    private TextView religions;
    private TextView cities;
    private TextView languages;
    private TextView literacy;
    private TextView population;
    private TextView area;
    private TextView formation;
    private TextView highPoint;
    private TextView gdp;
    private TextView currency;
    private TextView code;
    private TextView callingCode;
    private TextView internetTLD;
    private TextView climate;
    private TextView organization;

    private ImageView flagView;

    private final SharedData sharedData = SharedData.getInstance();

    private ShareActionProvider mShareActionProvider;

    private String MENU_SHARE = "";

    public CountryDetailsActivity() {}

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.anim_left_push_in, R.anim.anim_left_push_in_2);
        setContentView(R.layout.activity_country_details);
        setToolbar();
        setContents();
        populate();
        loadAdView();
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.country_toolbar);
        setSupportActionBar(toolbar);

        this.MENU_SHARE = "Global Encyclopedia on Android \n" +
                "\n" +
                "\n" +
                "Country: " + CountryDetailsLoader.loadedFromAssetsList.get(SharedData.getInstance().getIndex()).getName() + "\n" +
                "Capital: " + CountryDetailsLoader.loadedFromAssetsList.get(SharedData.getInstance().getIndex()).getCapital() + "\n" +
                "Continent: " + CountryDetailsLoader.loadedFromAssetsList.get(SharedData.getInstance().getIndex()).getContinent() + "\n" +
                "Population: " + CountryDetailsLoader.loadedFromAssetsList.get(SharedData.getInstance().getIndex()).getPopulation() + "\n" +
                "Highest Point: " + CountryDetailsLoader.loadedFromAssetsList.get(SharedData.getInstance().getIndex()).getHighPoint() + "\n" +
                "GDP: " + CountryDetailsLoader.loadedFromAssetsList.get(SharedData.getInstance().getIndex()).getGdp() + "\n\n" +
                "To get detailed info of every country download the app on the Android phone from the following link\n\n" +
                "https://play.google.com/store/apps/details?id=com.ardentlabs.globalencyc";
    }

    private void setContents() {
        makeTitle();
    }

    private void makeTitle() {
        this.titleView = (TextView) findViewById(R.id.country_titleView);
        this.captialView = (TextView) findViewById(R.id.tv_country_capital);
        this.continentView = (TextView) findViewById(R.id.tv_country_continent);

        this.titleView.setText("Country: " + CountryDetailsLoader.loadedFromAssetsList.
                get(sharedData.getIndex()).getName());
        this.captialView.setText("Capital: " + CountryDetailsLoader.loadedFromAssetsList.
                get(sharedData.getIndex()).getCapital());
        this.continentView.setText("Continent: " + CountryDetailsLoader.loadedFromAssetsList.
                get(sharedData.getIndex()).getContinent());

        this.titleAnim = AnimationUtils.loadAnimation(this, R.anim.title_anim);
        this.titleView.setAnimation(titleAnim);
        this.captialView.setAnimation(titleAnim);
        this.continentView.setAnimation(titleAnim);

        //ImageView
        this.flagView = (ImageView) findViewById(R.id.iv_country_flag);
        this.flagView.setImageResource(ResourcesManager.getFlag(CountryDetailsLoader.
                loadedFromAssetsList.get(sharedData.getIndex()).getId()));
        this.flagView.setAnimation(titleAnim);
        this.flagView.setOnClickListener(this);

        this.mapView = (TextView) findViewById(R.id.tv_maps_country_details);
        this.mapView.setOnClickListener(this);
        this.mapView.setAnimation(titleAnim);
    }

    private void populate() {
        this.officialName = (TextView) findViewById(R.id.tv_official_name);
        this.religions = (TextView) findViewById(R.id.tv_major_religions);
        this.cities = (TextView) findViewById(R.id.tv_major_cities);
        this.languages = (TextView) findViewById(R.id.tv_major_languages);
        this.literacy = (TextView) findViewById(R.id.tv_major_literacy);
        this.population = (TextView) findViewById(R.id.tv_major_population);
        this.area = (TextView) findViewById(R.id.tv_major_total_area);
        this.formation = (TextView) findViewById(R.id.tv_major_formation);
        this.highPoint = (TextView) findViewById(R.id.tv_major_high_point);
        this.gdp = (TextView) findViewById(R.id.tv_gdp);
        this.currency = (TextView) findViewById(R.id.tv_major_currency);
        this.code = (TextView) findViewById(R.id.tv_code);
        this.callingCode = (TextView) findViewById(R.id.tv_calling_code);
        this.internetTLD = (TextView) findViewById(R.id.tv_internet_tld);
        this.climate = (TextView) findViewById(R.id.tv_climate);
        this.organization = (TextView) findViewById(R.id.tv_organization);

        this.officialName.setText(CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getOfficialName());
        this.religions.setText(CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getMajorReligion());
        this.cities.setText(CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getMajorCities());
        this.languages.setText(CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getLanguages());
        this.literacy.setText(CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getLiteracy());
        this.population.setText(CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getPopulation());
        this.area.setText(CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getArea());
        this.formation.setText(CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getFormation());
        this.highPoint.setText(CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getHighPoint());
        this.gdp.setText(CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getGdp());
        this.currency.setText(CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getCurrency());
        this.code.setText(CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getCode());
        this.callingCode.setText(CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getCallingCode());
        this.internetTLD.setText(CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getInternetTLD());
        this.climate.setText(CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getClimate());
        this.organization.setText(CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getOrganization());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem share = menu.findItem(R.id.action_share);

        mShareActionProvider = (ShareActionProvider) MenuItemCompat.
                getActionProvider(share);
        setShareIntent(createShareIntent());
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(getApplicationContext(), AboutDialog.class));
        } else if (id == R.id.action_share) {
            return true;
        } else if (id == R.id.action_contact) {
            startActivity(new Intent(getApplicationContext(), EmailActivity.class));
        } else if (id == R.id.action_search) {
            startActivity(new Intent(getApplicationContext(), SearchActivity.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     *
     * @param shareIntent
     */
    private void setShareIntent(Intent shareIntent) {
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(shareIntent);
        }
    }

    private Intent createShareIntent() {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent
                .putExtra(
                        Intent.EXTRA_TEXT, MENU_SHARE);
        shareIntent.setType("text/plain");
        return shareIntent;
    }

    private void loadAdView() {
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("abc")
                .build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, CountryFlagsMenuActivity.class));
        finish();
    }

    @Override
    public void onClick(View view) {
        if ((view == this.mapView) || (view == this.flagView)) {
            startActivity(new Intent(this, MapActivity.class));
            finish();
        }
    }
}/** end class. */
