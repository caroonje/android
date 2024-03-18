package com.bitc.app1227

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

//        layout 파일에서 지정한 태그의 id를 기반으로 하여 해당 태그를 불러옴
//        제네릭 방식으로 지정한 ID를 가지고 있는 태그를 가져옴
        val button1 = findViewById<Button>(R.id.btn1)
        val button2 = findViewById<Button>(R.id.btn2)
//        변수에 태그 타입을 지정하고 findViewById()를 통해서 지정한 ID를 가진 태그를 가져옴
        val button3:Button = findViewById(R.id.btn3)
        val button4:Button = findViewById(R.id.btn4)

//        가져온 태그에 클릭이벤트 설정
        button1.setOnClickListener {
            button1.text="버튼 1"
        }
        button2.setOnClickListener {
            button2.text="버튼 2"
        }
        button3.setOnClickListener {
            button3.text="버튼 3"
        }
        button4.setOnClickListener {
            button4.text="버튼 4"
        }

    }
}