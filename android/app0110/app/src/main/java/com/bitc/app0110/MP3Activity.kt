package com.bitc.app0110

import android.bluetooth.BluetoothClass.Service
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import com.bitc.app0110.databinding.ActivityMp3Binding


class MP3Activity : AppCompatActivity() {


//    실행한 서비스를 액티비티에서 제어하기 위해서 서비스 타입의 객체를 저장할 변수 선언
    var mP3PlayerService: MP3PlayerService? = null

//    bindService()로 서비스 실행 시 데이터 연동을 위해서 자동 실행되는 ServiceConnection 객체 선언
    val mP3PlayerServiceConnection: ServiceConnection = object : ServiceConnection{
//        onBind() 실행 시 자동 실행되는 메소드
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
//            bindService() 메소드 실행 시 생성된 mP3PlayerService클래스 타입의 객체를 service 란 이름의 매개변수로 전달함
//            MP3PlayerBinder 타입의 객체로 강제 타입 변환을 진행함
//            MP3PlayerBinder 객체의 멤버 메서드인 getService() 를 사용하여 MP3PlayerService 타입의 객체를 받아옴
//            현재 서비스의
            mP3PlayerService = (service as MP3PlayerService.MP3PlayerBinder).getService()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMp3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if (mP3PlayerService == null){
                val intent = Intent(this,MP3PlayerService::class.java)
                bindService(intent,mP3PlayerServiceConnection, Context.BIND_AUTO_CREATE)

        }
//         받아온 MP3PlayerService 객체의 멤버 메소드를 사용하여 mp3 파일을 제어할 수 있음
        binding.btnMp3Play.setOnClickListener {
            mP3PlayerService?.play()
        }

        binding.btnMp3Stop.setOnClickListener {
            mP3PlayerService?.stop()
        }

        binding.btnMp3Pause.setOnClickListener {
            mP3PlayerService?.pause()
        }


    }
}