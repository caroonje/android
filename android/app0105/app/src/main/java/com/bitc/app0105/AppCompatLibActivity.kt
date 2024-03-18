package com.bitc.app0105

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.app0105.databinding.ActivityAppCompatLibBinding

class AppCompatLibActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAppCompatLibBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}