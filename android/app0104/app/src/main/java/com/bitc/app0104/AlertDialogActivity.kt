package com.bitc.app0104

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bitc.app0104.databinding.ActivityAlertDialogBinding
import com.bitc.app0104.databinding.ActivityMainBinding
import com.bitc.app0104.databinding.DialogCustomBinding

class AlertDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAlertDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBasicAlertDialog.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("기본 Alert Dialog")
                setMessage("안드로이드에서 제공하는 기본  Alert Dialog 사용하기")
                setPositiveButton("확인", null)
                show()
            }
        }

        binding.btnCustomDialog.setOnClickListener {
//            커스텀 다이얼 로그 화면으로 사용할 layout 파일을 viewBinding 을 사용하여 가져옴
            val dialogBinding = DialogCustomBinding.inflate(layoutInflater)
            AlertDialog.Builder(this).run {
                setTitle("Custom Alert Dialog")
//                setView() 를 사용하여 AlertDialog에 커스텀 다이얼 로그의 화면을 기본 화면 대신 사용함
                setView(dialogBinding.root)
                setPositiveButton("확인", null)
                show()
            }
        }
    }
}