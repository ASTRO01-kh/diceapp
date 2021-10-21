package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bellybutton: Button = findViewById(R.id.rull)
        bellybutton.setOnClickListener { rollDice() }
    }
    private fun rollDice() {
        val dice = Dice(6)
        val ruling = dice.roll()
        val luckier = 1
        val diceimage: ImageView = findViewById(R.id.imageView)
        val value: TextView = findViewById(R.id.textView)
        val drawableResource =when(ruling){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }
        diceimage.setImageResource(drawableResource)
        value.text = ruling.toString()
        val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)//you can use .show()
        toast.show()
        if (ruling==luckier){
            Toast.makeText(this,"you Win^-^",Toast.LENGTH_SHORT).show()
        }
    }
}

class Dice(private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}