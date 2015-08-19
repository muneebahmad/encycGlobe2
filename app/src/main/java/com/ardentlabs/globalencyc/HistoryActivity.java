package com.ardentlabs.globalencyc;

import android.content.Intent;
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

import com.ardentlabs.globalencyc.iofiles.HistoryLoader;
import com.ardentlabs.globalencyc.models.Dater;
import com.ardentlabs.globalencyc.ui.AboutDialog;
import com.ardentlabs.globalencyc.view.MyHistoryLayout;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by muneebahmad on 01/04/15.
 */
public class HistoryActivity extends ActionBarActivity {

    private LinearLayout mainLayout;
    private TextView titleView;
    private Animation titleAnim;

    private ShareActionProvider mShareActionProvider;

    private String MENU_SHARE = "";

    public HistoryActivity() {}


    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.anim_right_push_in, R.anim.anim_right_push_in_2);
        setContentView(R.layout.activity_history);
        setToolbar();
        setContents();
        loadAdView();
        addShareInfo();
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.history_toolbar);
        setSupportActionBar(toolbar);
    }

    private void addShareInfo() {
        MENU_SHARE = "Global Encyclopedia on Android [V-1.2]\n\n" +
                "Today's 5 Historical events:\n\n" +
                "1: " + Dater.getDate() + " " + HistoryLoader.loadedFromAssetsList.get(0).getYear() + " : " + HistoryLoader.loadedFromAssetsList.get(0).getDescription() + "\n" +
                "2: " + Dater.getDate() + " " + HistoryLoader.loadedFromAssetsList.get(1).getYear() + " : " + HistoryLoader.loadedFromAssetsList.get(1).getDescription() + "\n" +
                "3: " + Dater.getDate() + " " + HistoryLoader.loadedFromAssetsList.get(2).getYear() + " : " + HistoryLoader.loadedFromAssetsList.get(2).getDescription() + "\n" +
                "4: " + Dater.getDate() + " " + HistoryLoader.loadedFromAssetsList.get(3).getYear() + " : " + HistoryLoader.loadedFromAssetsList.get(3).getDescription() + "\n" +
                "5: " + Dater.getDate() + " " + HistoryLoader.loadedFromAssetsList.get(4).getYear() + " : " + HistoryLoader.loadedFromAssetsList.get(4).getDescription() + "\n" +
                "To get detailed info of every country download the app on your Android phone from the following link\n\n" +
                "https://play.google.com/store/apps/details?id=com.ardentlabs.globalencyc";
    }

    private void setContents() {
        this.titleView = (TextView) findViewById(R.id.history_titleView);
        this.titleView.setText(Dater.getDate());

        this.titleAnim = AnimationUtils.loadAnimation(this, R.anim.title_anim);
        this.titleView.setAnimation(titleAnim);

        this.mainLayout = (LinearLayout) findViewById(R.id.history_main_linear_layout);
        populate();
    }

    private void populate() {
        for (int i = 0; i < HistoryLoader.loadedFromAssetsList.size(); i++) {
            this.mainLayout.addView(new MyHistoryLayout(this, i + 1, HistoryLoader.loadedFromAssetsList.get(i).getYear(),
                    HistoryLoader.loadedFromAssetsList.get(i).getEvent(),
                    HistoryLoader.loadedFromAssetsList.get(i).getDescription()));
        }
        this.mainLayout.addView(new MyHistoryLayout(this, 1000, "", "", ""));
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
