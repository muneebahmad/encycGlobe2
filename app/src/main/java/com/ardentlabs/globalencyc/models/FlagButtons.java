package com.ardentlabs.globalencyc.models;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ardentlabs.globalencyc.data.ResourcesManager;
import com.ardentlabs.globalencyc.data.SharedData;
import com.ardentlabs.globalencyc.interfaces.FlagButtonListener;
import com.ardentlabs.globalencyc.iofiles.CountryDetailsLoader;
import com.ardentlabs.globalencyc.util.Log;

/**
 * Created by muneebahmad on 26/03/15.
 */
public class FlagButtons {

    static FlagButtonListener listener;

    public FlagButtons() {}

    /**
     *
     * @param context
     * @param buttResId
     * @return
     * @throws NullPointerException
     */
    public static Button getFlagButton(final Context context, final int buttResId, final int index) throws
            NullPointerException {
        Button imgButt = new Button(context);
        imgButt.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        imgButt.setBackgroundResource(ResourcesManager.getButton(buttResId));

        imgButt.setOnClickListener(new android.view.View.OnClickListener() {

            @Override
            public void onClick(View view) {
                com.ardentlabs.globalencyc.util.Log.log("FLAGS BUTTON >>> Image Button clicked >>> " +
                        buttResId);
                if (SharedData.getInstance().getActivatedClasses() == SharedData.ActivatedClasses.COUNTRIES_DETAILS) {
                    listener.fireFlagButton(buttResId);
                } else if (SharedData.getInstance().getActivatedClasses() == SharedData.ActivatedClasses.COUNTRIES_HOLIDAYS) {
                    listener.fireHolidayButton(buttResId);
                }
                SharedData.getInstance().setIndex(index);
                Log.log("INDEX " + " -> " + SharedData.getInstance().getIndex());
            }
        });

        return imgButt;
    }

    /**
     *
     * @param flagButtonListener {@link #FlagButtonListener}
     */
    public static void addFlagButtonListener(FlagButtonListener flagButtonListener) {
        listener = flagButtonListener;
    }

}/** end class. */
