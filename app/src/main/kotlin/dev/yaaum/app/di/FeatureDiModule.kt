package dev.yaaum.app.di

import dev.yaaum.presentaion.feature.onboarding.di.onboardingFeatureModule
import dev.yaaum.presentation.feature.applications.di.applicationsFeatureModule
import dev.yaaum.presentation.feature.health.di.healthFeatureModule
import dev.yaaum.presentation.feature.main.di.mainFeatureModule
import dev.yaaum.presentation.feature.settings.di.settingsFeatureModule
import org.koin.dsl.module

/**
 * All di-modules from features
 */
val featureDiModule = module {
    includes(
        applicationsFeatureModule,
        healthFeatureModule,
        mainFeatureModule,
        settingsFeatureModule,
        onboardingFeatureModule,
    )
}
