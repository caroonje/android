package com.bitc.applayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.applayout.databinding.ActivityMain2Binding
import com.bitc.applayout.databinding.ActivityMainBinding

class SubActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSub2.setOnClickListener {
            val intent: Intent = Intent(this, SubActivity2::class.java)
            startActivity(intent)
        }

    }
}