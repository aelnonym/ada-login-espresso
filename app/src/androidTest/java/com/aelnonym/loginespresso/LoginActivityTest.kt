package com.aelnonym.loginespresso

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
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

        Espresso.onView(ViewMatchers.withId(R.id.editTextUsername))
            .perform(ViewActions.replaceText("username"))

        Espresso.onView(ViewMatchers.withId(R.id.editTextPassword))
            .perform(ViewActions.replaceText("password"))

        Espresso.onView(ViewMatchers.withId(R.id.buttonLogin)).perform(ViewActions.click())

        Intents.intended(IntentMatchers.hasComponent(CadastroActivity::class.java.name))
    }
}
