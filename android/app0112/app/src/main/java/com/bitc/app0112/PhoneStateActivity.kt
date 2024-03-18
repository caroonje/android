package com.bitc.app0112

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneStateListener
import android.telephony.ServiceState
import android.telephony.SubscriptionInfo
import android.telephony.SubscriptionManager
import android.telephony.TelephonyCallback
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import com.bitc.app0112.databinding.ActivityPhoneStateBinding

class PhoneStateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPhoneStateBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        전화 상태 정보 가져오기
//        안드로이드 시스템의 서비스중 telephonyManager 타입의 객체를 가져옴
        val telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

//        API 31 버전 이상부터 사용
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//            telephonyManager에 콜백 메소드 추가
            telephonyManager.registerTelephonyCallback(
//                스레드 동작
                mainExecutor,
//                TelephonyCallback() 클래스를 상속받아 구현함
                object : TelephonyCallback(), TelephonyCallback.CallStateListener {
                    //                    전화 상태 정보가 변경시 자동 동작
                    override fun onCallStateChanged(state: Int) {
                        when (state) {
                            TelephonyManager.CALL_STATE_IDLE -> Log.d("KSC", "대기중")
                            TelephonyManager.CALL_STATE_OFFHOOK -> Log.d("KSC", "통화 종료")
                            TelephonyManager.CALL_STATE_RINGING -> Log.d("KSC", "연결중")
                        }
                    }
                }
            )
        }



//        val phoneStateListener = object : PhoneStateListener(){
//            override fun onServiceStateChanged(serviceState: ServiceState?) {
//                super.onServiceStateChanged(serviceState)
//
//                when(serviceState?.state){
//                    ServiceState.STATE_EMERGENCY_ONLY -> Log.d("KSC","긴급 전화 사용")
//                    ServiceState.STATE_OUT_OF_SERVICE -> Log.d("KSC","서비스 지역 아님")
//                    ServiceState.STATE_POWER_OFF -> Log.d("KSC","전원 꺼짐")
//                    ServiceState.STATE_IN_SERVICE -> Log.d("KSC","서비스 지역")
//                }
//
//            }
//        }






//        val permissionLauncher = registerForActivityResult(
//            ActivityResultContracts.RequestMultiplePermissions()
//        ){
//            if (it.all { permission -> permission.value == true }){
//
//            }
//            else{
//                Toast.makeText(this,"권한 없음", Toast.LENGTH_SHORT).show()
//            }
//        }
//        var phoneNumber: String = "없음"
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            val subscriptionManager =
//                getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE) as SubscriptionManager
//            for (subscriptionInfo: SubscriptionInfo in subscriptionManager.activeSubscriptionInfoList) {
//                val activeSubscriptionId: Int = subscriptionInfo.subscriptionId
//                if (ActivityCompat.checkSelfPermission(
//                        this, Manifest.permission.READ_PHONE_NUMBERS
//                    ) != PackageManager.PERMISSION_GRANTED
//                ) {
//                    return
//                }
//                phoneNumber = subscriptionManager.getPhoneNumber(activeSubscriptionId)
//            }
//
//        } else {
//            phoneNumber = telephonyManager.line1Number
//        }





        binding.btnStateListenOn.setOnClickListener {

//            manager.listen(phoneStateListener,PhoneStateListener.LISTEN_SERVICE_STATE or PhoneStateListener.LISTEN_CALL_STATE)
//            Log.d("KSC", "휴대폰 상태 정보 가져오기 이벤트 시작")

            if (isNetworkAvailable()) {
                Log.d("KSC", "네트워크 접속 가능")
            }
            else {
                Log.d("KSC", "네트워크 접속 불가")
            }
        }
        binding.btnStateListenOff.setOnClickListener {

//            manager.listen(phoneStateListener,PhoneStateListener.LISTEN_NONE)
            Log.d("KSC", "휴대폰 상태 정보 가져오기 이벤트 해제")
        }
    }

    private fun isNetworkAvailable() : Boolean {
//        안드로이드 시스템의 서비스로 connectivityManager 타입의 객체 생성
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            현재 네트워크 상태 확인
            val nw = connectivityManager.activeNetwork ?: return false
//            사용하고 있는 네트워트 종류 가져오기
            val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
//            사용하는 네트워크 종류 확인 후 결과 출력
            return when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    Log.d("KSC", "WIFI 사용")
                    true
                }
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    Log.d("KSC", "모바일 데이터 사용")
                    true
                }
                else -> false
            }
        }
        else {
            return connectivityManager.activeNetworkInfo?.isConnected ?: false
        }
    }
}