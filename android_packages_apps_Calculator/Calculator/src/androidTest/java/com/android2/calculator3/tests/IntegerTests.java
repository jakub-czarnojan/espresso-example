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
public class IntegerTests {
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
    Sprawdzenie czy kalkulator poprawnie dodaje cyfry zmiennoprzecinkowe.
    Działanie: 9.3+3.5=12.8
     */
    @Test
    public void shouldAddTwoFloatNumebers() throws Exception {
        onView(withId(R.id.digit9)).perform(click());
        onView(withId(R.id.dot)).perform(click());
        onView(withId(R.id.digit3)).perform(click());
        onView(withId(R.id.plus)).perform(click());
        onView(withId(R.id.digit3)).perform(click());
        onView(withId(R.id.dot)).perform(click());
        onView(withId(R.id.digit5)).perform(click());
        onView(withId(R.id.equal)).perform(click());
        onView(allOf(withText("12.8"), isDescendantOfA(withId(R.id.display)))).check(matches(isDisplayed()));
    }

    /*
    Sprawdzenie czy kalkulator poprawnie odejmuje cyfry zmiennoprzecinkowe.
    Działanie: 9.3-3.5=5.8
     */
    @Test
    public void shouldSubstractTwoFloatNumebers() throws Exception {
        onView(withId(R.id.digit9)).perform(click());
        onView(withId(R.id.dot)).perform(click());
        onView(withId(R.id.digit3)).perform(click());
        onView(withId(R.id.minus)).perform(click());
        onView(withId(R.id.digit3)).perform(click());
        onView(withId(R.id.dot)).perform(click());
        onView(withId(R.id.digit5)).perform(click());
        onView(withId(R.id.equal)).perform(click());
        onView(allOf(withText("5.8"), isDescendantOfA(withId(R.id.display)))).check(matches(isDisplayed()));
    }

    /*
    Sprawdzenie czy kalkulator poprawnie mnoży cyfry zmiennoprzecinkowe.
    Działanie: 9.3*3.5=32.55
     */
    @Test
    public void shouldMultiplyTwoFloatNumebers() throws Exception {
        onView(withId(R.id.digit9)).perform(click());
        onView(withId(R.id.dot)).perform(click());
        onView(withId(R.id.digit3)).perform(click());
        onView(withId(R.id.mul)).perform(click());
        onView(withId(R.id.digit3)).perform(click());
        onView(withId(R.id.dot)).perform(click());
        onView(withId(R.id.digit5)).perform(click());
        onView(withId(R.id.equal)).perform(click());
        onView(allOf(withText("32.55"), isDescendantOfA(withId(R.id.display)))).check(matches(isDisplayed()));
    }

    /*
    Sprawdzenie czy kalkulator poprawnie dzieli cyfry zmiennoprzecinkowe.
    Działanie: 9.3:3.5=2.65714286
     */
    @Test
    public void shouldDivideTwoFloatNumebers() throws Exception {
        onView(withId(R.id.digit9)).perform(click());
        onView(withId(R.id.dot)).perform(click());
        onView(withId(R.id.digit3)).perform(click());
        onView(withId(R.id.div)).perform(click());
        onView(withId(R.id.digit3)).perform(click());
        onView(withId(R.id.dot)).perform(click());
        onView(withId(R.id.digit5)).perform(click());
        onView(withId(R.id.equal)).perform(click());
        onView(allOf(withText("2.65714286"), isDescendantOfA(withId(R.id.display)))).check(matches(isDisplayed()));
    }
}
