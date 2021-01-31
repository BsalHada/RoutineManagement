package com.example.finalassignment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.finalassignment.LoginBllClass;
import com.example.finalassignment.MainActivity;
import com.example.finalassignment.R;
import com.example.finalassignment.StrictModeClass;

public class LoginActivity extends AppCompatActivity {
    Button btnreg;
    Vibrator vibrator;
    EditText emails,passwords;
    ImageButton back;
    Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnreg= findViewById(R.id.signin);
        back= findViewById(R.id.ic_back);
        signin=findViewById(R.id.signin);

        emails=findViewById(R.id.email);
        passwords=findViewById(R.id.password);

        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
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

    private void login() {
        String email = emails.getText().toString();
        String password = passwords.getText().toString();
        LoginBllClass LoginBllClass = new LoginBllClass();
        StrictModeClass.StrictMode();
        if (LoginBllClass.checkuser(email, password)) {
            // Intent intent = new Intent(LoginActivity.this, LandingActivity.class);
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        } else {
            vibrator.vibrate(1000);
            Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
            emails.requestFocus();
        }


    }

}
