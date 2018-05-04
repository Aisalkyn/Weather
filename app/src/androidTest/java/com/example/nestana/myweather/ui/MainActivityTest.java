package com.example.nestana.myweather.ui;


import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.nestana.myweather.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception
    {

    }
    @Test
    public void mainActivityTest() {
        Espresso.onView(withId(R.id.editText)).perform(typeText("Bishkek"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.searchWeatherBtn)).perform(click());
        Espresso.onView(withId(R.id.city_name)).check(matches(withText("Bishkek")));

    }

    @After
    public void tearDown() throws  Exception{

    }
}
