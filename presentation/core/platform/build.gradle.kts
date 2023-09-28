plugins {
    id("yaaum.convention.compose.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
    id("yaaum.convention.koin")
    alias(libs.plugins.ksp)
}

android {
    namespace = "dev.yaaum.presentation.core.platform"
}

dependencies{
    implementation(project(":common:core"))
    implementation(project(":presentation:core:analytics:core"))
    implementation(project(":presentation:core:analytics:logger"))
}