package com.example.empowerherwellness

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecommendationsActivity : AppCompatActivity() {

    private lateinit var symptomText: TextView
    private lateinit var weightText: TextView
    private lateinit var heightText: TextView
    private lateinit var activityText: TextView
    private lateinit var dietText: TextView
    private lateinit var workoutText: TextView
    private lateinit var mealPlanText: TextView
    private lateinit var btnMeals: Button
    private lateinit var workoutVideosButton: Button // Corrected variable declaration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommendations)

        // Initialize Views
        symptomText = findViewById(R.id.text_symptom)
        weightText = findViewById(R.id.text_weight)
        heightText = findViewById(R.id.text_height)
        activityText = findViewById(R.id.text_activity)
        dietText = findViewById(R.id.text_diet)
        workoutText = findViewById(R.id.text_workout)
        mealPlanText = findViewById(R.id.text_meal_plan)
        btnMeals = findViewById(R.id.btn_meals)
        workoutVideosButton = findViewById(R.id.btn_workouts) // Corrected

        // Get Data from Intent
        val symptom = intent.getStringExtra("SYMPTOM")
        val weight = intent.getStringExtra("WEIGHT")
        val height = intent.getStringExtra("HEIGHT")
        val activityLevel = intent.getStringExtra("ACTIVITY")
        val dietPreference = intent.getStringExtra("DIET")

        // Set Data
        symptomText.text = "Symptom: $symptom"
        weightText.text = "Weight: $weight kg"
        heightText.text = "Height: $height cm"
        activityText.text = "Activity Level: $activityLevel"
        dietText.text = "Diet Preference: $dietPreference"

        // Set Recommended Workouts
        workoutText.text = getWorkoutRecommendation(symptom, activityLevel)

        // Set Recommended Meal Plan
        mealPlanText.text = getMealPlanRecommendation(dietPreference, symptom)

        // Button Click to Open MealsActivity
        btnMeals.setOnClickListener {
            val intent = Intent(this, MealsActivity::class.java)
            startActivity(intent)
        }

        // Button Click to Open WorkoutVideosActivity
        workoutVideosButton.setOnClickListener {
            val intent = Intent(this, WorkoutVideosActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getWorkoutRecommendation(symptom: String?, activityLevel: String?): String {
        return when (activityLevel) {  // Change from symptom to activityLevel
            "Very Active" -> "✅ Cardio (30 mins) + Strength Training (15 mins)"
            "Lightly Active" -> "✅ Yoga (20 mins) + Light Walking (30 mins)"
            "Moderately Active" -> "✅ Light Stretching + 10,000 Steps"
            else -> "✅ General: 30 mins Brisk Walk + Bodyweight Exercises"
        }
    }

    private fun getMealPlanRecommendation(diet: String?, symptom: String?): String {
        return when (diet) {
            "Vegetarian" -> "🥗 Leafy Greens, Lentils, Whole Grains"
            "Non-Vegetarian" -> "🍗 Lean Chicken, Fish, Eggs, Vegetables"
            "Vegan" -> "🌱 Tofu, Nuts, Whole Grains, Fruits"
            else -> "🥑 Balanced: Protein + Healthy Fats + Complex Carbs"
        }
    }
}
