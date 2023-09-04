package dev.yaaum.host.navigation

import cafe.adriel.voyager.core.registry.ScreenRegistry
import dev.yaaum.main.navigation.mainScreenModule
import dev.yaaum.onboarding.navigation.onboardingScreenModule
import dev.yaaum.settings.navigation.settingsScreenModule

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
