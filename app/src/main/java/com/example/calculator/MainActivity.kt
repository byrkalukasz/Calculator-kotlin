package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var screen : TextView? =null
    private var screen1 : TextView? =null

    private var button0 : Button? = null
    private var button1 : Button? = null
    private var button2 : Button? = null
    private var button3 : Button? = null
    private var button4 : Button? = null
    private var button5 : Button? = null
    private var button6 : Button? = null
    private var button7 : Button? = null
    private var button8 : Button? = null
    private var button9 : Button? = null
    private var buttonAdd : Button? = null
    private var buttonMinus : Button? = null
    private var buttonMultiply : Button? = null
    private var buttonDevide : Button? = null
    private var buttonClear : Button? = null
    private var coma : Button? = null
    private var buttonClearAll : Button? = null
    private var Equal : Button? = null
    private var number : String? = ""
    private var helper : String? = ""
    private var operation : String? = ""
    private var helper2: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        screen = findViewById(R.id.screen)
        screen1 = findViewById(R.id.screen1)

        buttonAdd = findViewById(R.id.buttonAdd)
        buttonMinus = findViewById(R.id.buttonMinus)
        buttonMultiply = findViewById(R.id.buttonMultiply)
        buttonDevide = findViewById(R.id.buttonDevide)
        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        buttonClear = findViewById(R.id.buttonClear)
        buttonClearAll = findViewById(R.id.clearall)
        Equal = findViewById(R.id.Equal)
        coma = findViewById(R.id.coma)

        buttonAdd?.setOnClickListener(this)
        buttonMinus?.setOnClickListener(this)
        buttonMultiply?.setOnClickListener(this)
        buttonDevide?.setOnClickListener(this)
        coma?.setOnClickListener(this)
        button0?.setOnClickListener(this)
        button1?.setOnClickListener(this)
        button2?.setOnClickListener(this)
        button3?.setOnClickListener(this)
        button4?.setOnClickListener(this)
        button5?.setOnClickListener(this)
        button6?.setOnClickListener(this)
        button7?.setOnClickListener(this)
        button8?.setOnClickListener(this)
        button9?.setOnClickListener(this)
        buttonClear?.setOnClickListener(this)
        buttonClearAll?.setOnClickListener(this)
        Equal?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val test = v?.getId()
        when(test)
        {
            R.id.button0 -> number += "0"
            R.id.button1 -> number += "1"
            R.id.button2 -> number += "2"
            R.id.button3 -> number += "3"
            R.id.button4 -> number += "4"
            R.id.button5 -> number += "5"
            R.id.button6 -> number += "6"
            R.id.button7 -> number += "7"
            R.id.button8 -> number += "8"
            R.id.button9 -> number += "9"
            R.id.coma -> number += "."
            R.id.buttonClear -> number = ""
            R.id.clearall -> {
                number = ""
                operation = ""
                helper = ""
                helper2 = ""
            }
            R.id.buttonAdd ->{
                if(number == "" && operation != ""){
                    operation = "+"
                }
                else{
                if(helper == "")
                {
                    helper = number.toString()
                    number = ""
                    operation = "+"
                }
                else if(helper != null )
                {
                    if(number == "")
                    {
                        helper2 = helper
                        helper = (helper?.toFloat()!! + helper?.toFloat()!!).toString()
                    }
                    else
                    {
                        helper2 = number
                        number = (helper?.toFloat()!! + number?.toFloat()!!).toString()
                        helper = ""
                    }
                }
                }
            }
            R.id.buttonMinus -> {
                if (number == "" && operation != "") {
                    operation = "-"
                } else {
                    if (helper == "") {
                        helper = number.toString()
                        number = ""
                        operation = "-"
                    } else if (helper != null) {
                        if (number == "") {
                            helper2 = helper
                            helper = (helper?.toFloat()!! - helper?.toFloat()!!).toString()
                        } else {
                            helper2 = number
                            number = (helper?.toFloat()!! - number?.toFloat()!!).toString()
                            helper = ""
                        }
                    }
                }
            }
            R.id.buttonDevide ->{
                if(number == "" && operation != ""){
                    operation = "/"}
                else{
                if(helper == "")
                {
                    helper = number.toString()
                    number = ""
                    operation = "/"
                }
                else if(helper != null )
                {
                    if(number == "")
                    {
                        helper2 = helper
                        helper = (helper?.toFloat()!! / helper?.toFloat()!!).toString()
                    }
                    else
                    {
                        helper2 = number
                        number = (helper?.toFloat()!! / number?.toFloat()!!).toString()
                        helper = ""
                    }
                }
            }
            }
            R.id.buttonMultiply ->{
                if(number == "" && operation != ""){
                    operation = "*"}
                else{
                if(helper == "")
                {
                    helper = number.toString()
                    number = ""
                    operation = "*"
                }
                else if(helper != null )
                {
                    if(number == "")
                    {
                        helper2 = helper
                        helper = (helper?.toFloat()!! * helper?.toFloat()!!).toString()
                    }
                    else
                    {
                        helper2 = number
                        number = (helper?.toFloat()!! * number?.toFloat()!!).toString()
                        helper = ""
                    }
                }
            }}
            R.id.Equal -> {
                when(operation)
                {
                    "+" -> {
                        if(number == "" || helper == "")
                        {
                            Toast.makeText(this, "Wprowadz dane do wykonania obliczenia",Toast.LENGTH_LONG).show()
                        }else{
                        helper2 = number
                        number = (helper?.toFloat()!! + number?.toFloat()!!).toString() }}
                    "-" -> {
                        if(number == "")
                        {Toast.makeText(this, "Wprowadz dane do wykonania obliczenia",Toast.LENGTH_LONG).show()}else{
                            helper2 = number
                            number = (helper?.toFloat()!! - number?.toFloat()!!).toString()
                        } }
                    "*" -> {
                        if(number == "")
                        {
                            Toast.makeText(this, "Wprowadz dane do wykonania obliczenia",Toast.LENGTH_LONG).show()
                        }else{
                        helper2 = number
                        number = (helper?.toFloat()!! * number?.toFloat()!!).toString() }}
                    "/" -> {
                        if(number == "")
                        {
                            Toast.makeText(this, "Wprowadz dane do wykonania obliczenia",Toast.LENGTH_LONG).show()
                        }else{
                        helper2 = number
                        number = (helper?.toFloat()!! / number?.toFloat()!!).toString() }}
                    else -> Toast.makeText(this, "Wprowadz dane do wykonania obliczenia",Toast.LENGTH_LONG).show()
                }
            }
        }
        screen?.text = number
        var screen1String = helper + operation + helper2
        screen1?.text = screen1String
    }
}