package com.aelnonym.loginespresso

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var datePicker: DatePicker
    private lateinit var dateButton: Button
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.editTextUsername)
        passwordEditText = findViewById(R.id.editTextPassword)
        loginButton = findViewById(R.id.buttonLogin)
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            abrirTelaPrincipal()
        }
        datePicker = findViewById(R.id.datePicker)
        dateButton = findViewById(R.id.dateButton)

        dateButton.setOnClickListener {
            dateButton.text = datePicker.getString()
        }
    }

    fun DatePicker.getString(): String {
        return "$dayOfMonth/${month + 1}/$year"
    }

    private fun abrirTelaPrincipal() {
        val intent = Intent(this, CadastroActivity::class.java)
        startActivity(intent)
    }
}
