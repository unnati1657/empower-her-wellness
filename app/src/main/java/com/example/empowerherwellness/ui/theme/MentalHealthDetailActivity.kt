package com.example.empowerherwellness

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MentalHealthDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mental_health_detail)

        // Set up the Explore More button using findViewById
        val exploreMoreButton: Button = findViewById(R.id.btn_explore_more)
        exploreMoreButton.setOnClickListener {
            val intent = Intent(this, SymptomInfoActivity::class.java)
            startActivity(intent) // This will open the SymptomInfoActivity
        }

        // Set up the Songs button to open SongActivity
        val songsButton: Button = findViewById(R.id.btn_songs)
        songsButton.setOnClickListener {
            val intent = Intent(this, SongActivity::class.java)
            startActivity(intent) // This will open the SongActivity (which uses activity_song_categories.xml)
        }

        // Set up the Quotes button to open QuotesActivity
        val quotesButton = findViewById<Button>(R.id.btn_quotes)
        quotesButton.setOnClickListener {
            val intent = Intent(this, QuotesActivity::class.java)
            startActivity(intent)
        }

        // Find the "Videos Stash" button
        val videosStashButton = findViewById<Button>(R.id.btn_videos_stash)
        videosStashButton.setOnClickListener {
            val intent = Intent(this, RelaxationActivity::class.java) // Open RelaxationActivity
            startActivity(intent)
        }

    }
}
