package com.example.addnamesavedata

import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModel


class MainViewModel :ViewModel () {

    private var results: String = ""
    private val listOfNames = mutableListOf<String>()

    fun addNames(input: String) {
        val names = input

        if (names != "") {
            listOfNames.add(names + "\n")
            results = listOfNames.toString().replace("[", " ").replace("]", "").replace(",", "")
        } else {
            results = "No Name Entered"
        }




    }
    fun getResults(): String {
        return results
    }
}