package dev.yaaum.host.navigation

import cafe.adriel.voyager.core.registry.ScreenRegistry
import dev.yaaum.main.navigation.mainScreenModule
import dev.yaaum.onboarding.navigation.onboardingScreenModule
import dev.yaaum.settings.navigation.settingsScreenModule

class HostRoute {

    fun init() {
        ScreenRegistry {
            onboardingScreenModule()
            mainScreenModule()
            settingsScreenModule()
        }
    }
}
