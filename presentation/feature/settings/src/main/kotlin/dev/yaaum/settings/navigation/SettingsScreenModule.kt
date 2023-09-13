package dev.yaaum.settings.navigation

import cafe.adriel.voyager.core.registry.screenModule
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.settings.navigation.route.SettingsRoute

/**
 * Module for `presentation:feature:settings`
 */
val settingsScreenModule = screenModule {
    register<RouteGraph.SettingsScreen> {
        SettingsRoute()
    }
}
