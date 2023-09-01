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
    implementation(project(":common:core"))
    implementation(libs.compose.destinations.core)
    ksp(libs.compose.destinations.ksp)
}