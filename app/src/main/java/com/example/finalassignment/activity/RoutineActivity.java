package com.example.finalassignment.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import com.example.finalassignment.R;
import com.example.finalassignment.adapter.RoutineAdapter;
import com.google.android.material.tabs.TabLayout;

public class RoutineActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        tabLayout.addTab(tabLayout.newTab().setText("Monday"));
        tabLayout.addTab(tabLayout.newTab().setText("Tuesday"));
        tabLayout.addTab(tabLayout.newTab().setText("Wednesday"));
        tabLayout.addTab(tabLayout.newTab().setText("Thursday"));
        tabLayout.addTab(tabLayout.newTab().setText("Friday"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final RoutineAdapter adapter = new RoutineAdapter(this,getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        //Proximity Sensor
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        final Sensor proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        SensorEventListener sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.values[0] < proximitySensor.getMaximumRange()) {

                    getWindow().getDecorView().setBackgroundColor(Color.BLACK);

                } else {
                    getWindow().getDecorView().setBackgroundColor(Color.WHITE);


                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }

        };
        sensorManager.registerListener(sensorEventListener, proximitySensor, 2 * 1000 * 1000);

    }
}
