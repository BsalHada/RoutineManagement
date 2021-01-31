package com.example.finalassignment.api_classes;

import com.example.finalassignment.SignUpResponse;
import com.example.finalassignment.modal.EventModal;
import com.example.finalassignment.modal.NotificationModal;
import com.example.finalassignment.modal.RoutineModal;
import com.example.finalassignment.modal.UserModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Interface {

    //register user
    @POST("register/register_user")
    Call<Void> registerEmployee(@Body UserModal usersCUD);

    //for logging into the system
    @FormUrlEncoded
    @POST("register/login_user")
    Call<SignUpResponse> checkUser(@Field("email") String email, @Field("password") String password);

    @GET("register/me")
    Call<UserModal> getUserDetails(@Header("Authorization")String token);

    @GET("event/getproduct")
    Call<List<EventModal>> parseEvent();

    @GET("/notification/getNotification")
    Call<List<NotificationModal>> parseNotification();

    @GET("/schedule/getSchedule")
    Call<List<RoutineModal>> parseRoutine();

}
