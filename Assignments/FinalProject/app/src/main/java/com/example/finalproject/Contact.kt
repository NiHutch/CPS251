package com.example.finalproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contacts")
class Contact {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contactId")
    var id: Int = 0

    @ColumnInfo(name = "contactName")
    var contactName: String? = null

    var quantity: Int = 0


    constructor() {}


    constructor(contactname: String, quantity: Int) {
        this.contactName = contactname
        this.quantity = quantity
    }
}