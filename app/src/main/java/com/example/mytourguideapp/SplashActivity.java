package com.example.mytourguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_lENGTH = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //ligth status bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        //handler for set delay to mainactivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goToListPlacesActivity();
            }
        }, SPLASH_DISPLAY_lENGTH);
    }

    //get intent mainactivity
    private void goToListPlacesActivity() {
        Intent intent = new Intent (this.getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}