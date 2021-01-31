package com.example.finalassignment.activity;

import androidx.test.rule.ActivityTestRule;

import com.example.finalassignment.R;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


public class RegistratonActivityTest {
    @Rule
    public ActivityTestRule<RegistrationActivity> registrationActivityTestRule=
            new ActivityTestRule<>(RegistrationActivity.class);

    @Test
    public void clickSignUp() {
        String full_name = "fullname";
        String emailAddress = "fullname@gmail.com";
        String password = "password";

        //find the firstname edit text and type in the first name
        onView(withId(R.id.name)).perform(typeText(full_name), closeSoftKeyboard());

        //find the email address edit text and type in the email address
        onView(withId(R.id.email)).perform(typeText(emailAddress), closeSoftKeyboard());

        //find the password edit text and type in the password
        onView(withId(R.id.password)).perform(typeText(password), closeSoftKeyboard());

        //click the signup button
        onView(withId(R.id.icg_back)).perform(click());


    }
}
