package com.example.finalassignment.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.finalassignment.R;
import com.example.finalassignment.adapter.EventAdapter;
import com.example.finalassignment.api_classes.BaseAPI;
import com.example.finalassignment.api_classes.Interface;
import com.example.finalassignment.modal.EventModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventActivity extends AppCompatActivity {

    RecyclerView recyclerViewEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        recyclerViewEvent = findViewById(R.id.eventRecyclerview);

        event();
    }

    public void event(){
        Interface retrofitInterface = BaseAPI.getRetrofit().create(Interface.class);
        Call<List<EventModal>> productModalCall = retrofitInterface.parseEvent();
        productModalCall.enqueue(new Callback<List<EventModal>>() {
            @Override
            public void onResponse(Call<List<EventModal>> call, Response<List<EventModal>> response) {
                System.out.println("Collection list " + response.body());
                EventAdapter EventAdapter = new EventAdapter(getApplicationContext(),response.body());
                // elevation design
                LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getApplicationContext(),
                        LinearLayoutManager.VERTICAL, false);
                recyclerViewEvent.setLayoutManager(horizontalLayoutManager);
                recyclerViewEvent.setHasFixedSize(true);
                recyclerViewEvent.setAdapter(EventAdapter);
                EventAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<EventModal>> call, Throwable t) {

            }
        });

    }

}