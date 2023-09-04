package dev.yaaum.settings.navigation

import cafe.adriel.voyager.core.registry.screenModule
import dev.yaaum.navigation.RouteGraph
import dev.yaaum.settings.navigation.route.SettingsRoute

val settingsScreenModule = screenModule {
    register<RouteGraph.SettingsScreen> {
        SettingsRoute()
    }
}
