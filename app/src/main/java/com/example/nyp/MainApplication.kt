package com.example.nyp

import android.app.Application
import android.net.ConnectivityManager
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.M)
class MainApplication:Application() {
    val connectivityManager by lazy { getSystemService(ConnectivityManager::class.java) }
    val repository by lazy { MainRepository(connectivityManager) }
}