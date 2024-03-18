package com.bitc.app0103

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.bitc.app0103.databinding.ActivityPermissionBinding

class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPermissionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission())
        {
                isGranted ->
            if (isGranted){
                Log.d("gg-permission", "권한 주어짐")
            }
            else{
                Log.d("gg-permission","권한 거부됨")
            }
        }

        permissionLauncher.launch("android.permission.ACCESS_FINE_LOCATION")

    }
}