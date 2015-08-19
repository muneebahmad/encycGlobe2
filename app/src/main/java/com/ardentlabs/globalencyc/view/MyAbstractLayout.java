package com.ardentlabs.globalencyc.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ardentlabs.globalencyc.data.SharedData;
import com.ardentlabs.globalencyc.iofiles.GDPLoader;
import com.ardentlabs.globalencyc.iofiles.PopulationLoader;
import com.ardentlabs.globalencyc.util.DP;

/**
 * Created by muneebahmad on 04/04/15.
 */
public class MyAbstractLayout extends LinearLayout {

    private TextView countryView;
    private TextView valView;

    /**
     *
     * @param context
     * @param rank
     * @param countryName
     * @param value
     */
    public MyAbstractLayout(Context context, int rank, String countryName, String value) {
        super(context);
        make(context, rank, countryName, value);
    }

    /**
     *
     * @param context
     * @param rank
     * @param countryName
     * @param value
     */
    private void make(Context context, int rank, String countryName, String value) {
        this.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams mainLayoutParams = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams tvLayoutParams = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        tvLayoutParams.setMargins(2, 10, 10, 2);

        LinearLayout.LayoutParams tvLayoutParams2 = new LinearLayout.LayoutParams(
                DP.dpToPx(context, 40), LayoutParams.WRAP_CONTENT);
        tvLayoutParams2.setMargins(2, 10, 10, 2);

        LinearLayout.LayoutParams tvLayoutParams3 = new LinearLayout.LayoutParams(
                DP.dpToPx(context, 130), LayoutParams.WRAP_CONTENT);
        tvLayoutParams3.setMargins(2, 10, 10, 2);

        LinearLayout.LayoutParams sepParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                DP.dpToPx(context, 1));
        int m = DP.dpToPx(context, 2);
        sepParams.setMargins(m, m, m, m);

        View hSeparator1 = new View(context);
        hSeparator1.setBackgroundColor(Color.parseColor("#bbbbbb"));

        LinearLayout.LayoutParams vSepParams = new LinearLayout.LayoutParams(DP.dpToPx(context, 1),
                LinearLayout.LayoutParams.MATCH_PARENT);
        int mV = DP.dpToPx(context, 2);
        vSepParams.setMargins(mV, 0, mV, 0);

        View vSeparator1 = new View(context);
        vSeparator1.setBackgroundColor(Color.parseColor("#bbbbbb"));

        View vSeparator2 = new View(context);
        vSeparator2.setBackgroundColor(Color.parseColor("#bbbbbb"));

        // ------------------------------------------------------------------------------------------------------------------
        LinearLayout rowLayout1 = new LinearLayout(context);
        rowLayout1.setOrientation(LinearLayout.HORIZONTAL);
        rowLayout1.setWeightSum(3.0f);
        rowLayout1.setLayoutParams(new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));


        TextView rankView = new TextView(context);
        rankView.setTypeface(Typeface.DEFAULT_BOLD);
        rankView.setLayoutParams(tvLayoutParams2);
        rankView.setTextColor(Color.BLACK);

        countryView = new TextView(context);
        countryView.setTypeface(Typeface.DEFAULT_BOLD);
        countryView.setLayoutParams(tvLayoutParams3);
        countryView.setText(countryName);
        countryView.setTextColor(Color.BLACK);

        valView = new TextView(context);
        valView.setTypeface(Typeface.DEFAULT_BOLD);
        valView.setLayoutParams(tvLayoutParams);
        valView.setText(value);
        valView.setTextColor(Color.BLACK);

        if (rank == 0) {
            rankView.setText("Rank");
            rankView.setTextColor(Color.BLACK);
            countryView.setTextColor(Color.BLACK);
            valView.setTextColor(Color.BLACK);
        } else if (rank == 1000) {
          rankView.setText("");
        } else {
            rankView.setText(rank + "");
            rankView.setTextColor(Color.GRAY);
            countryView.setTextColor(Color.GRAY);
            valView.setTextColor(Color.GRAY);
        }

        rowLayout1.addView(rankView);
        rowLayout1.addView(vSeparator1, vSepParams);
        rowLayout1.addView(countryView);
        rowLayout1.addView(vSeparator2, vSepParams);
        rowLayout1.addView(valView);

        // --------------------------------------------------------------------------------------------------------------

        if (SharedData.getInstance().getActivatedClasses() == SharedData.ActivatedClasses.COUNTRIES_GDP) {
            if (rank == GDPLoader.loadedFromAssetsList.size()) {
                this.addView(rowLayout1, mainLayoutParams);
            } else {
                this.addView(rowLayout1, mainLayoutParams);
                this.addView(hSeparator1, sepParams);
            }
        } else if (SharedData.getInstance().getActivatedClasses() == SharedData.ActivatedClasses.COUNTRIES_POPULATION) {
            if (rank == PopulationLoader.loadedFromAssetsList.size()) {
                this.addView(rowLayout1, mainLayoutParams);
            } else {
                this.addView(rowLayout1, mainLayoutParams);
                this.addView(hSeparator1, sepParams);
            }
        }
    }

}/** end class. */
