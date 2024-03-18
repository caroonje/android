package com.bitc.app0110

import android.app.Service
import android.content.Intent
import android.content.ServiceConnection
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    lateinit var myBinder: MyBinder

    override fun onCreate() {
        super.onCreate()

        Log.d("csy-bindService","바인드 서비스 객체 생성")
        myBinder = MyBinder("MyService의 onBind() 실행")
    }

    override fun onBind(intent: Intent): IBinder {
        Log.d("csy-bindService","바인드 서비스 동작")

        Log.d("csy-bindSErvice","가져온 데이터 : ${myBinder.msg}")
        return myBinder
    }

    override fun unbindService(conn: ServiceConnection) {
        Log.d("csy-bindService","바인드 서비스 종료")
        super.unbindService(conn)
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("csy-bindService","바인드 서비스 삭제")
    }
}