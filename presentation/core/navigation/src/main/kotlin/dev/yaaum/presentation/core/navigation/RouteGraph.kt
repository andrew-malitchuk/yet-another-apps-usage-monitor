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
     * `:presentation:feature:settings`
     */
    data object AboutScreen : RouteGraph()

    /**
     * `:presentation:feature:settings`
     */
    data object PermissionScreen : RouteGraph()

    /**
     * `:presentation:feature:applications`
     */
    data object ApplicationsScreen : RouteGraph()

    /**
     * `:presentation:feature:applications`
     */
    data class ApplicationDetalizationScreen(val packageName: String) : RouteGraph()

    /**
     * `:presentation:feature:statistics`
     */
    data object PermissionsScreen : RouteGraph()

    /**
     * `:presentation:feature:health`
     */
    data object HealthScreen : RouteGraph()

    /**
     * `:presentation:feature:demo`
     */
    data object DemoScreen : RouteGraph()
}
