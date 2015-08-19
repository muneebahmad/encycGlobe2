package com.ardentlabs.globalencyc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.ardentlabs.globalencyc.data.ResourcesManager;
import com.ardentlabs.globalencyc.data.SharedData;
import com.ardentlabs.globalencyc.iofiles.CountryDetailsLoader;
import com.ardentlabs.globalencyc.ui.AboutDialog;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by muneebahmad on 07/04/15.
 */
public class MapActivity extends ActionBarActivity implements OnMapReadyCallback {

    private TextView titleView;
    private TextView capitalView;
    private TextView continentView;
    private ImageView flagView;

    private String MENU_SHARE = "";

    private ShareActionProvider mShareActionProvider;

    private SupportMapFragment mapFragment;

    private final SharedData sharedData = SharedData.getInstance();

    private String mapTitle = "Country";
    private double lat = 0.0;
    private double lng = 0.0;
    private float zoom = 4.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.anim_right_push_in, R.anim.anim_right_push_in_2);
        setContentView(R.layout.activity_map);
        setToolBar();
        setContents();
        initMap();
        loadAdView();
    }

    private void setToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.map_toolbar);
        setSupportActionBar(toolbar);
    }

    private void setContents() {
        setHeaders();
    }

    private void setHeaders() {
        this.titleView = (TextView) findViewById(R.id.map_titleView);
        this.capitalView = (TextView) findViewById(R.id.tv_map_capital);
        this.continentView = (TextView) findViewById(R.id.tv_map_continent);

        this.titleView.setText(CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getName());
        this.capitalView.setText(CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getCapital());
        this.continentView.setText(CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getContinent());

        this.flagView = (ImageView) findViewById(R.id.iv_map_flag);
        this.flagView.setImageResource(ResourcesManager.getFlag(CountryDetailsLoader.
                loadedFromAssetsList.get(sharedData.getIndex()).getId()));


        this.mapTitle = this.titleView.getText().toString();
        this.lat = CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getLat();
        this.lng = CountryDetailsLoader.loadedFromAssetsList.get(sharedData.getIndex()).getLng();
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

    private void initMap() {
        this.mapFragment = (SupportMapFragment) getSupportFragmentManager().
                findFragmentById(R.id.map);
        this.mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)).title(mapTitle));
        googleMap.animateCamera(CameraUpdateFactory.zoomIn());

        CameraPosition camPos = new CameraPosition.Builder().
                target(new LatLng(lat, lng)).zoom(zoom).build();

        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(camPos));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, CountryDetailsActivity.class));
        finish();
    }

}/** end class. */
