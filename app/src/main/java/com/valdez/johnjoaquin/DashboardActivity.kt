package com.valdez.johnjoaquin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
        val fab = findViewById<FloatingActionButton>(R.id.floating_action_button)
        fab.setOnClickListener {
            val intent = Intent(this, NewEmailActivity::class.java)
            startActivity(intent)
        }
    }
}