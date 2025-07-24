package com.example.empowerherwellness

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.airbnb.lottie.LottieAnimationView
import androidx.appcompat.app.AppCompatActivity

class RelaxationActivity : AppCompatActivity() {
    private lateinit var meditationAnimation: LottieAnimationView
    private lateinit var relaxBreathingAnimation: LottieAnimationView
    private var isMeditationVisible = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relaxation)

        meditationAnimation = findViewById(R.id.animation_meditation)
        val animationExercise = findViewById<LottieAnimationView>(R.id.animation_exercise)
        relaxBreathingAnimation = findViewById(R.id.animation_relax_breathing)
        val toggleAnimationButton = findViewById<Button>(R.id.toggle_animation_button)
        val playNatureSoundsButton = findViewById<Button>(R.id.play_nature_sounds_button)

        // Toggle Animations
        toggleAnimationButton.setOnClickListener {
            when {
                meditationAnimation.visibility == View.VISIBLE -> {
                    meditationAnimation.visibility = View.GONE
                    meditationAnimation.pauseAnimation()  // Pause meditation animation

                    relaxBreathingAnimation.visibility = View.VISIBLE
                    relaxBreathingAnimation.playAnimation()  // Start relax breathing animation
                }
                relaxBreathingAnimation.visibility == View.VISIBLE -> {
                    relaxBreathingAnimation.visibility = View.GONE
                    relaxBreathingAnimation.pauseAnimation()  // Pause relax breathing animation

                    animationExercise.visibility = View.VISIBLE
                    animationExercise.playAnimation()  // Start exercise animation
                }
                animationExercise.visibility == View.VISIBLE -> {
                    animationExercise.visibility = View.GONE
                    animationExercise.pauseAnimation()  // Pause exercise animation

                    meditationAnimation.visibility = View.VISIBLE
                    meditationAnimation.playAnimation()  // Start meditation animation
                }
            }
        }


        // Play Nature Sounds button click
        playNatureSoundsButton.setOnClickListener {
            val intent = Intent(this, NatureSoundsActivity::class.java)
            startActivity(intent)
        }
    }
}
