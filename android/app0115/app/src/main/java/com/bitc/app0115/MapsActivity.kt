package com.bitc.app0115

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bitc.app0115.databinding.ActivityMapsBinding
import net.daum.mf.map.api.MapView


class MapsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val mapView = findViewById<MapView>(binding.map_view)

    }
}
