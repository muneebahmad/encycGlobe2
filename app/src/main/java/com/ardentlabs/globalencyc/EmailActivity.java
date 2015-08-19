package com.ardentlabs.globalencyc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by muneebahmad on 09/04/15.
 */
public class EmailActivity extends ActionBarActivity implements View.OnClickListener {

    private EditText subjectText;
    private EditText msgText;

    private Button sendButt;
    private Button resetButt;
    private Button cancelButt;

    private TextView titleView;
    private Animation titleAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.anim_right_push_in, R.anim.anim_right_push_in_2);
        setContentView(R.layout.activity_email);
        setToolbar();
        this.subjectText = (EditText) findViewById(R.id.email_subject_et);
        this.msgText = (EditText) findViewById(R.id.email_message_et);
        this.sendButt = (Button) findViewById(R.id.email_send_button);
        this.sendButt.setOnClickListener(this);
        this.resetButt = (Button) findViewById(R.id.email_reset_button);
        this.resetButt.setOnClickListener(this);
        this.cancelButt = (Button) findViewById(R.id.email_cancel_button);
        this.cancelButt.setOnClickListener(this);
        loadAdView();
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.email_toolbar);
        setSupportActionBar(toolbar);

        this.titleView = (TextView) findViewById(R.id.email_titleView);
        this.titleAnim = AnimationUtils.loadAnimation(this, R.anim.title_anim);
        this.titleView.setAnimation(titleAnim);
    }

    @Override
    public void onClick(View view) {
        if (view == this.sendButt) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"theardentbpo@gmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, this.subjectText.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, this.msgText.getText().toString());

            try {
                startActivity(intent);
            } catch (android.content.ActivityNotFoundException e) {
                Toast toast = Toast.makeText(this, "There are no email clients installed on your "
                        + "Computer!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            } finally {
                finish();
            }
        } else if (view == this.resetButt) {
            this.msgText.setText("");
            this.subjectText.setText("");
        } else if (view == this.cancelButt) {
            onBackPressed();
        }
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }

    private void loadAdView() {
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("abc")
                .build();
        mAdView.loadAd(adRequest);
    }
}/** end class. */
