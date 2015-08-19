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
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ardentlabs.globalencyc.data.ResourcesManager;
import com.ardentlabs.globalencyc.data.SharedData;
import com.ardentlabs.globalencyc.iofiles.CountryDetailsLoader;
import com.ardentlabs.globalencyc.iofiles.HolidayDetailsLoader;
import com.ardentlabs.globalencyc.ui.AboutDialog;
import com.ardentlabs.globalencyc.ui.MyHolidayLayout;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by muneebahmad on 31/03/15.
 */
public class HolidayActivity extends ActionBarActivity implements View.OnClickListener {

    private final SharedData sharedData = SharedData.getInstance();
    private ShareActionProvider mShareActionProvider;
    private String MENU_SHARE = "";

    private LinearLayout mainLayout;

    private TextView titleView;
    private Animation titleAnim;

    private TextView captialView;
    private TextView continentView;
    private TextView mapView;

    private ImageView flagView;

    LinearLayout.LayoutParams params;

    public HolidayActivity() {}

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.anim_left_push_in, R.anim.anim_left_push_in_2);
        setContentView(R.layout.activity_holiday);
        setToolbar();
        setContents();
        loadAdView();
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.holiday_toolbar);
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
        initLayout();
        populate();
    }

    private void initLayout() {
        this.mainLayout = (LinearLayout) findViewById(R.id.holiday_main_linear_layout);
    }

    private void makeTitle() {
        this.titleView = (TextView) findViewById(R.id.tv_holiday_country_titleView);
        this.captialView = (TextView) findViewById(R.id.tv_holiday_country_capital);
        this.continentView = (TextView) findViewById(R.id.tv_holiday_country_continent);

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
        this.flagView = (ImageView) findViewById(R.id.iv_holiday_country_flag);
        this.flagView.setImageResource(ResourcesManager.getFlag(CountryDetailsLoader.
                loadedFromAssetsList.get(sharedData.getIndex()).getId()));
        this.flagView.setAnimation(titleAnim);
        this.flagView.setOnClickListener(this);

        this.mapView = (TextView) findViewById(R.id.tv_holiday_maps_country_details);
        this.mapView.setOnClickListener(this);
        this.mapView.setAnimation(titleAnim);
    }

    private void populate() {
        int id = CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getId();
        String name = CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getName();

        params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(5, 10, 5, 10);

        for (int i = 0; i < HolidayDetailsLoader.loadedFromAssetsList.size(); i++) {
            if ((HolidayDetailsLoader.loadedFromAssetsList.get(i).getId().equals(id + "")) &&
                    (HolidayDetailsLoader.loadedFromAssetsList.get(i).getName().equals(name))) {
                String day = HolidayDetailsLoader.loadedFromAssetsList.get(i).getDay();
                String date = HolidayDetailsLoader.loadedFromAssetsList.get(i).getDate();
                String holiday = HolidayDetailsLoader.loadedFromAssetsList.get(i).getHoliday();
                String comments = HolidayDetailsLoader.loadedFromAssetsList.get(i).getComments();
                String type = HolidayDetailsLoader.loadedFromAssetsList.get(i).getType();
                mainLayout.addView(new MyHolidayLayout(this, day, date, holiday, type, comments), params);
            }
        }
    }

    private void loadAdView() {
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("abc")
                .build();
        mAdView.loadAd(adRequest);
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
        if ((view == this.mapView) || (view == this.flagView)) {
            startActivity(new Intent(this, MapActivity.class));
            finish();
        }
    }

    public void onBackPressed() {
        startActivity(new Intent(this, CountryFlagsMenuActivity.class));
        finish();
    }

}/** end class. */
