package com.ardentlabs.globalencyc.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.ardentlabs.globalencyc.CountryDetailsActivity;
import com.ardentlabs.globalencyc.data.SharedData;
import com.ardentlabs.globalencyc.iofiles.CountryDetailsLoader;

/**
 * Created by muneebahmad on 11/04/15.
 */
public class Searcher {

    public Searcher() {}

    /**
     *
     * @param context {@link #Context}
     * @param keyword {@link #String}
     */
    public static void search(Context context, String keyword) {
        if (keyword != null && keyword != "" && keyword.length() > 0) {
            CountryDetailsLoader.searchCountries(context, keyword);


            if (SharedData.getInstance().getActivatedClasses() != SharedData.ActivatedClasses.COUNTRIES_DETAILS) {
                makeEmptyDialog(context, "Search Results...", "Sorry! your search did not match with any characters of names"
                        + " in the datastore, "
                        + "Try again using different characters or categories.");
            }
        } else {
            makeEmptyDialog(context, "Input Error", "Input is Empty or you have entered an invalid character, "
                    + "Please Enter text input of at least 2 characters long"
                    + " to proceed with search.");
        }
    }

    /**
     *
     * @param ctx
     * @param title
     * @param msg
     */
    private static void makeEmptyDialog(Context ctx, String title, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     *
     * @param ctx
     * @param activatedClasses
     * @param index
     */
    public static void navigate(Context ctx, SharedData.ActivatedClasses activatedClasses,
                                int index) {
        SharedData.getInstance().setActivatedClasses(activatedClasses);
        SharedData.getInstance().setIndex(index);
        ctx.startActivity(new Intent(ctx, CountryDetailsActivity.class));
    }

}/** end class. */
