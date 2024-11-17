package com.example.coroutinesproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinesproject.databinding.CardLayoutBinding


class RecyclerAdapter(private val viewModel: MainViewModel) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: CardLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(listOfNames: String) {
            binding.nameResults.text = listOfNames
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(viewModel.listOfNames[position])
    }

    override fun getItemCount(): Int = viewModel.listOfNames.size
}