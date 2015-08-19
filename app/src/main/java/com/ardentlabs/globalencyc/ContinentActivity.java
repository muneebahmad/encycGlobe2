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
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ardentlabs.globalencyc.data.SharedData;
import com.ardentlabs.globalencyc.iofiles.CountryDetailsLoader;
import com.ardentlabs.globalencyc.iofiles.GDPLoader;
import com.ardentlabs.globalencyc.ui.AboutDialog;
import com.ardentlabs.globalencyc.util.Log;
import com.ardentlabs.globalencyc.view.MyContinentLayout;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by muneebahmad on 05/04/15.
 */
public class ContinentActivity extends ActionBarActivity implements View.OnClickListener {

    private ShareActionProvider mShareActionProvider;
    private String MENU_SHARE = "";

    private TextView titleView;
    private Animation titleAnim;

    private LinearLayout asiaLayout;
    private LinearLayout africaLayout;
    private LinearLayout northAmericaLayout;
    private LinearLayout southAmericaLayout;
    private LinearLayout antarcticaLayout;
    private LinearLayout europeLayout;
    private LinearLayout australiaLayout;

    private TextView asiaTitle;
    private TextView africaTitle;
    private TextView northAmericaTitle;
    private TextView southAmericaTitle;
    private TextView antarcticaTitle;
    private TextView europeTitle;
    private TextView australiaTitle;

    static final String TEXT_COUNTRY = "Country";
    static final String TEXT_AREA= "Area";
    static final String TEXT_POP = "Population";

