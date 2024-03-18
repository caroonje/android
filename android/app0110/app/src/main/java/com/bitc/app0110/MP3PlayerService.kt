package com.bitc.app0110

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.widget.Toast
//Service 클래스를 상속받아 사용자 서비스 클래스 생성
class MP3PlayerService : Service() {
//     음악 파일을 재생하기 위해 안드로이드에서 기본 제공하는 API
    var mediaPlayer : MediaPlayer? = null
//    IBinder를 상속받아 구현한 MP3PlayerBinder 클래스 타입의 객체 생성
    var mp3PlayerBinder: MP3PlayerBinder = MP3PlayerBinder()

//    내장 클래스로 선언
    inner class  MP3PlayerBinder: Binder(){
//        MP3PlayerService 타입의 반환
        fun getService() : MP3PlayerService{
//            MP3PlayerService의 객체 자신을 반환
            return this@MP3PlayerService
        }
    }

//    bindService() 실행시 동작하는 메소드
    override fun onBind(intent: Intent): IBinder {
        return mp3PlayerBinder
    }
//    mp3 파일 재생
    fun play(){
//        mediaPlayer 객체가 null인지 확인
        if (mediaPlayer == null){
//            MediaPlayer 객체 생성
            mediaPlayer = MediaPlayer.create(this,R.raw.chocolate)
            mediaPlayer?.setVolume(1.0f,1.0f)
            mediaPlayer?.isLooping = true
//            지정한 mp3 파일 재생
            mediaPlayer?.start()
            Toast.makeText(this,"음악이 재생됩니다.",Toast.LENGTH_SHORT).show()
        }
//        mediaPlayer 객체가 있을 경우(실행 중)
        else{
//            현재 mp3 파일이 재생 중인지 확인
            if (mediaPlayer!!.isPlaying){
                Toast.makeText(this,"이미 음악이 재생중입니다.",Toast.LENGTH_SHORT).show()
            }
            else{
                mediaPlayer?.start()
            }
        }
    }

//    mp3 파일  재생 정지
    fun stop(){
        mediaPlayer?.let {
            if (it.isPlaying){
                it.stop()
                it.release()
                mediaPlayer = null
                Toast.makeText(this,"정지 되었습니다.",Toast.LENGTH_SHORT).show()
            }
        }
    }
//    mp3 파일 재생 일시중지
    fun pause(){
        mediaPlayer?.let {
            if (it.isPlaying){
                it.pause()
                Toast.makeText(this,"중지 되었습니다.",Toast.LENGTH_SHORT).show()
            }
        }
    }
}