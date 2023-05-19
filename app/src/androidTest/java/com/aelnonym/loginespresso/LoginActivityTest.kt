package com.aelnonym.loginespresso

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.PickerActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun testLoginSuccess() {
        Intents.init()

        Espresso.onView(withId(R.id.editTextUsername))
            .perform(ViewActions.replaceText("username"))

        Espresso.onView(withId(R.id.editTextPassword))
            .perform(ViewActions.replaceText("password"))

        Espresso.onView(withId(R.id.buttonLogin)).perform(ViewActions.click())

        Intents.intended(IntentMatchers.hasComponent(CadastroActivity::class.java.name))
    }

    @Test
    fun testDatePicker() {
        val ano = 1994
        val mes = 1
        val dia = 30

        Espresso.onView(withId(R.id.datePicker)).perform(PickerActions.setDate(ano, mes, dia))

        Espresso.onView(withId(R.id.dateButton)).perform(click())

        Espresso.onView(withId(R.id.dateButton)).check(matches(withText("$dia/$mes/$ano")))
    }
}
