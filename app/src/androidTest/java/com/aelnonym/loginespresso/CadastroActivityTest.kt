package com.aelnonym.loginespresso

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class CadastroActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(CadastroActivity::class.java)

    @Test
    fun testCadastroSuccess() {
        Intents.init()

        Espresso.onView(ViewMatchers.withId(R.id.editTextUsername))
            .perform(ViewActions.replaceText("username"))

        Espresso.onView(ViewMatchers.withId(R.id.editTextPassword))
            .perform(ViewActions.replaceText("password"))

        Espresso.onView(ViewMatchers.withId(R.id.buttonRegister)).perform(ViewActions.click())

        Intents.intended(hasComponent(LoginActivity::class.java.name))
    }
}
