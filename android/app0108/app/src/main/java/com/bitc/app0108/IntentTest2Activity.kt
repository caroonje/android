package com.bitc.app0108

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.bitc.app0108.databinding.ActivityIntentTest2Binding

class IntentTest2Activity: AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = ActivityIntentTest2Binding.inflate(layoutInflater)
    setContentView(binding.root)

//    intent 불러오기
    val intentTest2 = intent
//    intent에 저장된 내용 가져오기
    val value3 = intentTest2.getStringExtra("param3")
    binding.textViewParam3.text = value3
    
    binding.btnIntentTest2Exit.setOnClickListener {
//      사용자가 입력한 데이터 가져오기
      val userText = binding.editTextUserText.text

//      intent에 데이터 추가
      intentTest2.putExtra("resultParam", userText.toString())
//      응답 결과 코드를 intent에 설정
      setResult(RESULT_OK, intentTest2)

//      현재 액티비티 종료
      finish()
    }
  }
}










