package com.example.empowerherwellness

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PeriodsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_periods_detail) // Use the new layout

        val startQuizButton: Button = findViewById(R.id.start_quiz_button)
        startQuizButton.setOnClickListener {
            // Start the MenstrualCycleQuizActivity
            val intent = Intent(this, MenstrualCycleQuizActivity::class.java)
            startActivity(intent)
        }
    }
}

