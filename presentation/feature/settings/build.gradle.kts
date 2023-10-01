@file:Suppress("SpellCheckingInspection")

plugins {
    id("yaaum.convention.compose.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
    alias(libs.plugins.ksp)
}

android {
    namespace = "dev.yaaum.feature.settings"
}

dependencies {
    implementation(libs.voyager.navigator)
    implementation(libs.voyager.transitions)
    implementation(libs.voyager.androidx)
    implementation(libs.voyager.koin)
    implementation(libs.voyager.tab.navigator)

    implementation(project(":presentation:core:ui"))
    implementation(project(":presentation:core:navigation"))
}