package com.example.finalassignment.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.finalassignment.R;

public class DashboardActivity extends AppCompatActivity {
    ImageView img_Routine;
    Button btn_login, btn_signup;
    CardView cardView_profile, cardView_Event, cardView_Notification, cardView_Calender, cardView_Map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        img_Routine = findViewById(R.id.img_Routine);
        cardView_profile = findViewById(R.id.profile);
        cardView_Event = findViewById(R.id.cardView_Event);

        img_Routine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RoutineActivity.class);
                startActivity(intent);
            }
        });

        cardView_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        cardView_Event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EventActivity.class);
                startActivity(intent);
            }
        });

        cardView_Notification = findViewById(R.id.cardView_Notification);
        cardView_Notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NotificationActivity.class);
                startActivity(intent);
            }
        });

        cardView_Calender = findViewById(R.id.cardView_Calender);
        cardView_Calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CalenderActivity.class);
                startActivity(intent);
            }
        });

        cardView_Map = findViewById(R.id.cardView_Map);
        cardView_Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SampleMapActivity.class);
                startActivity(intent);
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
