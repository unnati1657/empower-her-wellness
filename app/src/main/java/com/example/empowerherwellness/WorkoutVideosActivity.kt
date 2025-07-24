package com.example.empowerherwellness

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WorkoutVideosActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var workoutAdapter: WorkoutVideoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_videos)

        recyclerView = findViewById(R.id.recycler_workout_videos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Sample Workout Videos List
        val workoutVideos = listOf(
            WorkoutVideo("HIIT Cardio Workout", "30 mins", R.drawable.hiit_workout, "https://www.youtube.com/watch?v=kZDvg92tTMc"),
            WorkoutVideo("Full-Body Strength Training", "15 mins", R.drawable.fullbody, "https://www.youtube.com/watch?v=2xPxOHXyBJk"),
            WorkoutVideo("Dance Cardio", "30 mins", R.drawable.dance_cardio, "https://www.youtube.com/watch?v=xJrs_QX7Vr4"),
            WorkoutVideo("Beginner-Friendly Strength Training", "15 mins", R.drawable.beginner_exer, "https://www.youtube.com/watch?v=stx7PYeoMao") ,
                    WorkoutVideo("Yoga", "20 mins", R.drawable.yoga, "https://www.youtube.com/watch?v=s-1vMbAgYWU"),
        WorkoutVideo("Light Stretching", "20 mins", R.drawable.stretching, "https://www.youtube.com/watch?v=lNPaDikuRhU"),

        )

        // Set Adapter
        workoutAdapter = WorkoutVideoAdapter(this, workoutVideos)
        recyclerView.adapter = workoutAdapter
    }
}
