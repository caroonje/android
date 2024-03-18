package com.bitc.app0109

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import com.bitc.app0109.databinding.ActivityServiceBinding
import java.sql.Connection

class ServiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initEvent()
    }

    private fun initEvent(){
        binding.btnServiceStart.setOnClickListener {
            Log.d("KSC","서비스 시작 버튼 클릭")
            val startIntent = Intent(this,TimeService::class.java)
            startService(startIntent)
        }
        binding.btnServiceStop.setOnClickListener {
            Log.d("KSC","서비스 종료 버튼 클릭")
            val stopIntent = Intent(this,TimeService::class.java)
            stopService(stopIntent)

        }
    }
}