package dev.yaaum.host.navigation

import cafe.adriel.voyager.core.registry.ScreenRegistry
import dev.yaaum.main.navigation.mainScreenModule
import dev.yaaum.onboarding.navigation.onboardingScreenModule

class HostRoute {

    fun init() {
        ScreenRegistry {
            onboardingScreenModule()
            mainScreenModule()
        }
    }
}
