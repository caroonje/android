package com.bitc.app0112

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bitc.app0112.databinding.FragmentVolleyBinding
import com.bitc.app0112.model.ItemModel
import com.bitc.app0112.recycler.MyAdapter
import org.json.JSONObject

class VolleyFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentVolleyBinding.inflate(inflater, container, false)


        val url = MyApplication.BASE_URL+"/v2/everything?q="+
                "${MyApplication.QUERY}&apiKey=${MyApplication.API_KEY}&page=1&pageSize=5"

        val queue = Volley.newRequestQueue(activity)

        val jsonRequest = object: JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            Response.Listener<JSONObject> { response ->
                val jsonArray = response.getJSONArray("articles")
                val mutableList = mutableListOf<ItemModel>()
                for(i in 0 until jsonArray.length()){
                    ItemModel().run {
                        val article = jsonArray.getJSONObject(i)
                        author = article.getString("author")
                        title = article.getString("title")
                        description = article.getString("description")
                        urlToImage = article.getString("urlToImage")
                        publishedAt = article.getString("publishedAt")
                        mutableList.add(this)
                    }
                }
                binding.volleyRecyclerView.layoutManager = LinearLayoutManager(activity)
                binding.volleyRecyclerView.adapter = MyAdapter(activity as Context, mutableList)
            },
            Response.ErrorListener {
                Log.d("KSC", "error... $it")
            }
        ){
            override fun getHeaders(): MutableMap<String, String> {
                val map = mutableMapOf<String, String>(
                    "User-agent" to MyApplication.USER_AGENT
                )
                return map
            }
        }

        queue.add(jsonRequest)

        return binding.root
    }

}