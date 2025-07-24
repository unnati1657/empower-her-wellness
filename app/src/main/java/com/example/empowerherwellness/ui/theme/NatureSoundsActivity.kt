package com.example.empowerherwellness

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class NatureSoundsActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nature_sounds_menu)
    }

    // Function to play water sound
    fun playWaterSound(view: View) {
        playSound(R.raw.waterflow)
    }

    // Function to play rain sound
    fun playRainSound(view: View) {
        playSound(R.raw.rain)  // Make sure rain.mp3 exists in res/raw
    }

    // Function to play birds sound
    fun playBirdsSound(view: View) {
        playSound(R.raw.chirpingbird)  // Make sure birds.mp3 exists in res/raw
    }

    // Function to play drops sound
    fun playDropsSound(view: View) {
        playSound(R.raw.water)  // Make sure drops.mp3 exists in res/raw
    }
    fun playBreezeSound(view: View) {
        playSound(R.raw.breeze)  // Make sure breeze.mp3 exists in res/raw
    }
    fun playThunderSound(view: View) {
        playSound(R.raw.thunder)  // Make sure thunder.mp3 exists in res/raw
    }

    // Function to play a given sound
    private fun playSound(soundResId: Int) {
        // Stop and release any currently playing sound
        mediaPlayer?.release()

        // Initialize and play new sound
        mediaPlayer = MediaPlayer.create(this, soundResId)
        mediaPlayer?.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release() // Release MediaPlayer when activity is destroyed
    }
}
