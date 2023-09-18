package dev.yaaum.presentation.feature.host.navigation

import cafe.adriel.voyager.core.registry.ScreenRegistry
import dev.yaaum.presentaion.feature.onboarding.navigation.onboardingScreenModule
import dev.yaaum.presentation.feature.main.navigation.mainScreenModule
import dev.yaaum.presentation.feature.settings.navigation.settingsScreenModule

/**
 * Container for all nested graphs:
 * - `presentation:feature:onboarding`;
 * - `presentation:feature:main`;
 * - `presentation:feature:settings`;
 */
fun navigationInit() = ScreenRegistry {
    onboardingScreenModule()
    mainScreenModule()
    settingsScreenModule()
}
