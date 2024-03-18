package com.example.app1229

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app1229.databinding.ActivityConstraintAcitivityBinding

class ConstraintAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityConstraintAcitivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}