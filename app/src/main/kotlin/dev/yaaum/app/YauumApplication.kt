package dev.yaaum.app

import android.app.Application
import dev.yaaum.host.navigation.HostRoute

class YauumApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        HostRoute().init()
    }
}
