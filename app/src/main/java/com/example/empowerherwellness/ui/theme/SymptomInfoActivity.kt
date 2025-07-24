package com.example.empowerherwellness

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

data class SymptomInfo(
    val description: String,
    val precautions: String,
    val treatment: String,
    val imageResId: Int // Add image resource ID
)

class SymptomInfoActivity : AppCompatActivity() {

    private lateinit var symptoms: List<String>
    private lateinit var symptomInfoMap: Map<String, SymptomInfo>
    private lateinit var symptomInfoText: TextView
    private lateinit var precautionsTitle: TextView
    private lateinit var precautionsText: TextView
    private lateinit var treatmentTitle: TextView
    private lateinit var treatmentText: TextView
    private lateinit var symptomImage: ImageView
    private lateinit var learnMoreButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symptom_info)

        // Initialize views
        symptomInfoText = findViewById(R.id.symptom_info_text)
        precautionsTitle = findViewById(R.id.precautions_title)
        precautionsText = findViewById(R.id.precautions_text)
        treatmentTitle = findViewById(R.id.treatment_title)
        treatmentText = findViewById(R.id.treatment_text)
        symptomImage = findViewById(R.id.symptom_image)
        learnMoreButton = findViewById(R.id.learn_more_button)

        // Prepare the symptoms and their corresponding info
        symptoms = listOf("Headache", "Fever", "Cough", "Fatigue", "Nausea")
        symptomInfoMap = mapOf(
            "Headache" to SymptomInfo(
                description = "Information about headaches: A headache is pain or discomfort in the head, scalp, or neck. Serious causes of headaches are rare. Most people with headaches can feel much better by making lifestyle changes, learning ways to relax, and sometimes by taking medicines. The major areas of the brain have one or more specific functions.",
                precautions = "Avoid stress, stay hydrated, and maintain a regular sleep schedule.",
                treatment = "Over-the-counter pain relievers such as ibuprofen or acetaminophen.",
                imageResId = R.drawable.head_ache
            ),
            "Fever" to SymptomInfo(
                description = "Information about fever: Fever is the temporary increase in the body's temperature in response to a disease or illness. A child has a fever when the temperature is at or above one of these levels: 100.4°F (38°C) measured in the bottom (rectally) 99.5°F (37.5°C) measured in the mouth (orally).",
                precautions = "Stay hydrated and rest as much as possible.",
                treatment = "Use antipyretics like acetaminophen or ibuprofen to reduce fever.",
                imageResId = R.drawable.fever
            ),
            "Cough" to SymptomInfo(
                description = "Information about coughs: Coughing is an important reflex that helps protect your airway and lungs against irritants. Coughing can propel air and particles out of your lungs and throat at speeds close to 50 miles per hour.",
                precautions = "Stay hydrated and avoid irritants like smoke.",
                treatment = "Use cough suppressants or expectorants as needed.",
                imageResId = R.drawable.cough
            ),
            "Fatigue" to SymptomInfo(
                description = "Information about fatigue: Fatigue is a feeling of tiredness or lack of energy that is not relieved by rest. It can be a symptom of a medical condition or related to lifestyle factors.",
                precautions = "Ensure adequate sleep and manage stress.",
                treatment = "Consult a doctor if fatigue persists; lifestyle changes may be necessary.",
                imageResId = R.drawable.fatigue
            ),
            "Nausea" to SymptomInfo(
                description = "Information about nausea: Nausea is feeling an urge to vomit. It is often called 'being sick to your stomach.'",
                precautions = "Avoid strong odors and eat light, bland foods.",
                treatment = "Over-the-counter medications like meclizine or ginger supplements.",
                imageResId = R.drawable.nausea
            )
        )

        // Set up the Spinner
        val spinner: Spinner = findViewById(R.id.symptoms_spinner)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, symptoms)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Set a listener for the Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedSymptom = symptoms[position]
                // Update the TextView with symptom info
                val info = symptomInfoMap[selectedSymptom]

                // Display information
                symptomInfoText.text = info?.description
                precautionsTitle.visibility = View.VISIBLE
                precautionsText.text = info?.precautions
                precautionsText.visibility = View.VISIBLE
                treatmentTitle.visibility = View.VISIBLE
                treatmentText.text = info?.treatment
                treatmentText.visibility = View.VISIBLE

                // Display image if available
                symptomImage.setImageResource(info?.imageResId ?: 0)
                symptomImage.visibility = View.VISIBLE

                // Show the Learn More button
                learnMoreButton.visibility = View.VISIBLE

                // Handle Learn More button click
                learnMoreButton.setOnClickListener {
                    // Define the Wikipedia URLs for each symptom
                    val symptomWikiUrls = mapOf(
                        "Headache" to "https://en.wikipedia.org/wiki/Headache",
                        "Fever" to "https://en.wikipedia.org/wiki/Fever",
                        "Cough" to "https://en.wikipedia.org/wiki/Cough",
                        "Fatigue" to "https://en.wikipedia.org/wiki/Fatigue",
                        "Nausea" to "https://en.wikipedia.org/wiki/Nausea"
                    )

                    // Get the corresponding URL for the selected symptom
                    val url = symptomWikiUrls[selectedSymptom]

                    // Open the Wikipedia page in a browser
                    if (url != null) {
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(url)
                        startActivity(intent)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Hide all information when nothing is selected
                symptomInfoText.text = ""
                precautionsTitle.visibility = View.GONE
                precautionsText.visibility = View.GONE
                treatmentTitle.visibility = View.GONE
                treatmentText.visibility = View.GONE
                symptomImage.visibility = View.GONE
                learnMoreButton.visibility = View.GONE
            }
        }
    }
}
