
package com.example.empowerherwellness
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class ExerciseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preg)

        // Button for Exercise Video 1
        val exerciseVideo1: Button = findViewById(R.id.exerciseVideo1)
        exerciseVideo1.setOnClickListener {
            openYouTubeVideo("https://www.youtube.com/watch?v=Ia6dNwVs1M8") // Replace with your video link
        }

        // Button for Exercise Video 2
        val exerciseVideo2: Button = findViewById(R.id.exerciseVideo2)
        exerciseVideo2.setOnClickListener {
            openYouTubeVideo("https://www.youtube.com/watch?v=QU7ssIGEbog") // Replace with your video link
        }

        // Button for Exercise Video 3 (You can add more buttons similarly)
        val exerciseVideo3: Button = findViewById(R.id.exerciseVideo3)
        exerciseVideo3.setOnClickListener {
            openYouTubeVideo("https://www.youtube.com/watch?v=XhqntqSGKsc")
        }
        val exerciseVideo4: Button = findViewById(R.id.exerciseVideo4)
        exerciseVideo3.setOnClickListener {
            openYouTubeVideo("https://www.youtube.com/watch?v=dUoPxu6mnM0")
        }
        val exerciseVideo5: Button = findViewById(R.id.exerciseVideo5)
        exerciseVideo3.setOnClickListener {
            openYouTubeVideo("https://www.youtube.com/watch?v=qkhLev3bKd0")
        }
        val exerciseVideo6: Button = findViewById(R.id.exerciseVideo6)
        exerciseVideo3.setOnClickListener {
            openYouTubeVideo("https://www.youtube.com/watch?v=xJ-c6gQPX_s")
        }
    }

    // Helper function to open YouTube video link
    private fun openYouTubeVideo(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        intent.setPackage("com.google.android.youtube") // This tries to open in YouTube app first
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent) // Open in YouTube app
        } else {
            // If YouTube app is not installed, open in a web browser
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
    }
}
