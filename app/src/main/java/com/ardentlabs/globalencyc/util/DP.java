package com.ardentlabs.globalencyc.util;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by muneebahmad on 27/03/15.
 */
public class DP {

    /**
     *
     * @param context
     * @param dp int
     * @return Pixels(px) converted from DP in int
     */
    public static int dpToPx(Context context, int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

    /**
     *
     * @param context
     * @param px int
     * @return DP converted from Pixels(px) in int
     */
    public static int pxToDp(Context context, int px) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int dp = Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return dp;
    }

}/** end class. */
