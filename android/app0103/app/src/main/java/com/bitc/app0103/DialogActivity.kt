package com.bitc.app0103

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.bitc.app0103.databinding.ActivityDialogBinding
import java.sql.Date
import java.util.Calendar

class DialogActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToast.setOnClickListener {
            val text = binding.editTextMessage.text
            Toast.makeText(this, "입력한 메세지 : ${text}", Toast.LENGTH_SHORT).show()
            binding.editTextMessage.setText("")
        }
        binding.btnToastEvent.setOnClickListener {
            val text = binding.editTextMessage.text
            val toast = Toast.makeText(this, "입력한 메세지 : ${text}", Toast.LENGTH_SHORT)

            toast.addCallback(
                object : Toast.Callback() {
                    override fun onToastHidden() {
                        super.onToastHidden()
                        Log.d("KSC-toast", "토스트 메시지 숨겨질 때 동작하는 이벤트")
                    }

                    override fun onToastShown() {
                        super.onToastShown()
                        Log.d("KSC-toast", "토스트 메시지가 출력될 때 동작하는 이벤트")
                    }
                }
            )
            toast.show()
        }

        binding.editTextDate.setOnClickListener {
//            날짜 및 시간 정보를 가지고 있는 Calendar 객체를 가져옴, 싱글톤 방식으로 구현되어 있음
            val calendar = Calendar.getInstance()
            lateinit var currentDate: String

            val datePickerDialog = DatePickerDialog(
                this,
                object : DatePickerDialog.OnDateSetListener {
                    override fun onDateSet(
                        view: DatePicker?,
                        year: Int,
                        month: Int,
                        dayOfMonth: Int
                    ) {
                        Log.d("KSC-datePicker", "년도 : $year, 달: ${month + 1}, 일 : $dayOfMonth")
                        currentDate = "${year}년 ${month + 1}월 ${dayOfMonth}일"
                        binding.editTextDate.setText(currentDate)
                    }
//                현재 시간을 기준으로 년,월,일 정보를 가져와서 DatePickerDialog에 설정함
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
//                  람다식 사용한 방식
//                val test= DatePickerDialog(this,DatePickerDialog.OnDateSetListener{
//                    view, year, month, dayOfMonth -> currentDate = "${year}년-${month+1}월-${dayOfMonth}일"
//                    binding.editTextDate.setText(currentDate)
//                }, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH))


            datePickerDialog.show()

        }

        binding.editTextTime.setOnClickListener {
            val calendar = Calendar.getInstance()
            var currentTime = ""

            val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    Log.d("KSC-timePicker", "설정된 시간 : ${hourOfDay}시 ${minute}분")
                    currentTime = "${hourOfDay}시 ${minute}분 "
                    binding.editTextTime.setText(currentTime)
                },
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true
            )
            timePickerDialog.show()
        }


        val eventHandler = object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    Toast.makeText(this@DialogActivity, "positive 버튼 클릭", Toast.LENGTH_SHORT).show()
                } else if (which == DialogInterface.BUTTON_NEGATIVE) {
                    Toast.makeText(this@DialogActivity, "negative 버튼 클릭", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this).run {
                setIcon(android.R.drawable.ic_dialog_info)
                setTitle("테스트 Alert Dialog")
                setMessage("종료할거??")
                setPositiveButton("ㅇㅇ", eventHandler)
                setNegativeButton("ㄴㄴ", eventHandler)
                setNeutralButton("딴거", DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(this@DialogActivity, "neutral 버튼 클릭", Toast.LENGTH_SHORT).show()
                    setCancelable(true)
                })
                show()
            }

//            AlertDialog를 변수에 저장하여 필요할 때 호출
//            AlertDialog 에는 버튼을 3개 까지만 사용할 수 있음, 중복되는 버튼은 나중에 입력한 내용으로 출력됨

//            val alertDialog = AlertDialog.Builder(this)
//            alertDialog.setTitle("테스트 Alert Dialog")
//            alertDialog.setMessage("테스트 본문")
//            alertDialog.setPositiveButton("ㅇㅇ",null)
//            alertDialog.setNegativeButton("ㄴㄴ",null)
//            alertDialog.setNeutralButton("딴거",null)
//            alertDialog.setPositiveButton("YES",null)
//            alertDialog.setNegativeButton("NO",null)
//            alertDialog.show()
        }

        binding.btnAlertList.setOnClickListener {
            val items = arrayOf<String>("사과", "복숭아", "배", "수박")

            AlertDialog.Builder(this).run {
                setIcon(android.R.drawable.ic_dialog_info)
                setTitle("Alert 다이얼로그의 목록 출력")
                setItems(items, DialogInterface.OnClickListener { dialog, which ->
                    Log.d("KSC-alertDialog", "선택한 과일 : ${items[which]}")
                    Toast.makeText(
                        this@DialogActivity,
                        "선택한 과일 : ${items[which]}",
                        Toast.LENGTH_SHORT
                    ).show()
                })
                setPositiveButton("닫기", null)

                show()
            }
        }

//        체크박스,라디오 버튼을 AlertDialog에 출력하기
        binding.btnAlertCheckBox.setOnClickListener {
            val Items = arrayOf("사과", "복숭아", "배", "수박")


            AlertDialog.Builder(this).run {
                setIcon(android.R.drawable.ic_dialog_info)
                setTitle("Alert 다이얼로그의 체크박스 목록 출력")
                setMultiChoiceItems(
                    Items,
                    booleanArrayOf(false, false, false, false),
                    object : DialogInterface.OnMultiChoiceClickListener {

                        override fun onClick(
                            dialog: DialogInterface?,
                            which: Int,
                            isChecked: Boolean

                        ) {
                            Log.d(
                                "KSC",
                                "${Items[which]} 이  ${if (isChecked) "선택 되었습니다." else " 선택해제 되었습니다."}"
                            )
                        }
                    })

                setPositiveButton("닫기", eventHandler)
                show()
            }

        }

        binding.btnAlertRadio.setOnClickListener {
            val items = arrayOf<String>("가엔슬", "윌", "루시드", "데미안")

            AlertDialog.Builder(this).run {
                setIcon(android.R.drawable.ic_dialog_info)
                setTitle("Alert 다이얼로그의 라디오 출력")
                setSingleChoiceItems(items,1,object: DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        Log.d("KSC-alertDialog", "선택한 보스 : ${items[which]}")
                        Toast.makeText(this@DialogActivity,"선택한 보스 : ${items[which]}",Toast.LENGTH_SHORT).show()
                    }
                })
                setPositiveButton("닫기",eventHandler)
                show()
            }
        }
    }
}