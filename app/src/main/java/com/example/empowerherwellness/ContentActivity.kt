package com.example.empowerherwellness

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.empowerherwellness.R

class ContentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content) // Use R class to reference layout

        val pregnancySection: LinearLayout = findViewById(R.id.pregnancy_section)
        val mentalHealthSection: LinearLayout = findViewById(R.id.mental_health_section)
        val periodsSection: LinearLayout = findViewById(R.id.periods_section)
        val pcodSection: LinearLayout = findViewById(R.id.pcod_section)
        val feedbackButton: Button = findViewById(R.id.feedback_button)

        pregnancySection.setOnClickListener {
            val intent = Intent(this, PregnancyDetailActivity::class.java)
            startActivity(intent)
        }

        mentalHealthSection.setOnClickListener {
            val intent = Intent(this, MentalHealthDetailActivity::class.java)
            startActivity(intent)
        }

        periodsSection.setOnClickListener {
            val intent = Intent(this, PeriodsDetailActivity::class.java)
            startActivity(intent)
        }

        pcodSection.setOnClickListener {
            val intent = Intent(this, UserDetailActivity::class.java)
            startActivity(intent)
        }

        feedbackButton.setOnClickListener {
            // Navigate to the FeedbackActivity
            val intent = Intent(this, FeedbackActivity::class.java)
            startActivity(intent)
        }
    }
}
