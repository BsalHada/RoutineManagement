package com.example.finalassignment.activity;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.finalassignment.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class RoutineActivityTest {

    @Rule
    public ActivityTestRule<RoutineActivity> routineActivityActivityTestRule=
            new ActivityTestRule<>(RoutineActivity.class);

    @Test
    public void recyclerTest() throws Exception{
            onView(withId(R.id.recyclerView_Monday)).check(matches(isDisplayed()));
    }


}