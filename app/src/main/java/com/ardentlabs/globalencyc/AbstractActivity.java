package com.ardentlabs.globalencyc;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ardentlabs.globalencyc.data.SharedData;
import com.ardentlabs.globalencyc.iofiles.GDPLoader;
import com.ardentlabs.globalencyc.iofiles.PopulationLoader;
import com.ardentlabs.globalencyc.ui.AboutDialog;
import com.ardentlabs.globalencyc.view.MyAbstractLayout;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by muneebahmad on 02/04/15.
 */
public class AbstractActivity extends ActionBarActivity {

    private LinearLayout mainLayout;
    private LinearLayout titleLayout;
    private TextView titleView;
    private Animation titleAnim;

    private ShareActionProvider mShareActionProvider;
    private final SharedData sharedData = SharedData.getInstance();

    private int gdp[] = new int[GDPLoader.loadedFromAssetsList.size()];

    private String MENU_SHARE = "";

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.anim_right_push_in, R.anim.anim_right_push_in_2);
        setContentView(R.layout.activity_gdp);
        setToolbar();
        addShareInfo();
        setContents();
        loadAdView();
    }


    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.gdp_toolbar);
        this.titleLayout = (LinearLayout) findViewById(R.id.title_layout);
        if (sharedData.getActivatedClasses() == SharedData.ActivatedClasses.COUNTRIES_POPULATION) {
            toolbar.setBackgroundColor(Color.parseColor("#d362a3"));
            titleLayout.setBackgroundColor(Color.parseColor("#d362a3"));
        } else if (sharedData.getActivatedClasses() == SharedData.ActivatedClasses.COUNTRIES_GDP) {
            toolbar.setBackgroundColor(Color.parseColor("#aec42a"));
            titleLayout.setBackgroundColor(Color.parseColor("#aec42a"));
        }
        setSupportActionBar(toolbar);
    }

    private void setContents() {
        this.titleView = (TextView) findViewById(R.id.gdp_titleView);

        if (sharedData.getActivatedClasses() == SharedData.ActivatedClasses.COUNTRIES_GDP) {
            this.titleView.setText("Countries by GDP\n(U.S.$ Millions)");
        } else if (sharedData.getActivatedClasses() == SharedData.ActivatedClasses.COUNTRIES_POPULATION) {
            this.titleView.setText("Countries by Population\nWorld Population: ");
        }
        this.titleAnim = AnimationUtils.loadAnimation(this, R.anim.title_anim);
        this.titleView.setAnimation(titleAnim);

        this.mainLayout = (LinearLayout) findViewById(R.id.gdp_main_linear_layout);

        populate();
    }

    private void addShareInfo() {
        if (sharedData.getActivatedClasses() == SharedData.ActivatedClasses.COUNTRIES_GDP) {
            MENU_SHARE = "Global Encyclopedia on Android [V-1.2]\n\n" +
                    "First 5 countries with respect to GDP are:\n\n" +
                    "1: " + GDPLoader.loadedFromAssetsList.get(0).getName() + " GDP: " + GDPLoader.loadedFromAssetsList.get(0).getGdp() + "\n" +
                    "2: " + GDPLoader.loadedFromAssetsList.get(1).getName() + " GDP: " + GDPLoader.loadedFromAssetsList.get(1).getGdp() + "\n" +
                    "3: " + GDPLoader.loadedFromAssetsList.get(2).getName() + " GDP: " + GDPLoader.loadedFromAssetsList.get(2).getGdp() + "\n" +
                    "4: " + GDPLoader.loadedFromAssetsList.get(3).getName() + " GDP: " + GDPLoader.loadedFromAssetsList.get(3).getGdp() + "\n" +
                    "5: " + GDPLoader.loadedFromAssetsList.get(4).getName() + " GDP: " + GDPLoader.loadedFromAssetsList.get(4).getGdp() + "\n" +
                    "To get detailed info of every country download the app on your Android phone from the following link\n\n" +
                    "https://play.google.com/store/apps/details?id=com.ardentlabs.globalencyc";
        } else if (sharedData.getActivatedClasses() == SharedData.ActivatedClasses.COUNTRIES_POPULATION) {
            MENU_SHARE = "Global Encyclopedia on Android [V-1.2]\n\n" +
                    "First 5 countries with respect to Population are:\n\n" +
                    "1: " + PopulationLoader.loadedFromAssetsList.get(0).getCountry() + " Population: " + PopulationLoader.loadedFromAssetsList.get(0).getPopulation() + "\n" +
                    "2: " + PopulationLoader.loadedFromAssetsList.get(1).getCountry() + " Population: " + PopulationLoader.loadedFromAssetsList.get(1).getPopulation() + "\n" +
                    "3: " + PopulationLoader.loadedFromAssetsList.get(2).getCountry() + " Population: " + PopulationLoader.loadedFromAssetsList.get(2).getPopulation() + "\n" +
                    "4: " + PopulationLoader.loadedFromAssetsList.get(3).getCountry() + " Population: " + PopulationLoader.loadedFromAssetsList.get(3).getPopulation() + "\n" +
                    "5: " + PopulationLoader.loadedFromAssetsList.get(4).getCountry() + " Population: " + PopulationLoader.loadedFromAssetsList.get(4).getPopulation() + "\n" +
                    "To get detailed info of every country download the app on your Android phone from the following link\n\n" +
                    "https://play.google.com/store/apps/details?id=com.ardentlabs.globalencyc";
        }
    }

    private void populate() {
        if (sharedData.getActivatedClasses() == SharedData.ActivatedClasses.COUNTRIES_GDP) {
            this.mainLayout.addView(new MyAbstractLayout(this, 0, "Country", "GDP(US$ million)"));
            for (int i = 0; i < GDPLoader.loadedFromAssetsList.size(); i++) {
                this.mainLayout.addView(new MyAbstractLayout(this, i + 1, GDPLoader.loadedFromAssetsList.get(i).getName(),
                        GDPLoader.loadedFromAssetsList.get(i).getGdp()));
            }
            this.mainLayout.addView(new MyAbstractLayout(this, 1000, "", ""));
        } else if (sharedData.getActivatedClasses() == SharedData.ActivatedClasses.COUNTRIES_POPULATION) {
            this.mainLayout.addView(new MyAbstractLayout(this, 0, "Country", "Population"));
            for (int i = 0; i < PopulationLoader.loadedFromAssetsList.size(); i++) {
                this.mainLayout.addView(new MyAbstractLayout(this, i + 1, PopulationLoader.loadedFromAssetsList.
                        get(i).getCountry(), PopulationLoader.loadedFromAssetsList.get(i).getPopulation()
                        ));
            }
            this.mainLayout.addView(new MyAbstractLayout(this, 1000, "", ""));
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
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}/** end class. */
