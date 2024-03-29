package com.bitc.applayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.applayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lateinit var intent:Intent


        binding.btnLinearLayout.setOnClickListener {
             intent = Intent(this, SubActivity1::class.java)
            startActivity(intent)
        }

        binding.btnLinearLayout2.setOnClickListener {
             intent = Intent(this, SubActivity2::class.java)
            startActivity(intent)
        }

    }
}