package com.example.chromeversionfinder

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var version_text : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        version_text = findViewById(R.id.tv_version)
        isChromeInstalledAndVersionGreaterThan65()

    }


    private fun isChromeInstalledAndVersionGreaterThan65(): Boolean {
        val pInfo: PackageInfo? = try {
            packageManager.getPackageInfo("com.android.chrome", 0)
        } catch (e: PackageManager.NameNotFoundException) {
            Toast.makeText(this , "Chrome Is not Installed" , Toast.LENGTH_SHORT).show()
            return false
        }
        if (pInfo != null) {
            version_text.text = pInfo.versionName
        }
        return false
    }
}