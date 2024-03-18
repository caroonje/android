package com.example.app1229

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app1229.databinding.ActivityMain2Binding
import com.example.app1229.databinding.ActivityMainBinding

class Sub1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}