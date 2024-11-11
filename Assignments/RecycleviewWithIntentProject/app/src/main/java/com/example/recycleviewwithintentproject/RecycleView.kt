package com.example.recycleviewwithintentproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewwithintentproject.databinding.CardLayoutBinding
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter(private val viewModel: MainViewModel) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: CardLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            // Set the click listener on the itemView
            itemView.setOnClickListener { v ->
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) { // Check if position is valid

                    val intent = Intent(v.getContext(), SecondActivity::class.java).apply {
                        putExtra("input1", binding.itemTitle.text.toString())
                        putExtra("input2", binding.itemDetail.text.toString())
                        putExtra("input3", R.drawable.android_image_3)            }
                    v.getContext().startActivity(intent);
                }
            }
        }

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