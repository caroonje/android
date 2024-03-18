package com.bitc.app0110

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import android.util.Log
import com.bitc.app0110.databinding.ActivityBindServiceBinding

class BindServiceActivity : AppCompatActivity() {

    lateinit var messenger: Messenger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBindServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        IBinder를 상속받아 구현한 안드로이드 Api에서 제공하는 클래스

        val connection: ServiceConnection = object : ServiceConnection{
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                Log.d("csy-bind","onServiceConnected 실행됨")

                val serviceBinder = service as MyBinder
                Log.d("csy-bind","onBind()에서 전달한 데이터 : ${serviceBinder.msg}")

                serviceBinder.sendData("onServiceConnected에서 전달한 데이터")
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                TODO("Not yet implemented")
            }
        }

//        bindSErvice()를 실행 시 연결되는 ServiceConnection 타입의 변수 선언
        val connection2: ServiceConnection = object : ServiceConnection{
//             서비스 동작 시 자동 실행되는 메소드
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
//                매개변수로 넘어오는 IBinder 타입의 객체를 Messenger객체의 매개변수로 사용하여
//                Messenger 객체를 생성
               messenger = Messenger(service)
            }
            override fun onServiceDisconnected(name: ComponentName?) {
            }
        }

        binding.btnBindServiceStart.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            bindService(intent,connection, Context.BIND_AUTO_CREATE)
        }

        binding.btnBindServiceStop.setOnClickListener {
            unbindService(connection)
        }

        binding.btnBindServicStart2.setOnClickListener {
//            인텐트 생성
            val intent = Intent(this, MyService2::class.java)
//            bindService()로 서비스 시작
            bindService(intent,connection2, Context.BIND_AUTO_CREATE)
        }

        binding.btnBindServicSend2.setOnClickListener {
//            서비스로 데이터를 전다하기 위한 데이터 세팅
            val msg = Message()
            msg.what = 10
            msg.obj = "hello"
//            send() 메소드를 사용하여 서비스로 데이터 전달
            messenger.send(msg)
        }
    }
}