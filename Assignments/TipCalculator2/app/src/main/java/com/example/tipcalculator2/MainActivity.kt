package com.example.tipcalculator2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val amount = findViewById<EditText>(R.id.amount)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val results = findViewById<TextView>(R.id.results)
        val tipResult = findViewById<TextView>(R.id.tipResult)
        val tipResult2 = findViewById<TextView>(R.id.tipResult2)
        val tipResult3 = findViewById<TextView>(R.id.tipResult3)

        btnCalculate.setOnClickListener {
            val billAmount = amount.text.toString().toDoubleOrNull()
            if (billAmount != null) {
                val tipAmount = billAmount * 1.1
                val tipAmount2 = billAmount * 1.15
                val tipAmount3 = billAmount * 1.2
                val formatter = DecimalFormat("#,###.00")
                results.text = "The tips are as follows:"
                tipResult.text = "10% = ${formatter.format(tipAmount)}"
                tipResult2.text = "15% = ${formatter.format(tipAmount2)}"
                tipResult3.text = "20 % = ${formatter.format(tipAmount3)}"
            } else {
                results.text = "YOU MUST ENTER A BILL AMOUNT"
                tipResult.text = ""
                tipResult2.text = ""
                tipResult3.text = ""
            }
        }
    }
}