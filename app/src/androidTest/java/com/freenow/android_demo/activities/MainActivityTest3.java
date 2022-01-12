package com.freenow.android_demo.activities;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;
import androidx.test.runner.AndroidJUnit4;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import com.freenow.android_demo.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest3 {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");

    @Test
    public void VerifySuccessfullCall() {
        try {
            onView(withId(R.id.edt_username)).check(matches(isDisplayed()));
            onView(withId(R.id.edt_username))
                    .perform(typeText("crazydog335"), closeSoftKeyboard());
            onView(withId(R.id.edt_password)).check(matches(isDisplayed()));
            onView(withId(R.id.edt_password))
                    .perform(typeText("venture"), closeSoftKeyboard());

            onView(withId(R.id.btn_login)).check(matches(isClickable()));
            onView(withId(R.id.btn_login)).perform(click());

            onView(withId(R.id.btn_login)).check(matches(isDisplayed()));
            onView(withId(R.id.btn_login)).perform(click());
            onView(withId(R.id.textSearch)).perform(typeText("sa"), closeSoftKeyboard());


            DataInteraction appCompatTextView = onData(anything())
                    .inAdapterView(withText(is("Samantha Reed")));
            appCompatTextView.perform(click());


            onView(withId(R.id.fab)).check(matches(isDisplayed()));
            onView(withId(R.id.fab)).perform(click());

            SystemClock.sleep(4500);

            ViewInteraction viewGroup = onView(
                    allOf(withParent(withParent(withId(android.R.id.content))),
                            isDisplayed()));
            viewGroup.check(matches(isDisplayed()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
