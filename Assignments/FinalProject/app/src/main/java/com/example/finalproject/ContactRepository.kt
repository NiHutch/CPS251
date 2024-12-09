package com.example.finalproject

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ContactRepository (application: Application) {
    val searchResults = MutableLiveData<List<Contact>>()
    private var contactDao: ContactDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allContacts: LiveData<List<Contact>>?
    val ascendResults: LiveData<List<Contact>>?

    init {
        val db: ContactRoomDatabase? = ContactRoomDatabase.getDatabase(application)
        contactDao = db?.contactDao()
        allContacts = contactDao?.getAllContacts()
        ascendResults = contactDao?.ascendContact()
    }

    fun insertContact(newcontact: Contact) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newcontact)
        }
    }

    private fun asyncInsert(contact: Contact) {
        contactDao?.insertContact(contact)
    }

    fun deleteContact(name: String) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(name)
        }
    }

    private fun asyncDelete(name: String) {
        contactDao?.deleteContact(name)
    }

    fun findContact(name: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }

    //USES THE DEFERRED TO RETURN THE VALUES TO THE AWAIT OF THE FIND CONTACT
    private fun asyncFind(name: String): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO) {
            //NOTICE THIS IS A RETURN HERE BECAUSE IT IS A SELECT QUERY IT RETURNS A VALUE
            return@async contactDao?.findContact(name)
        }

//    fun ascendContact() {
//        coroutineScope.launch(Dispatchers.IO) {
//            ascendResults.value = asyncAscend().await()        }
//    }
//
//    private fun asyncAscend(): Deferred<LiveData<List<Contact>>?> =
//        coroutineScope.async(Dispatchers.IO) {
//        return@async contactDao?.ascendContact()
//    }

}