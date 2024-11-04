package com.example.recycleviewproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewproject.databinding.CardLayoutBinding

class RecyclerAdapter(private val viewModel: MainViewModel) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: CardLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(title: String, detail: String, imageResId: Int) {
            binding.itemImage.setImageResource(imageResId)
            binding.itemTitle.text = title
            binding.itemDetail.text = detail
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(viewModel.titles[position], viewModel.details[position], viewModel.images[position])
    }

    override fun getItemCount(): Int = viewModel.titles.size
}