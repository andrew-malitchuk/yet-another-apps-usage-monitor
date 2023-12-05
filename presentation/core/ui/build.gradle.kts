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
    implementation(libs.foundation.android)
    implementation(libs.accompanist.drawablepainter)


    implementation(project(":common:core"))
    implementation(project(":presentation:core:models"))
    implementation(project(":presentation:core:localisation"))
}
