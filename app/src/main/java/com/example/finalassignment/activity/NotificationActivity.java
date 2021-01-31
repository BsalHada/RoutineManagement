package com.example.finalassignment.activity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalassignment.R;
import com.example.finalassignment.adapter.NotificationAdapter;
import com.example.finalassignment.api_classes.BaseAPI;
import com.example.finalassignment.api_classes.Interface;
import com.example.finalassignment.modal.NotificationModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationActivity extends AppCompatActivity {

    RecyclerView notificationRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notificationRecyclerview = findViewById(R.id.notificationRecyclerview);
        notification();

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

    public void notification() {
        Interface retrofitInterface = BaseAPI.getRetrofit().create(Interface.class);
        Call<List<NotificationModal>> productModalCall = retrofitInterface.parseNotification();
        productModalCall.enqueue(new Callback<List<NotificationModal>>() {
            @Override
            public void onResponse(Call<List<NotificationModal>> call, Response<List<NotificationModal>> response) {
                System.out.println("Collection list " + response.body());
                NotificationAdapter NotificationAdapter = new NotificationAdapter(getApplicationContext(), response.body());
                // elevation design
                LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getApplicationContext(),
                        LinearLayoutManager.VERTICAL, false);
                notificationRecyclerview.setLayoutManager(horizontalLayoutManager);
                notificationRecyclerview.setHasFixedSize(true);
                notificationRecyclerview.setAdapter(NotificationAdapter);
                NotificationAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<NotificationModal>> call, Throwable t) {

            }
        });
    }

}