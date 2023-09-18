package dev.yaaum.presentation.feature.main.navigation

import cafe.adriel.voyager.core.registry.screenModule
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.feature.main.navigation.route.MainRoute

/**
 * Module for `presentation:feature:main`
 */
val mainScreenModule = screenModule {
    register<RouteGraph.MainScreen> { args ->
        MainRoute(args.from)
    }
}
