package com.bitc.applayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.applayout.databinding.ActivityMain2Binding
import com.bitc.applayout.databinding.ActivitySub2Binding

class SubActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySub2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}