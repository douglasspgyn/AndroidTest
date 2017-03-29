package douglasspgyn.com.github.androidtest;

import android.content.res.Resources;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import junit.framework.TestCase;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import douglasspgyn.com.github.androidtest.ui.contact.ContactActivity;
import douglasspgyn.com.github.androidtest.utils.ContactMock;

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
public class ContactActivityInstrumentedTest extends TestCase {
    @Rule
    public ActivityTestRule<ContactActivity> activityTestRule = new ActivityTestRule<>(ContactActivity.class);

    @Test
    public void createContact() {
        int recyclerItemsBefore = ContactMock.getContacts().size();

        onView(withId(R.id.action_create_contact)).perform(click());
        onView(withId(R.id.create_contact_name)).perform(typeText("Test"), closeSoftKeyboard());
        onView(withId(R.id.create_contact_phone)).perform(typeText("123456789"), closeSoftKeyboard());
        onView(withId(R.id.save_contact)).perform(click());

        int recyclerItemsAfter = ContactMock.getContacts().size();

        assertEquals(recyclerItemsBefore, recyclerItemsAfter - 1);
    }

    @Test
    public void deleteContact() {
        int recyclerItemsBefore = ContactMock.getContacts().size();

        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, RowViewAction.clickChildViewWithId(R.id.contact_delete)));

        int recyclerItemsAfter = ContactMock.getContacts().size();

        assertEquals(recyclerItemsBefore, recyclerItemsAfter + 1);
    }

    public static class RowViewAction {
        public static ViewAction clickChildViewWithId(final int id) {
            return new ViewAction() {
                @Override
                public Matcher<View> getConstraints() {
                    return null;
                }

                @Override
                public String getDescription() {
                    return "Click on a child view with specified id.";
                }

                @Override
                public void perform(UiController uiController, View view) {
                    View v = view.findViewById(id);
                    v.performClick();
                }
            };
        }
    }

    @Test
    public void editContact() {
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.create_contact_name)).perform(typeText(" Edit"), closeSoftKeyboard());
        onView(withId(R.id.save_contact)).perform(click());

        onView(withRecyclerView(R.id.recycler_view).atPositionOnView(0, R.id.contact_name)).check(matches(withText("Contact 0 Edit")));
    }

    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {

        return new RecyclerViewMatcher(recyclerViewId);
    }

    public static class RecyclerViewMatcher {
        private final int recyclerViewId;

        public RecyclerViewMatcher(int recyclerViewId) {
            this.recyclerViewId = recyclerViewId;
        }

        public Matcher<View> atPosition(final int position) {
            return atPositionOnView(position, -1);
        }

        public Matcher<View> atPositionOnView(final int position, final int targetViewId) {

            return new TypeSafeMatcher<View>() {
                Resources resources = null;
                View childView;

                public void describeTo(Description description) {
                    String idDescription = Integer.toString(recyclerViewId);
                    if (this.resources != null) {
                        try {
                            idDescription = this.resources.getResourceName(recyclerViewId);
                        } catch (Resources.NotFoundException var4) {
                            idDescription = String.format("%s (resource name not found)",
                                    new Object[]{Integer.valueOf
                                            (recyclerViewId)});
                        }
                    }

                    description.appendText("with id: " + idDescription);
                }

                public boolean matchesSafely(View view) {

                    this.resources = view.getResources();

                    if (childView == null) {
                        RecyclerView recyclerView =
                                (RecyclerView) view.getRootView().findViewById(recyclerViewId);
                        if (recyclerView != null && recyclerView.getId() == recyclerViewId) {
                            childView = recyclerView.findViewHolderForAdapterPosition(position).itemView;
                        } else {
                            return false;
                        }
                    }

                    if (targetViewId == -1) {
                        return view == childView;
                    } else {
                        View targetView = childView.findViewById(targetViewId);
                        return view == targetView;
                    }

                }
            };
        }
    }
}
