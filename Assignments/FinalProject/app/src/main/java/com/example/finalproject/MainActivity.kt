package com.example.finalproject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter: ContactListAdapter? = null
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listenerSetup()
        observerSetup()
        recyclerSetup()
    }

    private fun clearFields() {
        binding.contactID.text = ""
        binding.contactName.setText("")
        binding.contactNum.setText("")
    }

    private fun listenerSetup() {
        binding.addButton.setOnClickListener {
            val name = binding.contactName.text.toString()
            val quantity = binding.contactNum.text.toString()

            if (name != "" && quantity != "") {
                val contact = Contact(name, Integer.parseInt(quantity))
                viewModel.insertContact(contact)
                clearFields()
            } else {
                this.showToast("Incomplete information")
            }

        }
        binding.findButton.setOnClickListener {
            viewModel.findContact(
                binding.contactName.text.toString())
        }

//        binding.itemImage.setOnClicklistener {
//
//        }
        binding.ascendButton.setOnClickListener {
            viewModel.ascendContact()
            




        }

        binding.descendButton.setOnClickListener {
            viewModel.deleteContact(binding.contactName.text.toString())
            clearFields()
        }
    }

    private fun observerSetup() {
        viewModel.getAllContacts()?.observe(this) { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        }

        viewModel.ascendContact()?.observe(this) { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        }

        viewModel.getSearchResults().observe(this) { contacts ->
            contacts?.let {
                if (it.isNotEmpty()) {
                    adapter?.setContactList(it)
                    adapter?.notifyDataSetChanged()
                    clearFields()

                } else {
                    this.showToast("There are no contacts that match your search")
                }
            }
        }
//        viewModel.ascendContact().observe(this) { contacts ->
//            contacts?.let {
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.contact_list_item)
        binding.contactRecycler.layoutManager = LinearLayoutManager(this)
        binding.contactRecycler.adapter = adapter
    }

}