package dev.yaaum.presentaion.feature.statistics.navigation

import cafe.adriel.voyager.core.registry.screenModule
import dev.yaaum.presentaion.feature.statistics.navigation.route.PermissionsRoute
import dev.yaaum.presentation.core.navigation.RouteGraph

/**
 * Module for `presentation:feature:statistics`
 */
val statisticsScreenModule = screenModule {
    register<RouteGraph.PermissionsScreen> {
        PermissionsRoute()
    }
}
