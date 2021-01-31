package com.example.finalassignment.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalassignment.R;
import com.example.finalassignment.adapter.DayAdapter;
import com.example.finalassignment.api_classes.BaseAPI;
import com.example.finalassignment.api_classes.Interface;
import com.example.finalassignment.modal.RoutineModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TuesdayFragment extends Fragment {

    private static String day = "Tuesday";
    public TuesdayFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView_monday;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_monday, container, false);
        recyclerView_monday = view.findViewById(R.id.recyclerView_Monday);
        routine_tuesday();
        return view;
    }

    public void routine_tuesday(){
        Interface retrofitInterface = BaseAPI.getRetrofit().create(Interface.class);
        Call<List<RoutineModal>> productModalCall = retrofitInterface.parseRoutine();
        productModalCall.enqueue(new Callback<List<RoutineModal>>() {
            @Override
            public void onResponse(Call<List<RoutineModal>> call, Response<List<RoutineModal>> response) {
                DayAdapter DayAdapter = new DayAdapter(getActivity(),response.body());
                LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(),
                        LinearLayoutManager.HORIZONTAL, false);
                recyclerView_monday.setLayoutManager(horizontalLayoutManager);
                recyclerView_monday.setHasFixedSize(true);
                recyclerView_monday.setAdapter(DayAdapter);
                DayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<RoutineModal>> call, Throwable t) {

            }
        });
    }
}
