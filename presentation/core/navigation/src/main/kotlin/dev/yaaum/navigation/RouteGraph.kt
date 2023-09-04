package dev.yaaum.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class RouteGraph : ScreenProvider {
    data object OnboardingScreen : RouteGraph()
    data class MainScreen(val from: String) : RouteGraph()

    data object SettingsScreen : RouteGraph()
}
