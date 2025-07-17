package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var firstDice: ImageView
    private lateinit var secondDice: ImageView
    private lateinit var winnerTextView: TextView
    private lateinit var historyButton: Button

    private val random = Random()
    private val gameHistory = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dice = intArrayOf(
            R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,
            R.drawable.dice4, R.drawable.dice5, R.drawable.dice6
        )

        button = findViewById(R.id.rollButton)
        firstDice = findViewById(R.id.firstDice)
        secondDice = findViewById(R.id.secondDice)
        winnerTextView = findViewById(R.id.winnerTextView)
        historyButton = findViewById(R.id.historyButton)

        button.setOnClickListener {
            val num1 = random.nextInt(6)
            val num2 = random.nextInt(6)

            firstDice.setImageResource(dice[num1])
            secondDice.setImageResource(dice[num2])

            val result = when {
                num1 > num2 -> "Player A Wins"
                num1 < num2 -> "Player B Wins"
                else -> "Draw"
            }

            winnerTextView.text = result


            val entry = "A: ${num1 + 1}, B: ${num2 + 1} → $result"
            gameHistory.add(entry)
        }

        historyButton.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            intent.putStringArrayListExtra("history", gameHistory)
            startActivity(intent)
        }
    }
}
