package com.example.finalassignment.activity;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.finalassignment.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class DashboardActivityTest {
    @Rule
    public ActivityTestRule<DashboardActivity> dashboardActivityActivityTestRule =
            new ActivityTestRule<>(DashboardActivity.class);

    @Test
    public void dashboardTest(){
        onView(withId(R.id.cardView_Event)).perform(click());
    }
    @Test
    public void dashboardClickP(){
        onView(withId(R.id.profile)).perform(click());
    }
    @Test
    public void dashboardClickF(){
        onView(withId(R.id.calendarView)).perform(click());
    }

    @Test
    public void dashboardDoubleClick(){
        onView(withId(R.id.cardView_Calender)).perform(click());
    }
}

