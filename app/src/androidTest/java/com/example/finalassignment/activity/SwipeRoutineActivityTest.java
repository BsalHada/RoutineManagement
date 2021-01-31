package com.example.finalassignment.activity;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.finalassignment.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class SwipeRoutineActivityTest {


    @Rule
    public ActivityTestRule<RoutineActivity> routineActivityTestRule =
            new ActivityTestRule<>(RoutineActivity.class);

    @Test
    public void fragmentTest() {
        onView(withId(R.id.recyclerView_Monday)).perform(swipeLeft());
    }

    @Test
    public void fragmentTest1() {
        onView(withId(R.id.viewPager)).perform(swipeLeft());
    }


}

