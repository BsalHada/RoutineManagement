package com.example.finalassignment;

import com.example.finalassignment.api_classes.Interface;
import com.example.finalassignment.api_classes.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBllClass {
    boolean isSuccess = false;

    public boolean checkuser(String email, String password) {

        Interface Interface = Url.getInstance().create(com.example.finalassignment.api_classes.Interface.class);
        Call<SignUpResponse> usersCall = Interface.checkUser(email, password);

        try {
            Response<SignUpResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful() &&
                    loginResponse.body().getStatus().equals("Login success!")) {
                Url.token += loginResponse.body().getToken();
                // Url.Cookie = imageResponseResponse.headers().get("Set-Cookie");
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
