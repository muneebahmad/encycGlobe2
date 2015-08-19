package com.ardentlabs.globalencyc.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ardentlabs.globalencyc.util.DP;

/**
 * Created by muneebahmad on 07/04/15.
 */
public class MyContinentLayout extends LinearLayout {

    private TextView areaView;
    private TextView popView;

    /**
     *
     * @param context {@link #Context}
     * @param countryName {@link #String}
     * @param area {@link #String}
     * @param population {@link #String}
     * @param textColor int
     * @param textBold boolean
     * @param hSeparator boolean
     */
    public MyContinentLayout(Context context, String countryName, String area, String population, int textColor,
                             boolean textBold, boolean hSeparator) {
        super(context);
        make(context, countryName, area, population, textColor, textBold, hSeparator);
    }

    /**
     *
     * @param context {@link #Context}
     * @param countryName {@link #String}
     * @param area {@link #String}
     * @param population {@link #String}
     * @param textColor int
     * @param textBold boolean
     * @param hSeparator boolean
     */
    private void make(Context context, String countryName, String area, String population, int textColor,
                      boolean textBold, boolean hSep) {
        this.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams mainLayoutParams = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams tvLayoutParams = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        tvLayoutParams.setMargins(2, 10, 10, 2);

        LinearLayout.LayoutParams tvLayoutParams2 = new LinearLayout.LayoutParams(
                DP.dpToPx(context, 90), LayoutParams.WRAP_CONTENT);
        tvLayoutParams2.setMargins(2, 10, 10, 2);

        LinearLayout.LayoutParams tvLayoutParams3 = new LinearLayout.LayoutParams(
                DP.dpToPx(context, 100), LayoutParams.WRAP_CONTENT);
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


        TextView countryNameView = new TextView(context);
        if (textBold) countryNameView.setTypeface(Typeface.DEFAULT_BOLD);
        countryNameView.setLayoutParams(tvLayoutParams2);
        countryNameView.setTextColor(textColor);
        countryNameView.setText(countryName);

        areaView = new TextView(context);
        if (textBold) areaView.setTypeface(Typeface.DEFAULT_BOLD);
        areaView.setLayoutParams(tvLayoutParams3);
        areaView.setText(area);
        areaView.setTextColor(textColor);

        popView = new TextView(context);
        if (textBold) popView.setTypeface(Typeface.DEFAULT_BOLD);
        popView.setLayoutParams(tvLayoutParams);
        popView.setText(population);
        popView.setTextColor(textColor);

        rowLayout1.addView(countryNameView);
        rowLayout1.addView(vSeparator1, vSepParams);
        rowLayout1.addView(areaView);
        rowLayout1.addView(vSeparator2, vSepParams);
        rowLayout1.addView(popView);

        // --------------------------------------------------------------------------------------------------------------

        if (!hSep) {
            this.addView(rowLayout1, mainLayoutParams);
        } else if (hSep) {
            this.addView(rowLayout1, mainLayoutParams);
            this.addView(hSeparator1, sepParams);
        }
    }

}/** end class. */
