package com.bitc.app0102

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowMetrics
import android.widget.CompoundButton
import android.widget.Toast
import com.bitc.app0102.databinding.ActivityMainBinding
import com.bitc.app0102.databinding.ActivityViewEventBinding

class ViewEventActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityViewEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        액티비티에서 인터페이스를 상속 받은 후 인터페이스를 구현하여 실행
        binding.checkBox1.setOnCheckedChangeListener(this)

//        앱이 현재 가지고 있는 정보를 보내는 형식
//        this.baseContext = this@ViewEventActivity 같음
//        applicationContext

//        인터페이스를 상속받는 다른 클래스를 생성 후 해당 클래스를 구현하여 실행
//        클래스의 생성자에 context 정보를 매개변수로 전달함
        binding.checkBox2.setOnCheckedChangeListener(MyEventHandler(this@ViewEventActivity))
//        SAM 방식으로 람다 함수를 사용하여 실행
        binding.checkBox3.setOnCheckedChangeListener{
            compoundButton,b-> Toast.makeText(this,"세번째 체크 박스 클릭(b: $b)",Toast.LENGTH_SHORT).show()

        }

//        클릭 이벤트
        binding.button1.setOnClickListener{
            Toast.makeText(this,"클릭이벤트 발생",Toast.LENGTH_SHORT).show()
        }

//        롱 클릭 이벤트
        binding.button2.setOnLongClickListener(){
            Toast.makeText(this,"롱 클릭 이벤트 발생",Toast.LENGTH_SHORT).show()
//          롱 클릭 이벤트는 마지막에 Boolean 값을 반환 해야함
            true
        }


//        Log.d("ksc",Build.VERSION.SDK_INT.toString())
//        Log.d("ksc",Build.VERSION_CODES.R.toString())
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            val windowMetrics:WindowMetrics = windowManager.currentWindowMetrics
            val size = "width: ${windowMetrics.bounds.width()},height : ${windowMetrics.bounds.height()}"
            Log.d("KSC",size)
            Toast.makeText(this,size,Toast.LENGTH_SHORT).show()
        }
        else{
            val display = windowManager.defaultDisplay
            val displayMetrics = DisplayMetrics()
            display.getRealMetrics(displayMetrics)
            val size="width: ${displayMetrics.widthPixels},height : ${displayMetrics.heightPixels}"
            Log.d("KSC",size)
            Toast.makeText(this,size,Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        Toast.makeText(this,"첫번째 체크 박스 클릭",Toast.LENGTH_SHORT).show()
    }
}


// 주생성자의 매개변수의 값을 전달하는 방법1
//class MyEventHandler(context:Context): CompoundButton.OnCheckedChangeListener {
//    private lateinit var context: Context
//
//    init {
//        this.context = context
//    }
// 주생성자의 매개변수를 해당 클래스의 필드로 선언하여 사요 ㅇ
class MyEventHandler(private val context: Context): CompoundButton.OnCheckedChangeListener {
    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
//        생성자의 매개변수로 받아온 context 정보를 Toast 메세지에 사용함
        Toast.makeText(context,"두번째 체크 박스 클릭",Toast.LENGTH_SHORT).show()
        Log.d("ksc","두번째 체크 박스 클릭")
    }

}