    public View.OnLongClickListener longClickListener;
    View openLayout;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.anim_right_push_in, R.anim.anim_right_push_in_2);
        setContentView(R.layout.activity_continent);
        setToolbar();
        setContents();
        loadAdView();
        addShareInfo();
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.continent_toolbar);
        setSupportActionBar(toolbar);
    }

    private void setContents() {
        this.titleView = (TextView) findViewById(R.id.continent_titleView);

        int countryNo = CountryDetailsLoader.loadedFromAssetsList.size();
        String totalArea = "150,187,500 km2";

        this.titleView.setText("Total Countries: " + countryNo + "\n" +
                "Total Area: " + totalArea);
        this.titleAnim = AnimationUtils.loadAnimation(this, R.anim.title_anim);
        this.titleView.setAnimation(titleAnim);

        initAccordionComponents();
        populate();
    }

    private void initAccordionComponents() {
        this.asiaLayout = (LinearLayout) findViewById(R.id.panel_asia);
        this.africaLayout = (LinearLayout) findViewById(R.id.panel_africa);
        this.northAmericaLayout = (LinearLayout) findViewById(R.id.panel_north_america);
        this.southAmericaLayout = (LinearLayout) findViewById(R.id.panel_south_america);
        this.antarcticaLayout = (LinearLayout) findViewById(R.id.panel_antarctica);
        this.europeLayout = (LinearLayout) findViewById(R.id.panel_europe);
        this.australiaLayout = (LinearLayout) findViewById(R.id.panel_australia);

        this.asiaTitle = (TextView) findViewById(R.id.title_asia);
        this.asiaTitle.setText("Asia (" + SharedData.ASIA_NUM_COUNTRIES + ") countries");
        this.africaTitle = (TextView) findViewById(R.id.title_africa);
        this.africaTitle.setText("Africa (" + SharedData.AFRICA_NUM_COUNTRIES + ") countries");
        this.northAmericaTitle = (TextView) findViewById(R.id.title_north_america);
        this.northAmericaTitle.setText("North America (" + SharedData.N_AMERICA_NUM_COUNTRIES + ") countries");
        this.southAmericaTitle = (TextView) findViewById(R.id.title_south_america);
        this.southAmericaTitle.setText("South America (" + SharedData.S_AMERICA_NUM_COUNTRIES + ") countries");
        this.antarcticaTitle = (TextView) findViewById(R.id.title_antarctica);
        this.antarcticaTitle.setText("Antarctica (" + SharedData.ANTARCTICA_NUM_COUNTRIES + ") countries");
        this.europeTitle = (TextView) findViewById(R.id.title_europe);
        this.europeTitle.setText("Europe (" + SharedData.EUROPE_NUM_COUNTRIES + ") countries");
        this.australiaTitle = (TextView) findViewById(R.id.title_australia);
        this.australiaTitle.setText("Australia/Oceania (" + SharedData.AUSTRALIA_NUM_COUNTRIES + ") countries");

        this.asiaTitle.setOnClickListener(this);
        this.africaTitle.setOnClickListener(this);
        this.northAmericaTitle.setOnClickListener(this);
        this.southAmericaTitle.setOnClickListener(this);
        this.antarcticaTitle.setOnClickListener(this);
        this.europeTitle.setOnClickListener(this);
        this.australiaTitle.setOnClickListener(this);
    }

    private void populate() {
        populateAfrica();
        populateAntarctica();
        populateAsia();
        populateAustralia();
        popEurope();
        popNorthAmerica();
        popSouthAmerica();
    }

    private void addShareInfo() {
        MENU_SHARE = "Global Encyclopedia on Android [V-1.2]\n\n" +
                "Area of 5 Continents is:\n\n" +
                "1: " + SharedData.AFRICA_NAME + " Area: " + SharedData.AFRICA_AREA + "\n" +
                "2: " + SharedData.ANTARCTICA_NAME + " Area: " + SharedData.ANTARCTICA_AREA + "\n" +
                "3: " + SharedData.ASIA_NAME + " Area: " + SharedData.ASIA_AREA + "\n" +
                "4: " + SharedData.AUSTRALIA_NAME + " Area: " + SharedData.AUSTRALIA_AREA + "\n" +
                "5: " + SharedData.EUROPE_NAME + " Area: " + SharedData.EUROPE_AREA + "\n" +
                "To get detailed info of every country download the app on your Android phone from the following link\n\n" +
                "https://play.google.com/store/apps/details?id=com.ardentlabs.globalencyc";
    }

    private void populateAfrica() {
        this.africaLayout.addView(new MyContinentLayout(this, TEXT_COUNTRY, TEXT_AREA, TEXT_POP, Color.BLACK, true, true));
        this.africaLayout.addView(new MyContinentLayout(this, SharedData.AFRICA_NAME, SharedData.AFRICA_AREA, SharedData.AFRICA_POPULATION, Color.RED, true, true));
        for (int i = 0; i < CountryDetailsLoader.loadedFromAssetsList.size(); i++) {
            if (CountryDetailsLoader.loadedFromAssetsList.get(i).getContinent().equals("Africa")) {
                this.africaLayout.addView(new MyContinentLayout(this, CountryDetailsLoader.loadedFromAssetsList.get(i).getName(),
                        CountryDetailsLoader.loadedFromAssetsList.get(i).getArea(),
                        CountryDetailsLoader.loadedFromAssetsList.get(i).getPopulation(), Color.DKGRAY, false, true));
            }
        }
        this.africaLayout.addView(new MyContinentLayout(this, "", "", "", Color.BLACK, false, false));
    }

    private void populateAntarctica() {
        this.antarcticaLayout.addView(new MyContinentLayout(this, TEXT_COUNTRY, TEXT_AREA, TEXT_POP, Color.BLACK, true, true));
        this.antarcticaLayout.addView(new MyContinentLayout(this, SharedData.ANTARCTICA_NAME, SharedData.ANTARCTICA_AREA,
                SharedData.ANTARCTICA_POPULATION, Color.RED, true, true));
        for (int i = 0; i < CountryDetailsLoader.loadedFromAssetsList.size(); i++) {
            if (CountryDetailsLoader.loadedFromAssetsList.get(i).getContinent().equals(SharedData.ANTARCTICA_NAME)) {
                this.antarcticaLayout.addView(new MyContinentLayout(this, CountryDetailsLoader.loadedFromAssetsList.get(i).getName(),
                        CountryDetailsLoader.loadedFromAssetsList.get(i).getArea(),
                        CountryDetailsLoader.loadedFromAssetsList.get(i).getPopulation(), Color.DKGRAY, false, true));
            }
        }
        this.antarcticaLayout.addView(new MyContinentLayout(this, "", "", "", Color.BLACK, false, false));
    }

    private void populateAsia() {
        this.asiaLayout.addView(new MyContinentLayout(this, TEXT_COUNTRY, TEXT_AREA, TEXT_POP, Color.BLACK, true, true));
        this.asiaLayout.addView(new MyContinentLayout(this, SharedData.ASIA_NAME, SharedData.ASIA_AREA,
                SharedData.ASIA_POPULATION, Color.RED, true, true));
        for (int i = 0; i < CountryDetailsLoader.loadedFromAssetsList.size(); i++) {
            if (CountryDetailsLoader.loadedFromAssetsList.get(i).getContinent().equals(SharedData.ASIA_NAME)) {
                this.asiaLayout.addView(new MyContinentLayout(this, CountryDetailsLoader.loadedFromAssetsList.get(i).getName(),
                        CountryDetailsLoader.loadedFromAssetsList.get(i).getArea(),
                        CountryDetailsLoader.loadedFromAssetsList.get(i).getPopulation(), Color.DKGRAY, false, true));
            }
        }
        this.asiaLayout.addView(new MyContinentLayout(this, "", "", "", Color.BLACK, false, false));
    }

    private void populateAustralia() {
        this.australiaLayout.addView(new MyContinentLayout(this, TEXT_COUNTRY, TEXT_AREA, TEXT_POP, Color.BLACK, true, true));
        this.australiaLayout.addView(new MyContinentLayout(this, SharedData.AUSTRALIA_NAME, SharedData.AUSTRALIA_AREA,
                SharedData.AUSTRALIA_POPULATION, Color.RED, true, true));
        for (int i = 0; i < CountryDetailsLoader.loadedFromAssetsList.size(); i++) {
            if ((CountryDetailsLoader.loadedFromAssetsList.get(i).getContinent().equals(SharedData.AUSTRALIA_NAME)) ||
                    (CountryDetailsLoader.loadedFromAssetsList.get(i).getContinent().equals("Oceania"))) {
                this.australiaLayout.addView(new MyContinentLayout(this, CountryDetailsLoader.loadedFromAssetsList.get(i).getName(),
                        CountryDetailsLoader.loadedFromAssetsList.get(i).getArea(),
                        CountryDetailsLoader.loadedFromAssetsList.get(i).getPopulation(), Color.DKGRAY, false, true));
            }
        }
        this.australiaLayout.addView(new MyContinentLayout(this, "", "", "", Color.BLACK, false, false));
    }

    private void popEurope() {
        this.europeLayout.addView(new MyContinentLayout(this, TEXT_COUNTRY, TEXT_AREA, TEXT_POP, Color.BLACK, true, true));
        this.europeLayout.addView(new MyContinentLayout(this, SharedData.EUROPE_NAME, SharedData.EUROPE_AREA,
                SharedData.EUROPE_POPULATION, Color.RED, true, true));
        for (int i = 0; i < CountryDetailsLoader.loadedFromAssetsList.size(); i++) {
            if (CountryDetailsLoader.loadedFromAssetsList.get(i).getContinent().equals(SharedData.EUROPE_NAME)) {
                this.europeLayout.addView(new MyContinentLayout(this, CountryDetailsLoader.loadedFromAssetsList.get(i).getName(),
                        CountryDetailsLoader.loadedFromAssetsList.get(i).getArea(),
                        CountryDetailsLoader.loadedFromAssetsList.get(i).getPopulation(), Color.DKGRAY, false, true));
            }
        }
        this.europeLayout.addView(new MyContinentLayout(this, "", "", "", Color.BLACK, false, false));
    }

    private void popNorthAmerica() {
        this.northAmericaLayout.addView(new MyContinentLayout(this, TEXT_COUNTRY, TEXT_AREA, TEXT_POP, Color.BLACK, true, true));
        this.northAmericaLayout.addView(new MyContinentLayout(this, SharedData.N_AMERICA_NAME, SharedData.N_AMERICA_AREA,
                SharedData.N_AMERICA_POPULATION, Color.RED, true, true));
        for (int i = 0; i < CountryDetailsLoader.loadedFromAssetsList.size(); i++) {
            if (CountryDetailsLoader.loadedFromAssetsList.get(i).getContinent().equals(SharedData.N_AMERICA_NAME)) {
                this.northAmericaLayout.addView(new MyContinentLayout(this, CountryDetailsLoader.loadedFromAssetsList.get(i).getName(),
                        CountryDetailsLoader.loadedFromAssetsList.get(i).getArea(),
                        CountryDetailsLoader.loadedFromAssetsList.get(i).getPopulation(), Color.DKGRAY, false, true));
            }
        }
        this.northAmericaLayout.addView(new MyContinentLayout(this, "", "", "", Color.BLACK, false, false));
    }

    private void popSouthAmerica() {
        this.southAmericaLayout.addView(new MyContinentLayout(this, TEXT_COUNTRY, TEXT_AREA, TEXT_POP, Color.BLACK, true, true));
        this.southAmericaLayout.addView(new MyContinentLayout(this, SharedData.S_AMERICA_NAME, SharedData.S_AMERICA_AREA,
                SharedData.S_AMERICA_POPULATION, Color.RED, true, true));
        for (int i = 0; i < CountryDetailsLoader.loadedFromAssetsList.size(); i++) {
            if (CountryDetailsLoader.loadedFromAssetsList.get(i).getContinent().equals(SharedData.S_AMERICA_NAME)) {
                this.southAmericaLayout.addView(new MyContinentLayout(this, CountryDetailsLoader.loadedFromAssetsList.get(i).getName(),
                        CountryDetailsLoader.loadedFromAssetsList.get(i).getArea(),
                        CountryDetailsLoader.loadedFromAssetsList.get(i).getPopulation(), Color.DKGRAY, false, true));
            }
        }
        this.southAmericaLayout.addView(new MyContinentLayout(this, "", "", "", Color.BLACK, false, false));
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

    /**
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        hideOthers(view);
    }

    private void hideThemAll() {
        if (openLayout == null) return;
        if (openLayout == this.africaLayout)
            africaLayout.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, africaLayout, true));
        if (openLayout == this.asiaLayout)
            asiaLayout.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, asiaLayout, true));
        if (openLayout == this.australiaLayout)
            australiaLayout.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, australiaLayout, true));
        if (openLayout == this.antarcticaLayout)
            antarcticaLayout.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, antarcticaLayout, true));
        if (openLayout == this.europeLayout)
            europeLayout.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, europeLayout, true));
        if (openLayout == this.northAmericaLayout)
            northAmericaLayout.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, northAmericaLayout, true));
        if (openLayout == this.southAmericaLayout)
            southAmericaLayout.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, southAmericaLayout, true));
    }

    /**
     *
     * @param view {@link #View}
     */
    private void hideOthers(View layoutView) {
        {
            int v;
            if(layoutView.getId() == R.id.title_africa) {
                v = africaLayout.getVisibility();
                if(v != View.VISIBLE) {
                    africaLayout.setVisibility(View.VISIBLE);
                    Log.log("CZ height..." + africaLayout.getHeight());
                }

                //panel1.setVisibility(View.GONE);
                //Log.v("CZ","again height..." + panel1.getHeight());
                hideThemAll();
                if(v != View.VISIBLE) {
                    africaLayout.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 0.0f, 1.0f, 500, africaLayout, true));
                }
            } else if(layoutView.getId() == R.id.title_antarctica) {
                v = antarcticaLayout.getVisibility();
                hideThemAll();
                if(v != View.VISIBLE) {
                    antarcticaLayout.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 0.0f, 1.0f, 500, antarcticaLayout, true));
                }
            } else if(layoutView.getId() == R.id.title_asia) {
                v = asiaLayout.getVisibility();
                hideThemAll();
                if(v != View.VISIBLE) {
                    asiaLayout.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 0.0f, 1.0f, 500, asiaLayout, true));
                }
            } else if(layoutView.getId() == R.id.title_australia) {
                v = australiaLayout.getVisibility();
                hideThemAll();
                if(v != View.VISIBLE) {
                    australiaLayout.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 0.0f, 1.0f, 500, australiaLayout, true));
                }
            } else if(layoutView.getId() == R.id.title_europe) {
                v = europeLayout.getVisibility();
                hideThemAll();
                if(v != View.VISIBLE) {
                    europeLayout.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 0.0f, 1.0f, 500, europeLayout, true));
                }
            } else if (layoutView.getId() == R.id.title_north_america) {
                v = northAmericaLayout.getVisibility();
                hideThemAll();
                if(v != View.VISIBLE) {
                    northAmericaLayout.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 0.0f, 1.0f, 500, northAmericaLayout, true));
                }
            } else if (layoutView.getId() == R.id.title_south_america) {
                v = southAmericaLayout.getVisibility();
                hideThemAll();
                if(v != View.VISIBLE) {
                    southAmericaLayout.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 0.0f, 1.0f, 500, southAmericaLayout, true));
                }
            }
        }
    }

    /**
     * Created by muneebahmad on 06/04/15.
     */
    public class ScaleAnimToShow extends ScaleAnimation {

        private View mView;

        private LinearLayout.LayoutParams mLayoutParams;

        private int mMarginBottomFromY, mMarginBottomToY;

        private boolean mVanishAfter = false;

        /**
         *
         * @param fromX
         * @param toX
         * @param fromY
         * @param toY
         * @param duration
         * @param view
         * @param vanishAfter
         */
        public ScaleAnimToShow(float fromX, float toX, float fromY, float toY, int duration,
                               View view, boolean vanishAfter) {
            super(fromX, toX, fromY, toY);
            openLayout = view;
            setDuration(duration);
            mView = view;
            mVanishAfter = vanishAfter;
            mLayoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            mView.setVisibility(View.VISIBLE);
            int height = mView.getHeight();
            //mMarginBottomFromY = (int) (height * fromY) + mLayoutParams.bottomMargin + height;
            //mMarginBottomToY = (int) (0 - ((height * toY) + mLayoutParams.bottomMargin)) + height;

            mMarginBottomFromY = 0;
            mMarginBottomToY = height;

            Log.log("CZ .................height..." + height +
                    " , mMarginBottomFromY...." + mMarginBottomFromY + " , mMarginBottomToY.." + mMarginBottomToY);
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            if (interpolatedTime < 1.0f) {
                int newMarginBottom = (int) ((mMarginBottomToY - mMarginBottomFromY) * interpolatedTime) - mMarginBottomToY;
                mLayoutParams.setMargins(mLayoutParams.leftMargin, mLayoutParams.topMargin, mLayoutParams.rightMargin, newMarginBottom);
                mView.getParent().requestLayout();
                //Log.v("CZ","newMarginBottom..." + newMarginBottom + " , mLayoutParams.topMargin..." + mLayoutParams.topMargin);
            }
        }

    }/** end class. */

    /**
     * Created by muneebahmad on 06/04/15.
     */
    public class ScaleAnimToHide extends ScaleAnimation {

        private View view;
        private LinearLayout.LayoutParams layoutParams;
        private int marginBottomFromY;
        private int marginBottomToY;
        private boolean vanishAfter = false;

        /**
         *
         * @param fromX float
         * @param toX float
         * @param fromY float
         * @param toY float
         * @param view {@link #View}
         * @param vanishAfter boolean
         */
        public ScaleAnimToHide(float fromX, float toX, float fromY, float toY, int duration,
                               View view, boolean vanishAfter) {
            super(fromX, toX, fromY, toY);
            setDuration(duration);
            openLayout =  null;
            this.view = view;
            this.vanishAfter = vanishAfter;
            this.layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int height = this.view.getHeight();
            marginBottomFromY = (int) (height * fromY) + layoutParams.bottomMargin - height;
            marginBottomToY = (int) (0 - ((height * toY) + layoutParams.bottomMargin)) - height;

            Log.log("SCALE TO HIDE ANIM -> " + "CZ" + "height..." + height + " , " +
                    "marginBottomFromY...." + marginBottomFromY  + " , marginBottomToY.." + marginBottomToY);
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            if (interpolatedTime < 1.0f) {
                int newMarginBottom = marginBottomFromY + (int) ((marginBottomToY - marginBottomFromY) * interpolatedTime);
                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin,layoutParams.rightMargin, newMarginBottom);
                view.getParent().requestLayout();
                //Log.v("CZ","newMarginBottom..." + newMarginBottom + " , mLayoutParams.topMargin..." + mLayoutParams.topMargin);
            } else if (vanishAfter) {
                view.setVisibility(View.GONE);
            }
        }
    }/** end class. */

}/** end class. */
