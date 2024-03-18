package com.bitc.app0110

import android.os.Binder
import android.util.Log

class MyBinder(var msg: String): Binder() {

    fun sendData(msg: String){
        this.msg = msg
    }
}