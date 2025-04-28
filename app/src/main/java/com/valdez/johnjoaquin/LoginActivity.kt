package com.valdez.johnjoaquin

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ScrollView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var layout: ScrollView
    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        sharedPreferences = getSharedPreferences("userPreferences", MODE_PRIVATE)

        layout = findViewById(R.id.activity_login)
        editTextUsername = findViewById(R.id.edittext_username)
        editTextPassword = findViewById(R.id.edittext_password)
        buttonLogin = findViewById(R.id.button_login)

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()
            val storedUsername = sharedPreferences.getString("username", null)
            val storedPassword = sharedPreferences.getString("password", null)

            if (username == storedUsername && password == storedPassword) {
                Toast.makeText(this, "Logged in successfully", Toast.LENGTH_LONG).show()

                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)

                finish()
            } else {
                val snackBar =
                    Snackbar.make(layout, "Incorrect username or password", Snackbar.LENGTH_LONG)
                snackBar.setAction("Try again") {
                    editTextUsername.setText("")
                    editTextPassword.setText("")
                }.show()
            }
        }
    }
}
