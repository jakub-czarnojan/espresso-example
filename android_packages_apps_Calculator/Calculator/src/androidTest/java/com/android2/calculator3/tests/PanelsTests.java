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
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class PanelsTests {
    @Rule
    public final ActivityRule<Calculator> main = new ActivityRule<>(Calculator.class);

    @After
    public void goBackToBasicPanel() throws Exception {
        pressBack();
    }

    @Test
     public void openEncodingPanel() throws Exception {
        onView(withId(R.id.panelswitch)).perform(swipeRight());
        onView(withText("Bin")).check(matches(isDisplayed()));
    }

    @Test
     public void openGraphPanel() throws Exception {
        onView(withId(R.id.panelswitch)).perform(swipeRight());
        onView(withId(R.id.panelswitch)).perform(swipeRight());
        onView(withId(R.id.graph)).check(matches(isDisplayed()));
    }

    @Test
    public void openFunctionPanel() throws Exception {
        onView(withId(R.id.panelswitch)).perform(swipeLeft());
        onView(withText("cos")).check(matches(isDisplayed()));
    }

    @Test
    public void openMatrixPanel() throws Exception {
        onView(withId(R.id.panelswitch)).perform(swipeLeft());
        onView(withId(R.id.panelswitch)).perform(swipeLeft());
        onView(withText("-Row")).check(matches(isDisplayed()));
    }
}
