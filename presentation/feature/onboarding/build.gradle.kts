@file:Suppress("SpellCheckingInspection")

plugins {
    id("yaaum.convention.compose.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
    id("yaaum.convention.koin")
    alias(libs.plugins.ksp)
}

android {
    namespace = "dev.yaaum.feature.onboarding"
}

dependencies {
    implementation(libs.voyager.navigator)
    implementation(libs.voyager.transitions)
    implementation(libs.voyager.androidx)
    implementation(libs.voyager.koin)

    implementation(libs.arrow.core)
    implementation(libs.arrow.fx.coroutines)
    implementation(libs.arrow.optics)

    implementation(project(":common:core"))
    implementation(project(":presentation:core:ui"))
    implementation(project(":presentation:core:platform"))
    implementation(project(":presentation:core:navigation"))
    implementation(project(":presentation:core:models"))

    implementation(project(":presentation:feature:main"))
    implementation(project(":presentation:core:ui"))

    implementation(project(":domain:core"))
    implementation(project(":domain:configuration"))
}