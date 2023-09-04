package dev.yaaum.app

import android.app.Application
import dev.yaaum.host.navigation.navigationInit

class YauumApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        navigationInit()
    }
}
