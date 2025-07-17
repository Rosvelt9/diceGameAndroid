package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history_activity)

        val backButton: Button = findViewById(R.id.backButton)
        val historyTextView: TextView = findViewById(R.id.historyTextView)
        val scoreTextView: TextView = findViewById(R.id.scoreTextView)

        backButton.setOnClickListener {
            finish()
        }

        val history = intent.getStringArrayListExtra("history")

        if (history != null && history.isNotEmpty()) {
            historyTextView.text = history.joinToString("\n")

            var aWins = 0
            var bWins = 0
            var draws = 0

            for (entry in history) {
                when {
                    entry.contains("Player A Wins") -> aWins++
                    entry.contains("Player B Wins") -> bWins++
                    entry.contains("Draw") -> draws++
                }
            }

            scoreTextView.text = "Score: A - $aWins, B - $bWins, Draws - $draws"
        } else {
            historyTextView.text = "No history yet."
            scoreTextView.text = "Score: A - 0, B - 0, Draws - 0"
        }
    }
}
