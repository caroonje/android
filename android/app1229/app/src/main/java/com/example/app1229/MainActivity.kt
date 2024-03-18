package com.example.app1229

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app1229.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lateinit var intent: Intent

        binding.btnRelative1.setOnClickListener{
            intent = Intent(this,Sub1::class.java)
            startActivity(intent)
        }

        binding.btnFreame.setOnClickListener{
            intent = Intent(this,FreamActivity::class.java)
            startActivity(intent)
        }

        binding.btnGrid.setOnClickListener{
            intent = Intent(this,GridActivity::class.java)
            startActivity(intent)
        }
        binding.btnConstraint.setOnClickListener{
            intent = Intent(this,ConstraintAcitivity::class.java)
            startActivity(intent)
        }
        binding.btnPhone.setOnClickListener{
            intent = Intent(this,PhoneActivity::class.java)
            startActivity(intent)
        }
        binding.btnTouch.setOnClickListener{
            intent = Intent(this,TouchActivity::class.java)
            startActivity(intent)
        }
    }
}