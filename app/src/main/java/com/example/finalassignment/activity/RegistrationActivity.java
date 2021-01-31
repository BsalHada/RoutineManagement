package com.example.finalassignment.activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.finalassignment.R;
import com.example.finalassignment.api_classes.Interface;
import com.example.finalassignment.api_classes.Url;
import com.example.finalassignment.modal.UserModal;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrationActivity extends AppCompatActivity {
    ImageView icg_back;
    EditText Name,Email,Password,addresss;
    ImageButton back;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        icg_back=findViewById(R.id.icg_back);

        icg_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

        Name=findViewById(R.id.name);
        Email=findViewById(R.id.email);
        Password=findViewById(R.id.password);
        addresss = findViewById(R.id.address);
        back=findViewById(R.id.icg_back);
        register=findViewById(R.id.signin);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
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

    private void register() {
        String fullname = Name.getText().toString();
        String email = Email.getText().toString();
        String password = Password.getText().toString();
        String address = addresss.getText().toString();

        UserModal employee = new UserModal(fullname, email, password, address);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Url.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Interface employeeApi = retrofit.create(Interface.class);
        Call<Void> voidCall = employeeApi.registerEmployee(employee);

        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(RegistrationActivity.this, "You have been registered", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(RegistrationActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
