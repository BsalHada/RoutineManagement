package com.example.finalassignment.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.finalassignment.fragment.FridayFragment;
import com.example.finalassignment.fragment.MondayFragment;
import com.example.finalassignment.fragment.ThursdayFragment;
import com.example.finalassignment.fragment.TuesdayFragment;
import com.example.finalassignment.fragment.WednesdayFragment;

public class RoutineAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    public RoutineAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                MondayFragment mondayFragment = new MondayFragment();
                return mondayFragment ;
            case 1:
                TuesdayFragment tuesdayFragment = new TuesdayFragment();
                return tuesdayFragment;
            case 2:
                WednesdayFragment wednesdayFragment = new WednesdayFragment();
                return wednesdayFragment;
            case 3:
                ThursdayFragment thursdayFragment = new ThursdayFragment();
                return thursdayFragment;
            case 4:
                FridayFragment fridayFragment= new FridayFragment();
                return fridayFragment;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}