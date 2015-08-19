package com.ardentlabs.globalencyc.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ardentlabs.globalencyc.R;
import com.ardentlabs.globalencyc.util.DP;

/**
 * Created by muneebahmad on 31/03/15.
 */
public class MyHolidayLayout extends LinearLayout {

    /**
     *
     * @param context
     * @param day
     * @param date
     * @param holiday
     * @param type
     * @param comments
     */
    public MyHolidayLayout(Context context, String day, String date, String holiday, String type,
                           String comments) {
        super(context);
        makeMyHolidayLayout(context, day, date, holiday, type, comments);
    }

    /**
     *
     * @param context
     * @param day
     * @param date
     * @param holiday
     * @param type
     * @param comments
     */
    private void makeMyHolidayLayout(Context context, String day, String date, String holiday,
                                     String type, String comments) {
        //LinearLayout mainLayout = new LinearLayout(context);
        this.setOrientation(LinearLayout.VERTICAL);
        this.setBackgroundResource(R.drawable.scrollview_bg);
        LinearLayout.LayoutParams mainLayoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        mainLayoutParams.setMargins(10, 0, 10, 0);

        LinearLayout.LayoutParams tvLayoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        tvLayoutParams.setMargins(5, 10, 5, 10);

        LinearLayout.LayoutParams tvLayoutParams1 = new LinearLayout.LayoutParams(DP.dpToPx(context, 80), LayoutParams.WRAP_CONTENT);
        tvLayoutParams1.setMargins(5, 10, 5, 10);

        LinearLayout.LayoutParams sepParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                DP.dpToPx(context, 1));
        int m = DP.dpToPx(context, 2);
        sepParams.setMargins(m, m, m, m);

        LinearLayout.LayoutParams vSepParams = new LinearLayout.LayoutParams(DP.dpToPx(context, 1),
                LinearLayout.LayoutParams.MATCH_PARENT);
        int mV = DP.dpToPx(context, 2);
        vSepParams.setMargins(mV, 0, mV, 0);

        View hSeparator1 = new View(context);
        hSeparator1.setBackgroundColor(Color.parseColor("#bbbbbb"));

        View hSeparator2 = new View(context);
        hSeparator2.setBackgroundColor(Color.parseColor("#bbbbbb"));

        View hSeparator3 = new View(context);
        hSeparator3.setBackgroundColor(Color.parseColor("#bbbbbb"));

        View vSeparator1 = new View(context);
        vSeparator1.setBackgroundColor(Color.parseColor("#bbbbbb"));

        View vSeparator2 = new View(context);
        vSeparator2.setBackgroundColor(Color.parseColor("#bbbbbb"));

        View vSeparator3 = new View(context);
        vSeparator3.setBackgroundColor(Color.parseColor("#bbbbbb"));

        View vSeparator4 = new View(context);
        vSeparator4.setBackgroundColor(Color.parseColor("#bbbbbb"));

        //------------------------------------------------------------------------------------------------------------------
        LinearLayout rowLayout1 = new LinearLayout(context);
        rowLayout1.setOrientation(LinearLayout.HORIZONTAL);
        rowLayout1.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        TextView dateView = new TextView(context);
        dateView.setTypeface(Typeface.DEFAULT_BOLD);
        dateView.setLayoutParams(tvLayoutParams1);
        dateView.setText("Date");
        dateView.setTextColor(Color.GRAY);

        TextView dateContentView = new TextView(context);
        dateContentView.setTypeface(Typeface.DEFAULT_BOLD);
        dateContentView.setLayoutParams(tvLayoutParams);
        dateContentView.setText(day + ", " + date);
        dateContentView.setTextColor(Color.GRAY);

        rowLayout1.addView(dateView);
        rowLayout1.addView(vSeparator1, vSepParams);
        rowLayout1.addView(dateContentView);

        //--------------------------------------------------------------------------------------------------------------

        LinearLayout rowLayout2 = new LinearLayout(context);
        rowLayout2.setOrientation(LinearLayout.HORIZONTAL);
        rowLayout2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        TextView typeView = new TextView(context);
        typeView.setTypeface(Typeface.DEFAULT_BOLD);
        typeView.setLayoutParams(tvLayoutParams1);
        typeView.setText("Type");
        typeView.setTextColor(Color.GRAY);

        TextView typeContentView = new TextView(context);
        typeContentView.setTypeface(Typeface.DEFAULT_BOLD);
        typeContentView.setLayoutParams(tvLayoutParams);
        typeContentView.setText(type);
        typeContentView.setTextColor(Color.GRAY);

        rowLayout2.addView(typeView);
        rowLayout2.addView(vSeparator2, vSepParams);
        rowLayout2.addView(typeContentView);

        //-----------------------------------------------------------------------------------------------------------------------

        LinearLayout rowLayout3 = new LinearLayout(context);
        rowLayout3.setOrientation(LinearLayout.HORIZONTAL);
        rowLayout3.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        TextView hView = new TextView(context);
        hView.setTypeface(Typeface.DEFAULT_BOLD);
        hView.setLayoutParams(tvLayoutParams1);
        hView.setText("Holiday");
        hView.setTextColor(Color.GRAY);

        TextView hContentView = new TextView(context);
        hContentView.setTypeface(Typeface.DEFAULT_BOLD);
        hContentView.setLayoutParams(tvLayoutParams);
        hContentView.setText(holiday);
        hContentView.setTextColor(Color.GRAY);

        rowLayout3.addView(hView);
        rowLayout3.addView(vSeparator3, vSepParams);
        rowLayout3.addView(hContentView);

        //--------------------------------------------------------------------------------------------------------------------------

        LinearLayout rowLayout4 = new LinearLayout(context);
        rowLayout4.setOrientation(LinearLayout.HORIZONTAL);
        rowLayout4.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        TextView cView = new TextView(context);
        cView.setTypeface(Typeface.DEFAULT_BOLD);
        cView.setLayoutParams(tvLayoutParams1);
        cView.setText("Comments");
        cView.setTextColor(Color.GRAY);

        TextView cContentView = new TextView(context);
        cContentView.setTypeface(Typeface.DEFAULT_BOLD);
        cContentView.setLayoutParams(tvLayoutParams);
        cContentView.setText(comments);
        cContentView.setTextColor(Color.GRAY);

        rowLayout4.addView(cView);
        rowLayout4.addView(vSeparator4, vSepParams);
        rowLayout4.addView(cContentView);

        //---------------------------------------------------------------------------------------------------------------------------

        this.addView(rowLayout1, mainLayoutParams);
        this.addView(hSeparator1, sepParams);
        this.addView(rowLayout2, mainLayoutParams);
        this.addView(hSeparator3, sepParams);
        this.addView(rowLayout3, mainLayoutParams);
        this.addView(hSeparator2, sepParams);
        this.addView(rowLayout4, mainLayoutParams);
    }
}/** end class. */
