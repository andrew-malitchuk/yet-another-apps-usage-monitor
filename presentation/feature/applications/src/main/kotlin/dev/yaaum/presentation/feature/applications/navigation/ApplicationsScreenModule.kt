package dev.yaaum.presentation.feature.applications.navigation

import cafe.adriel.voyager.core.registry.screenModule
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.feature.applications.navigation.route.ApplicationDetalizationRoute
import dev.yaaum.presentation.feature.applications.navigation.route.ApplicationsRoute

/**
 * Module for `presentation:feature:applications`
 */
val applicationsScreenModule = screenModule {
    register<RouteGraph.ApplicationsScreen> {
        ApplicationsRoute()
    }
    register<RouteGraph.ApplicationDetalizationScreen> {
        ApplicationDetalizationRoute()
    }
}
