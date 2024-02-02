plugins {
    id("yaaum.convention.compose.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
}

android {
    namespace = "dev.yaaum.presentation.core.models"
}

dependencies {
    implementation(project(":domain:core"))
    implementation(project(":domain:timeusage"))
    implementation(project(":domain:configuration"))
    implementation(project(":domain:applications"))
    implementation(project(":domain:health"))
    implementation(project(":common:core"))
    implementation(project(":presentation:core:localisation"))
}