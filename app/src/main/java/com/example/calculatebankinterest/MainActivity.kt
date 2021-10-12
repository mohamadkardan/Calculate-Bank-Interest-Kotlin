package com.example.calculatebankinterest

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

//    lateinit allows you to make it non nullable,
//    but not assign it a value at the time that your Activity's constructor is called
//    'calculate?' This will make a regular call if btnProceed is a non-null value, and do nothing otherwise.

    private lateinit var edittextPrice: EditText
    private lateinit var edittextMonth: EditText
    private lateinit var edittextPercent: EditText
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        onClick()
    }

    private fun initializeViews() {
        edittextPrice = findViewById(R.id.edittext_price)
        edittextMonth = findViewById(R.id.edittextMonth)
        edittextPercent = findViewById(R.id.edittextPercent)
        calculateButton = findViewById(R.id.buttonCalculate)
    }

    private fun onClick() {
        val formatter: DecimalFormat = NumberFormat.getInstance() as DecimalFormat
        formatter.applyPattern("###,###")

        calculateButton.setOnClickListener {
            val formattedString: String = formatter.format(calculateInterest())
            Toast.makeText(this, " مقدار سود ماهانه شما: $formattedString", LENGTH_LONG).show()
        }
    }

    private fun calculateInterest(): Long {
        val price = edittextPrice.text.toString().toLong()
        val month = edittextMonth.text.toString().toLong()
        val percent = edittextPercent.text.toString().toLong()

        return (price * (month * 30) * percent) / 36500
    }

}