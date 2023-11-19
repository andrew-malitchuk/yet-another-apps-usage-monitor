package dev.yaaum.presentation.feature.health.navigation

import cafe.adriel.voyager.core.registry.screenModule
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.feature.health.navigation.route.HealthRoute

/**
 * Module for `presentation:feature:health`
 */
val healthScreenModule = screenModule {
    register<RouteGraph.HealthScreen> {
        HealthRoute()
    }
}
