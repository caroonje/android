package com.bitc.app0112

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.app0112.databinding.ActivityMainBinding
import com.bitc.app0112.databinding.ItemMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnPhoneState.setOnClickListener {
            val intent: Intent = Intent(this, PhoneStateActivity::class.java)
            startActivity(intent)
        }

        binding.btnVolley.setOnClickListener {
            val intent: Intent = Intent(this, VolleyActivity::class.java)
            startActivity(intent)
        }

        binding.btnGlide.setOnClickListener {
            val intent: Intent = Intent(this, GlideActivity::class.java)
            startActivity(intent)
        }

        binding.btnNews.setOnClickListener {
            val intent: Intent = Intent(this, ItemMainBinding::class.java)
            startActivity(intent)
        }
    }


}