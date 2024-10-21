package com.example.addnamesavedata

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel


    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val input = findViewById<EditText>(R.id.textInput)
        val button = findViewById<Button>(R.id.button)
        val results = findViewById<TextView>(R.id.results)

        results.text = viewModel.getResults()

        button.setOnClickListener {
            viewModel.addNames(input.text.toString())

            results.text = viewModel.getResults()


            input.setText("")

        }
    }
}