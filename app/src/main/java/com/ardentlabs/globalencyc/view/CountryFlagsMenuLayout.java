package com.ardentlabs.globalencyc.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ardentlabs.globalencyc.util.DP;

/**
 * Created by muneebahmad on 26/03/15.
 */
public class CountryFlagsMenuLayout {

    public CountryFlagsMenuLayout() {}


    /**
     *
     * @param context
     * @param item1
     * @param item2
     * @param item3
     * @param countryName1
     * @param countryName2
     * @param countryName3
     * @return {@link #HorizontalScrollView}
     */
    public static HorizontalScrollView makeTableRows(Context context, Button item1, Button item2, Button item3, String countryName1,
                                                     String countryName2, String countryName3) {
        HorizontalScrollView hsv = new HorizontalScrollView(context);
        hsv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(30, 20, 20, 30);

        LinearLayout.LayoutParams tvParams = new LinearLayout.LayoutParams(DP.dpToPx(context, 75), LayoutParams.WRAP_CONTENT);

        LinearLayout txtLayout = new LinearLayout(context);
        txtLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        txtLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        txtLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout txt2Layout = new LinearLayout(context);
        txt2Layout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        txt2Layout.setGravity(Gravity.CENTER_HORIZONTAL);
        txt2Layout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout txt3Layout = new LinearLayout(context);
        txt3Layout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        txt3Layout.setGravity(Gravity.CENTER_HORIZONTAL);
        txt3Layout.setOrientation(LinearLayout.VERTICAL);

        TextView tv = new TextView(context);
        //tv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        tv.setTextColor(Color.BLACK);
        tv.setText(countryName1);
        tv.setGravity(Gravity.CENTER_HORIZONTAL);
        tv.setTypeface(Typeface.DEFAULT_BOLD);
        tv.setTextColor(Color.GRAY);

        TextView tv2 = new TextView(context);
        //tv2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        tv2.setTextColor(Color.BLACK);
        tv2.setText(countryName2);
        tv2.setGravity(Gravity.CENTER_HORIZONTAL);
        tv2.setTypeface(Typeface.DEFAULT_BOLD);
        tv2.setTextColor(Color.GRAY);

        TextView tv3 = new TextView(context);
        //tv3.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        tv3.setTextColor(Color.BLACK);
        tv3.setText(countryName3);
        tv3.setGravity(Gravity.CENTER_HORIZONTAL);
        tv3.setTypeface(Typeface.DEFAULT_BOLD);
        tv3.setTextColor(Color.GRAY);

        if (item1 != null) {
            txtLayout.addView(item1);
            txtLayout.addView(tv, tvParams);
        }

        if (item2 != null) {
            txt2Layout.addView(item2);
            txt2Layout.addView(tv2, tvParams);
        }

        if (item3 != null) {
            txt3Layout.addView(item3);
            txt3Layout.addView(tv3, tvParams);
        }


        linearLayout.addView(txtLayout, layoutParams);
        linearLayout.addView(txt2Layout, layoutParams);
        linearLayout.addView(txt3Layout, layoutParams);

        hsv.addView(linearLayout);
        return hsv;
    }

}/** end class. */
