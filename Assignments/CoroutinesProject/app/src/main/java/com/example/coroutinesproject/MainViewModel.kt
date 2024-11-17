package com.example.coroutinesproject

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*


class MainViewModel :ViewModel () {
    private var entry: String = ""
    private var time = 0L
    val listOfNames = arrayListOf<String>()

    suspend fun addNames(input: String) {

        time = (1..10).random().toLong()*1000
        delay(time)
        entry = "The name is " + input + " and the delay is " + time + " milliseconds"
        listOfNames.add(entry)
    }
}