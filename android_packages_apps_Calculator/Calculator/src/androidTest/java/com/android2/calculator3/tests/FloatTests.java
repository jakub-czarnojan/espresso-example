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
public class FloatTests {
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
    Sprawdzenie czy kalkulator poprawnie dodaje cyfry całkowite.
    Działanie: 9+3=12
     */
    @Test
    public void shouldAddTwoIntegerNumebers() throws Exception {
        onView(withId(R.id.digit9)).perform(click());
        onView(withId(R.id.plus)).perform(click());
        onView(withId(R.id.digit3)).perform(click());
        onView(withId(R.id.equal)).perform(click());
        onView(allOf(withText("12"), isDescendantOfA(withId(R.id.display)))).check(matches(isDisplayed()));
    }

    /*
    Sprawdzenie czy kalkulator poprawnie odejmuje cyfry całkowite.
    Działanie: 9-3=6
     */
    @Test
    public void shouldSubstractTwoIntegerNumebers() throws Exception {
        onView(withId(R.id.digit9)).perform(click());
        onView(withId(R.id.minus)).perform(click());
        onView(withId(R.id.digit3)).perform(click());
        onView(withId(R.id.equal)).perform(click());
        onView(allOf(withText("6"), isDescendantOfA(withId(R.id.display)))).check(matches(isDisplayed()));
    }

    /*
    Sprawdzenie czy kalkulator poprawnie mnoży cyfry całkowite.
    Działanie: 9*3=27
     */
    @Test
    public void shouldMultiplyTwoIntegerNumebers() throws Exception {
        onView(withId(R.id.digit9)).perform(click());
        onView(withId(R.id.mul)).perform(click());
        onView(withId(R.id.digit3)).perform(click());
        onView(withId(R.id.equal)).perform(click());
        onView(allOf(withText("27"), isDescendantOfA(withId(R.id.display)))).check(matches(isDisplayed()));
    }

    /*
    Sprawdzenie czy kalkulator poprawnie dzieli cyfry całkowite.
    Działanie: 9:3=3
     */
    @Test
    public void shouldDivideTwoIntegerNumebers() throws Exception {
        onView(withId(R.id.digit9)).perform(click());
        onView(withId(R.id.div)).perform(click());
        onView(withId(R.id.digit3)).perform(click());
        onView(withId(R.id.equal)).perform(click());
        onView(allOf(withText("3"), isDescendantOfA(withId(R.id.display)))).check(matches(isDisplayed()));
    }
}
