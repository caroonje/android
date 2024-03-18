package com.example.app1229

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.example.app1229.databinding.ActivityTouchBinding

class TouchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityTouchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.view.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_MOVE -> {
//                    해당 태그에 터치 이벤트를 정의해야 x,y,rawX,rawY의 값이 서로 다르게 표시 됨
//                    x, y 이벤트가 발생한 태그의 x, y 좌표를 출력
//                    rawX, rawY : 전체 화면에서 이벤트가 발생한 x ,y 좌표를 출력
                    Log.d(
                        "Roonje_view",
                        "Touch move event x : ${event.x}, y: ${event.y}, rawX: ${event.rawX}, rawY: ${event.rawY}"
                    )
                }
            }
            true
        }

//      뒤로가기 이벤트 메소드를 미리 만들어 놓고 콜백 메소드로 등록하는 방식
//        onBackPressedDispatcher.addCallback(this,callback)

//      익명 메소드(뒤로가기 이벤트 메소드)를 콜백 메소드를 등록하는 방식
        onBackPressedDispatcher.addCallback(this,object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                Log.d("ksc_back","뒤로가기 버튼 누름 (신규버전)")
            }
        })

    }

    //    터치와 관련된 이벤트 정보를 엑티비티에서 받으려면 onTouchEvent 메소드를 오버라이딩 해야함
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                Toast.makeText(this@TouchActivity, "터치 다운 이벤트", Toast.LENGTH_SHORT).show()
            }

            MotionEvent.ACTION_UP -> {
                Toast.makeText(this@TouchActivity, "터치 업 이벤트", Toast.LENGTH_SHORT).show()
            }

            MotionEvent.ACTION_MOVE -> {
                Log.d(
                    "Roonje",
                    "Touch move event x : ${event.x}, y: ${event.y}, rawX: ${event.rawX}, rawY: ${event.rawY}"
                )
            }
        }
        return super.onTouchEvent(event)

    }

    //    키 이벤트 사용 시
    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("ksc_key", "키 업 이벤트")
        Toast.makeText(this@TouchActivity, "키 업 이벤트", Toast.LENGTH_SHORT).show()
        return super.onKeyUp(keyCode, event)
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("ksc_key", "키 다운 이벤트")
        Toast.makeText(this@TouchActivity, "키 다운 이벤트", Toast.LENGTH_SHORT).show()
        when(keyCode){
            KeyEvent.KEYCODE_0 ->Log.d("ksc_key", "0키 누름")
            KeyEvent.KEYCODE_A ->Log.d("ksc_key", "A키 누름")
            KeyEvent.KEYCODE_1 ->Log.d("ksc_key", "1키 누름")
            KeyEvent.KEYCODE_2 ->Log.d("ksc_key", "2키 누름")
        }
        return super.onKeyDown(keyCode, event)
    }


//    콜백 메소드로 등록할 뒤로가기 이벤트 메소드를 미리 생성(API33버전이상)
    private val callback = object :OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            Log.d("ksc_back","뒤로가기 버튼 누름 (신규버전)")

        }
    }

//    API 32버전 까지의 뒤로 가기 버튼 이벤트
//    override fun onBackPressed() {
//        Log.d("ksc_back","Back Button 누름")
//        super.onBackPressed()
//    }


}
