package com.bitc.app0109

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat


class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Log.d("KSC","MyReceiver..............")
//        알림 서비스 설정
        val manager = context.getSystemService(AppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager
        val builder: NotificationCompat.Builder

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channelId = "one=channel"
            val channelName = "My Channel One"
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "My Channel One Description"
                setShowBadge(true)
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()

                setSound(uri, audioAttributes)
                enableVibration(true)
            }

            manager.createNotificationChannel(channel)
            builder = NotificationCompat.Builder(context, channelId)
        }
//        API 26 미만 일 경우
        else{
            builder = NotificationCompat.Builder(context)
        }
//        알림 메세지 설정
        builder.run {
            setSmallIcon(android.R.drawable.ic_notification_overlay)
            setWhen(System.currentTimeMillis())
            setContentTitle("홍길동")
            setContentText("안녕하세요")
        }
//        안드로이드 시스템에 알림 요청
        manager.notify(11,builder.build())
    }
}