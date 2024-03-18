package com.bitc.app0109

import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.BatteryManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.bitc.app0109.databinding.ActivityReceiverBinding


class ReceiverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityReceiverBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        권한 학인
//        RequestMultiplePermissions() 메소드를 콜백함수로 등록
        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            if (it.all { permission ->
                    permission.value == true
                }) {
                val intent = Intent(this, MyReceiver::class.java)
                sendBroadcast(intent)
            } else {
                Toast.makeText(this, "퍼미션 없음", Toast.LENGTH_SHORT).show()
            }
        }
//        사용자 브로드캐스트 리시버 등록
        registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))!!.apply {
            when (getIntExtra(BatteryManager.EXTRA_STATUS, -1)) {
                BatteryManager.BATTERY_STATUS_CHARGING -> {
                    when (getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)) {
                        BatteryManager.BATTERY_PLUGGED_USB -> {
                            binding.chargingResultView.text = "USB 충전 중"
                            binding.chargingImageView.setImageBitmap(
                                BitmapFactory.decodeResource(
                                    resources, R.drawable.usb
                                )
                            )
                        }

                        BatteryManager.BATTERY_PLUGGED_AC -> {
                            binding.chargingResultView.text = "AC 충전 중"
                            binding.chargingImageView.setImageBitmap(
                                BitmapFactory.decodeResource(
                                    resources, R.drawable.ac
                                )
                            )
                        }
                    }


                }

                else -> {
                    binding.chargingResultView.text = "충전중이 아닙니다."
                }
            }
//            배터리 충전 사이클 상태 정보
            val level = getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
//            배터리 충전 상태 값 정보
            val scale = getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            val batteryPct = level / scale.toFloat() * 100
            binding.percentResultView.text = "$batteryPct %"
        }

//        버튼 클릭 시
        binding.btnRunReceiver.setOnClickListener {
//            OS의 사용 버전에 따라서 실행 방식 변경
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                val isGrant = ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS")
//                권한 확인 , 알림 사용 권한 확인
                if (isGrant == PackageManager.PERMISSION_GRANTED
                ) {
                    val intent = Intent(this, MyReceiver::class.java)
                    sendBroadcast(intent)
                } else {
//                    app 사용자에게 사용권한 요청
                    permissionLauncher.launch(arrayOf("android.permission.POST_NOTIFICATIONS"))
                }
            }
//            API 32 이하일 경우
            else {
                val intent = Intent(this, MyReceiver::class.java)
                sendBroadcast(intent)
            }
        }
    }
}