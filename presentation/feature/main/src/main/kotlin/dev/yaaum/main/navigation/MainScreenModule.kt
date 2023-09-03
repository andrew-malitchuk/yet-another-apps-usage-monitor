package dev.yaaum.main.navigation

import cafe.adriel.voyager.core.registry.screenModule
import dev.yaaum.navigation.RouteGraph

val mainScreenModule = screenModule {
    register<RouteGraph.MainScreen> {
        MainRoute()
    }
}
