package com.android2.calculator3.tests;

import android.support.test.runner.AndroidJUnit4;

import com.android2.calculator3.Calculator;
import com.android2.calculator3.R;
import com.android2.calculator3.tests.Tools.ActivityRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class ErrorTests {
    @Rule
    public final ActivityRule<Calculator> main = new ActivityRule<>(Calculator.class);


    @Before
    public void cleanDisplay() throws Exception {
        onView(withId(R.id.del)).perform(longClick());
    }

    @After
    public void clean() throws Exception {
        onView(withId(R.id.clear)).perform(longClick());
    }

    /*
    Sprawdzenie czy kalkulator zwraca nieskończoność przy dzieleniu przez zero.
    Działanie: 9:0=∞
    Znak pomocniczy: ∞
     */
    @Test
    public void dividingByZeroShouldReturnInfinity() throws Exception {
        onView(withId(R.id.digit9)).perform(click());
        onView(withId(R.id.div)).perform(click());
        onView(withId(R.id.digit0)).perform(click());
        onView(withId(R.id.equal)).perform(click());
        onView(allOf(withText("∞"), isDescendantOfA(withId(R.id.display)))).check(matches(isDisplayed()));
    }

    /*
    Sprawdzenie czy kalkulator zwraca "Not a Number" przy dzieleniu zera przez zero.
    Działanie: 0:0=NaN
    Znak pomocniczy: ∞
     */
    @Test
    public void dividingZeroByZeroShouldReturnNaN() throws Exception {
        onView(withId(R.id.digit0)).perform(click());
        onView(withId(R.id.div)).perform(click());
        onView(withId(R.id.digit0)).perform(click());
        onView(withId(R.id.equal)).perform(click());
        onView(allOf(withText("NaN"), isDescendantOfA(withId(R.id.display)))).check(matches(isDisplayed()));
    }
}
