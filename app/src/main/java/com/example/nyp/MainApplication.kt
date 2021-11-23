package com.example.nyp

import android.app.Application

class MainApplication:Application() {
    val repository by lazy { MainRepository() }
}