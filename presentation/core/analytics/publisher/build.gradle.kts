plugins {
    id("yaaum.convention.compose.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
}

android {
    namespace = "dev.yaaum.presentation.core.analytics.publisher"
}

dependencies{
    implementation(project(":presentation:core:analytics:core"))
    implementation(project(":presentation:core:analytics:subscriber"))
}