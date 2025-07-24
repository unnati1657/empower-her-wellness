package com.example.empowerherwellness

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MenstrualCycleQuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)  // Ensure this matches your XML file name

        val submitButton: Button = findViewById(R.id.submit_button)

        submitButton.setOnClickListener {
            val answers = collectAnswers()

            if (answers.contains("No answer selected")) {
                // Show a warning if not all questions are answered
                Toast.makeText(this, "Please answer all questions before submitting!", Toast.LENGTH_SHORT).show()
            } else {
                // Generate feedback based on answers
                val resultMessage = analyzeAnswers(answers)

                // Navigate to ResultsActivity
                val intent = Intent(this, ResultsActivity::class.java).apply {
                    putExtra("RESULT", resultMessage)
                }
                startActivity(intent)
            }
        }
    }

    /**
     * Collects selected answers from all RadioGroups in the layout.
     */
    private fun collectAnswers(): List<String?> {
        val questionGroups = listOf(
            findViewById<RadioGroup>(R.id.answers_group),
            findViewById<RadioGroup>(R.id.answers_group_2),
            findViewById<RadioGroup>(R.id.answers_group_3),
            findViewById<RadioGroup>(R.id.answers_group_4),
            findViewById<RadioGroup>(R.id.answers_group_5)
        )

        return questionGroups.map { group ->
            val selectedId = group.checkedRadioButtonId
            if (selectedId != -1) {
                findViewById<RadioButton>(selectedId).text.toString()
            } else {
                "No answer selected"
            }
        }
    }

    /**
     * Analyzes the collected answers and generates feedback.
     */
    private fun analyzeAnswers(answers: List<String?>): String {
        val feedback = mutableListOf<String>()

        if (answers[0]?.contains("More than 2 weeks ago") == true) {
            feedback.add("It seems your periods might be irregular.")
        }
        if (answers[1]?.contains("7 days or more") == true) {
            feedback.add("Your periods seem to last longer than usual. Consider tracking them.")
        }
        if (answers[2]?.contains("No, it's irregular") == true) {
            feedback.add("Your cycles appear irregular. Consulting a healthcare provider could help.")
        }
        if (answers[3]?.contains("Yes, often") == true) {
            feedback.add("You may experience severe PMS symptoms. Speak to a healthcare provider.")
        }
        if (answers[4]?.contains("tampons") == true || answers[4]?.contains("menstrual cup") == true) {
            feedback.add("Ensure safe usage of menstrual products to avoid health issues.")
        }

        return if (feedback.isEmpty()) {
            "Everything looks good! Keep tracking for better insights."
        } else {
            feedback.joinToString("\n")
        }
    }
}
