plugins {
    id("yaaum.convention.compose.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
}

android {
    namespace = "dev.yaaum.presentation.core.analytics.subsriper"
}

dependencies {
    implementation(project(":presentation:core:analytics:core"))
}