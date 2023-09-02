plugins {
    id("yaaum.convention.compose.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
    alias(libs.plugins.ksp)
}

android {
    namespace = "dev.yaaum.presentation.core.navigation"
}

dependencies{
    implementation(libs.compose.destinations.core)
    implementation(libs.compose.destinations.animations.core)
    ksp(libs.compose.destinations.ksp)
}