package com.example.addnamesavedata

import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel () {
    private var results: String = ""
    private val listOfNames = mutableListOf<String>()

    fun addNames(input: String) {

        if (input != "") {
            listOfNames.add(input + "\n")
            results = listOfNames.toString().replace("[", " ").replace("]", "").replace(",", "")
        } else {
            results = "No Name Entered"
        }
    }
    fun getResults(): String {
        return results
    }
}