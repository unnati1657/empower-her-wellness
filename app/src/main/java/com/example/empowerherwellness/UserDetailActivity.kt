package com.example.empowerherwellness

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class UserDetailActivity : AppCompatActivity() {

    private lateinit var symptomsSpinner: Spinner
    private lateinit var hormonalIssuesSpinner: Spinner
    private lateinit var weightInput: EditText
    private lateinit var heightInput: EditText
    private lateinit var activitySpinner: Spinner
    private lateinit var dietSpinner: Spinner
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pcod_assessment) // Ensure this matches your XML file name

        // Initialize Views
        symptomsSpinner = findViewById(R.id.spinner_menstrual_irregularities)
        hormonalIssuesSpinner = findViewById(R.id.spinner_hormonal_skin_issues)
        weightInput = findViewById(R.id.edit_weight)
        heightInput = findViewById(R.id.edit_height)
        activitySpinner = findViewById(R.id.spinner_activity)
        dietSpinner = findViewById(R.id.spinner_diet)
        submitButton = findViewById(R.id.btn_submit)

        // Set Click Listener for Submit Button
        submitButton.setOnClickListener {
            validateAndProceed()
        }
    }

    private fun validateAndProceed() {
        val symptom = symptomsSpinner.selectedItem.toString()
        val hormonalIssue = hormonalIssuesSpinner.selectedItem.toString()
        val weightStr = weightInput.text.toString().trim()
        val heightStr = heightInput.text.toString().trim()
        val activityLevel = activitySpinner.selectedItem.toString()
        val dietPreference = dietSpinner.selectedItem.toString()

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields!", Toast.LENGTH_SHORT).show()
            return
        }

        val weight = weightStr.toDoubleOrNull()
        if (weight == null || weight !in 20.0..300.0) {
            Toast.makeText(this, "Enter valid weight (20-300 kg)", Toast.LENGTH_LONG).show()
            return
        }

        val height = heightStr.toDoubleOrNull()
        if (height == null || height !in 50.0..250.0) {
            Toast.makeText(this, "Enter valid height (50-250 cm)", Toast.LENGTH_LONG).show()
            return
        }

        // ✨ **Analyze user inputs and determine if PCOD is likely**
        val hasPCODRisk = checkPCODRisk(symptom, hormonalIssue, weight, activityLevel)

        // Show alert dialog with result
        showResultDialog(hasPCODRisk, symptom, hormonalIssue, weightStr, heightStr, activityLevel, dietPreference)
    }

    // 🔍 **Function to check PCOD risk based on inputs**
    private fun checkPCODRisk(symptom: String, hormonalIssue: String, weight: Double, activityLevel: String): Boolean {
        val highRiskSymptoms = listOf("Irregular Periods", "Skipped Periods", "Heavy Bleeding")
        val highRiskHormonalIssues = listOf("Acne", "Hair Fall", "Facial Hair Growth")

        return (symptom in highRiskSymptoms || hormonalIssue in highRiskHormonalIssues || weight >= 80.0 || activityLevel == "Lightly Active")
    }

    // ⚡ **Function to show AlertDialog with PCOD suggestion**
    private fun showResultDialog(
        hasPCODRisk: Boolean,
        symptom: String,
        hormonalIssue: String,
        weight: String,
        height: String,
        activityLevel: String,
        dietPreference: String
    ) {
        val message = if (hasPCODRisk) {
            "Based on your inputs, you may have a risk of PCOD. It is advisable to consult a doctor for further evaluation."
        } else {
            "Your inputs indicate a lower risk of PCOD, but maintaining a healthy lifestyle is essential."
        }

        AlertDialog.Builder(this)
            .setTitle("Health Assessment Result")
            .setMessage(message)
            .setPositiveButton("Get Recommendations") { _, _ ->
                // Proceed to next screen
                val intent = Intent(this, RecommendationsActivity::class.java).apply {
                    putExtra("SYMPTOM", symptom)
                    putExtra("HORMONAL_ISSUE", hormonalIssue)
                    putExtra("WEIGHT", weight)
                    putExtra("HEIGHT", height)
                    putExtra("ACTIVITY", activityLevel)
                    putExtra("DIET", dietPreference)
                }
                startActivity(intent)
            }
            .setNegativeButton("Close", null)
            .show()
    }
}
