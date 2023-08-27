package dev.yaaum.app

import android.app.Application
import android.util.Log

class YauumApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("foo", "bar")
    }
}
