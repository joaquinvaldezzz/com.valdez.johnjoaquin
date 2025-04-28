package com.valdez.johnjoaquin

import Email
import EmailAdapter
import FragmentAdapter
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)

        val btnLogout = findViewById<Button>(R.id.btn_logout)
        val tabLayout = findViewById<TabLayout>(R.id.dashboard_tabs)
        val viewPager = findViewById<ViewPager2>(R.id.view_pager)

        btnLogout.setOnClickListener {
            showDialog()
        }

        val fragmentAdapter = FragmentAdapter(this)
        viewPager.adapter = fragmentAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Inbox"
                1 -> "Sent"
                else -> null
            }
        }.attach()

        val listView = findViewById<ListView>(R.id.list_view)
        val emails = listOf(
            Email(
                "remalyn.cañete@gmail.com",
                "Meeting Reminder",
                "Don't forget about the meeting tomorrow at 10 AM."
            ),
            Email(
                "bert.chua_jr@gmail.com",
                "Project Update",
                "The project is on track for completion next week."
            ),
            Email("mariz.chua@gmail.com", "Lunch Plans", "Are we still on for lunch at noon?"),
            Email("mina.chua@gmail.com", "Invoice", "Your invoice for the last month is attached."),
            Email(
                "christal.sofia@gmail.com", "Newsletter", "Check out our latest updates and offers!"
            ),
        )
        val adapter = EmailAdapter(this, emails)
        listView.adapter = adapter

        val fab = findViewById<FloatingActionButton>(R.id.floating_action_button)
        fab.setOnClickListener {
            val intent = Intent(this, NewEmailActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showDialog() {
        val alertDialog = AlertDialog.Builder(this@DashboardActivity)
        alertDialog.setTitle("Are you sure?")
            .setMessage("Do you want to change the content of the TextView?")
            .setNegativeButton("No") { dialogInterface, _ ->
                dialogInterface.cancel()
            }.setPositiveButton("Yes") { _, _ ->
                val loginActivity = Intent(this, LoginActivity::class.java)
                startActivity(loginActivity)
                finish()
            }.setCancelable(false)
        alertDialog.create().show()
    }
}
