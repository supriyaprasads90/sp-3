package com.freenow.android_demo.activities;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;
import androidx.test.runner.AndroidJUnit4;

import com.freenow.android_demo.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");

    @Test
    //Verify Login is successfull with correct username and password

    public void VerifySuccessfullLogin() {
        try {
            onView(withId(R.id.edt_username)).check(matches(isDisplayed()));
            onView(withId(R.id.edt_username))
                    .perform(typeText("crazydog335"), closeSoftKeyboard());
            onView(withId(R.id.edt_password)).check(matches(isDisplayed()));
            onView(withId(R.id.edt_password))
                    .perform(typeText("venture"), closeSoftKeyboard());

            onView(withId(R.id.btn_login)).check(matches(isDisplayed()));
            onView(withId(R.id.btn_login)).perform(click());

            onView(withId(R.id.textSearch))
                    .wait(5000);
            onView(withId(R.id.textSearch)).perform(typeText("sa"), closeSoftKeyboard());


            DataInteraction appCompatTextView = onData(anything())
                    .inAdapterView(withText(is("Samantha Reed")));
            appCompatTextView.perform(click());

            onView(withId(R.id.fab)).check(matches(isDisplayed()));
            onView(withId(R.id.fab)).perform(click());

            ViewInteraction viewGroup = onView(
                    allOf(withParent(withParent(withId(android.R.id.content))),
                            isDisplayed()));
            viewGroup.check(matches(isDisplayed()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


