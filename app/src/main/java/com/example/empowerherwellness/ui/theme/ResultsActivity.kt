package com.example.empowerherwellness

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class ResultsActivity : AppCompatActivity() {

    private lateinit var calendarView: CalendarView
    private lateinit var textCycleLength: TextView
    private lateinit var buttonDecrease: Button
    private lateinit var buttonIncrease: Button
    private lateinit var buttonCalculate: Button
    private lateinit var textOvulationDate: TextView
    private lateinit var textFertileWindow: TextView
    private lateinit var textNextPeriod: TextView
    private lateinit var buttonSetReminder: Button

    private var selectedDate: Long = 0
    private var cycleLength: Int = 28 // Default cycle length

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        // Retrieve the result from the Intent
        val result = intent.getStringExtra("RESULT")

        // Display the result in the TextView
        val resultTextView: TextView = findViewById(R.id.result_text)
        resultTextView.text = result

        // Initialize views
        calendarView = findViewById(R.id.calendarView)
        textCycleLength = findViewById(R.id.text_cycle_length)
        buttonDecrease = findViewById(R.id.button_decrease)
        buttonIncrease = findViewById(R.id.button_increase)
        buttonCalculate = findViewById(R.id.button_calculate)
        textOvulationDate = findViewById(R.id.text_ovulation_date)
        textFertileWindow = findViewById(R.id.text_fertile_window)
        textNextPeriod = findViewById(R.id.text_next_period)


        // Set default cycle length display
        textCycleLength.text = "$cycleLength days"

        // Handle calendar selection
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)
            selectedDate = calendar.timeInMillis
        }

        // Handle cycle length increase
        buttonIncrease.setOnClickListener {
            if (cycleLength < 35) {
                cycleLength++
                textCycleLength.text = "$cycleLength days"
            }
        }

        // Handle cycle length decrease
        buttonDecrease.setOnClickListener {
            if (cycleLength > 21) {
                cycleLength--
                textCycleLength.text = "$cycleLength days"
            }
        }

        // Calculate ovulation and fertile window
        buttonCalculate.setOnClickListener {
            if (selectedDate != 0L) {
                val calendar = Calendar.getInstance()
                calendar.timeInMillis = selectedDate

                // Approximate ovulation date (14 days before next period)
                calendar.add(Calendar.DAY_OF_MONTH, 14)
                val ovulationDate = formatDate(calendar.time)
                textOvulationDate.text = ovulationDate

                // Fertile window (5 days before ovulation to ovulation day)
                calendar.add(Calendar.DAY_OF_MONTH, -5)
                val fertileStart = formatDate(calendar.time)
                calendar.add(Calendar.DAY_OF_MONTH, 5)
                val fertileEnd = formatDate(calendar.time)
                textFertileWindow.text = "$fertileStart - $fertileEnd"

                // Next period start date
                calendar.timeInMillis = selectedDate
                calendar.add(Calendar.DAY_OF_MONTH, cycleLength)
                val nextPeriod = formatDate(calendar.time)
                textNextPeriod.text = nextPeriod
            }
        }


    }

    private fun formatDate(date: Date): String {
        val sdf = SimpleDateFormat("d MMMM yyyy", Locale.getDefault())
        return sdf.format(date)
    }


}
