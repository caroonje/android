package com.bitc.app0102

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.KeyEvent
import android.widget.Toast
import com.bitc.app0102.databinding.ActivityStopBinding
import com.bitc.app0102.databinding.ActivityViewEventBinding
import java.security.Key

class StopActivity : AppCompatActivity() {

    var initTime = 0L
    var pauseTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityStopBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.startButton.setOnClickListener{
            binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
            binding.chronometer.start()
            binding.stopButton.isEnabled =true
            binding.resetButton.isEnabled =true
            binding.startButton.isEnabled =false
        }
        binding.stopButton.setOnClickListener{
            pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            binding.stopButton.isEnabled =false
            binding.resetButton.isEnabled =true
            binding.startButton.isEnabled =true

        }
        binding.resetButton.setOnClickListener{
            pauseTime = 0L
            binding.resetButton.text="리셋"
            binding.chronometer.base = SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            binding.stopButton.isEnabled =false
            binding.resetButton.isEnabled =false
            binding.startButton.isEnabled =true
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode ===KeyEvent.KEYCODE_BACK){
            if (System.currentTimeMillis()-initTime > 3000){
                Toast.makeText(this,"종료하려면 한번 더 누르세요!",Toast.LENGTH_SHORT).show()
                initTime = System.currentTimeMillis()
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}