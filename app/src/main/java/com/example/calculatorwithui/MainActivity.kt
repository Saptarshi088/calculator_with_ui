package com.example.calculatorwithui

import android.icu.util.Output
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.calculatorwithui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var canAddOperation = false
    private var canAddDecimal = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun acAction(view: View) {
        binding.inputUser.text = ""
        binding.outputText.text = ""
    }

    fun backSpaceAction(view: View) {
        val len = binding.inputUser.length()
        if (len > 0) {
            binding.inputUser.text = binding.inputUser.text.subSequence(0, len - 1)
        }
    }

    fun numberAction(view: View)
    {
        if (view is Button) {
            if (view.text == ".") {
                if (canAddDecimal)
                    binding.inputUser.append(view.text)
                canAddDecimal = false
            } else {
                binding.inputUser.append(view.text)
            }
        }
        canAddOperation = true
    }


    fun operatorAction(view: View) {
        if(view is Button && canAddOperation){
            binding.inputUser.append(view.text)
            canAddOperation=false
            canAddDecimal=true
        }
    }

    fun equalsAction(view: View) {
        binding.outputText.text=calculateResults()
    }

    private fun calculateResults(): String {
        val digitsOperator=digitOperators()
        if(digitsOperator.isEmpty())return ""
        val timeDivision=timeDivisionCalculate(digitsOperator)
        if(timeDivision.isEmpty()) return " "


        val result=addSubstractCalculate(timeDivision)
        return result.toString()
    }

    private fun addSubstractCalculate(passedList: MutableList<Any>): Float{
        var result = passedList[0] as Float
        for(i in passedList.indices){
            if(passedList[i] is Char && i!=passedList.lastIndex ){
                val operator = passedList[i]
                val nextDigit = passedList[i+1] as Float
                val prevDigit = passedList[i-1] as Float
                if(operator == '+' ){
                    result+=nextDigit
                }
                if(operator == '-' ){
                    result-=nextDigit
                }
            }
        }

        return result
    }

    private fun timeDivisionCalculate(passedList: MutableList<Any>): MutableList<Any> {
        var list=passedList
        while(list.contains('X')||list.contains('/')){
            list =calcTimesDiv(list)
        }
        return list
    }

    private fun calcTimesDiv(passedList: MutableList<Any>): MutableList<Any> {
        val newList = mutableListOf<Any>()
        var restartIndex=passedList.size
        for(i in passedList.indices){
            if(passedList[i] is Char && i!=passedList.lastIndex && i<restartIndex){
                val operator = passedList[i]
                val prevDigit = passedList[i-1] as Float
                val nextDigit = passedList[i+1] as Float
                when(operator){
                    'X'->{
                        newList.add(prevDigit*nextDigit)
                        restartIndex=i+1
                    }
                    '/'->{
                        newList.add(prevDigit/nextDigit)
                        restartIndex=i+1
                    }
                    else->{
                        newList.add(prevDigit)
                        newList.add(operator)
                    }
                }
            }
            if(i>restartIndex){
                newList.add(passedList[i])
            }
        }

        return newList
    }

    private fun digitOperators():MutableList<Any>{
        val list=mutableListOf<Any>()
        var curentDigit=""
        for(character in binding.inputUser.text){
            if(character.isDigit() || character=='.'){
                curentDigit+=character
            }
            else{
                list.add(curentDigit.toFloat())
                curentDigit=""
                list.add(character)
            }
        }
        if(curentDigit!=""){
            list.add(curentDigit.toFloat())
        }

        return list
    }
}














