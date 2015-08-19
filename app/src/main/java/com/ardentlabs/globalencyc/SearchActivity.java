package com.ardentlabs.globalencyc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ardentlabs.globalencyc.data.SharedData;
import com.ardentlabs.globalencyc.interfaces.SearchButtonListener;
import com.ardentlabs.globalencyc.iofiles.CountryDetailsLoader;
import com.ardentlabs.globalencyc.view.MySearchLayout;

import java.util.Locale;

/**
 * Created by muneebahmad on 10/04/15.
 */
public class SearchActivity extends ActionBarActivity implements View.OnClickListener, SearchButtonListener {

    private EditText searchField;
    private ImageButton searchButton;
    private Button cancelButton;
    private Button resetButton;

    private TextView titleView;
    private Animation titleAnim;

    private LinearLayout mainLayout;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(R.anim.anim_right_push_in, R.anim.anim_right_push_in_2);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setToolbar();
        setContents();

        MySearchLayout.addSearchButtonListener(this);
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.search_toolbar);
        setSupportActionBar(toolbar);

        this.titleView = (TextView) findViewById(R.id.search_titleView);
        this.titleAnim = AnimationUtils.loadAnimation(this, R.anim.title_anim);
        this.titleView.setAnimation(titleAnim);
    }

    private void setContents() {
        this.mainLayout = (LinearLayout) findViewById(R.id.search_main_layout);
        this.mainLayout.setOnClickListener(this);

        this.searchField = (EditText) findViewById(R.id.search_et);
        this.searchButton = (ImageButton) findViewById(R.id.search_button);
        this.searchButton.setOnClickListener(this);
        this.cancelButton = (Button) findViewById(R.id.search_cancel_button);
        this.cancelButton.setOnClickListener(this);
        this.resetButton = (Button) findViewById(R.id.search_reset_button);
        this.resetButton.setOnClickListener(this);
    }

    private void search() {
        String key = this.searchField.getText().toString();
        if (key != null && key.length() > 0)
            key.toLowerCase(Locale.ENGLISH);
        for (int i = 0; i < CountryDetailsLoader.loadedFromAssetsList.size(); i++) {
            char first = CountryDetailsLoader.loadedFromAssetsList.get(i).getName().toLowerCase(Locale.ENGLISH).charAt(0);
            char second = CountryDetailsLoader.loadedFromAssetsList.get(i).getName().toLowerCase(Locale.ENGLISH).charAt(1);

            char keyFirst = 'a';
            if (key != null && key.length() > 0) {
                keyFirst = key.charAt(0);
            }
            char keySecond;
            if (key.length() > 1) {
                keySecond = key.charAt(1);
            }

            if (keyFirst == first) {
                this.mainLayout.addView(new MySearchLayout(this, CountryDetailsLoader.loadedFromAssetsList.get(i).getName(), i));
            }
        }
    }

    @Override
    public void onClick(View view) {
        if (view == this.searchButton) {
            this.mainLayout.removeAllViews();
            search();
        } else if (view == this.cancelButton) {
            onBackPressed();
        } else if (view == this.resetButton) {
            this.searchField.setText("");
            this.mainLayout.removeAllViews();
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onSearchButtonClicked(int index) {
        SharedData.getInstance().setIndex(index);
        startActivity(new Intent(this, CountryDetailsActivity.class));
        finish();
    }

}/** end class. */
