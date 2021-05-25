package com.example.exerciciomvvm.itemRegisterPage

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.hasErrorText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.exerciciomvvm.R
import com.example.exerciciomvvm.mainPage.MainActivity
import org.hamcrest.Matchers.nullValue
import org.junit.After
import org.junit.Test
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ItemRegisterTest {

    @get : Rule
    var activityRule = ActivityScenarioRule(ItemRegister::class.java)

    @Before
    fun setup(){
        Intents.init()
    }

    @Test
    fun errorPrice(){
        onView(withId(R.id.productName)).perform(typeText("Maça"), closeSoftKeyboard())

        onView(withId(R.id.registerButton)).perform(click())

        onView(withId(R.id.productName)).check(matches(hasErrorText(nullValue(String::class.java))))
        onView(withId(R.id.value)).check(matches(hasErrorText("Campo Obrigatorio")))
    }

    @Test
    fun errorProduct(){
        onView(withId(R.id.value)).perform(typeText("12245" ), closeSoftKeyboard())

        onView(withId(R.id.registerButton)).perform(click())

        onView(withId(R.id.value)).check(matches(hasErrorText(nullValue(String::class.java))))
        onView(withId(R.id.productName)).check(matches(hasErrorText("Campo Obrigatorio")))
    }

    @Test
    fun intentRelease(){

        onView(withId(R.id.value)).perform(typeText("12245"), closeSoftKeyboard())
        onView(withId(R.id.productName)).perform(typeText("Maça"), closeSoftKeyboard())

        onView(withId(R.id.registerButton)).perform(click())

        intended(hasComponent(MainActivity::class.java.name))
    }

    @After
    fun after(){
        Intents.release()
    }
}