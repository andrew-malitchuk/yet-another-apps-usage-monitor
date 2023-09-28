plugins {
    id("yaaum.convention.compose.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
    id("yaaum.convention.koin")
    alias(libs.plugins.ksp)
}

android {
    namespace = "dev.yaaum.presentation.core.analytics.subscriber.impl.local"
}

dependencies {
    implementation(project(":presentation:core:analytics:subscriber"))
    implementation(project(":presentation:core:analytics:core"))
}