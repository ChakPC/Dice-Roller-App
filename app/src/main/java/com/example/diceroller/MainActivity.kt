package com.example.diceroller

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

var x = false

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.TOP or Gravity.CENTER, 0, 200)
            toast.show()
            rollDice()
        }
        rollDice()
    }

    private fun rollDice() {
        val myDice = Dice(6)
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceRoll= myDice.roll()
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        val diceValue=diceRoll.toString()
        diceImage.contentDescription = diceRoll.toString()

        if(x) {
            val diceTextView: TextView = findViewById(R.id.textView2)
            diceTextView.text = diceValue
        }

        if(!x){x=true}
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
