package dev.yaaum.presentation.feature.host.navigation

import cafe.adriel.voyager.core.registry.ScreenRegistry
import dev.yaaum.presentaion.feature.demo.navigation.demoScreenModule
import dev.yaaum.presentaion.feature.onboarding.navigation.onboardingScreenModule
import dev.yaaum.presentaion.feature.statistics.navigation.statisticsScreenModule
import dev.yaaum.presentation.feature.applications.navigation.applicationsScreenModule
import dev.yaaum.presentation.feature.health.navigation.healthScreenModule
import dev.yaaum.presentation.feature.main.navigation.mainScreenModule
import dev.yaaum.presentation.feature.settings.navigation.settingsScreenModule

/**
 * Container for all nested graphs:
 * - `presentation:feature:onboarding`;
 * - `presentation:feature:main`;
 * - `presentation:feature:settings`;
 * - `presentation:feature:applications`;
 * - `presentation:feature:statistics`;
 * - `presentation:feature:health`;
 * - `presentation:feature:demo`;
 */
fun navigationInit() = ScreenRegistry {
    onboardingScreenModule()
    mainScreenModule()
    settingsScreenModule()
    applicationsScreenModule()
    statisticsScreenModule()
    healthScreenModule()
    demoScreenModule()
}
