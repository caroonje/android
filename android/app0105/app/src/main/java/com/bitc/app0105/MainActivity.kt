package com.bitc.app0105

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.app0105.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTheme.setOnClickListener{
            val intent=Intent(this,ThemeActivity::class.java)
            startActivity(intent)
        }
        binding.btnToolbar.setOnClickListener{
            val intent=Intent(this,ToolbarActivity::class.java)
            startActivity(intent)
        }
        binding.btnAppCompatLib.setOnClickListener{
            val intent=Intent(this,AppCompatLibActivity::class.java)
            startActivity(intent)
        }
        binding.btnFragment.setOnClickListener{
            val intent=Intent(this,FragmentActivity::class.java)
            startActivity(intent)
        }
    }
}