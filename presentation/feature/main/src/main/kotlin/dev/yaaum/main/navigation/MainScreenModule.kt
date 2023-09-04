package dev.yaaum.main.navigation

import cafe.adriel.voyager.core.registry.screenModule
import dev.yaaum.main.navigation.route.MainRoute
import dev.yaaum.navigation.RouteGraph

/**
 * Module for `presentation:feature:main`
 */
val mainScreenModule = screenModule {
    register<RouteGraph.MainScreen> { args ->
        MainRoute(args.from)
    }
}
