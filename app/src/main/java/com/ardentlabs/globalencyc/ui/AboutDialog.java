package com.ardentlabs.globalencyc.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ardentlabs.globalencyc.R;

/**
 * Created by muneebahmad on 25/03/15.
 */
public class AboutDialog extends Activity {

    private TextView msgView;
    private Button okButt;
    private LinearLayout bgLayout;
    private Animation dialogAnim;

    public AboutDialog () {}

    /**
     *
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.dialog_enter_anim, R.anim.dialog_enter_anim);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_about);
        setContents();
    }

    private void setContents() {
        /**
        this.bgLayout = (LinearLayout) findViewById(R.id.abt_bg_layout);
        this.dialogAnim = AnimationUtils.loadAnimation(this, R.anim.anim_spl);
        this.bgLayout.setAnimation(dialogAnim);

         **/
        this.msgView = (TextView) findViewById(R.id.abt_dialog_message_text);
        this.msgView.setText("  Application                    Global Encyclopedia\n" +
                             "  Developed by                Ardent Labs\n" +
                             "  Version                          1.0.2\n" +
                             "  Compatibility                2.3.3 -> 5.1\n" +
                             "  Programmer                  Muneeb Ahmad\n" +
                             "\n" +
                             " Copyright Ardent Labs");

        this.okButt = (Button) findViewById(R.id.abt_dialog_no_butt);
        this.okButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}/** end class. */
