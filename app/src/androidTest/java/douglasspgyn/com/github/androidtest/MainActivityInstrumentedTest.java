package douglasspgyn.com.github.androidtest;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import douglasspgyn.com.github.androidtest.ui.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Douglas on 29/03/17.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentedTest extends TestCase {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void openUnitConverterTest() {
        onView(withId(R.id.unit_converter)).perform(click());
        onView(withId(R.id.temperature_to_convert)).check(matches(isDisplayed()));
    }

    @Test
    public void openAndCloseUnitConverterTest() {
        onView(withId(R.id.unit_converter)).perform(click());
        onView(withId(R.id.temperature_to_convert)).perform(pressBack());
        onView(withId(R.id.unit_converter)).check(matches(isDisplayed()));
    }

    @Test
    public void openContactsTest() {
        onView(withId(R.id.contact_list)).perform(click());
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()));
    }

    @Test
    public void openAndCloseContactsTest() {
        onView(withId(R.id.contact_list)).perform(click());
        onView(withId(R.id.recycler_view)).perform(pressBack());
        onView(withId(R.id.contact_list)).check(matches(isDisplayed()));
    }
}
