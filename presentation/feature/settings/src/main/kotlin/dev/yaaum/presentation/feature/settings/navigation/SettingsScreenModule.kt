package dev.yaaum.presentation.feature.settings.navigation

import cafe.adriel.voyager.core.registry.screenModule
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.feature.settings.navigation.route.AboutRoute
import dev.yaaum.presentation.feature.settings.navigation.route.SettingsRoute

/**
 * Module for `presentation:feature:settings`
 */
val settingsScreenModule = screenModule {
    register<RouteGraph.SettingsScreen> {
        SettingsRoute()
    }
    register<RouteGraph.AboutScreen> {
        AboutRoute()
    }
}
