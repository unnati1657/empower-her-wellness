package com.example.empowerherwellness

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DoDontsActivity : AppCompatActivity() {

    private lateinit var questionInput: EditText
    private lateinit var askButton: Button
    private lateinit var responseText: TextView

    private val doDontsMap = mapOf(
        "can i eat fish" to "No, avoid raw or high-mercury fish!",
        "can i eat fruits" to "Yes, eating fruits is healthy during pregnancy.",
        "can i drink coffee" to "Limit caffeine intake to 200mg per day.",
        "can i smoke" to "No, smoking is harmful to both you and the baby.",
        "can i exercise" to "Yes, light exercises like walking or yoga are recommended.",
        "can i lift heavy objects" to "No, avoid lifting heavy objects to prevent strain.",
        "can i take medicine" to "Consult your doctor before taking any medication.",
        "can i sleep on my back" to "No, sleeping on your side is better for blood circulation.",
        "can i eat spicy food" to "Yes, but in moderation to avoid heartburn.",
        "can i eat sushi" to "No, avoid raw seafood to prevent infections.",
        "can i drink herbal tea" to "Some are safe, but consult your doctor before drinking.",
        "can i eat junk food" to "Occasionally, but prioritize a balanced diet.",
        "can i drink soft drinks" to "Limit intake, as they may contain high sugar or caffeine.",
        "can i dye my hair" to "Yes, but use ammonia-free dyes in a well-ventilated area.",
        "can i travel" to "Yes, but check with your doctor, especially in the third trimester.",
        "can i take hot baths" to "Avoid very hot baths or saunas to prevent overheating.",
        "can i sleep on my stomach" to "Not recommended as pregnancy progresses; sleep on your side instead.",
        "can i eat cheese" to "Yes, but avoid unpasteurized soft cheeses to prevent infections.",
        "can i use a sauna" to "No, high temperatures can be harmful during pregnancy.",
        "can i drink alcohol" to "No, alcohol can harm the baby’s development.",
        "alcohol" to "No",
        "fruits" to "Yes"

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dodonts)

        questionInput = findViewById(R.id.questionInput)
        askButton = findViewById(R.id.askButton)
        responseText = findViewById(R.id.responseText)

        askButton.setOnClickListener {
            val userQuestion = questionInput.text.toString().lowercase()
            val response = doDontsMap[userQuestion] ?: "Sorry, I don't have information on that."
            responseText.text = response
            responseText.visibility = TextView.VISIBLE
        }
    }
}
