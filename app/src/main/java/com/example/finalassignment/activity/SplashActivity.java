package com.example.finalassignment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import com.example.finalassignment.R;



public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN_TIMEOUT =3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);getWindow().setStatusBarColor(Color.parseColor("#008577"));

        // pass activity after 3 sec
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LandingActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN_TIMEOUT);

    }
}
