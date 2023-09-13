package dev.yaaum.presentation.core.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

/**
 * The root of navigation graph
 */
sealed class RouteGraph : ScreenProvider {
    /**
     * `:presentation:feature:onboarding`
     */
    data object OnboardingScreen : RouteGraph()

    /**
     * `:presentation:feature:main`
     *
     * @param from
     */
    data class MainScreen(val from: String) : RouteGraph()

    /**
     * `:presentation:feature:settings`
     */
    data object SettingsScreen : RouteGraph()
}
