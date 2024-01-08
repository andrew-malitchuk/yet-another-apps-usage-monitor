@file:Suppress("SpellCheckingInspection")

plugins {
    id("yaaum.convention.compose.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
    id("yaaum.convention.koin")
    alias(libs.plugins.ksp)
}

android {
    namespace = "dev.yaaum.presentation.feature.main"
}

dependencies {
    implementation(libs.voyager.navigator)
    implementation(libs.voyager.transitions)
    implementation(libs.voyager.androidx)
    implementation(libs.voyager.koin)
    implementation(libs.voyager.tab.navigator)

    implementation(libs.arrow.core)
    implementation(libs.arrow.fx.coroutines)
    implementation(libs.arrow.optics)

    implementation(libs.material3)
    implementation(libs.navigation.compose)
    implementation(libs.compose.material)
//    implementation("androidx.compose.material:material:1.5.2")
    implementation(libs.accompanist.drawablepainter)

    implementation(project(":presentation:core:ui"))
    implementation(project(":presentation:core:platform"))
    implementation(project(":presentation:core:models"))
    implementation(project(":presentation:core:localisation"))
    implementation(project(":presentation:core:navigation"))

    implementation(project(":common:core"))

    implementation(project(":domain:core"))
    implementation(project(":domain:configuration"))
    implementation(project(":domain:timeusage"))
    implementation(project(":domain:health"))
}