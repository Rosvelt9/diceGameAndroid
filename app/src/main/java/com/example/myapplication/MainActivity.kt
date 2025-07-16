package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var firstDice: ImageView
    private lateinit var secondDice: ImageView
    private lateinit var winnerTextView: TextView
    private val random = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // array ro shevinaxot kamatlebi
        val dice = intArrayOf(
            R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,
            R.drawable.dice4, R.drawable.dice5, R.drawable.dice6
        )

        // referencebi
        button = findViewById(R.id.rollButton)
        firstDice = findViewById(R.id.firstDice)
        secondDice = findViewById(R.id.secondDice)
        winnerTextView = findViewById(R.id.winnerTextView)

        // click
        button.setOnClickListener {
            // randoms
            val num1 = random.nextInt(6)
            val num2 = random.nextInt(6)


            firstDice.setImageResource(dice[num1])
            secondDice.setImageResource(dice[num2])

            winnerTextView.text = if (num1 > num2) {
                "Player A Wins"
            } else if (num1 < num2) {
                "Player B Wins"
            } else {
                "Draw"
            }
        }
    }
}