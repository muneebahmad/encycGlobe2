package com.ardentlabs.globalencyc.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ardentlabs.globalencyc.R;
import com.ardentlabs.globalencyc.interfaces.SearchButtonListener;

/**
 * Created by muneebahmad on 11/04/15.
 */
public class MySearchLayout extends LinearLayout {

    private static SearchButtonListener buttListener;

    /**
     *
     * @param context
     * @param countryName
     */
    public MySearchLayout(Context context, String countryName, int index) {
        super(context);
        make(context, countryName, index);
    }

    /**
     *
     * @param context
     * @param countryName
     */
    private void make(Context context, String countryName, final int index) {
        this.setOrientation(LinearLayout.HORIZONTAL);
        this.setLayoutParams(new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        this.setGravity(Gravity.LEFT);
        this.setBackgroundResource(R.drawable.tv_bg);

        LinearLayout.LayoutParams tvLayoutParams = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        tvLayoutParams.setMargins(10, 0, 0, 0);
        tvLayoutParams.gravity = Gravity.CENTER_VERTICAL;

        TextView countryView = new TextView(context);
        countryView.setTypeface(Typeface.DEFAULT_BOLD);
        countryView.setTextColor(Color.DKGRAY);
        countryView.setLayoutParams(tvLayoutParams);
        countryView.setText(countryName);

        this.addView(countryView);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                buttListener.onSearchButtonClicked(index);
            }
        });
    }

    /**
     *
     * @param searchButtonListener
     */
    public static void addSearchButtonListener(SearchButtonListener searchButtonListener) {
        buttListener = searchButtonListener;
    }

}/** end class. */
