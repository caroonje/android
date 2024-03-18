package com.bitc.app0108

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bitc.app0108.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = ActivityChatBinding.inflate(layoutInflater)
    setContentView(binding.root)

    //    출력할 데이터 만듬
    val items = mutableListOf<ChatData>()
    items.add(ChatData("아이유", "안녕하세요 아이유입니다.", "01-08-12:04"))
    items.add(ChatData("유인나", "안녕하세요 유인나입니다.", "01-08-12:05"))
    items.add(ChatData("유재석", "안녕하세요 유재석입니다.", "01-08-12:06"))
    items.add(ChatData("유병재", "안녕하세요 유병재입니다.", "01-08-12:07"))
    items.add(ChatData("이재용", "안녕하세요 이재용입니다.", "01-08-12:08"))

    val chatAdapter = ChatAdapter(items);

    val linearLayoutManager = LinearLayoutManager(this)
    linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
//    현재 엑티비티의 리사이클러 뷰에 사용할 layout 을 지정함
    binding.recyclerViewChat.layoutManager = linearLayoutManager
//    현재 엑티비티의 리사이클러 뷰 UI에 adapter 연동, MyAdapter 클래스의 객체 생성, 생성자의 매개변수에 만들어진 데이터 전달
    binding.recyclerViewChat.adapter = chatAdapter
    binding.recyclerViewChat.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

    binding.btnRecyclerViewAdd.setOnClickListener {
      items.add(ChatData("홍길동", "안녕하세요 홍길동입니다.", "01-08 12:34"))
      chatAdapter.notifyDataSetChanged()
    }

    binding.btnRecyclerViewRemove.setOnClickListener {
      items.removeAt(items.size - 1)
      chatAdapter.notifyDataSetChanged()
    }
  }
}








