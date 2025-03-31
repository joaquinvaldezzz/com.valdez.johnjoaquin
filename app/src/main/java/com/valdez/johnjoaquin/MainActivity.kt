package com.valdez.johnjoaquin

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("userPreferences", MODE_PRIVATE)

        editTextUsername = findViewById(R.id.edittext_firstname)
        editTextPassword = findViewById(R.id.edittext_password)
        buttonSignUp = findViewById(R.id.button_signup)

        buttonSignUp.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                val editor = sharedPreferences.edit()

                editor.putString("username", username)
                editor.putString("password", password)
                editor.apply()

                Toast.makeText(this, "Signed up successfully", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)

                finish()
            }
        }
    }
}
