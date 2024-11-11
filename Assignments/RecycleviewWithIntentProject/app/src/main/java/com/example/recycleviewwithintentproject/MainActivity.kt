package com.example.recycleviewwithintentproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.recycleviewwithintentproject.databinding.ActivityMainBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val data = Data()
        viewModel.populateTitles(data)
        viewModel.populateDetails(data)
        viewModel.populateImages(data)

        adapter = RecyclerAdapter(viewModel)
        binding.recyclerView.adapter = adapter


    }


}