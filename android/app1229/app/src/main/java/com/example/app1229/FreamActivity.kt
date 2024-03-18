package com.example.app1229

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.app1229.databinding.ActivityFreamBinding

class FreamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityFreamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener{
            binding.btn1.visibility = View.INVISIBLE
            binding.Img1.visibility = View.VISIBLE
        }

        binding.Img1.setOnClickListener{
            binding.Img1.visibility = View.INVISIBLE
            binding.btn1.visibility = View.VISIBLE

        }


    }
}