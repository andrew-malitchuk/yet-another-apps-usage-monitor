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
     */
    data object MainScreen : RouteGraph()

    /**
     * `:presentation:feature:settings`
     */
    data object SettingsScreen : RouteGraph()

    /**
     * `:presentation:feature:applications`
     */
    data object ApplicationsScreen : RouteGraph()
}
