package com.example.empowerherwellness

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class PregnancyDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pregnancy_detail) // Make sure activity_pregnancy_detail.xml exists
    }

    fun openDoDontsActivity(view: android.view.View) {
        Log.d("PregnancyDetailActivity", "Do's and Don'ts clicked")
        val intent = Intent(this, DoDontsActivity::class.java)
        startActivity(intent)
    }
    fun openExerciseActivity(view: android.view.View) {
        val intent = Intent(this, ExerciseActivity::class.java)
        startActivity(intent)
    }
    // Open Baby Growth Stages Activity
    fun openBabyGrowthActivity(view: View) {
        val intent = Intent(this, BabyGrowthActivity::class.java)
        startActivity(intent)
    }
}