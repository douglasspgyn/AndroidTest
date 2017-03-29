package douglasspgyn.com.github.androidtest;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import douglasspgyn.com.github.androidtest.ui.unitconverter.UnitConverterActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Douglas on 29/03/17.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class UnitConverterInstrumentedTest extends TestCase {
    @Rule
    public ActivityTestRule<UnitConverterActivity> activityTestRule = new ActivityTestRule<>(UnitConverterActivity.class);

    @Test
    public void convertToCEmpty() {
        onView(withId(R.id.convert_to_c)).perform(click());
        onView(withId(R.id.temperature_converted)).check(matches(withText("")));
    }

    @Test
    public void convertToCText() {
        onView(withId(R.id.temperature_to_convert)).perform(typeText("aaa"), closeSoftKeyboard());
        onView(withId(R.id.convert_to_c)).perform(click());
        onView(withId(R.id.temperature_converted)).check(matches(withText("")));
    }

    @Test
    public void convertToC() {
        onView(withId(R.id.temperature_to_convert)).perform(typeText("50"), closeSoftKeyboard());
        onView(withId(R.id.convert_to_c)).perform(click());
        onView(withId(R.id.temperature_converted)).check(matches(withText(activityTestRule.getActivity().getString(R.string.temperature_c, "10.00"))));
    }

    @Test
    public void convertToFEmpty() {
        onView(withId(R.id.convert_to_f)).perform(click());
        onView(withId(R.id.temperature_converted)).check(matches(withText("")));
    }

    @Test
    public void convertToFText() {
        onView(withId(R.id.temperature_to_convert)).perform(typeText("aaa"), closeSoftKeyboard());
        onView(withId(R.id.convert_to_f)).perform(click());
        onView(withId(R.id.temperature_converted)).check(matches(withText("")));
    }

    @Test
    public void convertToF() {
        onView(withId(R.id.temperature_to_convert)).perform(typeText("50"), closeSoftKeyboard());
        onView(withId(R.id.convert_to_f)).perform(click());
        onView(withId(R.id.temperature_converted)).check(matches(withText(activityTestRule.getActivity().getString(R.string.temperature_f, "122.00"))));
    }
}
