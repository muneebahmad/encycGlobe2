package com.ardentlabs.globalencyc.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ardentlabs.globalencyc.iofiles.HistoryLoader;
import com.ardentlabs.globalencyc.util.DP;

/**
 * Created by muneebahmad on 05/04/15.
 */
public class MyHistoryLayout extends LinearLayout {

    private TextView detailView;

    /**
     *
     * @param context
     * @param index
     * @param year
     * @param event
     * @param description
     */
    public MyHistoryLayout(Context context, int index, String year, String event, String description) {
        super(context);
        make(context, index, year, event, description);
    }

    /**
     *
     * @param context
     * @param index
     * @param year
     * @param event
     * @param description
     */
    private void make(Context context, int index, String year, String event, String description) {
        this.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams mainLayoutParams = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

        LinearLayout.LayoutParams tvLayoutParams = new LinearLayout.LayoutParams(
                DP.dpToPx(context, 50), LayoutParams.WRAP_CONTENT);
        tvLayoutParams.setMargins(10, 10, 10, 10);

        LinearLayout.LayoutParams tvLayoutParams2 = new LinearLayout.LayoutParams(
                DP.dpToPx(context, 50), LayoutParams.WRAP_CONTENT);
        tvLayoutParams2.setMargins(10, 10, 10, 10);

        LinearLayout.LayoutParams tvLayoutParams3 = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        tvLayoutParams3.setMargins(10, 10, 10, 10);

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

        //==========================================================================
        LinearLayout rowLayout1 = new LinearLayout(context);
        rowLayout1.setOrientation(LinearLayout.HORIZONTAL);
        rowLayout1.setWeightSum(3.0f);
        rowLayout1.setLayoutParams(new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        TextView yearView = new TextView(context);
        yearView.setTypeface(Typeface.DEFAULT_BOLD);
        yearView.setLayoutParams(tvLayoutParams2);
        yearView.setText(year);
        yearView.setTextColor(Color.parseColor("#be1e2d"));

        TextView eventView = new TextView(context);
        eventView.setTypeface(Typeface.DEFAULT_BOLD);
        eventView.setTextColor(Color.parseColor("#1e90ff"));
        eventView.setLayoutParams(tvLayoutParams);
        eventView.setText(event);

        detailView = new TextView(context);
        detailView.setTypeface(Typeface.DEFAULT_BOLD);
        detailView.setLayoutParams(tvLayoutParams3);
        detailView.setText(description);
        detailView.setTextColor(Color.DKGRAY);

        rowLayout1.addView(yearView);
        rowLayout1.addView(vSeparator1, vSepParams);
        rowLayout1.addView(eventView);
        rowLayout1.addView(vSeparator2, vSepParams);
        rowLayout1.addView(detailView);

        if (index == HistoryLoader.loadedFromAssetsList.size()) {
            this.addView(rowLayout1, mainLayoutParams);
        } else {
            this.addView(rowLayout1, mainLayoutParams);
            this.addView(hSeparator1, sepParams);
        }
    }

}/** end class. */
