package com.example.finalassignment.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalassignment.R;
import com.example.finalassignment.api_classes.Interface;
import com.example.finalassignment.api_classes.Url;
import com.example.finalassignment.modal.UserModal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfileActivity extends AppCompatActivity {

    TextView txtName, txtEmail, txtAddress;
    UserModal userModals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        txtAddress = findViewById(R.id.txtaddress);

        loadCurrentUser();


    }

    private void loadCurrentUser() {
        Interface Interface = Url.getInstance().create(Interface.class);
        final Call<UserModal> userCall = Interface.getUserDetails(Url.token);
        Toast.makeText(ProfileActivity.this, "" + Url.token, Toast.LENGTH_SHORT).show();
        userCall.enqueue(new Callback<UserModal>() {
            @Override
            public void onResponse(Call<UserModal> call, Response<UserModal> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(ProfileActivity.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                userModals = response.body();
                txtName.setText(response.body().getFullname());
                txtEmail.setText(response.body().getEmail());
                txtAddress.setText(response.body().getAddress());

            }

            @Override
            public void onFailure(Call<UserModal> call, Throwable t) {
                Log.d("My message", "onFaliure" + t.getLocalizedMessage());
                Toast.makeText(ProfileActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}

