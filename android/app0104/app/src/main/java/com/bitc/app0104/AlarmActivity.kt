package com.bitc.app0104

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import com.bitc.app0104.databinding.ActivityAlarmBinding

class AlarmActivity : AppCompatActivity() {

    private lateinit var notification: Uri
    private lateinit var ringtone: Ringtone
    private lateinit var player: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSystemAlarmStart.setOnClickListener {
            Toast.makeText(this, "안드로이드 시스템 음원을 알람으로 사용하기", Toast.LENGTH_SHORT).show()

            notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            ringtone = RingtoneManager.getRingtone(applicationContext, notification)
            ringtone.play()
        }
        binding.btnSystemAlarmStop.setOnClickListener {
            Toast.makeText(this, "알람 끄기", Toast.LENGTH_SHORT).show()
            ringtone.stop()
        }

        binding.btnUserMediaAlarmStart.setOnClickListener {
            Toast.makeText(this, "사용자 미디어를 알람으로 사용하기", Toast.LENGTH_SHORT).show()
//            안드로이드 앱 안에 지정된 주소에 있는 미디어 파일 재생
            player = MediaPlayer.create(this, R.raw.tracehone)
            player.start()
        }
        binding.btnUserMediaAlarmStop.setOnClickListener {
            Toast.makeText(this, "알람 끄기", Toast.LENGTH_SHORT).show()
            player.stop()
        }
        binding.btnVibrator.setOnClickListener {
            val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val vibratorManager = this.getSystemService(Context.VIBRATOR_MANAGER_SERVICE)
                        as VibratorManager
                vibratorManager.defaultVibrator;
            } else {
                getSystemService(VIBRATOR_SERVICE) as Vibrator
            }

//           기본 진동 방식으로 0.5초간 진동
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                vibrator.vibrate(
                    VibrationEffect.createOneShot(
                        500,
                        VibrationEffect.DEFAULT_AMPLITUDE
                    )
                )
            } else {
                vibrator.vibrate(500)
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                vibrator.vibrate(
                    VibrationEffect.createWaveform(
                        longArrayOf(500, 100, 500, 2000),
                        intArrayOf(0, 50, 0, 200), -1
                    )
                )

            } else {
                vibrator.vibrate(longArrayOf(500, 1000, 500, 2000), -1)
            }

        }

        binding.btnStatusAlarm.setOnClickListener {
            notiAlarm()
        }
    }

    private fun notiAlarm() {
//        getSystemService(서비스) : 안드로이드 시스템에서 동작하고 있는 서비스 중 지정한 서비스를 가져옴
//        getSystemService() 메소드를 사용하여 NotificationManager 타입의 객체를 가져오기
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
//        NotificationCompat 타입의 객체를 저장할 변수 선언
        val builder: NotificationCompat.Builder

//        API 26부터 채널이 추가 되어 버전에 따라 사용 방식을 변경
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "one-channel"
            val channelName = "My Channel One"
//            채널 객체 생성
            val channel = NotificationChannel(
                channelId, channelName,
//                알림 등급 설정
                NotificationManager.IMPORTANCE_HIGH
            )

//            채널에 다양한 정보 설정
            channel.description = "My Channel One Description"
            channel.setShowBadge(true)

//            알림 동작시 사용할 음원 지정
//            안드로이드 기본  알림 음원 정보 가져오기
            val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val audioAttributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_ALARM).build()

//            알림 채널에 사용할 음원 설정
            channel.setSound(uri, audioAttributes)
//            알림시 라이트 사용
            channel.enableLights(true)
            channel.lightColor = Color.RED
//            알림 시 진동 사용
            channel.enableVibration(true)
            channel.vibrationPattern = longArrayOf(100, 200, 100, 200)
//            생성된 채널 정보를 NotificationManager 객체에 저장
            manager.createNotificationChannel(channel)
//            채널을 이용해 빌더 생성
            builder = NotificationCompat.Builder(this, channelId)
        } else {
            builder = NotificationCompat.Builder(this)
        }

//        스테이터스 창 알림 화면 설정
        builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
        builder.setWhen(System.currentTimeMillis())
        builder.setContentTitle("알림창 제목")
        builder.setContentText("알림창 내용")


////        화면 전환을 위한 Intent를 저장할 리스트 변수 생성
//        var mainIntent = mutableListOf<Intent>()
////        리스트에 화면을 전환할 앱의 애티비티 Intent를 추가함
//        mainIntent.add(Intent(this,MainActivity::class.java))
//
////        PendingIntent를 통해서 안드로이드 시스템에 이벤트 요청 처리 등록
//        var eventPendingIntent = PendingIntent.getActivities(
//            this,
//            30,
//            mainIntent.toTypedArray(),
//            PendingIntent.FLAG_MUTABLE
//        )
        val mainIntent = Intent(this, MainActivity::class.java)
        var eventPendingIntent =
            PendingIntent.getActivity(this, 30, mainIntent, PendingIntent.FLAG_MUTABLE)

//        알림에 PendingIntent를 추가
        builder.setContentIntent(eventPendingIntent)

//        알림에는 액션을 3개까지 추가할 수 있음
//        알림에 액션을 추가
        builder.addAction(
//            매개변수는 아이콘, 액션버튼 제목, PendingIntent 객체 순서
            NotificationCompat.Action.Builder(
                android.R.drawable.stat_notify_more,
                "화면전환",
                eventPendingIntent
            ).build()
        )
////        액션 버튼을 추가로 입력
//        val dialogIntent = Intent(this, AlertDialogActivity::class.java)
//        val dialogPendingIntent =
//            PendingIntent.getActivity(this, 40, dialogIntent, PendingIntent.FLAG_MUTABLE)
//
//        builder.addAction(
//            NotificationCompat.Action.Builder(
//                android . R . drawable . ic_dialog_info, "Dialog", dialogPendingIntent
//            ).build()
//        )

//        알림창에서 답장하기
//        답장 시 사용할 키 설정, 리시버에서 해당 키로 데이터를 가져옴
        val receiverKeyName = "KSC"
//        RemoteInput를 통해서 알림창에서 응답할 수 있도록 객체 생성
        val receiverLabel="답장"
        val remoteInput: RemoteInput = RemoteInput.Builder(receiverKeyName).run {
            setLabel("응답")
            build()
        }

//        RemoteInput 답장 내용을 받아볼 리시버 Intent 생성
        val receiverIntent = Intent(this,MyReceiver::class.java)
//        RemoteInput 도 PendingIntent 를 사용하여 안드로이드 서비스에 등록해야 함
        val receiverPendingIntent = PendingIntent.getBroadcast(this,50,receiverIntent,PendingIntent.FLAG_MUTABLE)

//        RemoteInput도 알림의 이벤트 액션 이므로  addAction()을 사용하여 Action으로 등록
        builder.addAction(
            NotificationCompat.Action.Builder(
                android.R.drawable.ic_menu_send, "응답",receiverPendingIntent
            ).addRemoteInput(remoteInput).build()
        )


//        NotificationManager 를 사용하여 스테이터스창에 알림창 출력
        manager.notify(11, builder.build())
    }


}