package com.freenow.android_demo;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.freenow.android_demo.R;
import com.freenow.android_demo.activities.MainActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.Runner;
import org.junit.runner.RunWith;
import android.content.Context;



@RunWith(AndroidJUnit4.class)
public class Login {

        @Rule
        public ActivityScenarioRule<MainActivity> myactivityScenarioRule =
               new ActivityScenarioRule<>(MainActivity.class);
        @Rule
        public GrantPermissionRule mGrantPermissionRule =
                GrantPermissionRule.grant(
                        "android.permission.ACCESS_FINE_LOCATION");

        @Test
        public void VerifyLogin() {


                onView(withId(R.id.edt_username)).perform(typeText("crazydog335"));
                onView(withId(R.id.edt_password)).perform(typeText("venture"));
                onView(withId(R.id.btn_login)).perform(click());
                // use 'activity'.


        }
    }


