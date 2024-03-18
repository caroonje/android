package com.bitc.app0102

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.app0102.databinding.ActivityMainBinding
import com.bitc.app0102.databinding.ActivityViewEventBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lateinit var intent: Intent

        binding.btnViewEvent.setOnClickListener{
            intent = Intent(this,ViewEventActivity::class.java)
            startActivity(intent)
        }
        binding.StopWatch.setOnClickListener{
            intent = Intent(this,StopActivity::class.java)
            startActivity(intent)
        }
        binding.btnAndroidResource.setOnClickListener{
            intent = Intent(this,AndroidResourceActivity::class.java)
            startActivity(intent)
        }

        binding.btnLandView.setOnClickListener{
            intent = Intent(this,LandActivity::class.java)
            startActivity(intent)
        }
    }
}