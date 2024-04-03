package dev.draft.mytestapp

import android.content.res.Resources
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleUITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun showsCorrectTextOnLoad() {
        onView(withId(R.id.textview_first))
            .check(matches(withText("This is the first fragment. Click on the button to navigate to the second fragment.")))
    }

    @Test
    fun switchesFragmentsCorrectly() {
        onView(withId(R.id.button_first)).perform(click())

        onView(withId(R.id.textview_second))
            .check(matches(withText("This is the second fragment. Click on the button to navigate back to the first fragment.")))
    }

    @Test
    fun switchesFragmentsBackCorrectly() {
        onView(withId(R.id.button_first)).perform(click())


        onView(withId(R.id.button_second)).perform(click())

        onView(withId(R.id.textview_first))
            .check(matches(withText("This is the first fragment. Click on the button to navigate to the second fragment.")))
    }
}