package com.bitc.app0112

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract.Root
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bitc.app0112.databinding.ActivityVolleyBinding
import com.google.gson.Gson
import com.google.gson.JsonObject
import org.json.JSONObject


class VolleyActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityVolleyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val queue = Volley.newRequestQueue(this)

        binding.btnVolleyRequest.setOnClickListener {

            val url = binding.etServerUrl.text.toString()

            var stringRequest = StringRequest(
                Request.Method.GET,
                url,
                Response.Listener<String> {
                    Log.d("KSC-volley", "서버데이터 : $it")
                    binding.tvVolley.text = it
                },
                Response.ErrorListener { error -> Log.d("gg-volley", "error : $error") }
            )

            queue.add(stringRequest)
        }


        binding.btnVolleyRequestJson.setOnClickListener {
            val url = binding.etServerUrl.text.toString()
            val gson = Gson()

            var data = mutableMapOf<String, String>("title" to "슬램덩크", "rank" to "1위")

            var jsonObject:JSONObject = JSONObject()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                jsonObject.append("title","슬램덩크")
                jsonObject.append("rank","1")
            }
//            json 타입으로 데이터 가져오기
            val jsonRequest = JsonObjectRequest(
                Request.Method.GET,
                url,
//                json방식으로 서버에 데이터 전달 시 사용하는 부분
                null,
                Response.Listener<JSONObject> {
                    Log.d("KSC", "json 방식으로 데이터 가져오기 성공")
                    Log.d("KSC", "$data")

                    var kobis: Kobis = gson.fromJson(it.toString(), Kobis::class.java)
                    val dailyBoxOfficeList = kobis.boxOfficeResult?.dailyBoxOfficeList

                    for (item in dailyBoxOfficeList!!) {
//                     binding.tvVolley.text = item.movieNm
//                        Log.d("KSC", "제목 : ${item.movieNm}")
                    }
//                    Log.d("KSC","${kobis.boxOfficeResult?.dailyBoxOfficeList?.get(0)?.movieNm}")

                },

                Response.ErrorListener { error ->
                    Log.d("KSC", "json 방식으로 데이터 가져오기 오류 \n error: $error")
                }
            )
            queue.add(jsonRequest)
        }
        binding.btnVolleyUrlClear.setOnClickListener {
            binding.etServerUrl.setText("")
        }

    }
}