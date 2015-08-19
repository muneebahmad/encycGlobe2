package com.ardentlabs.globalencyc.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ardentlabs.globalencyc.MainActivity;
import com.ardentlabs.globalencyc.R;

/**
 * Created by muneebahmad on 25/03/15.
 */
public class ExitDialog extends Activity implements View.OnClickListener {

    private TextView msgView;
    private Button yesButt;
    private Button noButt;

    private Animation stageAnim;
    private LinearLayout stageLayout;

    public ExitDialog() {}

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        overridePendingTransition(R.anim.dialog_enter_anim, R.anim.dialog_enter_anim);
        setContentView(R.layout.dialog_ext);

        setContents();
    }

    private void setContents() {
        this.msgView = (TextView) findViewById(R.id.exit_dialog_message_text);
        this.msgView.setText("Do you really want to exit this application?");

        this.yesButt = (Button) findViewById(R.id.exit_dialog_yes_butt);
        this.yesButt.setOnClickListener(this);
        this.noButt = (Button) findViewById(R.id.exit_dialog_no_butt);
        this.noButt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == this.yesButt) {
            MainActivity.main.finish();
            System.exit(0);
        } else if (view == this.noButt) {
            finish();
        }
    }
}/** end class. */
