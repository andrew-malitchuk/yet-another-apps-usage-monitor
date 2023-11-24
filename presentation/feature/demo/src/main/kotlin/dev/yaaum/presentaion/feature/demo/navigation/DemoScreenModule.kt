package dev.yaaum.presentaion.feature.demo.navigation

import cafe.adriel.voyager.core.registry.screenModule
import dev.yaaum.presentaion.feature.demo.navigation.route.DemoRoute
import dev.yaaum.presentation.core.navigation.RouteGraph

/**
 * Module for `presentation:feature:demo`
 */
val demoScreenModule = screenModule {
    register<RouteGraph.DemoScreen> {
        DemoRoute()
    }
}
