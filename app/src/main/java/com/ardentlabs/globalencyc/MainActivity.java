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
import android.widget.ImageButton;
import android.widget.TextView;

import com.ardentlabs.globalencyc.data.ResourcesManager;
import com.ardentlabs.globalencyc.data.SharedData;
import com.ardentlabs.globalencyc.ui.AboutDialog;
import com.ardentlabs.globalencyc.ui.ExitDialog;
import com.ardentlabs.globalencyc.util.Log;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * @author muneebahmad
 */
public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private TextView titleView;
    private Animation titleAnim;
    private Animation tangoAnim;

    private ImageButton buttCountryDetails;
    private ImageButton buttCountryHolidays;
    private ImageButton buttCountryGDP;
    private ImageButton buttCountryPopulation;
    private ImageButton buttCountryContinent;
    private ImageButton buttHistory;
    private ImageButton buttTellFriend;

    private final SharedData sharedData = SharedData.getInstance();
    private String className = "Main Menu";

    public static ActionBarActivity main;

    private ShareActionProvider mShareActionProvider;

    public static final String MENU_SHARE = "Hey! I found this wonderful "
            + "Android app \'Global Encyclopedia\' on the Google Play Store, just check it out.\n\n\n"
            + "https://play.google.com/store/apps/details?id=com.ardentlabs.globalencyc";

    public MainActivity() {}

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.anim_left_push_in, R.anim.anim_left_push_in_2);
        setContentView(R.layout.activity_main);
        setToolbar();
        setTitle();
        setContents();
        main = this;

        ResourcesManager.initResourcesManager();
        loadAdView();
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
    }

    private void setTitle() {
        this.titleView = (TextView) findViewById(R.id.titleView);
        this.titleView.setText("Categories");

        this.titleAnim = AnimationUtils.loadAnimation(this, R.anim.title_anim);
        this.titleView.setAnimation(titleAnim);
    }

    private void setContents() {
        this.tangoAnim = AnimationUtils.loadAnimation(this, R.anim.tango_anim);

        this.buttCountryDetails = (ImageButton) findViewById(R.id.butt_country_details);
        this.buttCountryDetails.setOnClickListener(this);
        this.buttCountryDetails.setAnimation(tangoAnim);
        this.buttCountryContinent = (ImageButton) findViewById(R.id.butt_country_continents);
        this.buttCountryContinent.setOnClickListener(this);
        this.buttCountryContinent.setAnimation(tangoAnim);
        this.buttCountryGDP = (ImageButton) findViewById(R.id.butt_country_gdp);
        this.buttCountryGDP.setOnClickListener(this);
        this.buttCountryGDP.setAnimation(tangoAnim);
        this.buttCountryPopulation = (ImageButton) findViewById(R.id.butt_country_population);
        this.buttCountryPopulation.setOnClickListener(this);
        this.buttCountryPopulation.setAnimation(tangoAnim);
        this.buttCountryHolidays = (ImageButton) findViewById(R.id.butt_country_holidays);
        this.buttCountryHolidays.setOnClickListener(this);
        this.buttCountryHolidays.setAnimation(tangoAnim);
        this.buttHistory = (ImageButton) findViewById(R.id.butt_country_history);
        this.buttHistory.setOnClickListener(this);
        this.buttHistory.setAnimation(tangoAnim);
        this.buttTellFriend = (ImageButton) findViewById(R.id.butt_tell_a_friend);
        this.buttTellFriend.setOnClickListener(this);
        this.buttTellFriend.setAnimation(tangoAnim);
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

    @Override
    public void onClick(View view) {
        if (view == this.buttCountryDetails) {
            sharedData.setActivatedClasses(SharedData.ActivatedClasses.COUNTRIES_DETAILS);
            this.className = "COUNTRY DETAILS";
            startActivity(new Intent(this, CountryFlagsMenuActivity.class));
            finish();
        } else if (view == this.buttCountryContinent) {
            sharedData.setActivatedClasses(SharedData.ActivatedClasses.COUNTRIES_CONTINENT);
            this.className = "COUNTRY CONTINENT";
            startActivity(new Intent(this, ContinentActivity.class));
            finish();
        } else if (view == this.buttCountryHolidays) {
            sharedData.setActivatedClasses(SharedData.ActivatedClasses.COUNTRIES_HOLIDAYS);
            this.className = "COUNTRY HOLIDAYS";
            startActivity(new Intent(this, CountryFlagsMenuActivity.class));
            finish();
        } else if (view == this.buttCountryGDP) {
            sharedData.setActivatedClasses(SharedData.ActivatedClasses.COUNTRIES_GDP);
            this.className = "COUNTRY GDP";
            startActivity(new Intent(this, AbstractActivity.class));
            finish();
        } else if (view == this.buttCountryPopulation) {
            sharedData.setActivatedClasses(SharedData.ActivatedClasses.COUNTRIES_POPULATION);
            this.className = "COUNTRY POPULATION";
            startActivity(new Intent(this, AbstractActivity.class));
            finish();
        } else if (view == this.buttHistory) {
            sharedData.setActivatedClasses(SharedData.ActivatedClasses.TODAY_IN_HISTORY);
            this.className = "TODAY IN HISTORY";
            startActivity(new Intent(this, HistoryActivity.class));
            finish();
        } else if (view == this.buttTellFriend) {
            sharedData.setActivatedClasses(SharedData.ActivatedClasses.TELL_A_FRIEND);
            this.className = "TELL A FRIEND";
            makeShareDialog();
        }

        Log.log(className + " Activated");
    }

    private void makeShareDialog() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, MENU_SHARE);
        intent.setType("text/plain");
        startActivity(intent);
    }

    private void loadAdView() {
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("abc")
                .build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ExitDialog.class));
    }

}/** end class. */
