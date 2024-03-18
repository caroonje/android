package com.bitc.test1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bitc.test1.databinding.ActivityMainBinding

//해당 화면에서 연산을 진행하는 파일
//Spring 프로젝트에서 Controller + Service 의 역할을 하는 파일

//AppCompatActivity 를 상속받아 사용
class MainActivity : AppCompatActivity() {
    // 상속받은 onCreate() 메소드를 오버라이딩 하여 사용
    override fun onCreate(savedInstanceState: Bundle?) {
//        부모 객체의 onCreate 메소드 실행
        super.onCreate(savedInstanceState)
//    setContentView(리소스) : UI 파일과 연동하여 화면에 출력하는 메소드
//    R : 안드로이드 프로젝트의 리소스 객체


//        setContentView(R.layout.activity_main)

//        layout 파일에서 각각의 태그를 id값을 통해서 찾아옴
////      layout 파일에서 TextView 를 찾아옴
//        val textView: TextView = findViewById(R.id.textView)
////      찾아온 TextView 의 속성 중 text 속성값을 변경
//        textView.text = "이제는 우리가 헤어져야 할 시간"


//        view binding 방식으로 layout 파일 자동 파싱
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.text = "view 바인딩으로 TextView의 text값 변경"

    }
}