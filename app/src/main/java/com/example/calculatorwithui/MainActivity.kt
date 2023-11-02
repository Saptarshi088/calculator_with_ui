package com.example.calculatorwithui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val userInput=findViewById<TextView>(R.id.inputUser)
        val displayOutput=findViewById<TextView>(R.id.output)
        val AC=findViewById<Button>(R.id.acButton)
        val DEL=findViewById<Button>(R.id.delButton)
        val DIVISION=findViewById<Button>(R.id.divButton)
        val SEVEN=findViewById<Button>(R.id.sevenButton)
        val EIGHT =findViewById<Button>(R.id.eightButton)
        val NINE=findViewById<Button>(R.id.nineButton)
        val FOUR=findViewById<Button>(R.id.fourButton)
        val FIVE = findViewById<Button>(R.id.fiveButton)
        val SIX =findViewById<Button>(R.id.sixButton)
        val ONE=findViewById<Button>(R.id.oneButton)
        val TWO =findViewById<Button>(R.id.twoButton)
        val THREE =findViewById<Button>(R.id.threeButton)
        val MINUS=findViewById<Button>(R.id.minusButton)
        val MUL=findViewById<Button>(R.id.mulButton)
        val PLUS=findViewById<Button>(R.id.plusButton)
        val DECIMAL=findViewById<Button>(R.id.decimalButton)
        val ZERO=findViewById<Button>(R.id.zeroButton)
        val EQUALS=findViewById<Button>(R.id.equalsButton)
        val PERCENT=findViewById<Button>(R.id.percentButton)

    }
}