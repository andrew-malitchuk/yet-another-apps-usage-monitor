@file:Suppress("SpellCheckingInspection")

plugins {
    id("yaaum.convention.compose.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
    alias(libs.plugins.ksp)

}

android {
    namespace = "dev.yaaum.feature.host"
}

dependencies {
    implementation(libs.compose.destinations.core)
    implementation(libs.compose.destinations.animations.core)
    ksp(libs.compose.destinations.ksp)

    implementation(project(":presentation:core:ui"))
    implementation(project(":presentation:core:navigation"))
    implementation(project(":common:core"))
}