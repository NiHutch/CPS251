package com.example.recycleviewwithintentproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recycleviewwithintentproject.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val dataReceived = intent.getStringExtra("input1")
        binding.textView.text = dataReceived ?: "No data received"

        val dataReceived2 = intent.getStringExtra("input2")
        binding.textView2.text = dataReceived2 ?: "No data received"

        val dataReceived3 = intent.getStringExtra("input3")

        binding.imageView.setImageResource(R.drawable.android_image_2)
        //= dataReceived3 ?: "No data received"

        binding.imageView.setOnClickListener {
            val returnIntent = Intent().apply {
                putExtra("response", "Response from SecondActivity")
            }
            setResult(RESULT_OK, returnIntent)
            finish()
        }

    }
}