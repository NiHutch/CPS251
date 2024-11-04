package com.example.recycleviewproject

import androidx.lifecycle.ViewModel


class MainViewModel :ViewModel () {
    public var titles : Array <String> =arrayOf("a", "b", "c", "d", "e", "f", "g", "h")

    public var details : Array <String> =arrayOf("a", "b", "c", "d", "e", "f", "g", "h")

    public var images : IntArray =intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)



    fun populateTitles(data: Data) {
        titles = data.titles.copyOf()
        for (element in titles ) {
            var randomNum = (0..7).random()
            titles [randomNum] = element

        }
    }

    fun populateDetails(data: Data) {
        details = data.details.copyOf()
        for (element in details ) {
            var randomNum = (0..7).random()
            details [randomNum] = element

        }
    }

    fun populateImages(data: Data) {
        images = data.images.copyOf()
        for (element in images ) {
            var randomNum = (0..7).random()
            images [randomNum] = element

        }
    }


}