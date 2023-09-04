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
    implementation(libs.voyager.navigator)
    implementation(libs.voyager.transitions)
    implementation(libs.voyager.androidx)
    implementation(libs.voyager.koin)

    implementation(libs.androidx.core.splashscreen)


    implementation(project(":presentation:core:ui"))
    implementation(project(":common:core"))
    implementation(project(":presentation:feature:onboarding"))
    implementation(project(":presentation:feature:main"))
    implementation(project(":presentation:feature:settings"))
}