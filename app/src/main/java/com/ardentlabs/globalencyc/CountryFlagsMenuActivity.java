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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ardentlabs.globalencyc.interfaces.FlagButtonListener;
import com.ardentlabs.globalencyc.iofiles.CountryDetailsLoader;
import com.ardentlabs.globalencyc.models.FlagButtons;
import com.ardentlabs.globalencyc.ui.AboutDialog;
import com.ardentlabs.globalencyc.util.Log;
import com.ardentlabs.globalencyc.view.CountryFlagsMenuLayout;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by muneebahmad on 26/03/15.
 */
public class CountryFlagsMenuActivity extends ActionBarActivity implements View.OnClickListener,
        FlagButtonListener {

    private LinearLayout linearLayout;
    private TextView titleView;
    private Animation titleAnim;

    private ShareActionProvider mShareActionProvider;

    public static final String MENU_SHARE = "Hey! I found this wonderful "
            + "Android app \'Global Encyclopedia\' on the Google Play Store.\n" +
            "This app covers data for 197 countries.\n\n\n"
            + "https://play.google.com/store/apps/details?id=com.ardentlabs.globalencyc";

    public CountryFlagsMenuActivity() {super();}

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.anim_right_push_in, R.anim.anim_right_push_in_2);
        setContentView(R.layout.activity_country_flags_menu);
        setToolbar();
        setContents();
        FlagButtons.addFlagButtonListener(this);
        loadAdView();
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.country_detail_toolbar);
        setSupportActionBar(toolbar);
    }

    private void setContents() {
        this.titleView = (TextView) findViewById(R.id.country_detail_titleView);
        this.titleView.setText("Countries");
        this.titleAnim = AnimationUtils.loadAnimation(this, R.anim.title_anim);
        this.titleView.setAnimation(titleAnim);

        this.linearLayout = (LinearLayout) findViewById(R.id.country_flags_linear_layout);

        populateView();
    }

    /**
     *
     * @throws NullPointerException
     * @throws ArrayIndexOutOfBoundsException
     */
    private void populateView() throws NullPointerException, ArrayIndexOutOfBoundsException {
        int listSize = CountryDetailsLoader.loadedFromAssetsList.size();

        for (int i = 0; i < listSize - 1; i++) {
            Log.log(i + " ITERED");
            if (i % 3 == 0 && i + 2 != CountryDetailsLoader.loadedFromAssetsList.size()) {
                linearLayout.addView(CountryFlagsMenuLayout.makeTableRows(getApplicationContext(),
                        FlagButtons.getFlagButton(getApplicationContext(),
                                CountryDetailsLoader.loadedFromAssetsList.get(i).getId(), i),
                        FlagButtons.getFlagButton(getApplicationContext(),
                                CountryDetailsLoader.loadedFromAssetsList.get(i + 1).getId(), i + 1),
                        FlagButtons.getFlagButton(getApplicationContext(),
                                CountryDetailsLoader.loadedFromAssetsList.get(i + 2).getId(), i + 2),
                        CountryDetailsLoader.loadedFromAssetsList.get(i).getName(),
                        CountryDetailsLoader.loadedFromAssetsList.get(i + 1).getName(),
                        CountryDetailsLoader.loadedFromAssetsList.get(i + 2).getName()));
            } else if (i + 2 == CountryDetailsLoader.loadedFromAssetsList.size()) {

                linearLayout.addView(CountryFlagsMenuLayout.makeTableRows(getApplicationContext(),
                        FlagButtons.getFlagButton(getApplicationContext(),
                                CountryDetailsLoader.loadedFromAssetsList.get(i + 1).getId(), i + 1),
                        null,
                        null,
                        CountryDetailsLoader.loadedFromAssetsList.get(i + 1).getName(),
                        null,
                        null
                        ));

            }
        }
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

    /**
     *
     */
    @Override
    public void fireFlagButton(int index) {
        startActivity(new Intent(this, CountryDetailsActivity.class));
        finish();
    }

    /**
     *
     */
    @Override
    public void fireHolidayButton(int index) {
        startActivity(new Intent(this, HolidayActivity.class));
        finish();
    }

    private void loadAdView() {
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("abc")
                .build();
        mAdView.loadAd(adRequest);
    }

    /**
     *
     * @param view
     */
    @Override
    public void onClick(View view) {

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}/** end class. */
