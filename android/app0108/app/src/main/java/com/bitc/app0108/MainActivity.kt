package com.bitc.app0108

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat.startActivity
import com.bitc.app0108.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  //  기존 startActivityForResult() 방식을 더이상 사용할 수 없음
//  ActivityResultLauncher 방식을 사용하여 이전 액티비티에서 전달한 데이터를 받아옴
//  변수 지연 초기화 방식 사용 시 오류 발생
//  registerForActivityResult()를 사용하여 StartActivityForResult()를 콜백함수로 등록함
  private val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
    ActivityResultContracts.StartActivityForResult()
  ) {
//    응답 결과가 RESULT_OK 일 경우에만 intent에서 데이터 가져오기
    if (it.resultCode == RESULT_OK) {
      val resultData = it.data?.getStringExtra("resultParam")
      Toast.makeText(this, "받아온 데이터 : $resultData", Toast.LENGTH_LONG).show()
    }
    else {
      Toast.makeText(this, "취소 되었습니다.", Toast.LENGTH_LONG).show()
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.btnRecyclerView.setOnClickListener {
      val intent = Intent(this, RecyclerViewActivity::class.java)
      startActivity(intent)
    }

//    문제 1) 카카오톡 채팅방 리스트를 따라하는 리사이클러뷰를 작성하세요
//    # 리스트 목록은 5개
//    # 리스트에 표시될 데이터는 이름, 채팅 내용, 시간 (해당 데이터는 데이터 클래스 타입의 객체로 전달)
//    # 엑티비티 명 : ChatActivity.kt, activity_chat.xml
//    # 리사이클러뷰 항목 xml 명 : item_chat.xml
//    # ViewHolder 명 : ChatViewHolder
//    # Adapter 명 : ChatAdapter

    binding.btnRecyclerViewChat.setOnClickListener {
      val intent = Intent(this, ChatActivity::class.java)
      startActivity(intent)
    }

    binding.btnDrawerLayout.setOnClickListener {
      val intent = Intent(this, DrawerLayoutActivity::class.java)
      startActivity(intent)
    }

    binding.btnViewPager2.setOnClickListener {
      val intent = Intent(this, ViewPagerActivity::class.java)
      startActivity(intent)
    }

    binding.btnIntentTest1.setOnClickListener {
      val intent = Intent(this, IntentTest1Activity::class.java)
      intent.putExtra("param1", "첫번째 데이터")
      intent.putExtra("param2", 1000)
      startActivity(intent)
    }

    binding.btnIntentTest2.setOnClickListener {
      val intent = Intent(this, IntentTest2Activity::class.java)
//      서브 액티비티에 전달할 데이터 추가
      intent.putExtra("param3", "메인 엑티비티에서 전달한 데이터")
//      launch()를 실행하여 액티비티 실행 요청
      requestLauncher.launch(intent)
    }

    binding.btnCalculator.setOnClickListener {
      val intent = Intent(this,CalculatorActivity::class.java)
      startActivity(intent)
    }


  }
}







