package com.example.coroutinesproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinesproject.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private var job: Job? = null
    private lateinit var binding: ActivityMainBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val input = findViewById<EditText>(R.id.textInput)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            if (job == null || job?.isActive != true) {
                job = CoroutineScope(Dispatchers.Main).launch {
                    viewModel.addNames(input.text.toString())
                    adapter?.notifyDataSetChanged()
                }
            }
        }
        adapter = RecyclerAdapter(viewModel)
        binding.recyclerView.adapter = adapter
    }
}