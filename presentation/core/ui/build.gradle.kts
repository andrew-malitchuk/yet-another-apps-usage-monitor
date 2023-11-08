@file:Suppress("SpellCheckingInspection")

plugins {
    id("yaaum.convention.compose.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
}

android {
    namespace = "dev.yaaum.presentation.core.ui"
}

dependencies {
    implementation(libs.compose.material)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.appcompat)
    implementation(libs.core.ktx)
    implementation(libs.compose.runtime)
    implementation(libs.constraintlayout.compose)

    implementation(project(":common:core"))
    implementation(project(":presentation:core:models"))
}
