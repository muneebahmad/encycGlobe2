package com.ardentlabs.globalencyc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ardentlabs.globalencyc.data.Loader;
import com.ardentlabs.globalencyc.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by muneebahmad on 24/03/15.
 */
public class SplashActivity extends Activity {

    private ImageView logoView;
    private Animation logoAnim;
    private ProgressBar progressBar;
    private TextView loadingView;
    private TextView stateView;

    private static final String FILENAME = "encyc.conf";
    private static final String VALUE = "initialized";

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        loadAnim();
        setLoadingProgress();
        if (checkPreCondition().equals(VALUE)) {
            Toast toast = Toast.makeText(this, "Welcome back!", Toast.LENGTH_LONG);
            toast.show();
            loadData();
            pThread.start();
        } else if (!checkPreCondition().equals(VALUE)) {
            Toast toast = Toast.makeText(this, "Welcome to Global Encyclopedia!", Toast.LENGTH_LONG);
            toast.show();
            writeBuffer();
            loadData();
            pThread.start();
        }
    }

    private void loadData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Loader.load(SplashActivity.this);
                incrLoadingProgress();
            }
        }, 2000);
    }

    private void setLoadingProgress() {
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        this.progressBar.setIndeterminate(false);
        this.progressBar.setMax(100);
        this.loadingView = (TextView) findViewById(R.id.loadingView);
        this.stateView = (TextView) findViewById(R.id.stateView);
    }

    private void incrLoadingProgress() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                progressBar.setProgress(Loader.getLoadingProgress());
                loadingView.setText("LOADING " + Loader.getLoadingProgress()
                        + " %");
                stateView.setText(Loader.getState());
            }
        }, 500);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                progressBar.setProgress(Loader.getLoadingProgress());
                loadingView.setText("LOADING " + Loader.getLoadingProgress()
                        + " %");
                stateView.setText(Loader.getState());
            }
        }, 1000);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                progressBar.setProgress(Loader.getLoadingProgress());
                loadingView.setText("LOADING " + Loader.getLoadingProgress()
                        + " %");
                stateView.setText(Loader.getState());
            }
        }, 2000);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                progressBar.setProgress(Loader.getLoadingProgress());
                loadingView.setText("LOADING " + Loader.getLoadingProgress()
                        + " %");
                stateView.setText(Loader.getState());
            }
        }, 2500);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                progressBar.setProgress(Loader.getLoadingProgress());
                loadingView.setText("LOADING " + Loader.getLoadingProgress()
                        + " %");
                stateView.setText(Loader.getState());
            }
        }, 4300);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                progressBar.setProgress(Loader.getLoadingProgress());
                loadingView.setText("LOADING " + Loader.getLoadingProgress()
                        + " %");
                stateView.setText(Loader.getState());
            }
        }, 6000);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                progressBar.setProgress(Loader.getLoadingProgress());
                loadingView.setText("LOADING " + Loader.getLoadingProgress()
                        + " %");
                stateView.setText(Loader.getState());
            }
        }, 7000);

    }

    private void loadAnim() {
        this.logoView = (ImageView) findViewById(R.id.splash_logo);
        this.logoAnim = AnimationUtils.loadAnimation(this, R.anim.anim_spl);
        this.logoView.setAnimation(logoAnim);
    }

    private String checkPreCondition() {
        FileInputStream fis;
        String retVal = "";

        try {
            fis = openFileInput(FILENAME);
            byte[] input = new byte[fis.available()];
            while (fis.read(input) != -1) {
                retVal += new String(input);
            }
        } catch (FileNotFoundException e) {
            Log.log(SplashActivity.class.getName() + e + " in checkPrecondition()");
        } catch (IOException e) {
            Log.log(SplashActivity.class.getName() + e + " in checkPrecondition()");
        }
        return  retVal;
    }

    private void writeBuffer() {
        FileOutputStream fos;
        try {
            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(VALUE.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.log(SplashActivity.class.getName() + e + " writing buffer");
        } catch (IOException e) {
            e.printStackTrace();
            Log.log(SplashActivity.class.getName() + e + " writing buffer");
        }
    }

    Thread pThread = new Thread() {
        @Override
        public void run() {
            try {
                sleep(10000);
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            } catch (InterruptedException e) {
                e.printStackTrace();
                Log.log(SplashActivity.class.getName() + "ERROR IN THREAD... ");
            } finally {
                finish();
            }
        }
    };

    @Override
    public void onBackPressed() {}

}/** end class. */
